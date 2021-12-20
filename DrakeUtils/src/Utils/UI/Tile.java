package Utils.UI;

import Utils.Debug;
import Utils.Math.Vector2;

import java.util.ArrayList;

public class Tile {
    public Vector2 gridPos;
    private int id;
    private static GUI container;


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

    public boolean checkIfEntityAbove(){
        for (int i = 0; i < container.entityArrayList.size(); i++){
            Entity e = container.entityArrayList.get(i);
            if(e.getPos().equals(this.gridPos)){
                return true;
            }
        }
        return false;
    }


    public static int findNextAvailibleID(){
        int id = 0;
        for (int i = 0; i < container.tileArrayList.size(); i++){
            for(int k = 0; k < container.tileArrayList.get(i).size(); k++) {
                Tile t = container.tileArrayList.get(i).get(k);
                if (t.getId() == id) {
                    continue;
                } else {
                    id = t.getId() + 1;
                    break;
                }
            }
        }
        return id;
    }

    @Override
    public String toString() {
        return gridPos.toString();
    }
}
