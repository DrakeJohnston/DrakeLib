package Utils.UI;

import Utils.Debug;
import Utils.Entities.Entity;
import Utils.Math.Vector2;

import java.util.ArrayList;

public class Tile {
    public Vector2 gridPos;
    private int id;
    private GUI container;


    public Tile(int id, GUI container){
        this.id = id;
        this.container = container;
        //container.tileArrayList.get((int)gridPos.x).set((int)gridPos.y, this);
    }
    public Tile(int id, Vector2 pos, GUI container){
        this.id = id;
        this.container = container;
        gridPos = pos;
        //container.tileArrayList.get((int)gridPos.x).set((int)gridPos.y, this);
    }

    public int getId() {
        return id;
    }
    public Vector2 getGridPos() { return gridPos; }
    public GUI getContainer() { return container; }
    public void setId(int id) {this.id = id;}
    public void setContainer(GUI container) {
        this.container = container;
    }

    public boolean checkIfEntityAbove(){
        boolean check = false;
        int count = 0;
        for (Entity e : container.entityArrayList){
            if(e.getPos().equals(this.gridPos)){
                check = true;
                count++;

            }
        }
        return check;
    }

    public ArrayList<Entity> entitiesAbove(){
        ArrayList<Entity> temp = new ArrayList<>();
        ArrayList<Entity> arr = new ArrayList<>();

        for (Entity e : container.entityArrayList){
            if(e.getPos().equals(this.gridPos)){
                temp.add(e);
            }
        }

        for(int i = 0; i < temp.size(); i++){
            Entity tempEnt = temp.get(i);
            for (int k = i+1; k < temp.size(); k++){
                if(tempEnt.getPos().equals(temp.get(k).getPos())){
                    arr.add(tempEnt);
                    arr.add(temp.get(k));
                }
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        return gridPos.toString();
    }
}
