package de.lingen.modsim;

import javafx.scene.shape.Rectangle;

public class Simulation {

    private static Simulation simulation;
    private        Rectangle  rectangle;

    public static Simulation getInstance() {
        if (simulation == null)
            simulation = new Simulation();

        return simulation;
    }

    void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void next() {
        rectangle.setX(rectangle.getX() + 1);
    }
}
