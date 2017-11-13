package DLL;

import DBO.DBO_DANG_NHAP;
import DAL.DAL_DangNhap;
import java.util.ArrayList;

public class DLL_DangNhap {

    DAL_DangNhap loginQue = new DAL_DangNhap();

    public boolean getLogin(DBO_DANG_NHAP log) {
        return loginQue.getLogin(log);
    }

    public DBO_DANG_NHAP showDangNhap(String tenDangNhap, String matKhau) {
        return loginQue.showDangNhap(tenDangNhap, matKhau);
    }

    public ArrayList<DBO_DANG_NHAP> checkLogin(String tenDangNhap, String matKhau) {
        return loginQue.checkLogin(tenDangNhap, matKhau);
    }

    public boolean Update(DBO_DANG_NHAP obj) {
        return loginQue.Update(obj);
    }

    public boolean checkTonTaiTaiKhoan(String name, String pass) {
        return loginQue.checkTonTaiTaiKhoan(name, pass);
    }
}
