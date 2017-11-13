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
//Liệt kê các tập con m phần tử của tập n phần tử N = {1,2,3,...,n} (m<=n)

public class LietKeTapCon {
    static int []a = new int[101];
    static int n,m;
    
    static void mSet(int k) {
        for (int i = a[k-1]+1; i <= n-m+k; i++) {   //lấy lần lượt các UCV trong tập Sk để tím Sk+1
            a[k] = i;
            if(k == m) ghiNhan();
            else mSet(k+1);     //nếu k<m tức là cần tìm tiếp a[k+1]
        }
    }
    
    static void ghiNhan() {
        printArray(a);
    }
    
    public static void printArray(int []a) {
        for (int i = 1; i <= m; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("(nhap so < 100, n > m)n,m = ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a[0] = 0;
        mSet(1);
    }
}
