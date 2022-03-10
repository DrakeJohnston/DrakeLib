package Utils.Entities;

import Utils.Debug;
import Utils.Math.Vector2;
import Utils.UI.GUI;

public class Entity {
    private char character = ' ';
    protected Vector2 pos;
    protected GUI container;
    protected boolean passable;
    protected int renderOrder = 0;
    protected boolean isHidden = false;

    public static int count;

    public Entity(char c, Vector2 pos, GUI container){
        this.character = c;
        this.pos = pos;
        this.container = container;
        this.passable = false;
        container.entityArrayList.add(this);
        count++;
    }
    public Entity(char c, Vector2 pos, GUI container, boolean passable){
        this.character = c;
        this.pos = pos;
        this.container = container;
        this.passable = passable;
        container.entityArrayList.add(this);
        count++;
    }
    public Entity(char c, Vector2 pos, GUI container, int renderOrder){
        this.character = c;
        this.pos = pos;
        this.container = container;
        this.passable = false;
        this.renderOrder = renderOrder;
        container.entityArrayList.add(this);
        count++;
    }
    public Entity(char c, Vector2 pos, GUI container, boolean passable, int renderOrder){
        this.character = c;
        this.pos = pos;
        this.renderOrder = renderOrder;
        this.container = container;
        this.passable = passable;
        container.entityArrayList.add(this);
        count++;
    }
    public Entity(char c, Vector2 pos, GUI container, boolean passable, int renderOrder, boolean isHidden){
        this.character = c;
        this.isHidden = isHidden;
        this.pos = pos;
        this.renderOrder = renderOrder;
        this.container = container;
        this.passable = passable;
        container.entityArrayList.add(this);
        count++;
    }

    public char getCharacter() { return character; }
    public GUI getContainer() { return container; }
    public Vector2 getPos() { return pos; }
    public int getRenderOrder() { return renderOrder; }

    public boolean isHidden() { return isHidden; }

    public boolean isPassable() { return passable; }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
    public void setCharacter(char character) { this.character = character; }
    public void setPassable(boolean passable) { this.passable = passable; }
    public void setRenderOrder(int renderOrder) { this.renderOrder = renderOrder; }
    public void setContainer(GUI container) { this.container = container; }

    public void setHidden(boolean hidden) { isHidden = hidden; }

    @Override
    public String toString() {
        return "Entity{" + "character=" + character + ", pos=" + pos + ", container=" + container + ", isHidden" + isHidden +'}';
    }
}
