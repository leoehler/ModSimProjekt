package de.lingen.modsim.core;

import java.util.Random;

public abstract class Point2D {
    protected static Random random = new Random();
    protected        int    x;
    protected        int    y;
    protected        Field  field;

    public Point2D(int x, int y) {
        field = Field.getInstance();

        setX(x);
        setY(y);
    }

    // sqrt is expensive. distance^2 = (x2 - x1)^2 + (y2 - y1)^2 == distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
    public double distanceNoSqrt(Point2D pointB) {
        return (pointB.x - x) * (pointB.x - x) + (pointB.y - y) * (pointB.y - y);
    }

    public double distance(Point2D pointB) {
        return Math.sqrt((pointB.x - x) * (pointB.x - x) + (pointB.y - y) * (pointB.y - y));
    }

    public abstract boolean inBoundsX(int x);

    public abstract boolean inBoundsY(int y);

    public int getX() {
        return x;
    }

    public abstract void setX(int x);

    public int getY() {
        return y;
    }

    public abstract void setY(int y);

}
