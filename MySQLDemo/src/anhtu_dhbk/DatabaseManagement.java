/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhtu_dhbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class DatabaseManagement {
    private Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public final String DATABASE_NAME = "studentdb";
    public final String USERNAME = "root";
    public final String PASSWORD = "5555";
    public final String URL_MYSQL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
    
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL_MYSQL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public ResultSet getData() {
        try {
            pst = conn.prepareStatement("SELECT * FROM student");
            rs = pst.executeQuery();
            
            //pst.close();
            //conn.close();  sẽ có lỗi nếu close: java.sql.SQLException: Operation not allowed after ResultSet closed
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void insertRecord(Student st) {
        try {
            pst = conn.prepareCall("INSERT INTO student VALUES ('"+st.id+"', '"+st.name+"', '"+st.phone+"')");
            int kq = pst.executeUpdate();
            if(kq > 0) System.out.println("Insert successful!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showData(ResultSet rs2) {
        Student st;
        try {
            while(rs2.next()) {
                int id = rs2.getInt(1);
                String name = rs2.getString(2);
                String phone = rs2.getString(3);
                
                st = new Student(id, name, phone);
                st.displayStudentInfo();
                System.out.println("-----------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void close() {
        try {
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
