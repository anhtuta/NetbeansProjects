package DAL;

import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import DBO.DBO_Finding;
import java.util.ArrayList;

public class DAL_Finding extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_Finding> getFinding(String mssv) {
        ArrayList<DBO_Finding> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Finding(?)}");
            store_proc.setString(1, mssv);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                    DBO_Finding item = new DBO_Finding();
                    item.setSoTinChiDat(rs.getInt("SoTinChiDat"));
                    item.setDiemTrungBinh(rs.getFloat("DiemTrungBinh"));
                    objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Finding Error : " + e.toString());
        }
        getClose();
        return objs;
    }
}
