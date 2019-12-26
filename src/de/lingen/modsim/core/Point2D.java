package de.lingen.modsim.core;

import de.lingen.modsim.model.Field;
import de.lingen.modsim.model.blob.Point2DBlob;
import de.lingen.modsim.model.food.Point2DFood;

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

    /**
     * distance between this and given point
     * sqrt is expensive. distance^2 = (x2 - x1)^2 + (y2 - y1)^2 == distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     *
     * @param pointB second point
     * @return distance^2
     */
    public double distanceNoSqrt(Point2D pointB) {
        return (pointB.x - x) * (pointB.x - x) + (pointB.y - y) * (pointB.y - y);
    }

    /**
     * distance between this and given point
     *
     * @param pointB second point
     * @return distance
     */
    public double distance(Point2D pointB) {
        return Math.sqrt((pointB.x - x) * (pointB.x - x) + (pointB.y - y) * (pointB.y - y));
    }

    /**
     * checks if the point is in the area
     *
     * @param point point to check
     * @return true is in the area
     */
    public boolean inBounds(Point2D point) {
        return inBoundsX(point.getY()) && inBoundsY(point.getY());
    }

    /**
     * checks the x coordinate if it is in the area
     *
     * @param x x coordinate
     * @return true is in the area
     */
    public abstract boolean inBoundsX(int x);

    /**
     * checks the y coordinate if it is in the area
     *
     * @param y x coordinate
     * @return true is in the area
     */
    public abstract boolean inBoundsY(int y);


    /**
     * getter x coordinate
     *
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * set new x value. If the new value is out of bounds a random x coordinate will be set
     *
     * @param x x coordinate to set
     */
    public abstract void setX(int x);

    /**
     * getter y coordinate
     *
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * set new y value. If the new value is out of bounds a random x coordinate will be set
     *
     * @param y y coordinate to set
     */
    public abstract void setY(int y);

}
