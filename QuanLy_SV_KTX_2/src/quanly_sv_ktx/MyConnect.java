/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

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
 * //class này tạo kết nối đến csdl mà thôi, các hàm khác chỉ để thử nghiệm, tìm lỗi sai
 */
public class MyConnect {
    
    private Connection conn;
    
    public Connection connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_sv_ktx", "root", "5555");
            System.out.println("Connect successfull");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        }
        return conn;
    }
    
    ////////////////////////////////////////////////////////////////////////
    ////////các phần dưới đây chỉ để thử nghiệm, ko cần thiết cho MainWindow
    public ResultSet getData() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement(); //tạo đối tượng Statement để tương tác với CSDL
            rs = st.executeQuery("SELECT * FROM sinhvien"); //thực thi truy vấn = cách gọi phương thức từ đối tượng Statement, kết quả là các bản ghi lưu vào biến rs, tí nữa chỉ cần lấy biến rs này để hiển thị nó lên frame
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    private void showData(ResultSet rs) {
        try {
            while(rs.next()) {
                System.out.printf("%-10s %-20s %-4s %-20s %-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            ///CHÚ Ý PHẢI DÙNG LỆNH WHILE, KO DÙNG LỆNH do {} while, vì sẽ bị lỗi Before start of result set
            //nghĩa là viết như sau sẽ lỗi:
//            do {
//                System.out.printf("%-10s %-20s %-4s %-20s %-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteID(int id) {
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("DELETE FROM sinhvien WHERE MSSV = "+id);
            if(pst.executeUpdate() > 0) System.out.println("Delete successful");
            else System.out.println("Cannot delete. sinh vien đó ko tồn tại");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi ko delete đc");
        }
    }
    
    public static void main(String[] args) {
        MyConnect myConnect = new MyConnect();
        myConnect.connect();
        
        myConnect.showData(myConnect.getData());
    }
}
