package de.lingen.modsim.model;

import de.lingen.modsim.core.Blob;
import de.lingen.modsim.model.blob.NormalBlob;
import de.lingen.modsim.model.blob.Point2DBlob;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * actual the main loop of the simulation
 */
public class Population extends ArrayList<Blob> {
    //TODO remove, just temporary solution
    private static final int   ITERATION_SIZE = 20;
    private final static int   SIZE           = 1000;
    private              Field field;

    /**
     * constructor population
     */
    private Population() {
        super( SIZE );

        field = Field.getInstance();
    }

    /**
     * get singleton reference
     *
     * @return
     */
    public static Population getInstance() {
        return Inner.population;
    }

    /**
     * start the simulation
     *
     * @param amount starting population size
     * @throws SQLException sql error
     */
    public void startPopulation( int amount ) throws SQLException {
        // create start population
        for (int i = 0; i < amount; i++)
             add( new NormalBlob( Point2DBlob.randomPoint() ) );

        // main loop
        for (int i = 0; i < ITERATION_SIZE; i++) {
            actionPhase();
            liveOrDeathPhase();
        }

    }

    /**
     * every simulation object have it's time to do something like moving and eating
     *
     * @throws SQLException sql error
     */
    public void actionPhase() throws SQLException {
        field.generateRandomFoodPoints( 100 );

        for (Blob blob : this)
            blob.move( field.getNearestFood( blob ) );
    }

    /**
     * checks the population if any creature still have energy left or not
     */
    public void liveOrDeathPhase() {
//        for (int i = 0; i < size(); i++)
//            if (get(i).getEnergy() <= 0)
//                remove(i);

        removeIf( blob -> blob.getEnergy() <= 0 );
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder( 32 );

        forEach( blob -> builder.append( "{ \n" )
                                .append( "\t" )
                                .append( blob )
                                .append( "\n}\n" ) );

        return builder.toString();
    }

    /**
     * class for singleton
     */
    private static class Inner {
        private static Population population = new Population();
    }
}
