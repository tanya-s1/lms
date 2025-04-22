package services;

import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(User user) {
        repository.addUser(user);
    }

    public List<User> viewAllUsers() {
        return repository.getAllUsers();
    }
}

