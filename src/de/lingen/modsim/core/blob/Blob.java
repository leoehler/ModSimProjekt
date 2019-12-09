package de.lingen.modsim.core.blob;

import de.lingen.modsim.core.Point2D;

public abstract class Blob {

    private double energy;
    private double speed;
    private double size;
    private double sense;

    private Point2D pos;

    public Blob(Point2D pos){
        energy = 100;
        speed = 0.5;
        size = 1;
        sense = 1;

        this.pos = pos;
    }

    public Blob(double energy, double speed, double size, double sense, Point2D pos) {
        this.energy = energy;
        this.speed = speed;
        this.size = size;
        this.sense = sense;

        this.pos = pos;
    }

    public void calculateEnergycostPerTimeFrame(){
        energy = Math.pow(size,3) * Math.pow(speed,2) + sense;
    }

    /**
     * s = v * t
     * strecke = geschwindigkeit * zeit
     */
    public void move() {
        //TODO move
    }

    public abstract void moveStrategy();

    public double getEnergy() {
        return energy;
    }

    public double getSpeed() {
        return speed;
    }

    public double getSize() {
        return size;
    }

    public double getSense() {
        return sense;
    }
}
