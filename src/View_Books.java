import javax.swing.*;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.*;
public class View_Books extends JFrame {
    View_Books() {
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JLabel lb1 = new JLabel("VIEW BOOKS");
        jp1.add(lb1);
        add(jp1, BorderLayout.CENTER);
    }


}
