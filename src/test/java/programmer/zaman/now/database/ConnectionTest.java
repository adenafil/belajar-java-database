package programmer.zaman.now.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void tesConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?severTimeZone=Asia/Jakarta";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Sukses konek ke database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }

    @Test
    void tesConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?severTimeZone=Asia/Jakarta";
        String user = "root";
        String password = "";

        try(Connection connection = DriverManager.getConnection(jdbcUrl, user, password)) {

            System.out.println("Sukses konek ke database");
            //connection.close();
            //System.out.println("Koneksi sudah tertutup");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }


}
