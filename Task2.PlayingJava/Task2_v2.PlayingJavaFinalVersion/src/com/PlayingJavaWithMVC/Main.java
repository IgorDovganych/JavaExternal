package com.PlayingJavaWithMVC;

public class Main {
    public static void main(String[] args) {
        // Initialization
        GuessNumberModel guessNumberModel = new GuessNumberModel((int) (Math.random() * 101),0,100);
        View view = new View();
        Controller controller = new Controller(guessNumberModel, view);
        // Run
        controller.playGame();

    }
}
