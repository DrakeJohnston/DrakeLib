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

    Vector2[] selectionPoints;
    int selectedOption = 0;

    Tile selector = new Tile('@', new Vector2(1,1));
    Tile defaultChar = new Tile(' ');
    Vector2 lastPos = new Vector2(1,1);

    boolean freeSelect = false;
    boolean isActive;
    Scanner in = new Scanner(System.in);

    //todo: setup a value to set selector
    public GUI(Tile[][] g, Vector2[] points, boolean active, Tile defChar){
        guiArray = g;
        selectionPoints = points;
        defaultChar = defChar;
        isActive = active;
    }
    public GUI(Tile[][]g, boolean isActive, Tile defChar){
        guiArray = g;
        this.isActive = isActive;
        defaultChar = defChar;
        freeSelect = true;
    }
    public GUI(char[][] g, Vector2[] points, boolean active, char defChar){
        guiArray = Utility.charToTile(g);
        selectionPoints = points;
        defaultChar = Utility.charToTile(defChar);
        isActive = active;
    }
    public GUI(char[][]g, boolean isActive, char defChar){
        guiArray = Utility.charToTile(g);
        this.isActive = isActive;
        defaultChar = Utility.charToTile(defChar);
        freeSelect = true;
    }


    public int getSelector(){return selectedOption;}

    public void setSelector(int i){selectedOption = i;}

    public boolean IsActive(){ return isActive;}
    public void setActive(boolean val){  isActive = val;}

    public void moveSelector(float x, float y){
        //todo: fix so that when characters are at x one they can move left
        if((x < guiArray[0].length && y < guiArray.length) || (x < 0 && y < 0)) {
            lastPos.x = selector.getGridPos().x;
            lastPos.y = selector.getGridPos().y;

            selector.setGridPos(new Vector2(x, y));
        }
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
                    guiArray[(int)selectionPoints[i].x][(int)selectionPoints[i].y] = selector;
                } else if (i != selectedOption) {
                    guiArray[(int)selectionPoints[i].x][(int)selectionPoints[i].y] = defaultChar;
                }
            }
        }else{
            replaceAt(selector.getGridPos().x, selector.getGridPos().y, selector);
            replaceAt(lastPos.x, lastPos.y, defaultChar);
        }
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
