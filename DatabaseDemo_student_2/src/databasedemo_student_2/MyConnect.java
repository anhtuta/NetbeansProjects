/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedemo_student_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class MyConnect {

    private Connection connection;

    public void connect() {
        try {
            //kiểm tra  Driver, kiểm tra class name
            Class.forName("com.mysql.jdbc.Driver");
            
            //tai sao lam theo dong dwowis laij ko dc?
            //connection = DriverManager.getConnection("jdbc:mysql://localhost/student_2?\" + \"user=root&password=5555");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_2", "root", "5555");
            System.out.println("Connect successfull");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé mày!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: Class not found!");
        }
    }
    
    public Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_2", "root", "5555");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé mày!");
            return null;
        }
    }

    public ResultSet getData() { //get data from database: table student2, chú ý data này có kiểu ResultSet
        ResultSet rs = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM student2");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.toString());
        }
        return rs;
    }

    public ResultSet getDataID(String id) { //get data from database with ID = id
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM student2 WHERE id = "+id);
            //hoặc dùng hàm getString():
            //pst = connection.prepareStatement("SELECT * FROM student2 WHERE id = ?");
            //pst.setString(1, id); //hàm này set cái id cho dấu hỏi thứ 1 , nghĩa là thay dấu ? này = giá trị id
            
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko tồn tại sv này!");
        }
        return rs;
    }

    public void showData(ResultSet rs) {  //getData() xong phải hiển thị nó chứ nhỉ? Hiển thị lên console thôi
        try {
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-4s %-20s %-20s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteID(String id) {
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("DELETE FROM student2 WHERE id = "+id);
            if(pst.executeUpdate() > 0) {
                System.out.println("Delete success");
            }
            else System.out.println("ID ko ton tai! ko xoa dc");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: Couldm't delete");
        }
    }

    public void insert(Student_2 s) {
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("INSERT INTO student2 VALUE(?,?,?,?,?)");
            pst.setString(1, s.getId());
            pst.setString(2, s.getName());
            pst.setString(3, s.getGioitinh());
            pst.setString(4, s.getAddress());
            pst.setString(5, s.getEmail());
            
            //kiểm tra xem có insert thành công ko
            if(pst.executeUpdate() > 0) System.out.println("insert thành công");
            else System.out.println("insert failed!");
        } catch (SQLException ex) {
            //Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sinh viên đã tồn tại! ko thể insert!");
            //chú ý khi id trùng thì ko thể insert, và việc kiểm tra id trùng là do sql thực hiện vì ta đã cho id là trường khóa của table
        }
        
    }

    public void updateID(String id, Student_2 s) {
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("UPDATE student2 SET name = ?, Gioi_tinh = ?, Dia_chi = ?, email = ? WHERE id = "+id);
            pst.setString(1, s.getName());
            pst.setString(2, s.getGioitinh());
            pst.setString(3, s.getAddress());
            pst.setString(4, s.getEmail());
            if(pst.executeUpdate() > 0) System.out.println("Update success");
            else System.out.println("couldn't update");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: couldn't update");
        }
    }

    public static void main(String[] args) {
        MyConnect myConnect = new MyConnect();
        myConnect.connect();

        //hien thi data trong student2
        ResultSet rs = myConnect.getData();
        myConnect.showData(rs);
        
        System.out.println("\nsv có ID = 20130002:");
        myConnect.showData(myConnect.getDataID("20130002"));
        
        System.out.println("\nXoa sv 20122020");
        myConnect.deleteID("20122020");
        
        System.out.println("\nInsert sv = 20130004");
        myConnect.insert(new Student_2("20130004", "Sôn gô tên", "Nhật Bản", "Nam", "gotencute@gmail.com"));
        
        System.out.println("\nUpdate sv = 20130004");
        myConnect.updateID("20130004", new Student_2("20130004", "Picollo", "Namek", "Nam", "picollo_da_xanh@gmail.com"));
    }
}
