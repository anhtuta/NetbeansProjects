/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import basic_data_structures.StackList;
import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //chuyển hệ 10 sang 2 (hoặc sang bất kì hệ nào khác)
        System.out.println("Convert to binary: enter a number in decimal:");
        int n = sc.nextInt();
        StackList sl2 = new StackList();
        while(n!= 0) {
            sl2.push(n%2);  //push phần dư vào stack
            n = n/2;  //còn phần nguyên thì gán vào biến n
        }
        while(!sl2.isEmpty()) {
            System.out.print(sl2.pop());
        }
        System.out.println();
    }
}
