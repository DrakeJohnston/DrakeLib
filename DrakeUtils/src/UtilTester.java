import Utils.UI.GUI;

public class UtilTester {
    static boolean isRunning = true;
    static char[][] menu = {
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','P','l','a','y','0','0','0'},
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

    static  int[][] mainMenuPoints = {
            {1,7},
            {3,7}
    };

    public static GUI mainMenu = new GUI(menu, mainMenuPoints, true, '0');
    public static GUI game = new GUI(gamemenu, false, '0');

    public static  GUI[] guis = {
            mainMenu,
            game
    };

    public static void main(String[] args){

        while(isRunning) {

            for (int i=0; i < guis.length; i++){
                if(guis[i].IsActive() == true){

                    Class<?>[] argTypes = {String.class};
                    Object[] arguments = {" "};
                    GUI gui = guis[i];

                    gui.RunGUI();
                    gui.getInput("UtilTester", "useInput", argTypes, arguments);
                }
            }

        }
    }

    public static void useInput(String letter){
        if(mainMenu.IsActive()) {
            HandleMainMenuInput(letter);
        }else if(game.IsActive()){
            HandleGameInput(letter);
        }
    }

    private static void HandleGameInput(String letter) {
        int[] pos = game.getSelectorPos();
        switch (letter){
            case "W":
                game.moveSelector(pos[0] - 1, pos[1]);
                break;
            case "A":
                game.moveSelector(pos[0], pos[1] - 1);
                break;
            case "S":
                game.moveSelector(pos[0] + 1, pos[1]);
                break;
            case "D":
                game.moveSelector(pos[0], pos[1] + 1);
                break;
        }
    }

    private static void HandleMainMenuInput(String letter) {
        if (letter.equals("W")) {
            mainMenu.setSelector(mainMenu.getSelector() - 1);
        } else if (letter.equals("S")) {
            mainMenu.setSelector(mainMenu.getSelector() + 1);
        } else if (letter.equals("")) {

            if (mainMenu.getSelector() == 0) {
                game.setActive(true);
                mainMenu.setActive(false);
            } else if (mainMenu.getSelector() == 1) {
                isRunning = false;
            }

        }
    }
}
