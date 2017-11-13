package DAL;

import DBO.DBO_VIEW_THONGKE_CANHCAO;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAL_ViewTKCC extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_VIEW_THONGKE_CANHCAO> getSVCC(int namhoc, int hocki) {
        ArrayList<DBO_VIEW_THONGKE_CANHCAO> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_View_ThongKe_CanhCao(?,?)}");
            store_proc.setInt(1, namhoc);
            store_proc.setInt(2, hocki);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_VIEW_THONGKE_CANHCAO item = new DBO_VIEW_THONGKE_CANHCAO();
                    item.setMaLop(rs.getString("MaLop"));
                    item.setTenLop(rs.getString("TenLop"));
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    item.setHoTen(rs.getString("HoTen"));
                    item.setDiemSo(rs.getFloat("DiemSo"));
                    item.setHinhThuc(rs.getString("HinhThuc"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_getSVCC getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }
}
