package General;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import java.sql.*;

public class DBTest {
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet resultSet;

    @Test
    public static void DBconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Enviroments.dbUrl, Enviroments.dbUsername, Enviroments.dbPassword);
            String query = "Select * from automation_report";
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occured while loading the driver of JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
