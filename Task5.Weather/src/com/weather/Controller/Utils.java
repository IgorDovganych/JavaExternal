package com.weather.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static int getMenuNumber(int min, int max) {
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

    public static String getCity(){
        ArrayList<String> arrayofCities = new ArrayList();
        arrayofCities.add("Kyiv");
        arrayofCities.add("London");
        arrayofCities.add("Berlin");
        arrayofCities.add("Moscow");
        arrayofCities.add("Vien");
        arrayofCities.add("Rome");
        arrayofCities.add("Paris");
        String inputCity;
        do{
            Scanner input = new Scanner(System.in);
            inputCity = input.nextLine();
            if(!arrayofCities.contains(inputCity)) {
                System.out.println("Input is incorrect , enter from following cities Kyiv/London/Berlin/Moscow/Vien/Rome/Paris");
            }
        }while (!arrayofCities.contains(inputCity));
        return inputCity;
    }

    public static String readString(Pattern pattern) {
        Scanner sc = new Scanner(System.in);
        Matcher matcher;
        String value;
        do {
            System.out.println("You need to write correct string with this pattern " + pattern);
            value = sc.nextLine();
            matcher = pattern.matcher(value);
        } while (!matcher.matches());
        return value;
    }

}
