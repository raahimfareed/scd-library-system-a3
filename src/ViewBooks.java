import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewBooks extends JFrame {
    ViewBooks() {
        setTitle("View Books");
        setLayout(new BorderLayout());

        JPanel tablePanel = new JPanel(new GridLayout(0, 4));
        JLabel titleLabel = new JLabel("Title");
        JLabel genreLabel = new JLabel("Genre");
        JLabel priceLabel = new JLabel("Price");
        JLabel issuedToLabel = new JLabel("Issued To");

        tablePanel.add(titleLabel);
        tablePanel.add(genreLabel);
        tablePanel.add(priceLabel);
        tablePanel.add(issuedToLabel);

        BookDao bookDao = new BookDao();
        UserDao userDao = new UserDao();
        List<Book> books = bookDao.getAllBooks();
        for (Book book : books) {
            JLabel titleLabelData = new JLabel(book.getName());
            JLabel genreLabelData = new JLabel(book.getGenre());
            JLabel priceLabelData = new JLabel(String.valueOf(book.getPrice()));

            int issuedTo = book.getIssuedTo();
            String issuedToName;
            if (issuedTo != 0) {
                String[] userDetails = userDao.read(issuedTo);
                if (userDetails[0] != null) {
                    issuedToName = userDetails[0];
                } else {
                    issuedToName = "N/A";
                }
            } else {
                issuedToName = "N/A";
            }
            JLabel issuedToLabelData = new JLabel(issuedToName);

            tablePanel.add(titleLabelData);
            tablePanel.add(genreLabelData);
            tablePanel.add(priceLabelData);
            tablePanel.add(issuedToLabelData);
        }

        add(tablePanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
