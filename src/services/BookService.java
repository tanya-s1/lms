package services;

import entity.Book;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public void viewSortedBooks() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nSort Books By:");
            System.out.println("1. Price (Low to High)");
            System.out.println("2. Rating (High to Low)");
            System.out.println("3. Title (A-Z)");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            List<Book> sortedList = new ArrayList<>(bookRepo.getAllBooks());

            switch (choice) {
                case 1 -> {
                    Collections.sort(sortedList, new BookComparators.PriceComparator());
                    sortedList.forEach(System.out::println);
                }
                case 2 -> {
                    Collections.sort(sortedList, new BookComparators.RatingComparator());
                    sortedList.forEach(System.out::println);
                }
                case 3 -> {
                    Collections.sort(sortedList, new BookComparators.TitleComparator());
                    sortedList.forEach(System.out::println);
                }
                case 0 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
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
