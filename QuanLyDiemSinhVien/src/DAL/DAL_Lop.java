package DAL;

import DBO.DBO_LOP;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAL_Lop extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_LOP> getAllLop() {
        ArrayList<DBO_LOP> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_GetAll()}");
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_LOP item = new DBO_LOP();
                    item.setMaLop(rs.getString("MaLop"));
                    item.setTenLop(rs.getString("TenLop"));
                    item.setMaKhoa(rs.getString("MaKhoa"));
                    item.setKhoaHoc(rs.getString("KhoaHoc"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Lop getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_LOP> getAllLop_dk(String MaLop) {
        ArrayList<DBO_LOP> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_Get_dk(?)}");
            store_proc.setString(1, MaLop);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_LOP item = new DBO_LOP();
                item.setMaLop(rs.getString("MaLop"));
                item.setTenLop(rs.getString("TenLop"));
                item.setMaKhoa(rs.getString("MaKhoa"));
                item.setKhoaHoc(rs.getString("KhoaHoc"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Lop getAllLop() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Insert(DBO_LOP item) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_InsertItem(?,?,?,?)}");
            store_proc.setString(1, item.getMaLop());
            store_proc.setString(2, item.getTenLop());
            store_proc.setString(3, item.getMaKhoa());
            store_proc.setString(4, item.getKhoaHoc());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa insert() Error : " + e.toString());
        }
        getClose();
        return check;
    }

    // Khiểm tra sự tồn tại của lớp trong database
    public ArrayList<DBO_LOP> Check_Lop(String MaLop) {
        ArrayList<DBO_LOP> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_Get_dk(?)}");
            store_proc.setString(1, MaLop);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_LOP item = new DBO_LOP();
                    item.setMaLop(rs.getString("MaLop"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa chech Khoa dk() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MaLop) {
        ArrayList<DBO_LOP> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_Get_dk(?)}");
            store_proc.setString(1, MaLop);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_LOP item = new DBO_LOP();
                    item.setMaLop(rs.getString("MaLop"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa chech Khoa dk() Error : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // update dữ liệu
    public boolean Update(DBO_LOP item, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_UpdateItem(?,?,?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, item.getMaLop());
            store_proc.setString(3, item.getTenLop());
            store_proc.setString(4, item.getMaKhoa());
            store_proc.setString(5, item.getKhoaHoc());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Lop update Error : " + e.toString());
        }
        getClose();
        return check;
    }

    // Delete Item in table on database
    public boolean Delete(String MaLop) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Lop_DeleteItem(?)}");
            store_proc.setString(1, MaLop);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Lop Delete Error : " + e.toString());
        }
        getClose();
        return check;
    }
}
