package controller;

import entity.User;
import services.UserService;
import java.util.Scanner;

public class LoginController {
    private UserService userService = new UserService();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("Welcome " + user.getRole() + "!");
            if ("User".equals(user.getRole())) {
                new BookController().borrowBook();
            } else if ("Librarian".equals(user.getRole())) {
                new BookController().displayBooks();
            }
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }
}
