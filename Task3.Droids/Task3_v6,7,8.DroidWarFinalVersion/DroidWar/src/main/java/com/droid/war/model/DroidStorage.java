package com.droid.war.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DroidStorage {
    //wont need in future
    //static Droid droid1 = new DroidWithDoubleDamage("Android", 850, 30, 60);
    //wont need in future
    //static Droid droid2 = new DroidWithDoubleDamage("Apple", 1000, 20, 70);

    //static Droid droid3 = new DroidWithDoubleDamage("Loh", 1000, 20, 70);

    static List<Droid> allDroids = new ArrayList<>();
    static List<Droid> lobbyOfDroids = new ArrayList<>();

    public static final Comparator<Droid> BY_HEALTH =
            Comparator.comparingInt(Droid::getHealth).thenComparingInt(Droid::getArmor).thenComparing(Droid::getDamage).reversed();

    static {
        //allDroids.add(droid1);
        allDroids.addAll(deserializeDroidsFromFile("droids"));

        //lobbyOfDroids.add(droid3);

        lobbyOfDroids.addAll(deserializeDroidsFromFile("lobby"));
    }




    public static void showAllDroids() {
        for (Droid droid : allDroids) {
            System.out.println(droid);
        }
    }

    public static void showLobby() {
        for (Droid droid : lobbyOfDroids) {
            System.out.println(droid);
        }
    }

    public static List<Droid> getAllDroids() {
        return allDroids;
    }

    public static List<Droid> getLobbyOfDroids() {
        return lobbyOfDroids;
    }

    public static void main(String[] args) {
        Droid droid1 = new DroidWithDoubleDamage("Android", 850, 30, 60);
        Droid droid2 = new DroidWithDoubleDamage("Apple", 1000, 20, 70);
        allDroids.add(droid1);
        allDroids.add(droid2);
        lobbyOfDroids.add(droid1);
        lobbyOfDroids.add(droid2);
        serializeAndWriteLobbyToFile("lobby");
        serializeAndWriteDroidsToFile("droids");
        //System.out.println(deserializeDroidsFromFile("lobby"));
        System.out.println(lobbyOfDroids.get(0));
        System.out.println(lobbyOfDroids.get(1));
    }

    public static void serializeAndWriteDroidsToFile(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(allDroids);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeAndWriteLobbyToFile(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lobbyOfDroids);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Droid> deserializeDroidsFromFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<Droid>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static Droid getCertainDroid(String name) {
        for (Droid droid : allDroids) {
            if (droid.getName().equals(name)) {
                //System.out.println(droid);
                return droid;
            }
        }
        return null;
    }
    public static String deleteDroid(String name){
        for (Droid droid:allDroids) {
            if (droid.getName().equals(name)){
                allDroids.remove(droid);
                serializeAndWriteDroidsToFile("droids");
                return "Droid deleted";
            }
        }
        return "Droid with this name doesn't exist";
    }
}