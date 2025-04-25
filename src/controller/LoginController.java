package controller;

import entity.User;
import services.BookService;
import services.UserService;

import java.util.Scanner;

public class LoginController {
    private final UserService userService;
    private final BookService bookService;

    public LoginController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Login Menu =====");
            System.out.println("1. Login as User");
            System.out.println("2. Login as Librarian");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1 -> loginAsUser(sc);
                case 2 -> loginAsLibrarian(sc);
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void loginAsUser(Scanner sc) {
        System.out.print("Enter User ID ");
        String id = sc.nextLine().trim();
        User user = userService.loginAsUser(id);
        if (user != null) {
            BookController bookController = new BookController(bookService);
            bookController.userMenu(user.getId());
        } else {
            System.out.println("Invalid User ID.");
        }
    }

    private void loginAsLibrarian(Scanner sc) {
        System.out.print("Enter Librarian ID ");
        String id = sc.nextLine().trim();
        if (userService.isLibrarian(id)) {
            runLibrarianMenu();
        } else {
            System.out.println("Invalid Librarian ID.");
        }
    }

    private void runLibrarianMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Librarian Menu ---");
            System.out.println("1. View All Books");
            System.out.println("2. View All Users");
            System.out.println("3. Add User");
            System.out.println("4. Delete User");
            System.out.println("5. Update User");
            System.out.println("0. Logout");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookService.viewAllBooks();
                case 2 -> userService.viewAllUsers();
                case 3 -> userService.addUser();
                case 4 -> userService.deleteUser();
                case 5 -> userService.updateUser();
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
