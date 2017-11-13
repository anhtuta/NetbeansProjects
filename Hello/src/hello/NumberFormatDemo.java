/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author AnhTu
 */
public class NumberFormatDemo {
    public static void main(String[] args) {
        long l=123456789;
        double d=1234567.890193;
        
        Locale loc=new Locale("vi", "VN");
        NumberFormat myFormat=NumberFormat.getInstance(loc);
        
        myFormat.setMaximumFractionDigits(4); //só chữ số lớn nhất sau dấu thập phân
        myFormat.setMinimumFractionDigits(2);  //só chữ số nhỏ nhất sau dấu thập phân
        
        myFormat.setRoundingMode(RoundingMode.HALF_UP); //làm tròn lên
        
        System.out.println(myFormat.format(l));
        System.out.println(myFormat.format(d));
        
        //xem thêm trên youtube
    }
}
