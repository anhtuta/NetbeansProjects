package DAL;

import DBO.DBO_SINH_VIEN;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DAL_SinhVien extends DataAccessHelper {

    MyMethod method = new MyMethod();
    DBO_SINH_VIEN diem = new DBO_SINH_VIEN();
    CallableStatement store_proc = null;
    ResultSet rs = null;
    java.sql.Date sqlDate;

    public ArrayList<DBO_SINH_VIEN> getAllSinhVien() {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll()}");
            rs = store_proc.executeQuery();
            //PreparedStatement ps = cnn.prepareStatement("select * from SINH_VIEN");
//            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    item.setHoTen(rs.getString("HoTen"));
                    item.setNgaySinh(new Date(rs.getDate("NgaySinh").getTime()));
                    item.setGioiTinh(rs.getBoolean("GioiTinh"));
                    item.setMaLop(rs.getString("MaLop"));
                    item.setSoDienThoai(rs.getString("SoDienThoai"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Sv getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_SINH_VIEN> getAllSinhVien_dk(String MSSV) {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll_dk(?)}");
            store_proc.setString(1, MSSV);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                item.setHoTen(rs.getString("HoTen"));
                item.setNgaySinh(new Date(rs.getDate("NgaySinh").getTime()));
                item.setGioiTinh(rs.getBoolean("GioiTinh"));
                item.setMaLop(rs.getString("MaLop"));
                item.setSoDienThoai(rs.getString("SoDienThoai"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv getAllsv_dk() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_SINH_VIEN> Check_SV(String MSSV) {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll_dk(?)}");
            store_proc.setString(1, MSSV);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GetAllsv_dk() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MSSV) {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll_dk(?)}");
            store_proc.setString(1, MSSV);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GetAllsv_dk() Error : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Insert(DBO_SINH_VIEN obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_InsertItem(?,?,?,?,?,?)}");
            store_proc.setString(1, obj.getMaSoSinhVien());
            store_proc.setString(2, obj.getHoTen());
            sqlDate = new java.sql.Date(obj.getNgaySinh().getTime());
            store_proc.setDate(3, sqlDate);
            store_proc.setBoolean(4, obj.isGioiTinh());
            store_proc.setString(5, obj.getMaLop());
            store_proc.setString(6, obj.getSoDienThoai());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv insert() Error : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Update(DBO_SINH_VIEN obj, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call  sp_qldsv_SinhVien_UpdateItem(?,?,?,?,?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, obj.getMaSoSinhVien());
            store_proc.setString(3, obj.getHoTen());
            sqlDate = new java.sql.Date(obj.getNgaySinh().getTime());
            store_proc.setDate(4, sqlDate);
            store_proc.setBoolean(5, obj.isGioiTinh());
            store_proc.setString(6, obj.getMaLop());
            store_proc.setString(7, obj.getSoDienThoai());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv update() Error : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Delete(String MaGiangVien) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_DeleteItem(?)}");
            store_proc.setString(1, MaGiangVien);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv Delete() Error : " + e.toString());
        }
        getClose();
        return check;
    }
}
