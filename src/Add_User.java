import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Add_User extends JFrame {
    Add_User() {
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        /*JLabel lb2 = new JLabel("BID");*/
        JLabel lb3 = new JLabel("User Name");
        JLabel lb4 = new JLabel("Password");
        JLabel lb5 = new JLabel("Admin");
        /*JTextField jtf1 = new JTextField(1);*/
        JTextField jtf2 = new JTextField(1);
        JTextField jtf3 = new JTextField(1);
        JTextField jtf4 = new JTextField(1);
        JButton bt1 = new JButton("Add User");
        jp1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;

        /*jp1.add(lb2, constraints);
        constraints.gridy = 1;*/
        jp1.add(lb3, constraints);
        constraints.gridy = 1;
        jp1.add(lb4, constraints);
        constraints.gridy = 2;
        jp1.add(lb5, constraints);


        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;

        /*jp1.add(jtf1, constraints);
        constraints.gridy = 1;*/
        jp1.add(jtf2, constraints);
        constraints.gridy = 1;
        jp1.add(jtf3, constraints);
        constraints.gridy = 2;
        jp1.add(jtf4, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;

        jp1.add(bt1, constraints);
        add(jp1, BorderLayout.CENTER);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* int bid = Integer.parseInt(jtf1.getText());*/
                String name = jtf2.getText();
                String password = jtf3.getText();
                String admin = jtf4.getText();
                if (jtf2.getText().isEmpty() || jtf3.getText().isEmpty() || jtf4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Add_User.this, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int Row=0;
                Add_User_DAO aud = new Add_User_DAO();
                aud.insertUser(Row,name,password,admin);
            }
        });
    }
}