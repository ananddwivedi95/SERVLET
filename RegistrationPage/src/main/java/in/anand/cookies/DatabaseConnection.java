package in.anand.cookies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String dbURL = "jdbc:mysql://localhost:3306/registrationpage";
        String dbUser = "root";
        String dbPassword = "root"; // Replace with your actual MySQL password
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }
}
