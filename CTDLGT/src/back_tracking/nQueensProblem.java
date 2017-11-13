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

//sắp xếp n con hậu trên bàn cờ vua kích thước n*n sao cho chúng ko ăn đc nhau
//lời giải cần đưa ra tọa độ của n Queens theo cột
//VD: n=4, kq = (3,1,4,2), nghĩa là 4 con queen ở hàng 1 đến hàng 4 lần lượt ở cột thứ 3,1,4,2 như hình sau:
/*

_ _ Q _
Q _ _ _
_ _ _ Q
_ Q _ _

a[1]=3
a[2]=1
a[3]=4
a[4]=2
*/
//Tập UCV Sk phải thỏa mãn 2 đkiện sau với mọi i khác j: 
//  ai != aj
//  |ai - aj| != |i - j|
public class nQueensProblem {
    static int []a = new int[101];
    static int n;
    static int count=0;
    
    static boolean thuocTapUCV(int b, int k) {     //kiểm tra xem số b có thuộc tập UCV Sk hay ko, ở đây b có vai trò là a[k]. Cần kiểm tra liệu a[k] có thuộc tập Sk ko, hay nói cách khác a[k] có thỏa mãn đk đề bài ko
        for (int i = 1; i <= k-1; i++) {
            if(a[i] == b) return false;
            if(Math.abs(a[i] - b) == Math.abs(i - k)) return false;     //Nếu |a[i] - a[k]| = |i-k|, tức là con hậu thứ k cùng đường chéo với bất kì con hậu nào đã xếp trước đó, thì return false
        }
        return true;
    }
    
    static void ghiNhan() {
        printArray(a);
        count++;
    }
    
    public static void printArray(int []a) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    static void nQueens(int k) {
        for (int i = 1; i <= n; i++) {
            if(thuocTapUCV(i, k)) {
                a[k] = i;
                if(k == n) ghiNhan();
                else nQueens(k+1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("nhap so n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("\nCác cách xếp "+n+" con hậu là:");
        nQueens(1);
        System.out.println("\nVậy có tất cả "+count+" cách xếp!");
    }
}
