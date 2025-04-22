package controller;

import entity.Book;
import repository.BookRepository;
import services.BookService;

public class BookController {
	
	private BookService bookService;

    public BookController() {
        this.bookService = new BookService(new BookRepository());
    }

    public void createBook(int id, String title, String author) {
        Book book = new Book(id, title, author);
        bookService.addBook(book);
    }

    public void listBooks() {
        for (Book book : bookService.viewAllBooks()) {
            System.out.println(book.getBookId() + " - " + book.getTitle() + " , "+ book.getAuthor());
        }
    }
}