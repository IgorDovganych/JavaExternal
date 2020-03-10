package com.droid.war.model;

import com.droid.war.view.AdminView;
import com.droid.war.view.BundleHolder;

import java.util.Random;

public class Fight {


    public static Droid fight(Droid droid1, Droid droid2) {
        if(droid1.getHealth()<=0||droid2.getHealth()<=0) return null;
        //TODO engine start

        droid1.startEngine();
        droid2.startEngine();
        String healthBefore = BundleHolder.getBundle().getString("HEALTH_BEFORE");
        String healthAfter = BundleHolder.getBundle().getString("HEALTH_AFTER");
        String strikesOn  = BundleHolder.getBundle().getString("STRIKES_ON");
        System.out.println(BundleHolder.getBundle().getString("FIGHT_STARTED"));

        Droid droidFirst;
        Droid droidSecond;
        if (new Random().nextBoolean()) {
            droidFirst = droid1;
            droidSecond = droid2;

        } else {
            droidFirst = droid2;
            droidSecond = droid1;
        }
        System.out.println(BundleHolder.getBundle().getString("FIRST_ATTACKS") + " " +droidFirst.getName());

        int skipStrikeFirst = 0;
        int skipStrikeSecond = 0;

        int counter = 0;
        while (droidFirst.getHealth() > 0 && droidSecond.getHealth() > 0) {
            System.out.println("--------------------------------------------");


            System.out.println(BundleHolder.getBundle().getString("ATTACK") + " # " + ++counter);



            System.out.println(droidFirst.getName() +": "+  healthBefore +  " = " + droidFirst.getHealth());
            System.out.println(droidSecond.getName() +": "+ healthBefore +  " = "+ droidSecond.getHealth());

            //first android strike
            if (skipStrikeFirst > 0) {
                skipStrikeFirst--;
            } else {
                StrikeProperties strikePropertiesFirst = droidFirst.strike();
                System.out.println(droidFirst.getName() + ": " + strikesOn +" " + strikePropertiesFirst.getDamage() + " damage");

                int currentHealth = droidSecond.takeStrike(strikePropertiesFirst.getDamage(), strikePropertiesFirst.isIgnoreArmor());
                System.out.println(droidSecond.getName() +": "+ healthAfter + " = " + droidSecond.getHealth());
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
                System.out.println(droidSecond.getName()+ ": " + strikesOn +" " + strikePropertiesSecond.getDamage() + " damage");
                int currentHealth = droidFirst.takeStrike(strikePropertiesSecond.getDamage(), strikePropertiesSecond.isIgnoreArmor());
                System.out.println(droidFirst.getName()  +": "+healthAfter + " = " + droidFirst.getHealth());
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
