package DLL;

import DAL.DAL_GiangVien;
import DBO.DBO_GIANG_VIEN;
import java.util.ArrayList;

public class DLL_GiangVien {

    DAL_GiangVien dAL_GiangVien = new DAL_GiangVien();

    public ArrayList<DBO_GIANG_VIEN> getAllGV() {
        return dAL_GiangVien.getAllGV();
    }

    public ArrayList<DBO_GIANG_VIEN> getAllGV_dk(String MaGiangVien) {
        return dAL_GiangVien.getAllGV_dk(MaGiangVien);
    }

    public boolean Insert(DBO_GIANG_VIEN obj) {
        return dAL_GiangVien.Insert(obj);
    }

    public boolean Update(DBO_GIANG_VIEN obj, String dk) {
        return dAL_GiangVien.Update(obj, dk);
    }

    public boolean Delete(String MaGiangVien) {
        return dAL_GiangVien.Delete(MaGiangVien);
    }

    public ArrayList<DBO_GIANG_VIEN> Check_GV(String MaGV) {
        return dAL_GiangVien.Check_GV(MaGV);
    }

    public boolean Check(String MaGV) {
        return dAL_GiangVien.Check(MaGV);
    }
}
