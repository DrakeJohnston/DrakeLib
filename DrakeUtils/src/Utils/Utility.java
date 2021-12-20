package Utils;

import Utils.Math.Vector2;
import Utils.UI.GUI;
import Utils.UI.Tile;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

//Drakes Utility library
public class Utility {

    //converts string into a char array
    public static char[] StringToCharArray(String s){
        String[] strings = s.split(" ");
        String tmp  = " ";
        for (String n : strings){ tmp += n; }
        char[] c = tmp.toCharArray();
        return c;
    }

    //converts string into a string array
    public static String[] StringToStringArray(String s){
        String[] strings = s.split(" ");
        return strings;
    }

    //converts string into a int array
    public static int[] StringToIntArray(String s){
        String[] numStrings = s.split(" ");
        ArrayList<Integer> convertedInts = new ArrayList<Integer>();
        for (int i=0; i < numStrings.length; i++){
            convertedInts.add(Integer.parseInt(numStrings[i]));
        }
        int[] ints = convertIntArrFromArrList(convertedInts);
        return ints;
    }

    public static String[][] Int2DArrayToString2D(int[][] array2D){
        String[][] stringArray = new String[array2D.length][array2D[0].length];
        for (int i=0; i < stringArray.length; i++){
            for (int j=0; j < stringArray[i].length; j++){
                stringArray[i][j] = String.valueOf(array2D[i][j]);
            }
        }
        return stringArray;
    }

    //converts a array list into a int array
    public static int[] convertIntArrFromArrList(ArrayList<Integer> arrayList){
        int[] tmp = new int[arrayList.size()];
        for (int i=0; i < arrayList.size(); i++){
            tmp[i] = arrayList.get(i);
        }

        return tmp;
    }

    //converts a array list into a string array
    public static String[] convertStringArrFromArrList(ArrayList<String> arrayList){
        String[] tmp = new String[arrayList.size()];
        for (int i=0; i < arrayList.size(); i++){
            tmp[i] = arrayList.get(i);
        }

        return tmp;
    }

    public static ArrayList<ArrayList<Character>> CharAToAL(char[][] chars){
        ArrayList<ArrayList<Character>> c = new ArrayList<>();

        for(int i=0; i < chars.length; i++){
            ArrayList<Character> b = new ArrayList<>();
            for (int k=0; k < chars[i].length; k++){
                Character ch = Character.valueOf(chars[i][k]);
                b.add(ch);
                //Debug.printLn(ch);
            }
            c.add(b);
        }
        return c;
    }

    //returns a random array of type string from a string double array
    public static String[] getRandom(String[][] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    //concatinates a string from the array argument
    public static String StringArrayConcat(String[] arr){
        String cat = "";
        for(String val : arr){

            cat += val;
        }
        return cat;
    }


    //waits for the amount of time given in milliseconds
    public static void Wait(int time /*milliseconds*/){
        try{Thread.sleep(time);} catch(InterruptedException e){}
        //todo: add somthing if inturrupted
    }

    public static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(Debug.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
                return ste.getClassName();
            }
        }
        return null;
    }

    public static Object launchProcess(String className, String methodName, Class<?>[] argsTypes, Object[] methodArgs)
            throws Exception {

        Class<?> processClass = Class.forName(className); // convert string classname to class
        Object process = processClass.newInstance(); // invoke empty constructor

        Method aMethod = process.getClass().getMethod(methodName,argsTypes);
        Object res = aMethod.invoke(process, methodArgs); // pass arg
        return(res);
    }

}
