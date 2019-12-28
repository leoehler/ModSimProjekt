package de.lingen.modsim.core.blob;

import de.lingen.modsim.core.Field;
import de.lingen.modsim.core.Point2D;

import java.util.Random;

public abstract class Blob {

    private double energy;
    private double speed;
    private double size;
    private double sense;
    private double food;
    private final int SCALE = 10;

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
            // energy = Math.pow(size,3) + Math.pow(speed,2) + sense;
            // size^3 + speed^2 + sense
        //energy = (size * size * size) + (speed * speed) + sense;
        energy -= ((size * size * size) + (speed * speed) + sense);
    }


    /**
     * s = v * t
     * strecke = geschwindigkeit * zeit
     */
    public void move() {
        //TODO move
        while(energy > energyNeededToReachCorner(pos)) {
            switch (new Random().nextInt(3)){  //TODO ... OOB check
                case 0://horizontal R
                    pos.setX(pos.getX()+speed*SCALE);
                    break;
                case 1://horizontal L
                    pos.setX(pos.getX()-speed*);
                    break;
                case 2://vertikal O
                    pos.setY(pos.getY()+speed);
                    break;
                case 3://vertikal U
                    pos.setY(pos.getY()-speed);
                    break;
            }
            calculateEnergyCostPerTimeFrame();      // Energieverbrauch berechnen & verbrauchen.

            //scan 4 fooodz
            if (isFoodInRange())  // db abfrage........
                moveTowardsPoint(pos);
                if(onFood)      // db abfrage
                    if(food < 2)
                        eat();

        }

        current location check
            wofür nochmal



    }

    public void moveTowardsPoint(Point2D destination){
        //pos = point; // teleport ftw

        while(energy > energyNeededToReachCorner(pos)){
            //x koordinate
            if (Math.abs(destination.getX()-pos.getX()) > speed) {
                if(destination.getX() < pos.getX()) {             // nach links gehen
                    pos.setX(pos.getX() - speed);
                    calculateEnergyCostPerTimeFrame();
                }
                else if (destination.getX() > pos.getX()) {         // nach rechts gehen
                    pos.setX(pos.getX() + speed);
                    calculateEnergyCostPerTimeFrame();
                }
            }
            else {                  // abfrage ob gleich, damit nicht immer in den fall reingesprungen wird?
                pos.setX(destination.getX());
                calculateEnergyCostPerTimeFrame();
            }

            //y koordinate
            if (Math.abs(destination.getY()-pos.getY()) > speed) {
                if(destination.getY() < pos.getY()) {             // nach links gehen
                    pos.setY(pos.getY() - speed);
                    calculateEnergyCostPerTimeFrame();
                }
                else if (destination.getY() > pos.getY()) {         // nach rechts gehen
                    pos.setY(pos.getY() + speed);
                    calculateEnergyCostPerTimeFrame();
                }
            }
            else {
                pos.setY(destination.getY());
                calculateEnergyCostPerTimeFrame();
            }
        }
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

    public void eat(){
        food++;
    }

    public double energyNeededToReachCorner(Point2D pos){
        int x = pos.getX();
        int y = pos.getY();

        Field field = Field.getInstance();
        int distance = 0;
        double energy2C = 0;                // clean variant: just return statement further down
        switch(calcClosestBorder(pos)){
            case 1:
                distance = x;
                break;
            case 2:
                distance = field.MAX_Y - y;
                break;
            case 3:
                distance = field.MAX_X - x;
                break;
            case 4:
                distance = y;
                break;
        }
        energy2C = ((size*size*size)+(speed*speed)+sense) * (distance/speed);  //energy cost per time frame * distance covered per time interval
        return energy2C;
    }

    public int calcClosestBorder(Point2D pos){
        int x = pos.getX();
        int y = pos.getY();
        Field field = Field.getInstance();

        if (x <= field.MAX_X-x && x <= y && x <= field.MAX_Y-y)                                 //Left
            return 1;
        if (field.MAX_X-x <= x && field.MAX_X-x <= y && field.MAX_X-x <= field.MAX_Y-y)         //Right
            return 3;
        if (y <= field.MAX_Y-y && y <= x && y <= field.MAX_X-x)                                 //Bottom
            return 4;
        if (field.MAX_Y-y <= y && field.MAX_Y-y <= x && field.MAX_Y-y <= field.MAX_X-x)         //Top
            return 2;
        return 1;
    }
}
