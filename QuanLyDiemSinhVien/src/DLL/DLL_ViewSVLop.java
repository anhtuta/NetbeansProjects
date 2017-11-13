package DLL;

import DBO.DBO_VIEW_SV_LOP;
import java.util.ArrayList;
import DAL.DAL_ViewSVLop;

public class DLL_ViewSVLop {

    DAL_ViewSVLop dAL_ViewSVLop = new DAL_ViewSVLop();

    public ArrayList<DBO_VIEW_SV_LOP> getSVLop(String malop) {
        return dAL_ViewSVLop.getSVLop(malop);
    }
}
