package com.droid.war.controller;

import com.droid.war.model.Droid;
import com.droid.war.model.Fight;
import com.droid.war.model.DroidStorage;
import com.droid.war.view.AdminView;
import com.droid.war.view.UserView;

import java.util.Arrays;

import static com.droid.war.model.DroidStorage.BY_HEALTH;

public class UserController {
    private UserView userView;
    private AdminView adminView;
    private ControllerUtils controllerUtils = ControllerUtils.getInstance();
    public UserController(UserView userView) {
        this.userView = userView;
    }

    public void start() {
        while(true) {
            userView.userMenuMessage();
            int choice = controllerUtils.readInt(Arrays.asList(1, 2, 3));
            switch (choice) {
                case 1: { // get Droids for fight from lobby

                    int health1 = DroidStorage.getLobbyOfDroids().get(0).getHealth();
                    int health2 = DroidStorage.getLobbyOfDroids().get(1).getHealth();

                    Droid droid1 = DroidStorage.getLobbyOfDroids().get(0);
                    Droid droid2 = DroidStorage.getLobbyOfDroids().get(1);


                    Droid winner = Fight.fight(droid1, droid2);
                    DroidStorage.showLobby();

                    DroidStorage.getLobbyOfDroids().get(0).setHealth(health1);
                    DroidStorage.getLobbyOfDroids().get(1).setHealth(health2);

                    System.out.println(userView.showWinner() + winner.getName());
                    break;

                }
                case 2: {
                    return;
                }

                case 3: {//show lobby
                    DroidStorage.showLobby();
                    break;


                }
            }
        }
    }

}
