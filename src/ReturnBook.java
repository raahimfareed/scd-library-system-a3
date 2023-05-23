import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturnBook extends JFrame {
     public ReturnBook() {
          Connection conn = Database.connect();
          if (conn == null) {
               JOptionPane.showMessageDialog(this, "Couldn't establish connection with the database");
               return;
          }

          try (PreparedStatement statement = conn.prepareStatement("UPDATE books SET issued_to = NULL WHERE issued_to = 1")) {


               int rowsAffected = statement.executeUpdate();
               if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Book returned successfully.");
                    dispose(); // Close the window after returning the book
               } else {
                    JOptionPane.showMessageDialog(this, "Failed to return the book.");
               }
          } catch (SQLException e) {
               e.printStackTrace();
          }
     }
}
