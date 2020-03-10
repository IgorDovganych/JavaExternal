package com.PlayingJavaWithMVC;

import java.util.Scanner;

public class View {

    public void showEntranceMessage(int startInterval, int endInterval) {
        System.out.println("=========================================");
        System.out.println("Please guess a positive number ( " + startInterval + " - " + endInterval + " ) ");
    }

    public void showNumberOfTurns(int numberOfTurns){
        System.out.println("Number of turns : " + numberOfTurns);
    }


    public int getGuessedNum(int startInterval, int endInterval) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number < startInterval || number > endInterval);
        return number;
    }
}
