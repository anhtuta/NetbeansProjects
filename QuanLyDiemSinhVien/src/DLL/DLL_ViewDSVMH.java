package DLL;

import DBO.DBO_VIEW_DIEM_SV_MON_HOC;
import java.util.ArrayList;
import DAL.DAL_ViewDiemMonHocSV;

public class DLL_ViewDSVMH {

    DAL_ViewDiemMonHocSV dAL_ViewDiemMonHocSV = new DAL_ViewDiemMonHocSV();

    public ArrayList<DBO_VIEW_DIEM_SV_MON_HOC> getDSVMH(String mahocphan) {
        return dAL_ViewDiemMonHocSV.getDSVMH(mahocphan);
    }
}
