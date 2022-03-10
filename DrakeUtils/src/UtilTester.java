import Utils.ConsoleColors;
import Utils.Debug;
import Utils.Entities.EntityGroup;
import Utils.InputHandler;
import Utils.Math.Vector2;
import Utils.Entities.Entity;
import Utils.UI.GUI;

public class UtilTester {
    static boolean isRunning = true;

    public static GUI game = new GUI(new Vector2(5, 15), "game", '`', true);
    public static GUI main = new GUI(new Vector2(5, 15), "main", '`',false);

    public static Entity cursor = new Entity('@', new Vector2(2,6), game);

    public static Entity test3 = new Entity('9', new Vector2(4,10), game, false,10, false);
    public static Entity test4 = new Entity('8', new Vector2(4,10), game, 1);
    public static Entity test5 = new Entity('2', new Vector2(4,10), game, 2);
    public static Entity test6 = new Entity('E', new Vector2(4,10), game, 9);

    public static EntityGroup hello = new EntityGroup("Hello World!", new Vector2(0,0), main);

    public static EntityGroup test2 = new EntityGroup("****",
            new Vector2(2,0),
            new Vector2[]{new Vector2(0,0), new Vector2(1,0),new Vector2(0,1),new Vector2(1,1)},
            game);

    static boolean menuToggled = false;

    public static void main(String[] args){

        while(isRunning) {
            for(GUI g : GUI.getGuis()){
                if(g.IsActive()){
                    g.RunGUI();
                }
            }
            HandleInput();
        }

    }

    public static void HandleInput(){
        InputHandler.keybinds in = InputHandler.GetKeyPressed();
        if(in == InputHandler.keybinds.S_KEY){
            //game.MoveEntity(cursor, new Vector2(cursor.getPos().x + 1, cursor.getPos().y));
            game.ShiftAllEntities(new Vector2(-1,  0), new Entity[]{cursor});
        }
        if(in == InputHandler.keybinds.W_KEY){
            //game.MoveEntity(cursor, new Vector2(cursor.getPos().x - 1, cursor.getPos().y));
            game.ShiftAllEntities(new Vector2(1,  0), new Entity[]{cursor});
        }
        if(in == InputHandler.keybinds.A_KEY){
            //game.MoveEntity(cursor, new Vector2(cursor.getPos().x, cursor.getPos().y - 1));
            game.ShiftAllEntities(new Vector2(0,  1), new Entity[]{cursor});
        }
        if(in == InputHandler.keybinds.D_KEY){
            //game.MoveEntity(cursor, new Vector2(cursor.getPos().x, cursor.getPos().y + 1));
            game.ShiftAllEntities(new Vector2(0,  -1), new Entity[]{cursor});
        }
        if(in == InputHandler.keybinds.P_KEY){
            if(menuToggled){
                main.setActive(false);
                game.setActive(true);
                menuToggled = false;
            }
            else{
                main.setActive(true);
                game.setActive(false);
                menuToggled = true;
            }
        }
        if(in == InputHandler.keybinds.L_KEY){
            test2.setCharacters("*@**", test2.guiPoints);
        }
        if(in == InputHandler.keybinds.Z_KEY){
            test2.groupHidden(false);
        }
    }

}
