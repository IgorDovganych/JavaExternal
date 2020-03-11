package com.weather.View;

public class View {
    public String showNameOfUser(){
        return "Name of observer is ";
    }

    public String showCity(){
        return "Program will show you the weather in your city: ";
    }

    public void showMenu(){
        System.out.println("=========================\n1 - notify all observers \n2 - add observer \n3 - show observers \n4 - exit \n=========================");
    }

    public void writeObserverName(){
        System.out.println("Enter observer's name : ");
    }

    public void writeObserverCity(){
        System.out.println("Enter observer's city : ");
    }
}
