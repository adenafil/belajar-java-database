package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {
    @Test
    void testStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "insert into comments(email, comment) values('ade@gmail.com', 'hi')";

        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "insert into comments(email, comment) values(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        for (int i = 0; i < 1000; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "ade@test.com");
            preparedStatement.setString(2, "hii");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
