package de.lingen.modsim;

import de.lingen.modsim.db.Database;
import de.lingen.modsim.model.Field;
import de.lingen.modsim.model.Population;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Population population = Population.getInstance();

        try {

            population.startPopulation(100);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("time: " + (endTime - startTime)/60);
    }
}
