package de.lingen.modsim.model;

import de.lingen.modsim.model.blob.NormalBlob;
import de.lingen.modsim.model.blob.Point2DBlob;
import de.lingen.modsim.core.Blob;

import java.sql.SQLException;
import java.util.ArrayList;


public class Population extends ArrayList<Blob> {
    private final static int SIZE = 1000;

    //TODO remove
    static final int ITERATION_SIZE = 100;

    private Field field;

    private Population() {
        super(SIZE);

        field = Field.getInstance();
    }

    public static Population getInstance() {
        return Inner.population;
    }

    public void startPopulation(int amount) throws SQLException {
        for (int i = 0; i < amount; i++) {
            add(new NormalBlob(Point2DBlob.randomPoint()));
        }

        for (int i = 0; i < ITERATION_SIZE; i++) {
            actionPhase();
            liveOrDeathPhase();
        }

    }

    public void actionPhase() throws SQLException {
        field.generateRandomFoodPoints(100);

        for (Blob blob : this) {
            blob.move(field.getNearestFood(blob));
        }
    }

    public void liveOrDeathPhase() {
        //TODO live or death phase
    }

    private static class Inner {
        private static Population population = new Population();
    }
}
