package Utils;

import java.util.Scanner;

public class InputHandler {

    private static Scanner in = new Scanner(System.in);

    public static String GetKeyPressed(){
        return in.nextLine();
    }

}
