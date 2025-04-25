package repository;

import entity.*;

import java.util.*;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Librarian> librarians = new HashMap<>();

    public UserRepository() {
        users.put("U001", new User("U001", "Tanya"));
        users.put("U002", new User("U002", "ANimesh"));
        users.put("U003", new User("U003", "Yashasvi"));
        users.put("U004", new User("U004", "Riddhima"));
        librarians.put("L001", new Librarian("L001", "Librarian John"));
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public Collection<Librarian> getAllLibrarians() {
        return librarians.values();
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    public Librarian getLibrarianById(String id) {
        return librarians.get(id);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public boolean deleteUser(String id) {
        return users.remove(id) != null;
    }

    public void updateUser(User updatedUser) {
        users.put(updatedUser.getId(), updatedUser);
    }
}
