package DLL;

import DAL.DAL_SinhVien;
import DBO.DBO_SINH_VIEN;
import java.util.ArrayList;

public class DLL_SinhVien {

    private DAL.DAL_SinhVien dal_sv = new DAL_SinhVien();

    public ArrayList<DBO_SINH_VIEN> getAllSinhVien() {
        return dal_sv.getAllSinhVien();
    }

    public ArrayList<DBO_SINH_VIEN> getAllGV_dk(String mssv) {
        return dal_sv.getAllSinhVien_dk(mssv);
    }

    public ArrayList<DBO_SINH_VIEN> Check_SV(String mssv) {
        return dal_sv.Check_SV(mssv);
    }

    public boolean Insert(DBO_SINH_VIEN obj) {
        return dal_sv.Insert(obj);
    }

    public boolean Update(DBO_SINH_VIEN obj, String dk) {
        return dal_sv.Update(obj, dk);
    }

    public boolean Delete(String MaGiangVien) {
        return dal_sv.Delete(MaGiangVien);
    }
    public boolean Check(String MSSV) {
        return dal_sv.Check(MSSV);
    }
}
