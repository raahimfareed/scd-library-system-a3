import javax.swing.*;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Options extends JFrame {
    Options() {
        setVisible(true);
        setTitle("Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null); // Center the frame
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JButton bt1 = new JButton("View Books");
        JButton bt2 = new JButton("View Users");
        JButton bt4 = new JButton("Issue Book");
        JButton bt5 = new JButton("Add User");
        JButton bt6 = new JButton("Add Books");
        JButton bt7 = new JButton("Return Book");
        JButton bt8 = new JButton("Reset");
        jp1.setLayout(new FlowLayout(CENTER));
        jp1.add(bt1);
        jp1.add(bt2);
        jp1.add(bt4);
        jp1.add(bt5);
        jp1.add(bt6);
        jp1.add(bt7);
        jp1.add(bt8);
        add(jp1, BorderLayout.CENTER);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                ViewBooks vb = new ViewBooks();
                vb.setVisible(true);
                vb.setTitle("View Books");
                vb.setSize(300, 300);
                vb.setLocationRelativeTo(null); // Center the frame
            }
        });
        // Issue Book Button
        bt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IssueBook issueBook = new IssueBook();
                issueBook.setVisible(true);
            }
        });
        bt6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                AddBook ab = new AddBook();
                ab.setVisible(true);
                ab.setTitle("View Books");
                ab.setSize(300, 300);
                ab.setLocationRelativeTo(null); // Center the frame
            }
        });
        bt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                AddUser au = new AddUser();
                au.setVisible(true);
                au.setTitle("View Books");
                au.setSize(300, 300);
                au.setLocationRelativeTo(null); // Center the frame
            }
        });
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                ViewUsers vu = new ViewUsers();
                vu.setVisible(true);
                vu.setTitle("View Books");
                vu.setSize(300, 300);
                vu.setLocationRelativeTo(null); // Center the frame
            }
        });
        }
}
