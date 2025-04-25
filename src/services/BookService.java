package services;

import entity.Book;
import repository.BookRepository;

import java.util.Scanner;

public class BookService {
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void viewAllBooks() {
        for (Book book : bookRepo.getAllBooks()) {
            System.out.println(book);
        }
    }

    public void borrowBook(String userId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book ID to borrow: ");
        String id = sc.nextLine();

        Book book = bookRepo.findBookById(id);
        if (book != null) {
            book.borrow(userId);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String userId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book ID to return: ");
        String id = sc.nextLine();

        Book book = bookRepo.findBookById(id);
        if (book != null) {
            book.returnBook(userId);
        } else {
            System.out.println("Book not found.");
        }
    }
}
