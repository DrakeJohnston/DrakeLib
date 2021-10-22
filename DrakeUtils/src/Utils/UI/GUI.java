package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;

import java.util.Arrays;
import java.util.Scanner;

//the gui class depends on drake's library specificaly ConsoleColors
public class GUI{

    public int selector = 0;
    public String[] titleGraphics;
    public String[] titleColors;

    public String[] menuGraphics;
    public String[] menuOptions;

    String titleMenuNames;
    boolean isActive = false;
    Scanner input = new Scanner(System.in);

    public GUI(String[] titleG, String[] menuG, String[] menuOps, boolean startActive){
        titleGraphics = titleG;
        menuGraphics = menuG;
        isActive = startActive;
        menuOptions = menuOps;
    }
    public GUI(String[] titleG, String[] tColors, String[] menuG, String cName, String[] menuOps,  boolean startActive){
        titleGraphics = titleG;
        titleColors = tColors;
        menuGraphics = menuG;
        isActive = startActive;
        menuOptions = menuOps;
        titleMenuNames = cName;
    }
    public GUI(String[] titleG, String[] menuG, String cName, String[] menuOps, boolean startActive){
        titleGraphics = titleG;
        menuGraphics = menuG;
        isActive = startActive;
        menuOptions = menuOps;
        titleMenuNames = cName;
    }
    public GUI(String[] menuG, String cName, String[] menuOps, boolean startActive){
        menuGraphics = menuG;
        isActive = startActive;
        menuOptions = menuOps;
        titleMenuNames = cName;
    }
    public GUI(boolean startActive){
        isActive = startActive;
    }

    public void RunGUI(){

        while(isActive == true){
            InitGUI();
            if(menuGraphics != null) {
                displayMenu();
            }

            Debug.printLn(" ");
            Debug.print("Press w or s to go up or down the menu and then press enter to select: ");
            String selection = input.nextLine().toUpperCase();

            if(selection.equals("W")){
                selector--;
            }else if(selection.equals("S")){
                selector++;
            }else if(selection.isEmpty()){
                if(selector == 0){
                    isActive = false;
                }else{
                    isActive = false;
                }
            }
            ConsoleColors.clearScreen();
        }
    }

    public void InitGUI(){
        ConsoleColors.clearScreen();
        if(titleGraphics != null) {
            WriteTitle();
        }
        Debug.printLn(" ");
        if(titleMenuNames != null){
            Debug.printLn("Courtesy of "+ titleMenuNames, ConsoleColors.BLUE);
        }
        Debug.printLn(" ");

        if(menuGraphics != null) {
            int optionLevel = 0;
            for (int i = 0; i < menuGraphics.length; i++) {
                if (menuGraphics[i].indexOf('0') != -1) {
                    menuGraphics[i] = "|            " + menuOptions[optionLevel] + "            |";
                    optionLevel++;
                }
            }
        }
    }

    public void displayMenu(){
        for(int i=0; i < menuGraphics.length; i++){
            if(menuGraphics[i].indexOf('0') != -1 || menuGraphics[i].indexOf('P') != -1 || menuGraphics[i].indexOf('E') != -1){
                if(i == 2 && selector == 0){
                    menuGraphics[i] = "|            "+ menuOptions[0] +"            |";
                    Debug.printLn(menuGraphics[i]);
                }else if(i==4 && selector == 1){
                    menuGraphics[i] = "|            "+ menuOptions[1] +"            |";
                    Debug.printLn(menuGraphics[i]);
                }
                else{
                    Debug.printLn(menuGraphics[i],ConsoleColors.BLUE);
                }
            }else{
                Debug.printLn(menuGraphics[i],ConsoleColors.BLUE);
            }
        }
    }

    //prints the ascii art title
    public void WriteTitle(){
        for(int i=0; i < titleGraphics.length; i++){
            if(i != titleColors.length)
            {
                Debug.printLn(titleGraphics[i], titleColors[i]);
            }else{
                Debug.printLn(titleGraphics[i]);
            }
        }
    }

}
