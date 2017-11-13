/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back_tracking;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
//Bài toán này liệu kê tất cả xâu nhị phân có độ dài n
public class LietKeXauNhiPhan {
    static int []a = new int[101]; //xau dai toi da = 100 ki tu
    static int n;
    
    static void xau(int k) {
        int i;
        for (i = 0; i <= 1; i++) {  //j là các giá trị thuộc tập UCV Sk, ta duyệt tất cả các giá trị của j, nghĩa là duyệt từng phần tử của tập Sk
            a[k] = i;
            if(k==n) ghiNhan();
            else xau(k+1);
        }
    }
    static void ghiNhan() {
        printArray(a);
    }
    
    public static void printArray(int []a) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("Enter the length of the binary string n (n<100):");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        xau(1);
    }
}
