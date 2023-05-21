import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
interface library {
    void insertBook(int Row, String name, String genre, int price);
}
public class Add_Book_DAO implements library {
    @Override
    public void insertBook(int Row, String name, String genre, int price) {
        try{
            int Rows = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
            String SQL = "SELECT COUNT(*) AS total_rows FROM viewbooks";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                Row = resultSet.getInt("total_rows");
            }
            SQL = "insert into viewbooks values(?,?,?,?)";
            PreparedStatement ptst = conn.prepareCall(SQL);
            ptst.setInt(1,Rows+1);
            ptst.setString(2, name);
            ptst.setString(3, genre);
            ptst.setInt(4,price);
            ptst.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}