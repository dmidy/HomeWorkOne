package org.example;

import static org.example.Answer.*;
import java.util.Scanner;

public class Board {
    static byte input;
    static byte rand;
    static byte i;
    static char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static void displayBoard() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        new Answer(betweenLines);
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        new Answer(betweenLines);
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public static void clearBoard() {
        for (i = 0; i < 9; i++)
            box[i] = ' ';
    }



    public static boolean isBoxAvailable() {
        for (i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }
}