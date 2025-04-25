package entity;

public class Book {
    private String id;
    private String title;
    private boolean isBorrowed;
    private String borrowedBy;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
        this.borrowedBy = null;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }
    public String getBorrowedBy() { return borrowedBy; }

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
        return id + " - " + title + (isBorrowed ? " (Borrowed by: " + borrowedBy + ")" : "");
    }
}
