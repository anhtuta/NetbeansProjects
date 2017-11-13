package DAL;

import DBO.DBO_VIEW_DIEM_SV_MON_HOC;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAL_ViewDiemMonHocSV extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_VIEW_DIEM_SV_MON_HOC> getDSVMH(String mahocphan) {
        ArrayList<DBO_VIEW_DIEM_SV_MON_HOC> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_View_Diem_sv_MonHoc(?)}");
            store_proc.setString(1, mahocphan);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_VIEW_DIEM_SV_MON_HOC item = new DBO_VIEW_DIEM_SV_MON_HOC();
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    item.setTenHocPhan(rs.getString("TenHocPhan"));
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    item.setHoTen(rs.getString("HoTen"));
                    item.setDiem_Trung_Binh(rs.getFloat("Diem_Trung_Binh"));
                    item.setDiem_Chu(rs.getString("Diem_Chu"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_ViewDSVMH getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }
}
