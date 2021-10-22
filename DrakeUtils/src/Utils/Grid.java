package Utils;

import java.util.Arrays;

public class Grid {

    int xs, ys;
    private int[][] mainGrid;

    public Grid(int xSize, int ySize, boolean startEmpty){
        xs = xSize;
        ys = ySize;
        mainGrid = new int[xs][ys];
        if(startEmpty){
            for (int x = 0; x < xs; x++){
                for(int y = 0; y < ys; y++){
                    if(x < mainGrid.length && y < mainGrid[0].length) {
                        mainGrid[x][y] = 0;
                    }
                }
            }
        }else{
            for (int x = 0; x < xs; x++){
                for(int y = 0; y < ys; y++){
                    mainGrid[x][y] = 1;
                }
            }
        }
    }

    public int[][] getMainGrid(){
        return mainGrid;
    }



    public int findValue(int xPos, int yPos){
       int val = -1;
       if(xPos < mainGrid.length){
           if(yPos < mainGrid[0].length){
               val = mainGrid[xPos][yPos];
           }
       }
       return val;
    }

    public void ChangeGridValue(int xPos, int yPos, int val){
        if(xPos < mainGrid.length){
            if(yPos < mainGrid[0].length){
                mainGrid[xPos][yPos] = val; 
            }
        }
    }

    public int[] getGridSize(){
        int xTmp = mainGrid.length;
        int yTmp = mainGrid[0].length;
        int[] xyr = new int[2];
        xyr[0] = xTmp;
        xyr[1] = yTmp;
        return xyr;
    }

    public String[][] getGridAsString(){
        return Utility.Int2DArrayToString2D(mainGrid);
    }

    @Override
    public String toString() {
        return "Grid{" + "xs=" + xs +
                ", ys=" + ys +
                ", mainGrid=" + Arrays.toString(mainGrid) +
                '}';
    }
}
