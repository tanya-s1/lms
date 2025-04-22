package controller;

import entity.User;
import repository.UserRepository;
import services.UserService;

public class UserController {

	private UserService userService;

    public UserController() {
        this.userService = new UserService(new UserRepository());
    }

    public void createUser(int id, String name, String email) {
        User user = new User(id, name, email);
        userService.addUser(user);
    }

    public void listUsers() {
        for (User user : userService.viewAllUsers()) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }

}