package DAL;
import DBO.DBO_VIEW_SV_LOP;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DAL_ViewSVLop extends DataAccessHelper{
    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;
    
    public ArrayList<DBO_VIEW_SV_LOP> getSVLop(String malop){
        ArrayList<DBO_VIEW_SV_LOP> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_View_sv_lop(?)}");
            store_proc.setString(1, malop);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_VIEW_SV_LOP item = new DBO_VIEW_SV_LOP();
                    item.setMaSoSinhVien(rs.getString("MaSoSinhVien"));
                    item.setHoTen(rs.getString("HoTen"));
                    item.setMaLop(rs.getString("MaLop"));
                    item.setTenLop(rs.getString("TenLop"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_getSVLop getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }
}
