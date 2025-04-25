package services;

import entity.Book;
import java.util.Comparator;

public class BookComparators {

    public static class PriceComparator implements Comparator<Book> {
        public int compare(Book b1, Book b2) {
            return Double.compare(b1.getPrice(), b2.getPrice());
        }
    }

    public static class RatingComparator implements Comparator<Book> {
        public int compare(Book b1, Book b2) {
            return Double.compare(b2.getRating(), b1.getRating()); // High to low
        }
    }

    public static class TitleComparator implements Comparator<Book> {
        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareToIgnoreCase(b2.getTitle());
        }
    }
}
