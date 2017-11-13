package DBO;

import java.util.Date;

public class DBO_SINH_VIEN {

    private String MaSoSinhVien;
    private String HoTen;
    private Date NgaySinh;
    private boolean GioiTinh;
    private String MaLop;
    private String SoDienThoai;

    public String getMaSoSinhVien() {
        return MaSoSinhVien;
    }

    public void setMaSoSinhVien(String MaSoSinhVien) {
        this.MaSoSinhVien = MaSoSinhVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

}
