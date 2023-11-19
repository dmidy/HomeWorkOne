package org.example;

import org.example.Answer;

import java.util.Scanner;

public class LogicGame extends Answer {
    Answer answer = new Answer();
    Scanner scan = new Scanner(System.in);
    byte input;
    byte rand;
    byte i;
    boolean boxAvailable = false;
    byte winner = 0;
    char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public void startGame() {
        answer.answerOut(enterNumbText);

        boolean boxEmpty = false;
        int movesCounter = 0;
        int maxMoves = 9;

        while (movesCounter < maxMoves) {
            displayBoard();

            if (!boxEmpty) {
                clearBoard();
                boxEmpty = true;
            }

            userCheck();
            movesCounter++;

            if (checkWinner('X')) {
                answer.answerOut(winText);
                break;
            }

            botCheck();
            movesCounter++;

            if (checkWinner('O')) {
                answer.answerOut(loseText);
                break;
            }

            if (!isBoxAvailable()) {
                answer.answerOut(drawText);
                break;
            }
        }
    }

    public void displayBoard() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        answer.answerOut(betweenLines);
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        answer.answerOut(betweenLines);
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void clearBoard() {
        for (i = 0; i < 9; i++)
            box[i] = ' ';
    }

    public void userCheck() {
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

    public void botCheck() {
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    public void winnerCheck() {
        if (checkWinner('X')) {
            answer.answerOut(winText);
            System.exit(0);
        } else if (checkWinner('O')) {
            answer.answerOut(loseText);
            System.exit(0);
        } else if (!isBoxAvailable()) {
            answer.answerOut(drawText);
            System.exit(0);
        }
    }

    public boolean checkWinner(char symbol) {
        return ((box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol));
    }

    public boolean isBoxAvailable() {
        for (i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }
}