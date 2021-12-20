package Utils;
import java.time.LocalTime;
import java.util.ArrayList;

public class Debug {
    static LocalTime curTime = LocalTime.now();
    static ConsoleColors cc;

    //Sometimes you just wanna print
    public static void print(String s){
        System.out.print(s);
    }
    public static void print(String s, String cColor){
        System.out.print(cColor + s + cc.RESET);
    }
    public static void print(int i){
        System.out.print(i);
    }
    public static void print(long i){
        System.out.print(i);
    }

    public static void printLn(String s){
        System.out.println(s);
    }
    public static void printLn(String s, String cColor){
        System.out.println(cColor + s + cc.RESET);
    }
    public static void printLn(int i){
        System.out.println(i);
    }

    //normal print statement with time stamp
    public static void Log(String log){
        System.out.println(cc.WHITE_BOLD_BRIGHT + curTime + ": " + log + cc.RESET);
    }
    //allows you to pick a color from ConsoleColors
    public static void Log(String log, String cColor){
        System.out.println(cColor + curTime + ": " + log + cc.RESET);
    }

    //just loggin
    public static void Log(int log){
        System.out.println(cc.WHITE_BOLD_BRIGHT + curTime + ": " + log + cc.RESET);
    }

    //does same thing as log but different color for color coding (YELLOW)
    public static void LogWarning(String log){
        System.out.println(cc.YELLOW_BOLD + curTime + ": " + log + cc.RESET);
    }

    //does same thing as log but different color for color coding (RED)
    public static void LogError(String log){
        System.out.println(cc.RED_BOLD + curTime + ": " + log + cc.RESET);
    }

    //printing every element of an array of an array (2d STRING arrays)
    public static void PrintDoubleArray(String[][] array){
        for (int x=0; x < array.length; x++){
            System.out.print("\n");
            for (int y=0; y < array[0].length; y++){
                System.out.print(array[x][y]);
            }
        }
    }

    //printing every element of an array of an array (2d int arrays)
    public static void PrintDoubleArray(int[][] array){
        for (int x=0; x < array.length; x++){
            System.out.print("\n");
            for (int y=0; y < array[0].length; y++){
                System.out.print(array[x][y]);
            }
        }
    }

    //printing every element of an array of an array (2d double arrays)
    public static void PrintDoubleArray(double[][] array){
        for (int x=0; x < array.length; x++){
            System.out.print("\n");
            for (int y=0; y < array[0].length; y++){
                System.out.print(array[x][y]);
            }
        }
    }

    //printing every element of an array of an array (2d char arrays)
    public static void PrintDoubleArray(char[][] array){
        for (int x=0; x < array.length; x++){
            System.out.print("\n");
            for (int y=0; y < array[0].length; y++){
                System.out.print(array[x][y]);
            }
        }
    }
    //printing every element of an array of an array (2d char arrays)
    public static void PrintDoubleArray(ArrayList<ArrayList<Character>> array){
        for (int x=0; x < array.size(); x++){
            System.out.print("\n");
            for (int y=0; y < array.get(x).size(); y++){
                System.out.print(array.get(x).get(y));
            }
        }
    }
}
