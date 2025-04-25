package repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book("B001", "1984", 400, 4.5));
        books.add(new Book("B002", "The Alchemist", 450, 4.9));
        books.add(new Book("B003", "Harry Potter", 350, 4));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book; 
            }
        }
        return null;
    }
    
}
