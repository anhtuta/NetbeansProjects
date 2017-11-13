package DBO;

public class DBO_DIEM {

    private int id_DIEM;
    private String MaSoSinhVien;
    private String MaHocPhan;
    private float Diem_C;
    private float Diem_B;
    private float Diem_TL1;
    private float Diem_TL2;
    private float Diem_Trung_Binh;
    private String Diem_Chu;
    private boolean Xoa;

    public int getId_DIEM() {
        return id_DIEM;
    }

    public void setId_DIEM(int id_DIEM) {
        this.id_DIEM = id_DIEM;
    }

    public String getMaSoSinhVien() {
        return MaSoSinhVien;
    }

    public void setMaSoSinhVien(String MaSoSinhVien) {
        this.MaSoSinhVien = MaSoSinhVien;
    }

    public String getMaHocPhan() {
        return MaHocPhan;
    }

    public void setMaHocPhan(String MaHocPhan) {
        this.MaHocPhan = MaHocPhan;
    }

    public float getDiem_C() {
        return Diem_C;
    }

    public void setDiem_C(float Diem_C) {
        this.Diem_C = Diem_C;
    }

    public float getDiem_B() {
        return Diem_B;
    }

    public void setDiem_B(float Diem_B) {
        this.Diem_B = Diem_B;
    }

    public float getDiem_TL1() {
        return Diem_TL1;
    }

    public void setDiem_TL1(float Diem_TL1) {
        this.Diem_TL1 = Diem_TL1;
    }

    public float getDiem_TL2() {
        return Diem_TL2;
    }

    public void setDiem_TL2(float Diem_TL2) {
        this.Diem_TL2 = Diem_TL2;
    }

    public float getDiem_Trung_Binh() {
        return Diem_Trung_Binh;
    }

    public void setDiem_Trung_Binh(float Diem_Trung_Binh) {
        this.Diem_Trung_Binh = Diem_Trung_Binh;
    }

    public String getDiem_Chu() {
        return Diem_Chu;
    }

    public void setDiem_Chu(String Diem_Chu) {
        this.Diem_Chu = Diem_Chu;
    }

    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }

}
