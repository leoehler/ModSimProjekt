package de.lingen.modsim;

import de.lingen.modsim.core.Field;
import de.lingen.modsim.db.Database;

public class Main {

    public static void main(String[] args) {
        Database db = Database.getInstance();

        Field f = Field.getInstance();

        f.generateRandomFoodPoints(100);

    }
}
