package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    private final String database_name = "twitter";
    private final String connection_url = "jdbc:mysql://localhost:3306/" + database_name;
    private final String user = "root";
    private final String password = "rohan1234";
    private Connection connection;

    public boolean connect() {
        try {
            this.connection = DriverManager.getConnection(connection_url, user, password);
            return true;
        } catch (SQLException exception) {
            System.out.println("failed to connected to the datatase " + exception.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException exception) {
            System.out.println("failed to close the connection to the database " + exception.getMessage());
        }
    }

    private String wrapQuotesString(String str) {
        return "\"" + str + "\"";
    }

    public boolean createUserTable() {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            String query = "CREATE TABLE users(" +
                    "full_name VARCHAR(255) NOT NULL, " +
                    "username VARCHAR(24) PRIMARY KEY, " +
                    "email VARCHAR(255) NOT NULL UNIQUE, " +
                    "mobile_number VARCHAR(10) NOT NULL UNIQUE, " +
                    "bio VARCHAR(255), " +
                    "gender VARCHAR(24) NOT NULL, " +
                    "followers INT DEFAULT 0, " +
                    "followings INT DEFAULT 0, " +
                    "CHECK (gender = 'male' OR gender = 'female' OR gender = 'other')" +
                    ")";
            System.out.println(query);
            statement.execute(query);

            return true;
        } catch (SQLException exception) {
            System.out.println("failed to create table " + exception);
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                System.out.println("failed to close the statement " + exception.getMessage());
            }
        }
    }

    public ArrayList<User> getAllUsers() {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            ArrayList<User> users = new ArrayList<User>();

            while (resultSet.next()) {
                User user = new User(resultSet.getString("full_name"), resultSet.getString("username"),
                        resultSet.getString("email"), resultSet.getString("mobile_number"),
                        resultSet.getString("bio"), resultSet.getString("gender"), resultSet.getInt("followers"),
                        resultSet.getInt("followings"));
                users.add(user);
            }
            return users;
        } catch (SQLException exception) {
            System.out.println("failed to get the users data " + exception);
            return null;
        } finally {
            try {
                resultSet.close();
            } catch (SQLException exception) {
                System.out.println("failed to close the result set " + exception.getMessage());
            }
            try {
                statement.close();
            } catch (SQLException exception) {
                System.out.println("failed to close the statement " + exception.getMessage());
            }
        }
    }

    public User getUserByUsername(String username) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            String queryString = "SELECT * FROM users WHERE username = " + wrapQuotesString(username);
            resultSet = statement.executeQuery(queryString);
            resultSet.next();
            User user = new User(resultSet.getString("full_name"), resultSet.getString("username"),
                    resultSet.getString("email"), resultSet.getString("mobile_number"),
                    resultSet.getString("bio"), resultSet.getString("gender"), resultSet.getInt("followers"),
                    resultSet.getInt("followings"));

            return user;
        } catch (SQLException exception) {
            System.out.println("failed to get the data");
            return null;
        }
    }

    public boolean createUser(User user) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            String query = "INSERT INTO users(full_name, username, email, mobile_number, bio, gender) VALUES" +
                    "(" +
                    wrapQuotesString(user.getFullName()) + ", " +
                    wrapQuotesString(user.getUsername()) + ", " +
                    wrapQuotesString(user.getEmail()) + ", " +
                    wrapQuotesString(user.getMobileNumber()) + ", " +
                    wrapQuotesString(user.getBio()) + ", " +
                    wrapQuotesString(user.getGender()) +
                    ")";

            statement.execute(query);
            return true;
        } catch (SQLException exception) {
            System.out.println("failed to insert the data into the table " + exception);
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                System.out.println("failed to close the statement " + exception.getMessage());
            }
        }
    }

    public boolean deleteUserByUsername(String username) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            String queryString = "DELETE FROM users WHERE username = " + wrapQuotesString(username);

            statement.execute(queryString);
            return true;

        } catch (SQLException exception) {
            System.out.println("failed to delete the data : " + exception.getMessage());
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                System.out.println("failed to close the statement " + exception.getMessage());
            }
        }
    }

    public boolean updateUserByUsername(String username) {
        return false;
    }

}
