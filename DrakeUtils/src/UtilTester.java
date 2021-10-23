import Utils.Debug;
import Utils.Grid;
import Utils.UI.GUIV2;
import Utils.UI.GridUI;

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
            {4,7}
    };

    public static void main(String[] args) {
        GUIV2 gui = new GUIV2(menu, selPoints);

        while(isRunning) {
            gui.DisplayGUI();
            gui.UpdateGUI();

        }
    }
}
