package DLL;

import DBO.DBO_Finding;
import DAL.DAL_Finding;
import java.util.ArrayList;

public class DLL_Finding {
    
    DAL_Finding dAL_Finding = new DAL_Finding();
    
    public ArrayList<DBO_Finding> getFinding(String mssv) {
        return dAL_Finding.getFinding(mssv);
    }
}
