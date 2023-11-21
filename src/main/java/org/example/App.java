package org.example;

import static org.example.Answer.*;

public class App{
    public static void startGame() {
        Answer answer = new Answer();
        answer.answerOut(enterNumbText);

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
                answer.answerOut(winText);
                break;
            }

            Checker.botCheck();
            movesCounter++;

            if (Checker.checkWinner('O')) {
                answer.answerOut(loseText);
                break;
            }

            if (!Board.isBoxAvailable()) {
                answer.answerOut(drawText);
                break;
            }
        }
    }
    public static void main(String[] args) {
        startGame();
    }
}