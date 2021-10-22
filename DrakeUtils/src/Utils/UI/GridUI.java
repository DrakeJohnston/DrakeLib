package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Grid;
import Utils.Utility;

public class GridUI extends GUI{

    public String[][] menu;
    public Grid grid;

    public GridUI(Grid gridToUse, boolean startActive) {
        super(startActive);
        grid = gridToUse;
        menu = grid.getGridAsString();
    }

    @Override
    public void RunGUI(){
        while(isActive){
            InitGUI();
            displayMenu();

            Debug.printLn(" ");
            Debug.printLn("Please use wasd to move you cursor around!");
            Debug.printLn("Type the key then press enter to move: ");

            String selection = input.nextLine().toUpperCase();
            switch (selection){
                case "W":
                    Debug.Log("W Pressed");
                    break;
                case "A":
                    Debug.Log("A Pressed");
                    break;
                case "S":
                    Debug.Log("S Pressed");
                    break;
                case "D":
                    Debug.Log("D Pressed");
                    break;
                default:
                    Debug.Log("HMMMM THATS NOT WASD");
                    break;
            }

            Utility.Wait(750);
            ConsoleColors.clearScreen();
        }
    }

    @Override
    public void displayMenu() {
        Debug.PrintDoubleArray(menu);
    }
}
