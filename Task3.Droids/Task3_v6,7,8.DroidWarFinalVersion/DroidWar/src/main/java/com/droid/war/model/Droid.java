package com.droid.war.model;

import com.droid.war.view.BundleHolder;

import java.io.Serializable;

import static com.droid.war.view.BundleHolder.getBundle;

public abstract class Droid implements Comparable<Droid>, Serializable {
    private static final long serialVersionUID = 7245633461315534614L;
    protected Engine engine = new Engine();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



    public void startEngine() {
        engine.startEngine();
    }

    @Override
    public int compareTo(Droid droid) {
        return Integer.compare(this.health, droid.health);
    }

    @Override
    public String toString() {
        return getBundle().getString("NAME") + " - " + name
                + "; " + getBundle().getString("HEALTH") + " - " + health
                + "; " + getBundle().getString("ARMOR") + " - " + armor
                + "; " + getBundle().getString("DAMAGE") + " - " + this.strike().damage
                + "; " + getBundle().getString("TYPE") + " - " + this.getClass().getSimpleName() ;

    }
    protected class Engine implements Serializable {
        void startEngine() {
            System.out.println("vrum vrum");
        }
    }
}
