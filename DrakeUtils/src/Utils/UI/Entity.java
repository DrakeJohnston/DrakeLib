package Utils.UI;

import Utils.Debug;
import Utils.Math.Vector2;

public class Entity {
    private char character = ' ';
    private Vector2 pos;
    private GUI container;

    public static int count;

    public Entity(char c, Vector2 pos, GUI container){
        this.character = c;
        this.pos = pos;
        this.container = container;
        container.entityArrayList.add(this);
        count++;
    }

    public char getCharacter() { return character; }
    public GUI getContainer() { return container; }
    public Vector2 getPos() { return pos; }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
}
