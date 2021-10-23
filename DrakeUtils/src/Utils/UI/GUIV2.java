package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Locale;
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

    public void getInput(String className, String callMethod, Class<?>[] argTypes, Object[] methArgs){
        in.nextLine();
        String input = in.nextLine().toUpperCase();
        Debug.Log("input reached");

        try {
            Debug.Log("entered try");
            if(input.equals("W")){
                Utility.launchProcess(className, callMethod, argTypes, methArgs);
                Debug.Log("Button Pressed");
            }else if(input.equals("A")){
                Utility.launchProcess(className, callMethod, argTypes, methArgs);
            }else if(input.equals("S")){
                Utility.launchProcess(className, callMethod, argTypes, methArgs);
            }else if(input.equals("D")){
                Utility.launchProcess(className, callMethod, argTypes, methArgs);
            }
        }
        catch (Exception e){ Debug.Log("Class Not Found");}

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
