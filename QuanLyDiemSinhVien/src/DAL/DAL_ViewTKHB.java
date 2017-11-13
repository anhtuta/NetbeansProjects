package DAL;

import DBO.DBO_VIEW_THONGKE_HOCBONG;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAL_ViewTKHB extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_VIEW_THONGKE_HOCBONG> getSVHB(float dk, int soluong, String makhoa, int namhoc, int hocki) {
        ArrayList<DBO_VIEW_THONGKE_HOCBONG> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_View_ThongKe_HocBong(?,?,?,?,?)}");
            store_proc.setFloat(1, dk);
            store_proc.setInt(2, soluong);
            store_proc.setString(3, makhoa);
            store_proc.setInt(4, namhoc);
            store_proc.setInt(5, hocki);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_VIEW_THONGKE_HOCBONG item = new DBO_VIEW_THONGKE_HOCBONG();
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    item.setHoTen(rs.getString("HoTen"));
                    item.setDiemSo(rs.getFloat("DiemSo"));
                    item.setHinhThuc(rs.getString("HinhThuc"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_ViewTKHB getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }
}
