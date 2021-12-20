import Utils.Debug;
import Utils.InputHandler;
import Utils.Math.Vector2;
import Utils.UI.Entity;
import Utils.UI.GUI;
import Utils.UI.Tile;
import Utils.Utility;
import jdk.jshell.execution.Util;

import java.util.ArrayList;

public class UtilTester {
    static boolean isRunning = true;
    static char[][] menu = {
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','P','l','a','y','@','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','E','x','i','t','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'}
    };
    static char[][] gamemenu = {
            {'0','1','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','@','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'}
    };


    public static GUI game = new GUI(new Vector2(5, 15), "game", true);



    public static void main(String[] args){

        GUI gui = game;
        Entity cursor = new Entity('@', new Vector2(0,0), game);

        while(isRunning) {


            //Class<?>[] argTypes = {String.class};
            //Object[] arguments = {" "};
            //gui.getInput("UtilTester", "useInput", argTypes, arguments);

            gui.RunGUI();
            String s = InputHandler.GetKeyPressed();
            if(s.equals("s") || s.equals("S")){
                gui.MoveEntity(cursor, new Vector2(cursor.getPos().x + 1, cursor.getPos().y));
            }
            if(s.equals("w") || s.equals("W")){
                gui.MoveEntity(cursor, new Vector2(cursor.getPos().x - 1, cursor.getPos().y));
            }
            if(s.equals("a") || s.equals("A")){
                gui.MoveEntity(cursor, new Vector2(cursor.getPos().x, cursor.getPos().y - 1));
            }
            if(s.equals("d") || s.equals("D")){
                gui.MoveEntity(cursor, new Vector2(cursor.getPos().x, cursor.getPos().y + 1));
            }

        }

    }

}
