package com.droid.war.model;

import java.util.Random;

public class DroidWithStun extends Droid {

    public DroidWithStun(String name, int health, int armor, int damage) {
        super(name, health, armor, damage);
    }

    @Override
    public StrikeProperties strike() {
        int stunCount;
        int randomNumber = new Random().nextInt(100);
        if (randomNumber < 50) {
            stunCount = 0;
        } else if (randomNumber < 80) {
            stunCount = 1;
        } else {
            stunCount = 2;
        }
        return new StrikeProperties( damage, stunCount, false );
    }
}
