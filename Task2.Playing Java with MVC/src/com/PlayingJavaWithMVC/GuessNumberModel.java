package com.PlayingJavaWithMVC;

public class GuessNumberModel {

    private int correctNumber;
    private int startInterval;
    private int endInterval;
    private int numberOfTurns = 0;

    public GuessNumberModel(int correctNumber, int startInterval, int endInterval) {
        this.correctNumber = correctNumber;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public int getStartInterval() {
        return startInterval;
    }

    public int getEndInterval() {
        return endInterval;
    }

    public void setStartInterval(int startInterval) {
        this.startInterval = startInterval;
    }

    public void setEndInterval(int endInterval) {
        this.endInterval = endInterval;
    }

    public void incrementNumberOfTurns() {
        numberOfTurns++;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }
}
