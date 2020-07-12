
package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    private Connection c;

    public Connection getConnection() {
          
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3307/eczane?user=root&password=root");
            System.out.println("Bağlantı Başarılı");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Bağlantı Başarısız");
        }
        
        return c;
 
    }

    public void setConnection(Connection connection) {
        this.c = connection;
    }
    
}
