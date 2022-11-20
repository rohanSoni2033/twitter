import models.Database;
import java.util.ArrayList;
import models.User;

class Main {

	public static void main(String[] args) {
		Database db = new Database();

		db.connect();

		// db.createUserTable();

		ArrayList<User> users = db.getAllUsers();

		for (User movie : users) {
			System.out.println(movie.getObjecString());
		}

		// db.deleteUserByUsername("rohanSoni2033");

		// db.createUser(user);
		db.close();
	}

}