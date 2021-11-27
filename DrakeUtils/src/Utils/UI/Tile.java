package Utils.UI;

import Utils.Math.Vector2;

import java.util.ArrayList;

public class Tile {
    private char glyph = ' ';
    private Vector2 gridPos;
    private int id;

    private static ArrayList<Tile> tiles = new ArrayList<>();

    public Tile(char glyph, int id){
        this.glyph = glyph;
        this.id = id;
    }
    public Tile(char glyph, int id,Vector2 pos){
        this.glyph = glyph; this.gridPos = pos;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public Vector2 getGridPos() {
        return gridPos;
    }
    public char getGlyph() {
        return glyph;
    }

    public void setId(int id) {this.id = id;}
    public void setGlyph(char glyph) {
        this.glyph = glyph;
    }
    public void setGridPos(Vector2 gridPos) {
        this.gridPos = gridPos;
    }

    public static Tile findTileByGlyph(char g){
        for(Tile t : tiles){
            if(t.getGlyph() == g){
                return t;
            }
        }
        return null;
    }
    public static Tile findTileByID(int id){
        for(Tile t : tiles){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    public static int findNextAvailibleID(){
        int id = 0;
        for (int i = 0; i < tiles.size(); i++){
            Tile t = tiles.get(i);
            if(t.getId() == id){
                continue;
            }else{
                id = t.getId() + 1;
                break;
            }
        }
        return id;
    }
}
