package services;

import entity.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }

    public List<Book> viewAllBooks() {
        return repository.getAllBooks();
    }
}

