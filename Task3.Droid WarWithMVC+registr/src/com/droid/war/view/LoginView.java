package com.droid.war.view;

public class LoginView {
    public void writeChooseActionMessage() {
        System.out.println("Please enter 1 for login, 2 for registration:");
    }
    public void writeUserNameMessage() {
        System.out.println("Please write your user name:");
    }
    public void writePasswordMessage() {
        System.out.println("Please write your password:");
    }
    public void chooseYourRoleMessage() {
        System.out.println("Please choose your role: 1 for admin, 2 for user");
    }
    public void wrongPasswordMessage() {
        System.out.println("wrongPasswordMessage");
    }
    public void noSuchUserMessage() {
        System.out.println("no such user");
    }
    public void userWithSuchLoginAlreadyExistsMessage() {
        System.out.println("user with such login already exists");
    }
}
