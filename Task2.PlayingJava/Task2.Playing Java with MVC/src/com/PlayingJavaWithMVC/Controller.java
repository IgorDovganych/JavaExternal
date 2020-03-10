package com.PlayingJavaWithMVC;

public class Controller {
    private GuessNumberModel guessNumberModel;
    private View view;

    // Constants

    // REGEX

    public Controller(GuessNumberModel guessNumberModel, View view) {
        this.guessNumberModel = guessNumberModel;
        this.view = view;
    }

    public void playGame() {
        int guessedNumber;
        do {
            view.showEntranceMessage(guessNumberModel.getStartInterval(), guessNumberModel.getEndInterval());
            view.showNumberOfTurns(guessNumberModel.getNumberOfTurns());
            guessedNumber = view.getGuessedNum(guessNumberModel.getStartInterval(), guessNumberModel.getEndInterval());

            if (guessedNumber == guessNumberModel.getCorrectNumber()) {
                System.out.println("You won");
                guessNumberModel.incrementNumberOfTurns();
                view.showNumberOfTurns(guessNumberModel.getNumberOfTurns());
            } else if (guessedNumber < guessNumberModel.getCorrectNumber()) {
                guessNumberModel.setStartInterval(guessedNumber + 1);
                System.out.println("Your number is incorrect , you need to enter bigger number choose from interval (" + guessNumberModel.getStartInterval() + " - " + guessNumberModel.getEndInterval() + " )");
            } else if (guessedNumber > guessNumberModel.getCorrectNumber()) {
                guessNumberModel.setEndInterval(guessedNumber - 1);
                System.out.println("Your number is incorrect , you need to enter smaller number choose from interval (" + guessNumberModel.getStartInterval() + " - " + guessNumberModel.getEndInterval() + " )");
            }
            guessNumberModel.incrementNumberOfTurns();
        } while (guessedNumber != guessNumberModel.getCorrectNumber());
    }

}

