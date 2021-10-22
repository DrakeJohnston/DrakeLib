package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;

public class GUIV2 {
    char [][] guiArray;
    int[][] selectionPoints;

    public GUIV2(char[][] g){
        guiArray = g;
    }

    public void DisplayGUI(){
        for (int x=0; x < guiArray.length; x++){
            System.out.print("\n");
            for (int y=0; y < guiArray[0].length; y++){
                System.out.print(ConsoleColors.BLUE + guiArray[x][y] + ConsoleColors.RESET);
            }
        }
    }

    public char findCharAt(int x, int y){
        if(x < guiArray.length && y < guiArray[0].length) {
            return guiArray[x][y];
        }else{
            return ' ';
        }
    }
}
