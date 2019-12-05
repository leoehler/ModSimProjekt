package de.lingen.modsim;

public class Blob {

    private double energy;
    private double speed;
    private double size;
    private double sense;

    public Blob(){
        energy = 100;
        speed = 0.5;
        size = 1;
        sense = 1;
    }

    public Blob(double energy, double speed, double size, double sense) {
        this.energy = energy;
        this.speed = speed;
        this.size = size;
        this.sense = sense;
    }

    public void calculateEnergycostPerTimeFrame(){
        energy = size^3 * speed^2 + sense;
    }

}
