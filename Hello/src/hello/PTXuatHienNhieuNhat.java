/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */

/////////chương trình sau nhập vào 1 mảng và tìm phần tử xuất hiện nhiều nhất trong mảng
public class PTXuatHienNhieuNhat {
    static void display(int [] a) {    //hàm hiển thị mảng a
        int max = 0;
        int [] b = new int[a.length];  //khởi tạo mảng b có độ dài = độ dài mảng a
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<=i; j++)
                if(a[i] == a[j]) b[i]++;
        }
        
        //tìm giá trị xuất hiện nhiều nhất
        max = b[0];
        for(int i=0; i<a.length; i++)
            if(b[i]>max) max = b[i];
        for(int i=0; i<a.length; i++)
            if(b[i]==max) System.out.println("phan tu "+a[i]+" co so lan xuat hien la "+max);
        
    }
    
    static void nhap() {  //ham nhap mang a[]
        int [] a;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phan tu cua mang n= ");
        n = sc.nextInt();
        a = new int[n];
        for(int i=0;i<n; i++) {
            System.out.println("Nhap phan tu a["+i+"]= ");
            a[i] = sc.nextInt();
        }
        System.out.println("mang vua nhap la");
        for(int i=0; i<a.length; i++) System.out.print(a[i]+" ");
        System.out.println("");
        display(a);
    }
    
    public static void main(String[] args) {
        nhap();
    }
}
