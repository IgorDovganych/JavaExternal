package com.droid.war.model;

public class Factory {
    public static void createDroid(String type){
        switch (type){
            case "DroidWithDoubleDamage":
                if (DroidStorage.getCertainDroid("FactoryCreatedDD")==null){
                    DroidStorage.getAllDroids().add(new DroidWithDoubleDamage("FactoryCreatedDD", 500, 5,50));
                    DroidStorage.serializeAndWriteDroidsToFile("droids");
                    System.out.println("Droid 'FactoryCreatedDD' was created successfully");

                }else System.out.println("You already have this droid");
                break;
            case "DroidWithStun":
                if (DroidStorage.getCertainDroid("FactoryCreatedStun")==null){
                    DroidStorage.getAllDroids().add(new DroidWithDoubleDamage("FactoryCreatedStun", 500, 5,50));
                    DroidStorage.serializeAndWriteDroidsToFile("droids");
                    System.out.println("Droid 'FactoryCreatedStun' was created successfully");
                }else System.out.println("You already have this droid");
                break;
        }

    }

    public static void main(String[] args) {
        Droid droidWithDD = new DroidWithDoubleDamage("Apple", 1000, 20,140);
        //Droid droidWithDD = new DroidWithDoubleDamage("FactoryCreatedDD", 500, 5,50);

        DroidStorage.showAllDroids();
        createDroid("DroidWithDoubleDamage");
        System.out.println("===========");
        DroidStorage.showAllDroids();
        System.out.println("===========");
        createDroid("DroidWithDoubleDamage");
        //System.out.println( DroidStorage.deleteDroid("Apple"));
    }
}
