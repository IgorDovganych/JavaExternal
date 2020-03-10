package com.droid.war.view;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AdminView {
    public static final String MENU = "MENU";
    public static final String ADMIN_SHOW_ENTER_FIRST_DROID_PROPS = "ADMIN_SHOW_ENTER_FIRST_DROID_PROPS";
    public static final String ADMIN_SHOW_ENTER_SECOND_DROID_PROPS = "ADMIN_SHOW_ENTER_SECOND_DROID_PROPS";
    public static final String ADMIN_SHOW_ENTER_NAME = "ADMIN_SHOW_ENTER_NAME";
    public static final String ADMIN_SHOW_ENTER_HEALTH = "ADMIN_SHOW_ENTER_HEALTH";
    public static final String ADMIN_SHOW_ENTER_ARMOR = "ADMIN_SHOW_ENTER_ARMOR";
    public static final String ADMIN_SHOW_ENTER_DAMAGE = "ADMIN_SHOW_ENTER_DAMAGE";
    public static final String LOBBY_FILLED = "LOBBY_FILLED";
    public static final String LANGUAGE_MENU = "LANGUAGE_MENU";
    public static final String CHOOSE_ONE_OR_TWO = "CHOOSE_ONE_OR_TWO";
    public static final String TYPE_OF_DROID_MENU = "TYPE_OF_DROID_MENU";

    public static final String CHOOSE_FIRST_DROID = "CHOOSE_FIRST_DROID";

    public static final String CHOOSE_SECOND_DROID = "CHOOSE_SECOND_DROID";
    public static final String WINNER = "WINNER";
    public static final String FIGHT_STARTED = "FIGHT_STARTED";
    public static final String YOU_NEED_TO_CHOOSE_FROM = "YOU_NEED_TO_CHOOSE_FROM";

    public String youNeedToChooseFrom(){
                return BundleHolder.getBundle().getString(YOU_NEED_TO_CHOOSE_FROM);
            }

    public void adminMenuMessage() {
        System.out.println(BundleHolder.getBundle().getString(MENU));
    }

    public String showWinner(){
        return (BundleHolder.getBundle().getString(WINNER) + " = ");
    }
    public void adminShowEnterName() {
        System.out.println(BundleHolder.getBundle().getString(ADMIN_SHOW_ENTER_NAME));
    }

    public void adminShowEnterHealth() {
        System.out.println(BundleHolder.getBundle().getString(ADMIN_SHOW_ENTER_HEALTH));
    }

    public void adminShowEnterArmor() {
        System.out.println(BundleHolder.getBundle().getString(ADMIN_SHOW_ENTER_ARMOR));
    }

    public void adminShowEnterDamage() {
        System.out.println(BundleHolder.getBundle().getString(ADMIN_SHOW_ENTER_DAMAGE));
    }

    public void adminShowEnterTypeOfDroid() {
        System.out.println(BundleHolder.getBundle().getString(TYPE_OF_DROID_MENU));
    }

    public void adminShowChooseFirstDroid() {
        System.out.println(BundleHolder.getBundle().getString(CHOOSE_FIRST_DROID));
    }

    public void adminShowChooseSecondDroid() {
        System.out.println(BundleHolder.getBundle().getString(CHOOSE_SECOND_DROID));
    }
    public void youHaveFilledTheLobby(){
        System.out.println(BundleHolder.getBundle().getString(LOBBY_FILLED));
    }

    public void fightStarted(){
        System.out.println(BundleHolder.getBundle().getString(FIGHT_STARTED));

    }
    public void showErrorYouNeedToChooseOneOrTwo() {
        System.out.println(BundleHolder.getBundle().getString(CHOOSE_ONE_OR_TWO));
    }

    public void setLanguage(int first, int second) {
        System.out.println(BundleHolder.getBundle().getString(LANGUAGE_MENU));
        Scanner sc = new Scanner(System.in);
        int choice;
        do {

            showErrorYouNeedToChooseOneOrTwo();
            while (!sc.hasNextInt()) {
                showErrorYouNeedToChooseOneOrTwo();
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice != first && choice != second);
        if (choice == first) {
            BundleHolder.setLocale(new Locale("en", "US"));
            System.out.println("EN");

        } else {
            BundleHolder.setLocale(new Locale("ru", "RU"));
            System.out.println("RU");

        }
    }
}

