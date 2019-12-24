package de.lingen.modsim.model;

import de.lingen.modsim.model.blob.NormalBlob;
import de.lingen.modsim.model.blob.Point2DBlob;
import de.lingen.modsim.core.Blob;

import java.util.ArrayList;


public class Population extends ArrayList<Blob> {
    private final static int SIZE = 1000;

    //TODO remove


    private Field field;

    private Population() {
        super(SIZE);

        field = Field.getInstance();
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
        //TODO live or death phase
    }

    private static class Inner {
        private static Population population = new Population();
    }
}
