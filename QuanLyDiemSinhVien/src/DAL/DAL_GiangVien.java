package DAL;

import DBO.DBO_GIANG_VIEN;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAL_GiangVien extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_GIANG_VIEN> getAllGV() {
        ArrayList<DBO_GIANG_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_GiangVien_GetAll()}");
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_GIANG_VIEN item = new DBO_GIANG_VIEN();
                    item.setMaGiangVien(rs.getString("MaGiangVien"));
                    item.setHoTenGiangVien(rs.getString("HoTenGiangVien"));
                    item.setGioiTinh(rs.getBoolean("GioiTinh"));
                    item.setSoDienThoai(rs.getString("SoDienThoai"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GiangVien getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_GIANG_VIEN> getAllGV_dk(String MaGiangVien) {
        ArrayList<DBO_GIANG_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_GiangVien_GetAll_dk(?)}");
            store_proc.setString(1, MaGiangVien);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_GIANG_VIEN item = new DBO_GIANG_VIEN();
                item.setMaGiangVien(rs.getString("MaGiangVien"));
                item.setHoTenGiangVien(rs.getString("HoTenGiangVien"));
                item.setGioiTinh(rs.getBoolean("GioiTinh"));
                item.setSoDienThoai(rs.getString("SoDienThoai"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GiangVien getAllGV_dk() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Insert(DBO_GIANG_VIEN obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_GiangVien_InsertItem(?,?,?,?)}");
            store_proc.setString(1, obj.getMaGiangVien());
            store_proc.setString(2, obj.getHoTenGiangVien());
            store_proc.setBoolean(3, obj.isGioiTinh());
            store_proc.setString(4, obj.getSoDienThoai());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GiangVien insert() Error : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Update(DBO_GIANG_VIEN obj, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call  sp_qldsv_GiangVien_UpdateItem(?,?,?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, obj.getMaGiangVien());
            store_proc.setString(3, obj.getHoTenGiangVien());
            store_proc.setBoolean(4, obj.isGioiTinh());
            store_proc.setString(5, obj.getSoDienThoai());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GiangVien update() Error : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Delete(String MaGiangVien) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_GiangVien_DeleteItem(?)}");
            store_proc.setString(1, MaGiangVien);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GiangVien Delete() Error : " + e.toString());
        }
        getClose();
        return check;
    }

    public ArrayList<DBO_GIANG_VIEN> Check_GV(String MaGV) {
        ArrayList<DBO_GIANG_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_GiangVien_GetAll_dk(?)}");
            store_proc.setString(1, MaGV);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_GIANG_VIEN item = new DBO_GIANG_VIEN();
                    item.setMaGiangVien(rs.getString("MaGiangVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GetAllGiangVien_dk() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MaGV) {
        ArrayList<DBO_GIANG_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_GiangVien_GetAll_dk(?)}");
            store_proc.setString(1, MaGV);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_GIANG_VIEN item = new DBO_GIANG_VIEN();
                    item.setMaGiangVien(rs.getString("MaGiangVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GetAllGiangVien_dk() Error : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
