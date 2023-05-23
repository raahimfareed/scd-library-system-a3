import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ViewUsers extends JFrame {
    private UserDao userDao;
    private JTable table;

    public ViewUsers() {
        userDao = new UserDao();
        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setSize(300, 300);
        JLabel lb1 = new JLabel("VIEW USERS");
        jp1.add(lb1);
        add(jp1, BorderLayout.CENTER);

        displayUsers();
        setupTable();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayUsers() {
        List<User> users = userDao.getAllUsers();

        // Create a table model with column names
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("User ID");
        model.addColumn("Username");
        model.addColumn("Name");

        // Populate the table model with user data
        for (User user : users) {
            Object[] rowData = { user.getId(), user.getUsername(), user.getName() };
            model.addRow(rowData);
        }

        // Set the table model to the JTable
        table.setModel(model);
    }

    private void setupTable() {
        // Create the JTable and add it to the JFrame
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
