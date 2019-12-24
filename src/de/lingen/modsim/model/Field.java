package de.lingen.modsim.model;

import de.lingen.modsim.core.Blob;
import de.lingen.modsim.db.Database;
import de.lingen.modsim.model.food.Food;
import de.lingen.modsim.model.food.Point2DFood;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Field {

    private static Random x = new Random(123);
    public final   int    MAX_X;
    public final   int    MAX_Y;

    private Field() {
        MAX_X = 1000;
        MAX_Y = 1000;
    }

    public static Field getInstance() {
        return Inner.field;
    }

    public void generateRandomFoodPoints(int amount) throws SQLException {
        ArrayList<Point2DFood> foodsPoints = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            Point2DFood point2D;

            do {
                point2D = Point2DFood.randomPoint();
            } while (foodsPoints.contains(point2D));

            foodsPoints.add(point2D);
        }

        commitFoodToDB(foodsPoints);
    }

    private void commitFoodToDB(ArrayList<Point2DFood> foodPoints) throws SQLException {
        String query = "INSERT INTO FOOD(X_POS, Y_POS) VALUES (?, ?)";

        PreparedStatement statement = Database.getInstance().getConn().prepareStatement(query);

        for (Point2DFood item : foodPoints) {
            statement.setInt(1, item.getX());
            statement.setInt(2, item.getY());
            statement.execute();
        }
    }

    public ArrayList<Food> getNearestFood(Blob blob) throws SQLException {
        String            query     = "SELECT X_POS, Y_POS FROM FOOD WHERE X_POS >= ? AND X_POS <= ? AND Y_POS >= ? AND Y_POS <= ?;";
        PreparedStatement statement = Database.getInstance().getConn().prepareStatement(query);

        statement.setDouble(1, blob.getPos().getX() - blob.getSense());
        statement.setDouble(2, blob.getPos().getX() + blob.getSense());
        statement.setDouble(3, blob.getPos().getY() - blob.getSense());
        statement.setDouble(4, blob.getPos().getY() + blob.getSense());

        ResultSet resultSet = statement.executeQuery();

        ArrayList<Food> points = new ArrayList<>();

        while (resultSet.next())
            points.add(new Food(new Point2DFood(resultSet.getInt("X_POS"), resultSet.getInt("Y_POS")),
                                resultSet.getInt("ENERGY")));

        return points;
    }

    private static class Inner {
        private static Field field = new Field();
    }
}
