/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
public class ArrayToCollection {
    public static void main(String args[]) throws IOException {
        Scanner in=new Scanner(System.in);
        System.out.println("How many elements you want to add to the array: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.println("Enter your elements:");
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = in.nextLine();
        }
        System.out.println(name);
        
        List list = Arrays.asList(name); //chuyển mảng thành list
        System.out.println();
        for (Object li : list) {
            String str = (String) li;
            System.out.print(str + " ");
        }
    }
}
