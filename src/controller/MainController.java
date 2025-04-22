package controller;

public class MainController {

	public static void main(String[] args) {
		UserController userController = new UserController();
		BookController bookController = new BookController();

		// Adding users
		userController.createUser(1, "Tanya", "tanya@example.com");
		userController.createUser(2, "Yashasvi", "Yashasvi@example.com");

		// Adding books
		bookController.createBook(101, "The Alchemist", "Paulo Coelho");
		bookController.createBook(102, "1984", "George Orwell");

		// Display all users
		System.out.println("\nList of Users:");
		userController.listUsers();

		// Display all books
		System.out.println("\nList of Books:");
		bookController.listBooks();

	}
}