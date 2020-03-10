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
        view.getChoice(1,2);

        int numberFromKeyboard;
        do {
            view.showEntranceMessage(guessNumberModel.getStartInterval(), guessNumberModel.getEndInterval());
            view.showNumberOfTurns(guessNumberModel.getNumberOfTurns());
            numberFromKeyboard = view.getNumberFromKeyboard(guessNumberModel.getStartInterval(), guessNumberModel.getEndInterval());

            if (numberFromKeyboard == guessNumberModel.getCorrectNumber()) {
                view.showYouWon();
                guessNumberModel.incrementNumberOfTurns();
                view.showNumberOfTurns(guessNumberModel.getNumberOfTurns());
            } else if (numberFromKeyboard < guessNumberModel.getCorrectNumber()) {
                guessNumberModel.setStartInterval(numberFromKeyboard + 1);
                System.out.println(view.showYouNeedToEnterBiggerNum() +" ( " + guessNumberModel.getStartInterval() + " - " + guessNumberModel.getEndInterval() + " )");
            } else if (numberFromKeyboard > guessNumberModel.getCorrectNumber()) {
                guessNumberModel.setEndInterval(numberFromKeyboard - 1);
                System.out.println(view.showYouNeedToEnterSmallerNum() + " ( " + guessNumberModel.getStartInterval() + " - " + guessNumberModel.getEndInterval() + " )");
            }
            guessNumberModel.incrementNumberOfTurns();
        } while (numberFromKeyboard != guessNumberModel.getCorrectNumber());
    }

}

