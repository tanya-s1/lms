package entity;

public class Book {
    private String id;
    private String title;
    private boolean isBorrowed;
    private String borrowedBy;
    private double price;
    private double rating;

    public Book(String id, String title, double price, double rating) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
        this.borrowedBy = null;
        this.price = price;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public void borrow(String userId) {
        if (!isBorrowed) {
            isBorrowed = true;
            borrowedBy = userId;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook(String userId) {
        if (isBorrowed && borrowedBy.equals(userId)) {
            isBorrowed = false;
            borrowedBy = null;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("You can't return this book.");
        }
    }

    @Override
    public String toString() {
        return id + " - " + title + " - " + rating + " - " + price
                + (isBorrowed ? " (Borrowed by: " + borrowedBy + ")" : "");
    }
}
