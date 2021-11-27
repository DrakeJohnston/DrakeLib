package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Math.Vector2;
import Utils.Utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Locale;
import java.util.Scanner;

public class GUI {
    Tile [][] guiArray;
    boolean isActive = true;
    Scanner in = new Scanner(System.in);

    //todo: setup a value to set selector
    public GUI(Tile[][] g, boolean active){
        guiArray = g;
        isActive = active;
    }
    public GUI(Tile[][]g, boolean isActive, Tile defChar){
        guiArray = g;
        this.isActive = isActive;
    }
    public GUI(char[][] g, boolean active){
        guiArray = Utility.charToTile(g);
        isActive = active;
    }

    public boolean IsActive(){ return isActive;}
    public void setActive(boolean val){  isActive = val;}

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

    }

    public Tile findTileAt(int x, int y){
        if(x < guiArray.length && y < guiArray[0].length) {
            return guiArray[x][y];
        }else{
            return null;
        }
    }

    public void replaceAt(int x, int y, Tile newChar){
        if(x < guiArray.length && y < guiArray[0].length) {
            guiArray[x][y] = newChar;
        }
    }
    public void replaceAt(float x, float y, Tile newChar){
        if(x < guiArray.length && y < guiArray[0].length) {
            guiArray[(int)x][(int)y] = newChar;
        }
    }
    public void replaceAt(Vector2 vec, Tile newChar){
        if(vec.x < guiArray.length && vec.y < guiArray[0].length) {
            guiArray[(int)vec.x][(int)vec.y] = newChar;
        }
    }
}
