package com.droid.war.model;

import java.util.Random;

public class Fight {

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
        System.out.println("First attacks " + droidFirst.getName());
        int skipStrikeFirst = 0;
        int skipStrikeSecond = 0;

        int counter = 0;
        while (droidFirst.getHealth() > 0 && droidSecond.getHealth() > 0) {
            System.out.println("--------------------------------------------");
            System.out.println("Attack # " + ++counter);

            System.out.println(droidFirst.getName() + "'s health before attack = " + droidFirst.getHealth());
            System.out.println(droidSecond.getName() + "'s health before attack = " + droidSecond.getHealth());

            //first android strike
            if (skipStrikeFirst > 0) {
                skipStrikeFirst--;
            } else {
                StrikeProperties strikePropertiesFirst = droidFirst.strike();
                System.out.println(droidFirst.getName() + " strikes on " + strikePropertiesFirst.getDamage() + " damage");

                int currentHealth = droidSecond.takeStrike(strikePropertiesFirst.getDamage(), strikePropertiesFirst.isIgnoreArmor());
                System.out.println(droidSecond.getName() + "'s health after attack = " + droidSecond.getHealth());
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
                System.out.println(droidSecond.getName() + " strikes on " + strikePropertiesSecond.getDamage() + " damage");
                int currentHealth = droidFirst.takeStrike(strikePropertiesSecond.getDamage(), strikePropertiesSecond.isIgnoreArmor());
                System.out.println(droidFirst.getName() + "'s health after attack = " + droidFirst.getHealth());
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
