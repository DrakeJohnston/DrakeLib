package Utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class InputHandler {

    private static Scanner in = new Scanner(System.in);
    public enum keybinds {
        Q_KEY,
        W_KEY,
        E_KEY,
        R_KEY,
        T_KEY,
        Y_KEY,
        U_KEY,
        I_KEY,
        O_KEY,
        P_KEY,
        A_KEY,
        S_KEY,
        D_KEY,
        F_KEY,
        G_KEY,
        H_KEY,
        J_KEY,
        K_KEY,
        L_KEY,
        Z_KEY,
        X_KEY,
        C_KEY,
        V_KEY,
        B_KEY,
        N_KEY,
        M_KEY,
        ENTER_KEY,
    }

    HashMap<String, Integer> keys = new HashMap<>();

    public static keybinds GetKeyPressed(){
        keybinds key = keybinds.A_KEY;
        String s = in.nextLine().toLowerCase(Locale.ROOT);

        if(!s.isBlank()){
            switch (s){
                case "q":
                    key = keybinds.Q_KEY;
                    break;
                case "w":
                    key = keybinds.W_KEY;
                    break;
                case "e":
                    key = keybinds.E_KEY;
                    break;
                case "r":
                    key = keybinds.R_KEY;
                    break;
                case "t":
                    key = keybinds.T_KEY;
                    break;
                case "y":
                    key = keybinds.Y_KEY;
                    break;
                case "u":
                    key = keybinds.U_KEY;
                    break;
                case "i":
                    key = keybinds.I_KEY;
                    break;
                case "o":
                    key = keybinds.O_KEY;
                    break;
                case "p":
                    key = keybinds.P_KEY;
                    break;
                case "a":
                    key = keybinds.A_KEY;
                    break;
                case "s":
                    key = keybinds.S_KEY;
                    break;
                case "d":
                    key = keybinds.D_KEY;
                    break;
                case "f":
                    key = keybinds.F_KEY;
                    break;
                case "g":
                    key = keybinds.G_KEY;
                    break;
                case "h":
                    key = keybinds.H_KEY;
                    break;
                case "j":
                    key = keybinds.J_KEY;
                    break;
                case "k":
                    key = keybinds.K_KEY;
                    break;
                case "l":
                    key = keybinds.L_KEY;
                    break;
                case "z":
                    key = keybinds.Z_KEY;
                    break;
                case "x":
                    key = keybinds.X_KEY;
                    break;
                case "c":
                    key = keybinds.C_KEY;
                    break;
                case "v":
                    key = keybinds.V_KEY;
                    break;
                case "b":
                    key = keybinds.B_KEY;
                    break;
                case "n":
                    key = keybinds.N_KEY;
                    break;
                case "m":
                    key = keybinds.M_KEY;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + in.nextLine().toUpperCase(Locale.ROOT));
            }
        }else{
            key = keybinds.ENTER_KEY;
        }
        return key;
    }

    public static String GetRawInput(){
        return in.nextLine().toUpperCase(Locale.ROOT);
    }

}
