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

    static  int[][] selPoints = {
            {1,7},
            {3,7}
    };

    public static GUI gui = new GUI(menu, selPoints);

    public static void main(String[] args){

        while(isRunning) {
            gui.UpdateGUI();
            gui.DisplayGUI();

            Class<?>[] argTypes = {String.class};
            Object[] arguments = {" "};
            gui.getInput("UtilTester", "test", argTypes, arguments);
        }
    }

    public static void test(String letter){
        if(letter.equals("W")){
            gui.setSelector(gui.getSelector() - 1);
        }else if(letter.equals("S")){
            gui.setSelector(gui.getSelector() + 1);
        }else if(letter.equals("")){
            if(gui.getSelector() == 1){
                isRunning = false;
            }
        }
    }
}
