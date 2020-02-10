package com.droid.war;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int armor;
    protected int damage;

    public Droid(String name, int health, int armor, int damage) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.damage = damage;
    }

    public abstract StrikeProperties strike();

    public int takeStrike(int damageOfOpponent, boolean ignoreArmor) {
        damageOfOpponent = damageOfOpponent - (ignoreArmor ? 0 : armor);

        health = health - (Math.max(damageOfOpponent, 0));

        return health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }
}
