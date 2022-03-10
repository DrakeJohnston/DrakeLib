package Utils.Entities;

import Utils.Debug;
import Utils.Math.Vector2;
import Utils.UI.GUI;
import Utils.Utility;

import java.util.ArrayList;


public class EntityGroup {

    private ArrayList<Entity> characters = new ArrayList<>();
    private GUI entContainer;
    Vector2 position = new Vector2();
    public Vector2[] guiPoints;

    public EntityGroup(String text, Vector2 startPos, GUI entContainer){
        this.entContainer =  entContainer;
        this.position.add(startPos);
        char[] chars = Utility.StringToCharArray(text);

        for(int i = 0; i < chars.length; i++) {
            Entity e = new Entity(chars[i], new Vector2(startPos.x, startPos.y+=1), entContainer);
            this.characters.add(e);
        }
    }

    public EntityGroup(String text, Vector2 startPos, Vector2[] points, GUI entContainer){
        this.entContainer =  entContainer;
        this.position.add(startPos);
        char[] chars = Utility.StringToCharArray(text);
        guiPoints = points;
        for(int i = 0; i < chars.length; i++) {
            //todo: add error check if there are not enough points
            Vector2 pos = Vector2.AddVectors(startPos, points[i]);
            Entity e = new Entity(chars[i], pos, entContainer);
            this.characters.add(e);
        }
    }

    public GUI getEntContainer() {
        return entContainer;
    }
    public ArrayList<Entity> getCharacters() {
        return characters;
    }

    public void setEntContainer(GUI entContainer) {
        this.entContainer = entContainer;
        for(Entity e : characters){
            e.setContainer(entContainer);
        }
    }
    public void setCharacters(String characters) {
        char[] chars = Utility.StringToCharArray(characters);
        entContainer.RemoveEntity(this);
        for (int i = 0; i < chars.length; i++) {
            int temp = 1 + i;
            Entity e = new Entity(chars[i], new Vector2(position.x, position.y+temp), entContainer);
            this.characters.add(e);
            //this.characters.get(i).setCharacter(chars[i]);
        }
    }
    public void setCharacters(String characters, Vector2[] points) {
        char[] chars = Utility.StringToCharArray(characters);
        entContainer.RemoveEntity(this);
        for (int i = 0; i < chars.length; i++) {
            position.add(points[i]);
            Entity e = new Entity(chars[i], new Vector2(position.x, position.y), entContainer);
            this.characters.add(e);
            //this.characters.get(i).setCharacter(chars[i]);
            position.subtract(points[i]);
        }
    }

    public void groupHidden(boolean value){
        for (Entity e : characters){
            e.setHidden(value);
        }
    }

    public boolean getHidden(){ return characters.get(0).isHidden(); }

    public void MoveGroup(Vector2 dir){
        for(Entity e : characters){
            e.getPos().add(dir);
        }
    }

    @Override
    public String toString() {
        return "EntityGroup{" +
                "characters=" + characters +
                ", entContainer=" + entContainer +
                '}';
    }
}
