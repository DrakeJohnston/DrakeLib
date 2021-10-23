package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;

import java.util.Scanner;

public class GUIV2 {
    char [][] guiArray;
    int[][] selectionPoints;
    int selectedOption = 0;
    char selector = '@';
    Scanner in = new Scanner(System.in);

    public GUIV2(char[][] g, int[][] points){
        guiArray = g;
        selectionPoints = points;
    }

    public void getInput(){

    }

    public void DisplayGUI(){
        for (int x=0; x < guiArray.length; x++){
            System.out.print("\n");
            for (int y=0; y < guiArray[0].length; y++){
                System.out.print(ConsoleColors.BLUE + guiArray[x][y] + ConsoleColors.RESET);
            }
        }
    }

    public void UpdateGUI(){
        for(int i=0; i < selectionPoints.length; i++){
            if( i == selectedOption){
                guiArray[selectionPoints[i][0]][selectionPoints[i][1]] = selector;
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
