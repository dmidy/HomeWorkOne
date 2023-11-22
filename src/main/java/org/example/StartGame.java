package org.example;

import java.util.Scanner;

import static org.example.Answer.*;

public class StartGame {
    public static void startGame() {
        Scanner scan = new Scanner(System.in);
        new Answer(enterNumbText);

        boolean boxEmpty = false;
        int movesCounter = 0;
        int maxMoves = 9;

        while (movesCounter < maxMoves) {
            Board.displayBoard();

            if (!boxEmpty) {
                Board.clearBoard();
                boxEmpty = true;
            }

            Checker.userCheck();
            movesCounter++;

            if (Checker.checkWinner('X')) {
                new Answer(winText);
                scan.close();
                break;
            }

            Checker.botCheck();
            movesCounter++;

            if (Checker.checkWinner('O')) {
                new Answer(loseText);
                scan.close();
                break;
            }

            if (!Board.isBoxAvailable()) {
                new Answer(drawText);
                scan.close();
                break;
            }
        }
    }
}
