package repository;

import entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("librarian", "lib123", "Librarian"));
        users.add(new User("user", "user123", "User"));
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; 
    }
}