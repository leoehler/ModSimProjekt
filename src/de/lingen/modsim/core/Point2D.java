package de.lingen.modsim.core;

import java.util.Random;

public abstract class Point2D {
    protected int x;
    protected int y;

    protected     Field  field;
    protected static Random random = new Random();

    public Point2D(int x, int y) {
        field = Field.getInstance();

        setX(x);
        setY(y);
    }

    public abstract boolean inBoundsX(int x);

    public abstract boolean inBoundsY(int y);

    public abstract void setX(int x);

    public int getX() {
        return x;
    }

    public abstract void setY(int y);

    public int getY() {
        return y;
    }

}
