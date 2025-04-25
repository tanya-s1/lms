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
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookService.viewAllBooks();
                case 2 -> bookService.borrowBook(userId);
                case 3 -> bookService.returnBook(userId);
            }
        } while (choice != 0);
    }
}
