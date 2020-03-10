package com.PlayingJavaWithMVC;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class View {
    public ResourceBundle bundle;

    public static final String NUMBER_OF_TURNS = "NUMBER_OF_TURNS";
    public static final String OPENING_BRACKET = "OPENING_BRACKET";
    public static final String CLOSING_BRACKET = "CLOSING_BRACKET";
    public static final String DASH = "DASH";
    public static final String THATS_NOT_A_NUMBER = "THATS_NOT_A_NUMBER";
    public static final String ENTRANCE_MESSAGE = "ENTRANCE_MESSAGE";
    public static final String YOU_WON = "YOU_WON";
    public static final String YOU_NEED_TO_ENTER_BIGGER_NUM = "YOU_NEED_TO_ENTER_BIGGER_NUM";
    public static final String YOU_NEED_TO_ENTER_SMALLER_NUM = "YOU_NEED_TO_ENTER_SMALLER_NUM";
    public static final String NUMBER_NOT_IN_INTERVAL = "NUMBER_NOT_IN_INTERVAL";
    //ResourceBundle bundle = ResourceBundle.getBundle("resources");


    public void showEntranceMessage(int startInterval, int endInterval) {
        System.out.println("=========================================");
        System.out.println(bundle.getString(ENTRANCE_MESSAGE) + bundle.getString(OPENING_BRACKET) + startInterval + bundle.getString(DASH) + endInterval + bundle.getString(CLOSING_BRACKET));
    }

    public void showNumberOfTurns(int numberOfTurns){
        System.out.println(bundle.getString(NUMBER_OF_TURNS) + numberOfTurns);
    }

    public void setMyBundle(int choice) {
        if (choice == 1) {
            bundle = ResourceBundle.getBundle("com.PlayingJavaWithMVC/resources", new Locale("en", "US"));
            System.out.println("EN");

        }else {
            bundle = ResourceBundle.getBundle("com.PlayingJavaWithMVC/resources", new Locale("ru", "RU"));
            System.out.println("RU");

        }


    }

    public void showYouWon(){
        System.out.println(bundle.getString(YOU_WON));
    }

    public String showYouNeedToEnterBiggerNum(){
        return bundle.getString(YOU_NEED_TO_ENTER_BIGGER_NUM) ;
    }

    public String showYouNeedToEnterSmallerNum(){
        return bundle.getString(YOU_NEED_TO_ENTER_SMALLER_NUM);
    }

    public int getNumberFromKeyboard(int startInterval, int endInterval) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println(bundle.getString(NUMBER_NOT_IN_INTERVAL) + startInterval + " - " + endInterval);
            while (!sc.hasNextInt() ) {
                System.out.println(bundle.getString(THATS_NOT_A_NUMBER));
                sc.next();
            }
            number = sc.nextInt();
        } while (number < startInterval || number > endInterval);
        return number;
    }

    public void getChoice(int first , int second){
        System.out.println("Please select your language: ");
        System.out.println("1 - English ");
        System.out.println("2 - Russian ");
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("You need to choose 1 or 2 ! ");
            while (!sc.hasNextInt()) {
                System.out.println("You need to choose 1 or 2 ! ");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice != first && choice != second);
        if (choice == first) {
            bundle = ResourceBundle.getBundle("com.PlayingJavaWithMVC/resources", new Locale("en", "US"));
            System.out.println("EN");

        }else {
            bundle = ResourceBundle.getBundle("com.PlayingJavaWithMVC/resources", new Locale("ru", "RU"));
            System.out.println("RU");

        }
    }

    public void getLocales(){
        Locale[] locales = Locale.getAvailableLocales();
        for(Locale loc: locales){
            System.out.println(loc);
        }
    }
}
