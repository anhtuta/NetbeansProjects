package DLL;

import DBO.DBO_KHOA;
import DAL.DAL_Khoa;
import java.util.ArrayList;

public class DLL_Khoa {

    DAL_Khoa dAL_Khoa = new DAL_Khoa();

    public ArrayList<DBO_KHOA> getAllKhoa() {
        return dAL_Khoa.getAllKhoa();
    }

    public boolean Insert(DBO_KHOA obj) {
        return dAL_Khoa.Insert(obj);
    }

    public ArrayList<DBO_KHOA> getAllKhoa_dk(String MaKhoa) {
        return dAL_Khoa.getAllKhoa_dk(MaKhoa);
    }

    public boolean Update(DBO_KHOA obj, String dk) {
        return dAL_Khoa.Update(obj, dk);
    }

    public boolean Delete(String MaKhoa) {
        return dAL_Khoa.Delete(MaKhoa);
    }

    public ArrayList<DBO_KHOA> Check_Khoa(String MaKhoa) {
        return dAL_Khoa.Check_Khoa(MaKhoa);
    }
    public boolean Check(String MaKhoa) {
        return dAL_Khoa.Check(MaKhoa);
    }
}
