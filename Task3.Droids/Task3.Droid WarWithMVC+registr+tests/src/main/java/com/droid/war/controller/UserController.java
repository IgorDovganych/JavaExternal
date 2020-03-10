package com.droid.war.controller;

import com.droid.war.model.Droid;
import com.droid.war.model.DroidWithDoubleDamage;
import com.droid.war.model.Fight;
import com.droid.war.users.DroidStorage;
import com.droid.war.view.AdminView;
import com.droid.war.view.LoginView;
import com.droid.war.view.UserView;

import java.util.Arrays;

public class UserController {
    private UserView userView;
    private ControllerUtils controllerUtils = ControllerUtils.getInstance();
    public UserController(UserView userView) {
        this.userView = userView;
    }

    public void start() {
        userView.userMenuMessage();
        int choice = controllerUtils.readInt(Arrays.asList(1, 2,3));
        switch (choice){
            case 1:{ // get Droids for fight from storage

                DroidStorage droidStorage = new DroidStorage();
                Droid winner = Fight.fight(droidStorage.getDroid1(), droidStorage.getDroid2());
                System.out.println("Winner = " + winner.getName());

            }
            case 2:{
                LoginController loginController = new LoginController(new LoginView(), new UserController(new UserView()), new AdminController(new AdminView()));
                loginController.start();

            }
        }
    }

}
