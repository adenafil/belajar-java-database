package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {

    @Test
    void tesAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "insert into comments(email, comment) values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


        statement.setString(1, "ade@test.com");
        statement.setString(2, "hi");

        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println("id comment = " + id);
        }

        statement.close();
        connection.close();
    }

}
