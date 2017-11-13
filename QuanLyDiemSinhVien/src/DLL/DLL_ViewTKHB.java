package DLL;

import DBO.DBO_VIEW_THONGKE_HOCBONG;
import java.util.ArrayList;
import DAL.DAL_ViewTKHB;

public class DLL_ViewTKHB {

    DAL_ViewTKHB dAL_ViewTKHB = new DAL_ViewTKHB();

    public ArrayList<DBO_VIEW_THONGKE_HOCBONG> getSVHB(float dk, int soluong, String makhoa, int namhoc, int hocki) {
        return dAL_ViewTKHB.getSVHB(dk, soluong, makhoa, namhoc, hocki);
    }
}
