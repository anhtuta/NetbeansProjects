/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ThanhJupi
 */
public class DatabaseConnection {
    Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public DatabaseConnection() {
    }
    public String connectDatabase(String host,String database,String user,String password){
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlServer://localhost:"+host+";"+"databaseName="
                    +database+";"+"user="+user+";"+"password="+password+";");
         return "SuccessFull!"; 
        } catch (Exception e) {
            return "Error :"+e.toString();
        }
    }
}
