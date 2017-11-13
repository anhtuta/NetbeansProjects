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
//Nhập số n, sau đó liệt kê các hoán vị của tập n số: {1,2,3,...,n}
//Dễ thấy rằng tập các UCV Sk = N\{a1, a2,..., a(k-1)}

public class LietKeHoanVi {
    static int []a = new int[101];      //a là mảng chứa các phần tử của tập hoán vị
    static int n;   //nhập n nhỏ thôi để thử
    
    static boolean thuocTapUCV(int i, int k) {     //kiểm tra xem số i có thuộc tập UCV Sk hay ko, 
        //nghĩa là ta cần kiểm tra xem từ a[1]-a[k-1] có thằng nào = i hay ko, 
        //nếu có 1 thằng = i rồi thì a[k] ko thể = i đc nữa, nghĩa là i ko thuộc Sk
        for (int x = 1; x <= k-1; x++) {
            if(a[x] == i) return false;     //nếu như có 1 số từ a1 -> a(k-1) có giá trị = i thì i ko thuộc tập Sk
        }
        return true;
    }
    
    static void ghiNhan() {
        printArray(a);
    }
    
    public static void printArray(int []a) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    static void hoanVi(int k) {
        for (int i = 1; i <= n; i++) {
            if(thuocTapUCV(i, k)) {     //với mỗi vòng lặp của i, kiểm tra xem i có thuộc tập UCV Sk hay ko, nếu có thì cho a[k] = i
                a[k] = i;
                if(k==n) ghiNhan();
                else hoanVi(k+1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("nhap so n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("\nTập hoán vị của n số tự nhiên đầu tiên là:");
        hoanVi(1);
    }
}
