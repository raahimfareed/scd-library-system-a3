import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IssueBook extends JFrame {
    private JTextField bookIdTextField;
    private JButton issueButton;

    public IssueBook() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Issue Book");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdTextField = new JTextField();
        formPanel.add(bookIdLabel);
        formPanel.add(bookIdTextField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        issueButton = new JButton("Issue");
        mainPanel.add(issueButton, BorderLayout.SOUTH);

        add(mainPanel);

        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = bookIdTextField.getText();

                if (bookId.isEmpty()) {
                    JOptionPane.showMessageDialog(IssueBook.this, "Please enter a book ID.");
                    return;
                }

                int bookIdInt;
                try {
                    bookIdInt = Integer.parseInt(bookId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(IssueBook.this, "Invalid book ID format.");
                    return;
                }

                issueBookToUser(bookIdInt);
            }
        });

        setTitle("Issue Book");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void issueBookToUser(int bookId) {
        Connection conn = Database.connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Couldn't establish connection with the database");
            return;
        }

        try (PreparedStatement statement = conn.prepareStatement("UPDATE books SET issued_to = ? WHERE id = ?")) {
            System.out.println(Config.logged_in);
            statement.setInt(1, Config.logged_in);
            statement.setInt(2, bookId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Book issued successfully.");
                dispose(); // Close the window after issuing the book
            } else {
                JOptionPane.showMessageDialog(this, "Failed to issue the book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
