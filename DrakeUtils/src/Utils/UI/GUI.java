package Utils.UI;

import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Entities.Entity;
import Utils.Entities.EntityGroup;
import Utils.Math.Vector2;

import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public ArrayList<ArrayList<Tile>> tileArrayList = new ArrayList<>();
    public ArrayList<Entity> entityArrayList = new ArrayList<>();
    public char[][] stage;

    private boolean isActive = true;
    private Scanner in = new Scanner(System.in);
    private String guiName;
    private char backgroundChar;
    private Vector2 DIM;

    private static ArrayList<GUI> guis = new ArrayList<>();

    public GUI(Vector2 dim, String guiName, char backGround, boolean active){
        this.guiName = guiName;
        this.DIM = dim;
        isActive = active;
        guis.add(this);
        backgroundChar = backGround;
        for(int i = 0; i < dim.x; i++){
            this.tileArrayList.add(new ArrayList<>());
            for(int k =0; k < dim.y; k++){
                this.tileArrayList.get(i).add(new Tile(backgroundChar, new Vector2(i,k), this));
                //Debug.printLn(this.toString());
            }
        }
        stage = new char[tileArrayList.size()][tileArrayList.get(0).size()];
    }

    public boolean IsActive(){ return isActive;}
    public void setActive(boolean val){  isActive = val;}
    public char getBackChar(){return backgroundChar;}
    public void getBackChar(char c){backgroundChar = c;}

    public Vector2 getDIM() { return DIM; }

    public void RunGUI(){
        if(isActive) {
            UpdateGUI();
            DisplayGUI();
        }
    }

    public void UpdateGUI() {
        for (int x = 0; x < this.tileArrayList.size(); x++) {
            System.out.print("\n");
            for (int y = 0; y < this.tileArrayList.get(x).size(); y++) {
                Tile t = tileArrayList.get(x).get(y);
                if(!t.checkIfEntityAbove()) {
                    stage[x][y] = backgroundChar;
                }else{
                    HandleEntityTypes(x, y, t);
                }
            }
        }
    }

    private void HandleEntityTypes(int x, int y, Tile t) {
        ArrayList<Entity> ents = t.entitiesAbove();
        Entity e;

        if(!ents.isEmpty()){
            e = compareRenderOrder(ents);
        }else{
            e = FindEntByPos(new Vector2(x, y));
        }

        if(e.isHidden()){
            stage[(int) e.getPos().x][(int) e.getPos().y] = backgroundChar;
            e = null;
            ents.remove(e);
        }

        if(e != null) {
            Debug.Log(e.toString());
            stage[x][y] = e.getCharacter();
        }
    }

    private Entity compareRenderOrder(ArrayList<Entity> ents) {
        Entity e = ents.get(0);
        for (int i = 0; i < ents.size() - 1; i++) {
            Entity currEnt = ents.get(i + 1);
            if (currEnt.getRenderOrder() >= e.getRenderOrder()) {
                e = currEnt;
            }
        }
        if(!e.isHidden()){
            return e;
        }else {
            ents.remove(e);
            return compareRenderOrder(ents);
        }
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

        for (int x = 0; x < this.stage.length; x++) {
            System.out.print("\n");
            for (int y = 0; y < this.stage[x].length; y++) {
                System.out.print(ConsoleColors.BLUE + stage[x][y] + ConsoleColors.RESET);
            }
        }

        Debug.printLn(" ");
    }

    /*
    *  Entity e = FindEntByPos(new Vector2(x,y));
                    if(e != null) {
                        if(e instanceof TextEntity){

                        }
                        else {
                            System.out.print(ConsoleColors.BLUE + e.getCharacter() + ConsoleColors.RESET);
                        }
                    }
    * */

    public void MoveEntity(Entity e, Vector2 movement){
        if(this.IsActive()) e.setPos(movement);
    }

    public void ShiftAllEntities(Vector2 dir){
        for(Entity e : entityArrayList){
            e.getPos().add(dir);
        }
    }
    public void ShiftAllEntities(Vector2 dir, Entity[] exceptions){
        for(Entity e : entityArrayList){
            for(Entity ex : exceptions) {
                if(!e.equals(ex)) {
                    e.getPos().add(dir);
                }
            }
        }
        //e.getPos().add(dir);
    }

    public void RemoveEntity(Entity e){
        for (int i = 0; i < entityArrayList.size(); i++) {
            if(e != null) {
                if (entityArrayList.get(i).getPos() == e.getPos() && entityArrayList.get(i).getCharacter() == e.getCharacter()) {
                    entityArrayList.remove(e);
                    e = null;
                }
            }
        }
    }
    public void RemoveEntity(EntityGroup e){
        for (int i = 0; i < entityArrayList.size(); i++) {
            for(Entity ent : e.getCharacters()) {
                entityArrayList.remove(ent);
            }
        }
    }

    public Entity FindEntByPos(Vector2 pos){
        Entity r = null;
        for (Entity e : this.entityArrayList){
            if(e.getPos().equals(pos)){
                r = e;
            }
        }
        return r;
    }


    public String getGuiName() {
        return guiName;
    }

    public static ArrayList<GUI> getGuis() {
        return guis;
    }
    public static GUI getGUI(String guiName){
        for (GUI g : guis){
            if(g.getGuiName().equals(guiName)){
                return g;
            }
        }
        return null;
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