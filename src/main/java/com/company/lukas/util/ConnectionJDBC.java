package company.lukas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/store";

    public static final String USER = "root";
    public static final String PASS = "root";


    public static Connection conn = null;
    public static PreparedStatement preparedStatement = null;

    public static void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
    }

    public static  void closeStatement(){
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
