package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/escuela";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
     public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
    

