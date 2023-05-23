import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    LoginForm() {
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JLabel lb1 = new JLabel("User Name");
        JLabel lb2 = new JLabel("Password");
        JTextField jtf1 = new JTextField(1);
        JTextField jtf2 = new JPasswordField(1);
        JButton bt1 = new JButton("Login");
        JButton signupButton = new JButton("Switch to Signup"); // New signup button

        jp1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        jp1.add(lb1, constraints);
        constraints.gridy = 1;
        jp1.add(lb2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        jp1.add(jtf1, constraints);
        constraints.gridy = 1;
        jp1.add(jtf2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;

        jp1.add(bt1, constraints);
        constraints.gridy = 3;
        jp1.add(signupButton, constraints); // Add signup button

        add(jp1, BorderLayout.CENTER);

        // Switch to Signup form button action
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the Login form
                new Signup(); // Open the Signup form
            }
        });

        // Login button action
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validate the login credentials here
                String username = jtf1.getText();
                String password = jtf2.getText();

                UserDao userDao = new UserDao();
                String[] details = userDao.read(username);

                if (details.length > 0 && details[1].equals(password)) {
                    Config.logged_in = Integer.parseInt(details[2]);
                    Options options = new Options();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
        setTitle("Log-In");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(299, 300);
        setLocationRelativeTo(null);
    }
}
