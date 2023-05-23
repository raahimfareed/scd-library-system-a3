import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

interface UserDaoInterface {
    public abstract void create(String username, String name, String password);
    public abstract int find(String username);
    public abstract String[] read(String username);
    public abstract List<User> getAllUsers();
    public abstract String[] read(int userId);
}

public class UserDao implements UserDaoInterface {
    @Override
    public void create(String username, String name, String password) {
        Connection conn = Database.connect();
        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
           String query = "INSERT INTO users (username, name, password) VALUES (?, ?, ?);";
           PreparedStatement stmt = conn.prepareCall(query);
           stmt.setString(1, username);
           stmt.setString(2, name);
           stmt.setString(3, password);
           stmt.executeUpdate();
           conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int find(String username) {
        int userId = -1; // Default value if user is not found
        Connection conn = Database.connect();

        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return -1;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT id FROM users WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }

    @Override
    public String[] read(String username) {
        String[] details = new String[3];
        Connection conn = Database.connect();

        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return details;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    details[0] = resultSet.getString("username");
                    details[1] = resultSet.getString("password");
                    details[2] = String.valueOf(resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return details;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = Database.connect();

        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return users;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM users");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");

                User user = new User(id, username, name);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public String[] read(int userId) {
        String[] details = new String[2];
        Connection conn = Database.connect();

        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return details;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    details[0] = resultSet.getString("username");
                    details[1] = resultSet.getString("password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return details;
    }
}