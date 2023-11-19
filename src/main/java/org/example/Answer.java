package org.example;

public class Answer {
    protected static final String enterNumbText = "Enter box number to select. Enjoy!\n";
    protected static final String winText = "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    protected static final String loseText = "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    protected static final String drawText = "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
    protected static final String anotherEnterText = "That one is already in use. Enter another.";
    protected static final String invalidInputText = "Invalid input. Enter again.";
    protected static final String enterOnlyNumb = "Enter your move (1-9): ";
    protected static final String betweenLines = "-----------";



    private String answerOutString;

    public void answerOut(String answerOutString) {
        this.answerOutString = answerOutString;
        if (answerOutString != null) {
            System.out.println(answerOutString);
        } else {
            System.out.println("Error 404");
        }
    }
}