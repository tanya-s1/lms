package main;

import controller.LoginController;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.start();
    }
}