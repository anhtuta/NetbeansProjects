/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_date;

import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class Insert_phong {
    
    public static void main(String[] args) {
        //vi du:
        //INSERT INTO `quan_ly_sv_ktx`.`phong` (`tenPhong`, `loaiPhong`, `soLuongCho`, `soLuongChoTrong`, `giaThue`, `ToaNha_tenToaNha`) VALUES ('B9-101', 'nam', '8', '1', '4300', 'B9');
        String tenToaNha = "B9";
        String [] gtinh = {"nam", "nữ"};
        Random rd = new Random();
        for (int i = 1; i <= 13; i++) {
            System.out.println("INSERT INTO `quan_ly_sv_ktx`.`phong` (`tenPhong`, `loaiPhong`, `soLuongCho`, `soLuongChoTrong`, `giaThue`, `ToaNha_tenToaNha`) VALUES ('"+tenToaNha+"-"+ (300+i) +"', '"+ gtinh[rd.nextInt(2)] +"', '"+ (6+2) +"', '"+ (1+rd.nextInt(3)) +"', '"+ (20 + rd.nextInt(31)) + "00" +"', '" +tenToaNha+ "');");
        }
    }
}
