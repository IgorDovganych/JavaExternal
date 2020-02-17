package com.droid.war.view;

public class AdminView {
    public void adminMenuMessage() {
        System.out.println("Choose:");
        System.out.println("1 - run");
        System.out.println("2 - create droids for fight");
        System.out.println("3 - log out");
    }
    public void adminShowEnterFirstDroidProps(){
        System.out.println("Enter first droid's properties: ");
    }

    public void adminShowEnterSecondDroidProps(){
        System.out.println("Enter second droid's properties: ");
    }

    public void adminShowEnterName(){
        System.out.println("Enter Droids name: ");
    }

    public void adminShowEnterHealth(){
        System.out.println("Enter number of health: ");
    }

    public void adminShowEnterArmor(){
        System.out.println("Enter his armor: ");
    }
    public void adminShowEnterDamage(){
        System.out.println("Enter his damage: ");
    }
    public void adminShowEnterTypeOfDroid(){
        System.out.println("Enter Type of Droid: ");
        System.out.println("1 - Droid with double damage");
        System.out.println("2 - Droid with stun");
    }
}
