import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 interface library1 {
    public abstract void insertUser(int Row, String name, String password, String admin);
}
public class Add_User_DAO implements library1 {
    @Override
    public void insertUser(int Row, String name, String password, String admin) {
        try{
            int Rows = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
            String SQL = "SELECT COUNT(*) AS total_rows FROM viewusers";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                Row = resultSet.getInt("total_rows");
            }
            SQL = "insert into viewusers values(?,?,?,?)";
            PreparedStatement ptst = conn.prepareCall(SQL);
            ptst.setInt(1,Rows+1);
            ptst.setString(2, name);
            ptst.setString(3, password);
            ptst.setString(4,admin);
            ptst.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}