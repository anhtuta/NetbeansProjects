/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parentheses;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
public class Temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int T;
        System.out.println("Enter test_case:");
        T = sc.nextInt();
        
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < T; i++) {
            
            System.out.println("Enter a string:");
            str = sc2.nextLine();   //CHÚ Ý: ko thể dùng sc để đọc ở đây đc, ko biết tại sao!
            System.out.println("("+i+")String you entered: "+str);
        }
        
    }
}
