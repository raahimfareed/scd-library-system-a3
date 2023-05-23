import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reset extends JFrame {
    public Reset() {
        Connection conn = Database.connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Couldn't establish connection with the database");
            return;
        }
        try {
            // Clear the "books" table
            String clearBooksQuery = "DELETE FROM books";
            PreparedStatement clearBooksStatement = conn.prepareStatement(clearBooksQuery);
            clearBooksStatement.executeUpdate();
            String clearerQuery = "DELETE FROM users";
            PreparedStatement clearerStatement = conn.prepareStatement(clearerQuery);
            clearerStatement.executeUpdate();


            JOptionPane.showMessageDialog(this, "Tables Cleared successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}