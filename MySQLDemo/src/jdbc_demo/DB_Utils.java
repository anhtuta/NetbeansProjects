/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//see more: https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
public class DB_Utils {
    
    String url, user, password;
    Connection conn;
    
    public boolean initialize(int dbType) {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("database.properties"));
            url = p.getProperty("url"+dbType);
            user = p.getProperty("user");
            password = p.getProperty("password"+dbType);
            
            switch(dbType) {
                case 0: //mySQL
                    Class.forName("com.mysql.jdbc.Driver");  //load driver vào hệ thống
                    conn = DriverManager.getConnection(url+"?user="+user+"&password="+password);
                    //cach 2: conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_sv_ktx", "root", "5555");
                    break;
                case 1: //Oracle
                    Class.forName("oracle.jbdc.OracleDriver");
                    conn = DriverManager.getConnection(url, user, password);
                    break;
                case 2: //SQL server
                    break;
                default: throw new IllegalArgumentException("Invalid DB Type");
            }
            System.out.println(url);
            System.out.println(user+" - "+password);
            
        } catch (IOException ex) {
            Logger.getLogger(DB_Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DB_Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(conn == null) {
            throw new NullPointerException("Connection is null");
            //don't need return false, if connection is null, exception will occur and we can't do anything later
        } else System.out.println("Connection is OK");
        return true;
    }
    
    public static void main(String[] args) {
        DB_Utils db = new DB_Utils();
        try {
            boolean isConnected = db.initialize(0);
            System.out.println("isConnected? "+isConnected);
        } catch (Exception e) {
            //
        }
        //nhận xét: với 1 project lớn, nếu muốn thay đổi url, user, password,..., thì ta chỉ cần thay đổi ở file database.properties, như vậy dễ bảo trì hơn rất nhiều
        
        
        System.out.println("--------");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.version"));
    }
}
