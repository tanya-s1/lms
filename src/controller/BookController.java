package controller;

import services.BookService;

import java.util.Scanner;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void userMenu(String userId) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. View All Books");
            System.out.println("2. View Sorted Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookService.viewAllBooks();
                case 2 -> bookService.viewSortedBooks();
                case 3 -> bookService.borrowBook(userId);
                case 4 -> bookService.returnBook(userId);
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
