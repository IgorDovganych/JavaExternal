package com.droid.war.controller;

import com.droid.war.model.*;
import com.droid.war.view.AdminView;
import org.apache.log4j.Logger;

import java.util.Arrays;

import java.util.regex.Pattern;

import static com.droid.war.model.DroidStorage.BY_HEALTH;

public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);

    public static void main(String[] args) {
        //PropertyConfigurator.configure("log4j.properties");
        logger.info("Hello");
    }
    AdminView adminView;
    ControllerUtils controllerUtils = ControllerUtils.getInstance();
    UserController userController;

    public AdminController(AdminView adminView, UserController userController) {
        this.adminView = adminView;
        this.userController = userController;
    }

    public void start() {

        while (true) {
            adminView.adminMenuMessage();
            int choice = controllerUtils.readInt(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10));
            switch (choice) {
                case 1: { // get Droids for fight from storage

                    int health1 = DroidStorage.getLobbyOfDroids().get(0).getHealth();
                    int health2 = DroidStorage.getLobbyOfDroids().get(1).getHealth();

                    Droid droid1 = DroidStorage.getLobbyOfDroids().get(0);
                    Droid droid2 = DroidStorage.getLobbyOfDroids().get(1);

                    DroidStorage.showLobby();
                    Droid winner = Fight.fight(droid1, droid2);


                    DroidStorage.getLobbyOfDroids().get(0).setHealth(health1);
                    DroidStorage.getLobbyOfDroids().get(1).setHealth(health2);

                    System.out.println(adminView.showWinner() + winner.getName());
                    logger.info("Winner = " + winner.getName());
                    break;

                }

                case 2: {
                    //TODO write sort
                    DroidStorage.deserializeDroidsFromFile("droids");
                    DroidStorage.showAllDroids();
                    System.out.println("==========================");
                    DroidStorage.getAllDroids().sort(BY_HEALTH);
                    DroidStorage.showAllDroids();
                    break;
                }

                case 3: { // log out
                    return;
                }

                case 4: { // add droid to storage
                    //TODO add to view;
                    DroidStorage.deserializeDroidsFromFile("droids");
                    DroidStorage.getAllDroids().add(createDroid());
                    DroidStorage.serializeAndWriteDroidsToFile("droids");
                    break;
                }
                case 5: {//show ALL droids from file
                    DroidStorage.showAllDroids();
                    break;
                }
                case 6: {//show  lobby
                    DroidStorage.showLobby();
                    break;
                }

                case 7: {//fill the  lobby
                    fillTheLobby();
                    adminView.youHaveFilledTheLobby();
                    break;
                }
                case 8: {//set language
                    adminView.setLanguage(1, 2);
                    break;
                }
                case 9: {//create droid using factory
                    createDroidUsingFactory();

                    break;
                }
                case 10:{//delete droid from storage
                    adminView.adminShowEnterName();
                    String name = controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,20}"));
                    String message = DroidStorage.deleteDroid(name);
                    System.out.println(message);
                    break;
                }
            }
        }
    }

    public Droid createDroid() {
        adminView.adminShowEnterTypeOfDroid();
        int choice = controllerUtils.readInt(Arrays.asList(1, 2));
        adminView.adminShowEnterName();
        String name = controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,10}"));
        adminView.adminShowEnterHealth();
        int health = controllerUtils.readIntInRange(0, 1000);
        adminView.adminShowEnterArmor();
        int armor = controllerUtils.readIntInRange(0, 50);
        adminView.adminShowEnterDamage();
        int damage = controllerUtils.readIntInRange(0, 100);
        if (choice == 1) {
            return new DroidWithDoubleDamage(name, health, armor, damage);
        } else {
            return new DroidWithStun(name, health, armor, damage);
        }
    }

    public void fillTheLobby() { //filling The Lobby with 2 droids for fight
        DroidStorage.showAllDroids();
        adminView.adminShowChooseFirstDroid();
        Droid firstDroidForFight = DroidStorage.getCertainDroid(controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,20}")));
        DroidStorage.getLobbyOfDroids().clear();
        DroidStorage.getLobbyOfDroids().add(firstDroidForFight);
        adminView.adminShowChooseSecondDroid();
        Droid secondDroidForFight = DroidStorage.getCertainDroid(controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,20}")));
        DroidStorage.getLobbyOfDroids().add(secondDroidForFight);
        DroidStorage.serializeAndWriteLobbyToFile("lobby");
    }
    public void createDroidUsingFactory(){
        adminView.adminShowEnterTypeOfDroid();
        int typeOfDroid = controllerUtils.readInt(Arrays.asList(1, 2));
        switch (typeOfDroid){
            case 1:
                Factory.createDroid("DroidWithDoubleDamage");
                break;
            case 2:
                Factory.createDroid("DroidWithStun");
                break;
        }

    }
}
