package repository;

import entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();
    public BookRepository() {
//        // Sample books
//        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", true));
//        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", true));
//        books.add(new Book(3, "1984", "George Orwell", false));
    }
    public void addBook(Book book)
    {
    	books.add(book);
    }

//    public List<Book> getAllBooks() {
//        return books;
//    }
    public void getAllBooks() {
        for(int i=0;i<books.size();i++)
        {
        	System.out.println(books.get(i));
        }
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; 
    }

    public void updateBookAvailability(int id, boolean isAvailable) {
        Book book = getBookById(id);
        if (book != null) {
            book.setAvailable(isAvailable);
        }
    }
}