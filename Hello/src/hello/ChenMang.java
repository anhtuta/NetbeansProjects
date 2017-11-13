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

//////////bài toán chèn mảng b vào mảng b tại vị trí p của mảng a: tại vị trí a[p]
///ví dụ: mảng a=[21 43 23 12 44 32 76 90 33 ], b=[4 7 9], p = 5 thì in ra kq là [21 43 23 12 44 32 4 7 9 76 90 33 ]
public class ChenMang {
    static void nhap(int [] a) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<a.length; i++) {
            System.out.print("phan tu thu "+i+" = "); a[i] = sc.nextInt();
            
        }
    }
    
    static void show(int [] a) {
        for(int i= 0; i<a.length; i++) System.out.print(a[i]+" ");
        System.out.println("");
    }
    
    
    static void chen(int []a, int[]b, int p) {
        int i,q;
        q = a.length + b.length;
        int []c = new int[q];
        int []rest = new int[a.length - p-1];
        for(i=0; i<rest.length; i++) rest[i] = a[i+p+1];
        if(p>a.length) System.out.println("p lon hon kich thuoc mang a"); 
        else  {
            for( i=0; i<=p; i++)  c[i] = a[i];
            for(i=p+1; i<=p+b.length; i++)  c[i] = b[i-(p+1)];
            for(i = p+b.length + 1; i<q; i++)  c[i] = rest[i-(p+b.length + 1)];
        }
        
        show(c);
        
    }
    
    public static void main(String[] args) {
        int n,m,p;
        
        Scanner sc2 = new Scanner(System.in);
        System.out.println("nhap so luong phan tu cua mang a: ");
        n = sc2.nextInt();
        System.out.println("nhap so luong phan tu cua mang b: ");
        m = sc2.nextInt();
        
        int [] a = new int[n];
        int [] b = new int[m];
        
        System.out.println("nhap cac phan tu mang a: "); nhap(a); 
        System.out.println("nhap cac phan tu mang b: "); nhap(b); 
        System.out.print("mang a vua nhap la: "); show(a);
        System.out.print("mang b vua nhap la: ");show(b);
        
        System.out.println("Nhap vi tri can chen: ");
        p = sc2.nextInt();
        System.out.println("mang a sau khi chen la: ");
        chen(a,b,p);
    }
}
