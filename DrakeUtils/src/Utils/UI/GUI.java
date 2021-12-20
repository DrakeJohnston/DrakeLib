package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Math.Vector2;
import Utils.Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public  ArrayList<ArrayList<Tile>> tileArrayList = new ArrayList<>();
    public  ArrayList<Entity> entityArrayList = new ArrayList<>();

    private boolean isActive = true;
    private Scanner in = new Scanner(System.in);
    private String guiName;

    private static ArrayList<GUI> guis = new ArrayList<>();

//    public GUI(ArrayList<ArrayList<Character>> g, String guiName, boolean active){
//        tileArrayList = Utility.charToTile(g, this);
//        this.guiName = guiName;
//        isActive = active;
//
//    }
    public GUI(Vector2 dim, String guiName, boolean active){
        this.guiName = guiName;
        isActive = active;

        for(int i = 0; i < dim.x; i++){
            tileArrayList.add(new ArrayList<>());
            for(int k =0; k < dim.y; k++){
                tileArrayList.get(i).add(new Tile(0, new Vector2(i,k), this));
            }
        }
    }

    public boolean IsActive(){ return isActive;}
    public void setActive(boolean val){  isActive = val;}

    public void RunGUI(){
        if(isActive) {
            DisplayGUI();
            UpdateGUI();
        }
    }

    public void UpdateGUI() {

    }

    //gets the next key pressed and passes it to parameter method of class chosen
    /*public void getInput(String className, String callMethod, Class<?>[] argTypes, Object[] methArgs){
        String input = in.nextLine().toUpperCase();

        try {
            methArgs[0] = input;
            Utility.launchProcess(className, callMethod, argTypes, methArgs);
        }
        catch (Exception e){ Debug.Log("Class Not Found");}

    }*/

    public void DisplayGUI(){
        for (int x = 0; x < tileArrayList.size(); x++) {
            System.out.print("\n");
            for (int y = 0; y < tileArrayList.get(x).size(); y++) {
                if(!tileArrayList.get(x).get(y).checkIfEntityAbove()){
                    System.out.print(ConsoleColors.BLUE + "0" + ConsoleColors.RESET);
                }else{
                    Entity e = FindEntByPos(new Vector2(x,y));
                    if(e != null) {
                        System.out.print(ConsoleColors.BLUE + e.getCharacter() + ConsoleColors.RESET);
                    }
                }
            }
        }

        Debug.printLn(" ");
    }

    public void MoveEntity(Entity e, Vector2 movement){
        e.setPos(movement);
    }

    public Entity FindEntByPos(Vector2 pos){
        Entity r = null;
        for (Entity e : entityArrayList){
            if(e.getPos().equals(pos)){
                r = e;
            }
        }
        return r;
    }


    public String getGuiName() {
        return guiName;
    }

    public Tile findTileAt(int x, int y){
        if(x < tileArrayList.size() && y < tileArrayList.get(0).size()) {
            return tileArrayList.get(x).get(y);
        }else{
            return null;
        }
    }

    public void replaceAt(int x, int y, Tile newChar){
        if(x < tileArrayList.size() && y < tileArrayList.get(0).size()) {
            tileArrayList.get(x).set(y, newChar);
        }
    }
    public void replaceAt(float x, float y, Tile newChar){
        if(x < tileArrayList.size() && y < tileArrayList.get(0).size()) {
            tileArrayList.get((int)x).set((int)y, newChar);
        }
    }
    public void replaceAt(Vector2 vec, Tile newChar){
        if(vec.x < tileArrayList.size() && vec.y < tileArrayList.get(0).size()) {
            tileArrayList.get((int)vec.x).set((int)vec.y, newChar);
        }
    }


    @Override
    public String toString() {
        return "GUI{" + "isActive=" + isActive + ", guiName='" + guiName + '\'' + '}';
    }
}
