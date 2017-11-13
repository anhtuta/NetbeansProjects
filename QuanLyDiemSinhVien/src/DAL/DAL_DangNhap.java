package DAL;

import DBO.DBO_DANG_NHAP;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAL_DangNhap extends DataAccessHelper {

    MyMethod method = new MyMethod();
    DBO_DANG_NHAP log = new DBO_DANG_NHAP();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public boolean getLogin(DBO_DANG_NHAP log) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_DangNhap(?,?)}");
            store_proc.setString(1, log.getTenDangNhap());
            store_proc.setString(2, log.getMatKhau());
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error DAL_DangNhap : " + e.toString());
        }
        getClose();
        return check;
    }

    public ArrayList<DBO_DANG_NHAP> checkLogin(String tenDangNhap, String matKhau) {
        ArrayList<DBO_DANG_NHAP> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_DangNhap(?,?)}");
            store_proc.setString(1, tenDangNhap);
            store_proc.setString(2, matKhau);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_DANG_NHAP item = new DBO_DANG_NHAP();
                item.setTenDangNhap(rs.getString("TenDangNhap"));
                item.setMatKhau(rs.getString("MatKhau"));
                item.setHoTen(rs.getString("HoTen"));
                item.setEmail(rs.getString("Email"));
                item.setQuyen(rs.getString("Quyen"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Dang Nhap checklogin() Error : " + e.toString());
        }
        getClose();
        return objs;
    }
    
    public DBO_DANG_NHAP showDangNhap(String tenDangNhap, String matKhau) {
        DBO_DANG_NHAP item = new DBO_DANG_NHAP();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_DangNhap(?,?)}");
            store_proc.setString(1, tenDangNhap);
            store_proc.setString(2, matKhau);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                item.setTenDangNhap(rs.getString("TenDangNhap"));
                item.setMatKhau(rs.getString("MatKhau"));
                item.setHoTen(rs.getString("HoTen"));
                item.setEmail(rs.getString("Email"));
                item.setQuyen(rs.getString("Quyen"));
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Dang Nhap showDangNhap() Error : " + e.toString());
        }
        getClose();
        return item;
    }
    
    public boolean Update(DBO_DANG_NHAP obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_DangNhap_UpdateItem(?,?,?,?)}");
            store_proc.setString(1, obj.getTenDangNhap());
            store_proc.setString(2, obj.getMatKhau());
            store_proc.setString(3, obj.getHoTen());
            store_proc.setString(4, obj.getEmail());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_DangNhap update Error : " + e.toString());
        }
        getClose();
        return check;
    }
    
    public boolean checkTonTaiTaiKhoan(String name, String pass) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_DangNhap(?,?)}");
            store_proc.setString(1, name);
            store_proc.setString(2, pass);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error DAL_DangNhap : " + e.toString());
        }
        getClose();
        return check;
    }
}
