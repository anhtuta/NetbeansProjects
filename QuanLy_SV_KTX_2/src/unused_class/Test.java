/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unused_class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanly_sv_ktx.MyConnect;

/**
 *
 * @author AnhTu
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        PreparedStatement pst;
        ResultSet rs;
        Connection conn;
        
        MyConnect mc = new MyConnect();
        conn = mc.connect();
        
        pst = conn.prepareStatement("SELECT * FROM quan_ly_sv_ktx.phong WHERE tenPhong LIKE '"+"B6-107"+"';");
        rs = pst.executeQuery();
        
        int soSV = 0;
        while(rs.next()) {
            soSV = rs.getInt(3) - rs.getInt(4);
            System.out.println("rs.getInt(3)" + rs.getInt(3));
        }
        System.out.println(soSV);
    }
}
