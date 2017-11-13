package DLL;

import DBO.DBO_DIEM;
import DAL.DAL_Diem;
import java.util.ArrayList;

public class DLL_Diem {

    DAL_Diem dAL_Diem = new DAL_Diem();

    public ArrayList<DBO_DIEM> getAllDiem() {
        return dAL_Diem.getAllDiem();
    }
    
    public ArrayList<DBO_DIEM> getAllDiem_dk_mssv(String mssv) {
        return dAL_Diem.getAllDiem_dk_mssv(mssv);
    }

    public ArrayList<DBO_DIEM> getAllDiem_dk(String idDiem) {
        return dAL_Diem.getAllDiem_dk(idDiem);
    }
    public ArrayList<DBO_DIEM> getAllDiem_infor(String mssv, String mahp) {
        return dAL_Diem.getAllDiem_infor(mssv, mahp);
    }

    public ArrayList<DBO_DIEM> Check_Diem(String mssv, String mahocphan) {
        return dAL_Diem.Check_Diem(mssv, mahocphan);
    }

    public boolean Check(String mssv, String mahocphan) {
        return dAL_Diem.Check(mssv, mahocphan);
    }
    
    public boolean Insert(DBO_DIEM obj) {
        return dAL_Diem.Insert(obj);
    }

    public boolean Update(DBO_DIEM obj) {
        return dAL_Diem.Update(obj);
    }
    
    public boolean Delete(String mssv, String mahocphan){
        return dAL_Diem.Delete(mssv, mahocphan);
    }
}
