import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

interface BookDaoInterface {
    public abstract void create(String name, String genre, double price);
    public abstract List<Book> getAllBooks();
}

public class BookDao implements BookDaoInterface {
    @Override
    public void create(String name, String genre, double price) {
        Connection conn = Database.connect();
        if (conn == null) {
            System.out.println("Couldn't establish connection with the database");
            return;
        }
        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO books (name, genre, price) VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, genre);
            statement.setDouble(3, price);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book created successfully.");
            } else {
                System.out.println("Failed to create the book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM books");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String genre = resultSet.getString("genre");
                double price = resultSet.getDouble("price");
                int issuedTo = resultSet.getInt("issued_to");

                Book book = new Book(id, name, genre, price, issuedTo);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
