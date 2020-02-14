package com.droid.war.model;

public class StrikeProperties {
    int damage;
    int stun;
    boolean ignoreArmor;

    public StrikeProperties(int damage, int stun, boolean ignoreArmor) {
        this.damage = damage;
        this.stun = stun;
        this.ignoreArmor = ignoreArmor;
    }

    public int getDamage() {
        return damage;
    }

    public int getStunCount() {
        return stun;
    }

    public boolean isIgnoreArmor() {
        return ignoreArmor;
    }
}
