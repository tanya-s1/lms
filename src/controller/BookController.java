package controller;

import entity.Book;
import services.BookService;
import java.util.Scanner;

public class BookController {
    private BookService bookService = new BookService();

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }
    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        displayBooks();

        System.out.print("Enter Book ID to borrow: ");
        int id = scanner.nextInt();

        Book book = bookService.getBookById(id);
        if (book != null && book.isAvailable()) {
            bookService.updateBookAvailability(id, false);
            System.out.println("You borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available.");
        }
    }
}