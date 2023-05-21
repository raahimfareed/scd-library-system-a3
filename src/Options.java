import javax.swing.*;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Options extends JFrame {
    Options() {
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JButton bt1 = new JButton("View Books");
        JButton bt2 = new JButton("View Users");
        JButton bt3 = new JButton("View Issued Books");
        JButton bt4 = new JButton("Issue Book");
        JButton bt5 = new JButton("Add User");
        JButton bt6 = new JButton("Add Books");
        JButton bt7 = new JButton("Return Book");
        JButton bt8 = new JButton("Create/Reset");
        jp1.setLayout(new FlowLayout(CENTER));
        jp1.add(bt1);
        jp1.add(bt2);
        jp1.add(bt3);
        jp1.add(bt4);
        jp1.add(bt5);
        jp1.add(bt6);
        jp1.add(bt7);
        jp1.add(bt8);
        add(jp1, BorderLayout.CENTER);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                View_Books vb = new View_Books();
                vb.setVisible(true);
                vb.setTitle("View Books");
                vb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vb.setSize(300, 300);
                vb.setLocationRelativeTo(null); // Center the frame
            }
        });
        bt6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                Add_Book ab = new Add_Book();
                ab.setVisible(true);
                ab.setTitle("View Books");
                ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ab.setSize(300, 300);
                ab.setLocationRelativeTo(null); // Center the frame
            }
        });
        bt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                Add_User au = new Add_User();
                au.setVisible(true);
                au.setTitle("View Books");
                au.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                au.setSize(300, 300);
                au.setLocationRelativeTo(null); // Center the frame
            }
        });
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If login is successful, navigate to the options class
                View_User vu = new View_User();
                vu.setVisible(true);
                vu.setTitle("View Books");
                vu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vu.setSize(300, 300);
                vu.setLocationRelativeTo(null); // Center the frame
            }
        });
        }

    public static void main(String[] args) {
        Options frame = new Options();
        frame.setVisible(true);
        frame.setTitle("Admin Functions");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null); // Center the frame
    }

}
