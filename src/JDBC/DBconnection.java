package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static DBconnection dbconnection;
    private Connection connection;

    private DBconnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsale","root","1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DBconnection getInstance(){
        if (dbconnection == null){
            dbconnection = new DBconnection();
        }
        return dbconnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
