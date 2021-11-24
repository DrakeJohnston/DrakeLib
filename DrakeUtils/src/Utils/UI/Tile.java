package Utils.UI;

import Utils.Math.Vector2;

public class Tile {
    private char glyph = ' ';
    private Vector2 gridPos;

    public Tile(char glyph){
        this.glyph = glyph;
    }
    public Tile(char glyph, Vector2 pos){
        this.gridPos = pos;
    }

    public Vector2 getGridPos() {
        return gridPos;
    }
    public char getGlyph() {
        return glyph;
    }

    public void setGlyph(char glyph) {
        this.glyph = glyph;
    }
    public void setGridPos(Vector2 gridPos) {
        this.gridPos = gridPos;
    }
}
