package de.lingen.modsim;

import de.lingen.modsim.model.Population;

import java.sql.SQLException;

public class Main {

    public static void main( String[] args ) {

        Population population = Population.getInstance();

        System.out.println( population );

        try {

            population.startPopulation( 100 );

        } catch (SQLException e) {
            System.err.println( "Something went wrong with the database!!" );
            e.printStackTrace();
        }

        System.out.println( population );
    }
}
