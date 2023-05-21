import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login_Form extends JFrame {
    Login_Form() {
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JLabel lb1 = new JLabel("User Name");
        JLabel lb2 = new JLabel("Password");
        JTextField jtf1 = new JTextField(1);
        JTextField jtf2 = new JPasswordField(1);
        JButton bt1 = new JButton("Login");
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
        add(jp1, BorderLayout.CENTER);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validate the login credentials here
                String username = jtf1.getText();
                String password = jtf2.getText();

                // Perform login validation logic
                boolean isValid = validateLogin("Ayesha Amjad", "admin");

                if (isValid) {
                    // If login is successful, navigate to the options class
                    Options options = new Options();
                    options.setVisible(true);
                    options.setTitle("Options");
                    options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    options.setSize(300, 300);
                    options.setLocationRelativeTo(null); // Center the frame

                    // Close the login form
                    dispose();
                } else {
                    // Show an error message for invalid login
                    JOptionPane.showMessageDialog(Login_Form.this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Simulate login validation logic
    private boolean validateLogin(String username, String password) {
        // Perform your login validation logic here
        // Return true if the login is successful, false otherwise
        return username.equals("Ayesha Amjad") && password.equals("admin");
    }


    public static void main(String[] args) {
        Login_Form frame = new Login_Form();
        frame.setVisible(true);
        frame.setTitle("Log-In");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null); // Center the frame
    }
}
