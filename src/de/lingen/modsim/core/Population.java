package de.lingen.modsim.core;

import de.lingen.modsim.core.blob.Blob;
import de.lingen.modsim.core.blob.NormalBlob;
import de.lingen.modsim.core.blob.Point2DBlob;

import java.util.ArrayList;
import java.util.Random;


public class Population extends ArrayList<Blob> {
    private final static int SIZE = 1000;

    private Field field;

    private Population() {
        super(SIZE);

        field = Field.getInstance();
    }

    private static class Inner {
        private static Population population = new Population();
    }

    public static Population getInstance() {
        return Inner.population;
    }

    public void startPopulation(int amount) {
        for (int i = 0; i < amount; i++) {
            add(new NormalBlob(Point2DBlob.randomPoint()));
        }

    }

    public void actionPhase() {
        //TODO action phase
    }

    public void liveOrDeathPhase() {
        //TODO live or death pahse
    }
}
