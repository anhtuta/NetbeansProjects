package DLL;

import DBO.DBO_LOP;
import java.util.ArrayList;
import DAL.DAL_Lop;

public class DLL_Lop {

    DAL_Lop dal_lop = new DAL_Lop();

    public ArrayList<DBO_LOP> getAllLop_dk(String MaLop) {
        return dal_lop.getAllLop_dk(MaLop);
    }

    public ArrayList<DBO_LOP> getAllLop() {
        return dal_lop.getAllLop();
    }

    public boolean Insert(DBO_LOP item) {
        return dal_lop.Insert(item);
    }

    public ArrayList<DBO_LOP> Check_Lop(String MaLop) {
        return dal_lop.Check_Lop(MaLop);
    }

    public boolean Update(DBO_LOP item, String dk) {
        return dal_lop.Update(item, dk);
    }

    public boolean Delete(String MaLop) {
        return dal_lop.Delete(MaLop);
    }

    public boolean Check(String MaLop) {
        return dal_lop.Check(MaLop);
    }
}
