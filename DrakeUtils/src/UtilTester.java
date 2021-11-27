import Utils.Math.Vector2;
import Utils.UI.GUI;

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
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'}
    };

    static  Vector2[] mainMenuPoints = {
            new Vector2(1,7),
            new Vector2(3,7)
    };

    public static GUI mainMenu = new GUI(menu, "mainMenu", true);
    public static GUI game = new GUI(gamemenu, "game", true);

    public static  GUI[] guis = {
            mainMenu,
            game
    };

    public static void main(String[] args){

        while(isRunning) {

            for (int i=0; i < guis.length; i++){
                if(guis[i].IsActive() == true){

                    //Class<?>[] argTypes = {String.class};
                    //Object[] arguments = {" "};
                    GUI gui = guis[i];

                    gui.RunGUI();
                    //gui.getInput("UtilTester", "useInput", argTypes, arguments);
                }
            }

        }
    }

}
