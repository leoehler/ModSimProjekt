package de.lingen.modsim;

public class SeaTile {

    private boolean water;

    public SeaTile(boolean water){
        this.water = water;
    }
    public SeaTile(){
        water = false;
    }

    @Override
    public String toString() {
        if(water)
            return "O";
        else
            return "X";
    }
}
