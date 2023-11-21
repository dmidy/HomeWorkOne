package org.example;

import java.util.Scanner;

import static org.example.Answer.*;
import static org.example.Board.*;

public class Checker {

    public static void userCheck() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            answer.answerOut(enterOnlyNumb);
            try {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                        answer.answerOut(anotherEnterText);
                    } else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else {
                    answer.answerOut(invalidInputText);
                }
            } catch (java.util.InputMismatchException e) {
                scan.nextLine();
                answer.answerOut(invalidInputText);
            }
        }
    }

    public static void botCheck() {
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    public static boolean checkWinner(char symbol) {
        return ((box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol));
    }
}
