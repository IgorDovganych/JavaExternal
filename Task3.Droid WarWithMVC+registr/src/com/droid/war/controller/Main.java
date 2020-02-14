package com.droid.war.controller;

import com.droid.war.model.DroidWithDoubleDamage;
import com.droid.war.model.Droid;
import com.droid.war.model.StrikeProperties;
import com.droid.war.view.AdminView;
import com.droid.war.view.LoginView;
import com.droid.war.view.UserView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        LoginController loginController = new LoginController(new LoginView(), new UserController(new UserView()), new AdminController(new AdminView()));
        loginController.start();
    }


}
