package com.droid.war.controller;

import com.droid.war.model.User;
import com.droid.war.model.UserRole;
import com.droid.war.users.InMemoryUserProvider;
import com.droid.war.users.UserProvider;
import com.droid.war.view.AdminView;
import com.droid.war.view.LoginView;
import com.droid.war.view.UserView;

import java.util.Arrays;
import java.util.regex.Pattern;


public class LoginController {
    private LoginView loginView;
    private UserProvider userProvider = InMemoryUserProvider.getInstance();

    private UserController userController;
    private AdminController adminController;

    private ControllerUtils controllerUtils = ControllerUtils.getInstance();

    public LoginController(LoginView loginView, UserController userController, AdminController adminController) {
        this.loginView = loginView;
        this.userController = userController;
        this.adminController = adminController;
    }

    public void start() {
        User user;
        do {
            loginView.writeChooseActionMessage();
            int value = controllerUtils.readInt(Arrays.asList(1, 2));
            if (value == 1) {
                user = login();
            } else {
                user = register();
            }
        } while (user == null);
        switch (user.getRole()) {
            case ADMIN:
                adminController.start();
                break;
            case USER:
                userController.start();
        }
    }

    private User login() {
        loginView.writeUserNameMessage();
        String userName = controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,10}"));
        loginView.writePasswordMessage();
        String password = controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,10}"));
        User existingUser = userProvider.getUserByName(userName);
        if (existingUser == null) {
            loginView.noSuchUserMessage();
            return null;
        }
        if (!existingUser.getPassword().equals(password)) {
            loginView.wrongPasswordMessage();
            return null;
        }
        return existingUser;
    }

    private User register() {
        loginView.writeUserNameMessage();
        String userName = controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,10}"));
        User existingUser = userProvider.getUserByName(userName);
        if (existingUser != null) {
            loginView.userWithSuchLoginAlreadyExistsMessage();
            return null;
        }
        loginView.writePasswordMessage();
        String password = controllerUtils.readString(Pattern.compile("[a-zA-Z]{3,10}"));
        loginView.chooseYourRoleMessage();
        int value = controllerUtils.readInt(Arrays.asList(1, 2));
        UserRole role;
        if (value == 1) {
            role = UserRole.ADMIN;
        } else {
            role = UserRole.USER;
        }
        User user = new User(userName, password, role);
        userProvider.createUser(user);
        return user;
    }



}
