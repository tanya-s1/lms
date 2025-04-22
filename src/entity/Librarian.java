package entity;

public class Librarian {
    private int id;
    private String name;

    public Librarian(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
