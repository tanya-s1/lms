package services;

import entity.Book;
import repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository = new BookRepository();

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    public void updateBookAvailability(int id, boolean isAvailable) {
        bookRepository.updateBookAvailability(id, isAvailable);
    }
}