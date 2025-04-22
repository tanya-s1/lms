package entity;

public class Book {
    private int id;
    private String title;
    private boolean isBooked;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isBooked = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isBooked() { return isBooked; }

    public void setBooked(boolean booked) { isBooked = booked; }
}
