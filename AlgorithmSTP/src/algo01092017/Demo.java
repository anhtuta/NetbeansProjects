/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo01092017;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
public class Demo {
    public static void main(String[] args) {
        int n;
        int []a;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("a["+i+"] = "+a[i]);
        }
    }
}
