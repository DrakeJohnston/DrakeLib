package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Locale;
import java.util.Scanner;

public class GUI {
    char [][] guiArray;

    int[][] selectionPoints;
    int selectedOption = 0;

    char selector = '@';
    char defaultChar = '0';
    int[] selectorPos = {1,1};
    int[] lastPos = {1, 1};

    boolean freeSelect = false;
    boolean isActive;
    Scanner in = new Scanner(System.in);

    //todo: setup a value to set selector
    public GUI(char[][] g, int[][] points, boolean active, char defChar){
        guiArray = g;
        selectionPoints = points;
        defaultChar = defChar;
        isActive = active;
    }
    public GUI(char[][]g, boolean isActive, char defChar){
        guiArray = g;
        this.isActive = isActive;
        defaultChar = defChar;
        freeSelect = true;
    }

    public int getSelector(){return selectedOption;}

    public void setSelector(int i){selectedOption = i;}

    public boolean IsActive(){ return isActive;}
    public void setActive(boolean val){  isActive = val;}

    public void moveSelector(int x, int y){
        //todo: fix so that when characters are at x one they can move left
        if((x < guiArray[0].length && y < guiArray.length) || (x < 0 && y < 0)) {
            lastPos[0] = selectorPos[0];
            lastPos[1] = selectorPos[1];

            selectorPos[0] = x;
            selectorPos[1] = y;
        }
    }

    public int[] getSelectorPos(){
        int[] pos = {selectorPos[0], selectorPos[1]};
        return pos;
    }

    public void RunGUI(){
        UpdateGUI();
        DisplayGUI();
    }

    public void getInput(String className, String callMethod, Class<?>[] argTypes, Object[] methArgs){
        String input = in.nextLine().toUpperCase();

        try {
            methArgs[0] = input;
            Utility.launchProcess(className, callMethod, argTypes, methArgs);
        }
        catch (Exception e){ Debug.Log("Class Not Found");}

    }

    public void DisplayGUI(){
        for (int x = 0; x < guiArray.length; x++) {
            System.out.print("\n");
            for (int y = 0; y < guiArray[0].length; y++) {
                System.out.print(ConsoleColors.BLUE + guiArray[x][y] + ConsoleColors.RESET);
            }
        }
        Debug.printLn(" ");
    }

    public void UpdateGUI(){
        if(!freeSelect) {
            for (int i = 0; i < selectionPoints.length; i++) {
                if (i == selectedOption) {
                    guiArray[selectionPoints[i][0]][selectionPoints[i][1]] = selector;
                } else if (i != selectedOption) {
                    guiArray[selectionPoints[i][0]][selectionPoints[i][1]] = defaultChar;
                }
            }
        }else{
            replaceAt(selectorPos[0], selectorPos[1], selector);
            replaceAt(lastPos[0], lastPos[1], defaultChar);
        }
    }

    public char findCharAt(int x, int y){
        if(x < guiArray.length && y < guiArray[0].length) {
            return guiArray[x][y];
        }else{
            return ' ';
        }
    }

    public void replaceAt(int x, int y, char newChar){
        if(x < guiArray.length && y < guiArray[0].length) {
            guiArray[x][y] = newChar;
        }
    }
}
