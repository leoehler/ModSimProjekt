package de.lingen.modsim.core;

import de.lingen.modsim.core.food.Point2DFood;
import de.lingen.modsim.db.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Field {

    public final int MAX_X;
    public final int MAX_Y;

    private static Random x = new Random(123);

    private static class Inner {
        private static Field field = new Field();
    }

    private Field(){
        MAX_X = 1000;
        MAX_Y = 1000;
    }

    public static Field getInstance() {
        return Inner.field;
    }

    public void generateRandomFoodPoints(int amount){
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

    private void commitFoodToDB(ArrayList<Point2DFood> foodPoints) {
        String query = "INSERT INTO FOOD(X_POS, Y_POS) VALUES (?, ?)";
        try {
            PreparedStatement statement = Database.getInstance().getConn().prepareStatement(query);

            for (Point2DFood item : foodPoints) {
                statement.setInt(1, item.x);
                statement.setInt(2, item.y);
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
