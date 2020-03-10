package com.droid.war.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerUtils {

    private ControllerUtils() { }

    private static ControllerUtils instance = new ControllerUtils();

    public static ControllerUtils getInstance() {
        return instance;
    }

    public int readInt(List<Integer> possibleValues) {
        Scanner sc = new Scanner(System.in);
        int value = Integer.MIN_VALUE;
        do {
            System.out.println("You need to choose something from " + possibleValues.toString());
            String s = sc.nextLine();
            try {
                value = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                //continue
            }
        } while (!possibleValues.contains(value));
        return value;
    }


    public int readIntInRange(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int value = Integer.MIN_VALUE;
        do {
            System.out.println("You need to choose something from " + min + " to " + max);
            String s = sc.nextLine();
            try {
                value = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                //continue
            }
        } while (value<min||value>max);
        return value;
    }

    public String readString(Pattern pattern) {
        Scanner sc = new Scanner(System.in);
        Matcher matcher;
        String value;
        do {
            System.out.println("You need to write correct string");
            value = sc.nextLine();
            matcher = pattern.matcher(value);
        } while (!matcher.matches());
        return value;
    }


}
