import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Database.initialize();
        Login_Form frame = new Login_Form();
        frame.setVisible(true);
        frame.setTitle("Log-In");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(299,300);
        frame.setLocationRelativeTo(null); // Center the frame
    }
}