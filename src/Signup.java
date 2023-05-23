import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame {
    private JTextField usernameField;
    private JTextField nameField;
    private JPasswordField passwordField;

    Signup() {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        // Create username field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        // Create name field
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        // Create password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        // Create signup button
        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String name = nameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                UserDao userDao = new UserDao();
                userDao.create(username, name, password);
                Config.logged_in = userDao.find(username);

                dispose();
                Options options = new Options();

                usernameField.setText("");
                nameField.setText("");
                passwordField.setText("");
            }
        });

        // Create login button
        JButton loginButton = new JButton("Switch to Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the Signup form
                new LoginForm(); // Open the Login form
            }
        });

        // Create panel and add components
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(signupButton);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }
}