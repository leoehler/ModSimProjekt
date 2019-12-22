package de.lingen.modsim;

import de.lingen.modsim.core.Field;
import de.lingen.modsim.db.Database;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Database db = Database.getInstance();
        Field f = Field.getInstance();
        f.generateRandomFoodPoints(100);

        long endTime = System.currentTimeMillis();

        System.out.println("time: " + (endTime - startTime)/60);
    }
}
