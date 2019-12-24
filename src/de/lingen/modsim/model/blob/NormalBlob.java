package de.lingen.modsim.model.blob;

import de.lingen.modsim.core.Blob;

public class NormalBlob extends Blob {


    public NormalBlob(Point2DBlob pos) {
        super(pos);
    }

    public NormalBlob(double energy, double speed, double size, double sense, Point2DBlob pos) {
        super(energy, speed, size, sense, pos);
    }

    @Override
    public void moveStrategy() {
        //TODO move strategy
    }

    @Override
    public void simulate(int timeStep) {

    }
}
