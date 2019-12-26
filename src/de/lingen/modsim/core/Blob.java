package de.lingen.modsim.core;

import de.lingen.modsim.model.blob.Point2DBlob;
import de.lingen.modsim.model.food.Food;

import java.util.List;

/**
 * creatures living in the simulation
 */
public abstract class Blob implements ISimulationObject {

    private double energy;
    private double speed;
    private double size;
    private int    sense;

    private Point2D pos;

    /**
     * constructor with default values and given spawn point
     *
     * @param pos spawn position
     */
    public Blob( Point2D pos ) {
        energy = 200;
        speed  = 0.5;
        size   = 1;
        sense  = 5;

        this.pos = pos;
    }

    /**
     * constructor for individual creature and given spawn point
     *
     * @param energy energy
     * @param speed  speed
     * @param size   size
     * @param sense  sense
     * @param pos    spawn point
     */
    public Blob( double energy, double speed, double size, int sense, Point2D pos ) {
        this.energy = energy;
        this.speed  = speed;
        this.size   = size;
        this.sense  = sense;

        this.pos = pos;
    }

    /**
     * energy costs a blob have for a move
     */
    public double calculateEnergyCostPerTimeFrame() {
//        energy = Math.pow(size,3) + Math.pow(speed,2) + sense;
        // size^3 + speed^2 + sense
        return (size * size * size) + (speed * speed) + sense;
    }


    /**
     * moves and tries to find food or goes home
     * s = v * t
     * strecke = geschwindigkeit * zeit
     *
     * @param nearestFood foods the blob can "see" (inside it's sense)
     */
    public void move( List<Food> nearestFood ) {
        Food foodToCatchUp = closestFood( nearestFood );

        // if food is there try to reach
        if (foodToCatchUp != null) {
            pos = foodToCatchUp.getPos();
            energy += foodToCatchUp.ENERGY;
        } else { // if no food do random move
            pos = Point2DBlob.randomMove( pos, sense );
        }

        energy -= calculateEnergyCostPerTimeFrame();
    }

    /**
     * get food in range (sense)
     *
     * @param foods food in the environment
     * @return food in range (sense)
     */
    private Food closestFood( List<Food> foods ) {
        if (foods.isEmpty())
            return null;

        // TODO check if food is in circle range
        Food   closestFood     = foods.get( 0 );
        double closestDistance = pos.distanceNoSqrt( foods.get( 0 ).getPos() );

        double distance = .0;

        for (Food f : foods) {
            distance = pos.distanceNoSqrt( f.getPos() );
            if (distance < closestDistance) {
                closestFood     = f;
                closestDistance = distance;
            }
        }

        return closestFood;
    }

    /**
     * howe the blob should move
     * e.g. get one food and go home or tries to get two foods
     */
    public abstract void moveStrategy();

    @Override
    public String toString() {
        return "Blob{" +
               "energy=" + energy +
               ", speed=" + speed +
               ", size=" + size +
               ", sense=" + sense +
               ", pos=" + pos +
               '}';
    }

    /**
     * getter energy
     *
     * @return energy
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * getter speed
     *
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * getter size
     *
     * @return size
     */
    public double getSize() {
        return size;
    }

    /**
     * getter sense
     *
     * @return sense
     */
    public double getSense() {
        return sense;
    }

    /**
     * getter pos
     *
     * @return position
     */
    public Point2D getPos() {
        return pos;
    }
}
