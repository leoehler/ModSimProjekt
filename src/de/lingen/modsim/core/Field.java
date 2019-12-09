package de.lingen.modsim.core;

import java.util.HashMap;
import java.util.Random;

public class Field {

    public final int MAX_X;
    public final int MAX_Y;

    HashMap<Integer, Integer> m = new HashMap<>();

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

    public void generateFood(int amount){
        Random x = new Random();
        x.nextInt();
        for (int i = 0; i < 10; i++) {
            if (m.containsKey(i)) {

            }

        }

    }
    public void generateFoodAt(){

    }
}
