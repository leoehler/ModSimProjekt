package de.lingen.modsim;

public class Sea {

    private SeaTile[][] SeaBoard;
    private int width;                                      // Breite   [x]
    private int height;                                     // Höhe     [y]


    public Sea (){
        this(10, 10);
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



    public void showOnConsole(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("| " + SeaBoard[j][i].toString() + " ");
            }
            System.out.print("|");
            System.out.println("");
        }


    }
}