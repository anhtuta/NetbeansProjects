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

/////////bài toán phân tích số n ra thừa số nguyên tố

/////ý tưởng: lấy n chia cho các số tự nhiên i từ 2-n. nếu n chia hết cho i thì giữ nguyên i và thay n = n/i. nếu n ko chia hết cho i thì tăng i
public class PhanTichThuaSoNguyenTo {
    static void phanTich(int n)  {
        int i = 2;
        int m = n;
        while(n>0) {
            if(n==1||n==2) System.out.println(n);
            else if(n%i==0) {
                System.out.print(i+"*");
                n=n/i;
            }
            else i++;
            if((n==i)&&(n!=2)) {
                System.out.print(n);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int n;
        //String ch = new String();
        int ch; //điều kiện lặp lại chương trình
        do {
            System.out.println("nhap so n:");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            System.out.println("Phan tich n thanh cac thua so nguyen to: ");
            phanTich(n); 
            System.out.println("");
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Ban co muon tiep tuc? (1/0)");
            //ch = sc2.next();
            ch = sc2.nextInt();
        } while(ch==1);
        
    }
}
