package DLL;

import DAL.DAL_HocPhan;
import DBO.DBO_HOC_PHAN;
import java.util.ArrayList;

public class DLL_HocPhan {

    DAL_HocPhan dal_hp = new DAL_HocPhan();

    public ArrayList<DBO_HOC_PHAN> getAllHocPhan() {
        return dal_hp.getAllHocPhan();
    }

    public ArrayList<DBO_HOC_PHAN> getSearchHocPhan(String chuoitimkiem) {
        return dal_hp.getSearchHocPhan(chuoitimkiem);
    }

    public ArrayList<DBO_HOC_PHAN> getAllHocPhan_dk(String maHP) {
        return dal_hp.getAllhocPhan_dk(maHP);
    }

    public ArrayList<DBO_HOC_PHAN> Check_Lop(String maHP) {
        return dal_hp.Check_HocPhan(maHP);
    }

    public boolean Check(String MaHP) {
        return dal_hp.Check(MaHP);
    }
    
    public boolean Insert(DBO_HOC_PHAN item) {
        return dal_hp.Insert(item);
    }

    public boolean Update(DBO_HOC_PHAN item, String dk) {
        return dal_hp.Update(item, dk);
    }

    public boolean Delete(String MaLop) {
        return dal_hp.Delete(MaLop);
    }
    public ArrayList<Integer> getYear() {
        return dal_hp.getYear();
    }
}
