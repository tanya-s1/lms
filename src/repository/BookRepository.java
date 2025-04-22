package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) return book;
        }
        return null;
    }

}
