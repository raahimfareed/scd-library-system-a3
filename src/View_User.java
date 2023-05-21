import javax.swing.*;
import java.awt.*;
public class View_User extends JFrame {
    View_User() {
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JLabel lb1 = new JLabel("VIEW USERS");
        jp1.add(lb1);
        add(jp1, BorderLayout.CENTER);
    }


}