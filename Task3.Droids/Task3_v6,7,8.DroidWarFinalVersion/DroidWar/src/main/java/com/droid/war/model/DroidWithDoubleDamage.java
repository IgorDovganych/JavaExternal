package com.droid.war.model;

public class DroidWithDoubleDamage extends Droid {

    public DroidWithDoubleDamage(String name, int health, int armor, int damage) {
        super(name, health, armor, damage);
    }

    @Override
    public StrikeProperties strike() {
        return new StrikeProperties( damage*2, 0 , false );
    }


}
