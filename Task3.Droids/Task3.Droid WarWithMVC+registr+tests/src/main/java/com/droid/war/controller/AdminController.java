package com.droid.war.controller;

import com.droid.war.model.Droid;
import com.droid.war.model.DroidWithDoubleDamage;
import com.droid.war.model.DroidWithStun;
import com.droid.war.model.Fight;
import com.droid.war.users.DroidStorage;
import com.droid.war.view.AdminView;
import com.droid.war.view.LoginView;
import com.droid.war.view.UserView;

import java.util.Arrays;
import java.util.regex.Pattern;

public class AdminController {
    AdminView adminView;
    ControllerUtils controllerUtils = ControllerUtils.getInstance();

    public AdminController(AdminView adminView) {
        this.adminView = adminView;
    }

    public void start() {
        adminView.adminMenuMessage();
        int choice = controllerUtils.readInt(Arrays.asList(1, 2, 3));
        switch (choice) {
            case 1: { // get Droids for fight from storage

                DroidStorage droidStorage = new DroidStorage();
                Droid winner = Fight.fight(droidStorage.getDroid1(), droidStorage.getDroid2());
                System.out.println("============================");
                System.out.println("Winner = " + winner.getName());
                System.out.println("============================");
                start();

            }

            case 2: {

                adminView.adminShowEnterFirstDroidProps();
                DroidStorage.setDroid1(createDroid());//entering first droid
                DroidStorage.setDroid2(createDroid());//entering second droid
                Droid winner = Fight.fight(DroidStorage.getDroid1(), DroidStorage.getDroid2());
                System.out.println("============================");
                System.out.println("Winner = " + winner.getName());
                System.out.println("============================");
                start();

            }

            case 3: {
                LoginController loginController = new LoginController(new LoginView(), new UserController(new UserView()), new AdminController(new AdminView()));
                loginController.start();
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
}
