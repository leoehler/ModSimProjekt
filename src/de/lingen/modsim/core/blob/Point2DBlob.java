package de.lingen.modsim.core.blob;

import de.lingen.modsim.core.Field;
import de.lingen.modsim.core.Point2D;

public class Point2DBlob extends Point2D {

    public Point2DBlob(int x, int y) {
        super(x, y);
    }

    public boolean inBoundsX(int x) {
        return x >= 0 && x <= field.MAX_X;
    }

    public boolean inBoundsY(int y) {
        return y >= 0 && y <= field.MAX_Y;
    }

    /**
     * check if x is in bounds | true this.x is x, other x = 0
     * @param x x pos
     */
    public void setX(int x) {
        this.x = inBoundsX(x) ? x : randomPoint().x;
    }

    /**
     * check if y is in bounds | true this.y is y, other y = 0
     * @param y y pos
     */
    public void setY(int y) {
        this.y = inBoundsY(y) ? y : randomPoint().y;
    }

    /**
     * random point on one edge
     * @return pos
     */
    public static Point2DBlob randomPoint() {
        int x = 0, y = 0;
        Field field = Field.getInstance();

        // 0=left, 1=top, 2=right, 3=bottom
        switch (random.nextInt(4)) {
            case 0:
                x = 0;
                y = random.nextInt(field.MAX_Y + 1);
                break;
            case 1:
                x = random.nextInt(field.MAX_X + 1);
                y = field.MAX_Y;
                break;
            case 2:
                x = field.MAX_X;
                y = random.nextInt(field.MAX_Y + 1);
                break;
            case 3:
                x = random.nextInt(field.MAX_X + 1);
                y = 0;
                break;
        }
        return new Point2DBlob(x, y);

    }
}
