package de.lingen.modsim.core.blob;

import de.lingen.modsim.core.Field;
import de.lingen.modsim.core.Point2D;

import java.rmi.activation.ActivationGroup_Stub;

public abstract class Blob {

    private double energy;
    private double speed;
    private double size;
    private double sense;
    private double food;

    private Point2D pos;

    public Blob(Point2D pos){
        energy = 100;
        speed = 0.5;
        size = 1;
        sense = 1;
        food = 0;

        this.pos = pos;
    }

    public Blob(double energy, double speed, double size, double sense, Point2D pos) {
        this.energy = energy;
        this.speed = speed;
        this.size = size;
        this.sense = sense;

        this.pos = pos;
    }

    public void calculateEnergyCostPerTimeFrame(){
        //        energy = Math.pow(size,3) + Math.pow(speed,2) + sense;
        // size^3 + speed^2 + sense
        energy = (size * size * size) + (speed * speed) + sense;
    }


    /**
     * s = v * t
     * strecke = geschwindigkeit * zeit
     */
    public void move() {
        //TODO move
        while(energy > energyNeededToReachCorner) {


        }

        current location check



        check 4 foods
            true = move towards

            false move ranomdly

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

    public double getFood() {
        return food;
    }

    public void setFood(double food){
        this.food = food;
    }

    public double energyNeededToReachCorner(Point2D pos){
        double energy2C = 0;

        return energy2C;

    }

    public int calcClosestBorder(Point2D pos){
        int x = pos.getX();
        int y = pos.getY();
        Field field = Field.getInstance();

        //  Links = 1
        //  Oben = 2
        //  Rechts = 3
        //  Unten = 4

        if (x <= field.MAX_X-x && x <= y && x <= field.MAX_Y-y)
            return 1;
        if (field.MAX_X-x <= x && field.MAX_X-x <= y && field.MAX_X-x <= field.MAX_Y-y)
            return 3;
        if (y <= field.MAX_Y-y && y <= x && y <= field.MAX_X-x)
            return 4;
        if (field.MAX_Y-y <= y && field.MAX_Y-y <= x && field.MAX_Y-y <= field.MAX_X-x)
            return 2;
    }
}
