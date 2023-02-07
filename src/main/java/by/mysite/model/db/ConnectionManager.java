package by.mysite.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
     private static Connection cn;
     static {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
     public static Connection getConnection() throws SQLException {
         if (cn == null || cn.isClosed()) {
             return DriverManager.getConnection("jdbc:mysql://localhost:3306/itclass_po60", "root", "");
         }
         return cn;
     }
}
