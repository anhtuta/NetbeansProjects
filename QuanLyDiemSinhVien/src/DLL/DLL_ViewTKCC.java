package DLL;

import DBO.DBO_VIEW_THONGKE_CANHCAO;
import java.util.ArrayList;
import DAL.DAL_ViewTKCC;

public class DLL_ViewTKCC {

    DAL_ViewTKCC dAL_ViewTKCC = new DAL_ViewTKCC();

    public ArrayList<DBO_VIEW_THONGKE_CANHCAO> getSVCC(int namhoc, int hocki) {
        return dAL_ViewTKCC.getSVCC(namhoc, hocki);
    }
}
