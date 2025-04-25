package services;

import entity.User;
import repository.UserRepository;

import java.util.Scanner;

public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void viewAllUsers() {
        for (User user : userRepo.getAllUsers().values()) {
            System.out.println(user);
        }
    }

    public void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        userRepo.addUser(new User(id, name));
        System.out.println("User added.");
    }

    public void deleteUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user ID to delete: ");
        String id = sc.nextLine();
        if (userRepo.deleteUser(id)) {
            System.out.println("User deleted.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void updateUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user ID to update: ");
        String id = sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        userRepo.updateUser(new User(id, name));
        System.out.println("User updated.");
    }

    public User loginAsUser(String id) {
        return userRepo.getUserById(id);
    }

    public boolean isLibrarian(String id) {
        return userRepo.getLibrarianById(id) != null;
    }
}
