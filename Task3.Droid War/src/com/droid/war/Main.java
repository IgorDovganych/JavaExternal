package com.droid.war;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        DroidWithDoubleDamage droid1 = new DroidWithDoubleDamage("Droid with Armor",1000,30,50);
        DroidWithDoubleDamage droid2 = new DroidWithDoubleDamage("Droid with bigger Armor",1000,20,70);
        //new Main().fight(droid1,droid2);
        Droid winner = fight(droid1,droid2);
        System.out.println("Winner = " + winner.getName());
    }

    public static Droid fight(Droid droid1, Droid droid2) {
        System.out.println("Fight started");
        Droid droidFirst;
        Droid droidSecond;
        if (new Random().nextBoolean()) {
            droidFirst = droid1;
            droidSecond = droid2;

        } else {
            droidFirst = droid2;
            droidSecond = droid1;
        }
        int skipStrikeFirst = 0;
        int skipStrikeSecond = 0;
        while (droidFirst.getHealth() > 0 && droidSecond.getHealth() > 0) {
            //first android strike
            if (skipStrikeFirst > 0) {
                skipStrikeFirst--;
            } else {
                StrikeProperties strikePropertiesFirst = droidFirst.strike();
                int currentHealth = droidSecond.takeStrike(strikePropertiesFirst.getDamage(), strikePropertiesFirst.isIgnoreArmor());
                if (currentHealth <= 0) {
                    return droidFirst;
                }
                if (skipStrikeSecond == 0) {
                    skipStrikeSecond = strikePropertiesFirst.getStunCount();
                }
            }

            //second android strike
            if (skipStrikeSecond > 0) {
                skipStrikeSecond--;
            } else {
                StrikeProperties strikePropertiesSecond = droidSecond.strike();
                int currentHealth = droidFirst.takeStrike(strikePropertiesSecond.getDamage(), strikePropertiesSecond.isIgnoreArmor());
                if (currentHealth <= 0) {
                    return droidSecond;
                }
                if (skipStrikeFirst == 0) {
                    skipStrikeFirst = strikePropertiesSecond.getStunCount();
                }
            }
        }
        if (droidFirst.getHealth() <= 0) {
            return droidFirst;
        } else {
            return droidSecond;
        }
    }
}
