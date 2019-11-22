package de.lingen.modsim;

public class Sea {

    private SeaTile[][] SeaBoard;
    private int width;                                      // Breite   [x]
    private int height;                                     // Höhe     [y]


    public Sea (){
        SeaBoard = new SeaTile[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                SeaBoard[i][j] = new SeaTile();
            }
        }
    }

    public Sea (int height, int width){
        this.width = width;
        this.height = height;
        SeaBoard = new SeaTile[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                SeaBoard[x][y] = new SeaTile();
            }
        }

    }
}
