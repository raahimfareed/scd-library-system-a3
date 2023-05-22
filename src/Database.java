import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String hostname = "localhost";
    private static final int port = 3306;
    private static final String database = "scd_library_ass3";
    private static final String username = "uni";
    private static final String password = "";

    public static Connection connect() {
        try {
            String uri = String.format("jdbc:mysql://%s:%d/%s", hostname, port, database);
            return DriverManager.getConnection(uri, username, password);
        } catch (SQLException e) {
           System.out.format("An error occurred: %s\n", e.getMessage());
        }

        return null;
    }

    public static void initialize() {
        Connection conn = Database.connect();
        if (conn == null) {
            System.out.println("Connection could not be established");
            return;
        }

        try {
            Statement statement = conn.createStatement();
            String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "username VARCHAR(255) NOT NULL,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "password VARCHAR(255) NOT NULL,"
                    + "admin INT NOT NULL"
                    + ")";
            statement.executeUpdate(createUserTableQuery);

            // Create Book table
            String createBookTableQuery = "CREATE TABLE IF NOT EXISTS books ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "author VARCHAR(255) NOT NULL,"
                    + "genre VARCHAR(255) NOT NULL,"
                    + "price DECIMAL(10,2) NOT NULL,"
                    + "issued_to INT,"
                    + "FOREIGN KEY (issued_to) REFERENCES users(id)"
                    + ")";
            statement.executeUpdate(createBookTableQuery);
            conn.close();
        }
        catch (SQLException e) {
            System.out.format("An error occurred: %s", e.getMessage());
        }
    }
}
