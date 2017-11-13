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
public class ParentheseMatching {
    
    public static boolean isParentheseMatching(String str) { 
        int len = str.length();
        
        char [] arr = str.toCharArray();
        int arr2[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr2[i] = arr[i];
        }
        
        StackList sl3 = new StackList();
        for (int i = 0; i < len; i++) {
            if(arr2[i] == 40) { //40 là mã ASCII của dấu (
                sl3.push(arr2[i]);
            }
            else if(arr2[i] == 41) {//40 là mã ASCII của dấu )
                if(sl3.isEmpty()) {
                    System.out.println("error at "+i);
                    return false;
                }
                else sl3.pop();
            }
        }
        if(sl3.isEmpty()) {
            System.out.println("There's no error!");
            return true;
        }
        else {
            System.out.println("There's some mistakes: missing a/some parenthes(es) at the end");
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi có dấu ngoặc:");
        String str = sc.nextLine();
        
        ParentheseMatching.isParentheseMatching(str);
    }
}
