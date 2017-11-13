/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

/**
 *
 * @author AnhTu
 */
//////////////////
//class này chỉ gồm thuộc tính của 1 sv
//thêm class này khi đang làm chức năng find
//các chức năng khác trước đó ko cần class này
/////////////////

public class SinhVien {
    private int MSSV;
    private String name;
    private String gioiTinh;
    private String birthday;
    private String khoaVien;
    private int khoa;
    private String queQuan;
    private String phongTro;

    public int getMSSV() {
        return MSSV;
    }

    public String getName() {
        return name;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getKhoaVien() {
        return khoaVien;
    }

    public int getKhoa() {
        return khoa;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getPhongTro() {
        return phongTro;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setKhoaVien(String khoaVien) {
        this.khoaVien = khoaVien;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setPhongTro(String phongTro) {
        this.phongTro = phongTro;
    }

    public SinhVien(int MSSV, String name, String gioiTinh, String birthday, String khoaVien, int khoa, String queQuan, String phongTro) {
        this.MSSV = MSSV;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.birthday = birthday;
        this.khoaVien = khoaVien;
        this.khoa = khoa;
        this.queQuan = queQuan;
        this.phongTro = phongTro;
    }
    
    
}
