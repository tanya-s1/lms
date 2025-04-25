package main;

import controller.LoginController;
import repository.BookRepository;
import repository.UserRepository;
import services.BookService;
import services.UserService;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("===== Welcome to the Library Management System =====");

        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        BookService bookService = new BookService(bookRepo);
        UserService userService = new UserService(userRepo);
        LoginController loginController = new LoginController(userService, bookService);

        loginController.start();
    }
}
