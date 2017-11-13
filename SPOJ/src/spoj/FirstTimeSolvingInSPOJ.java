/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AnhTu
 * TEST - Life, the Universe, and Everything
#basic #tutorial #ad-hoc-1
Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything. More precisely... rewrite small numbers from input to output. Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.

 */

// lần đầu tiên thử giải 1 bài trên SPOJ, bài này khá dễ
public class FirstTimeSolvingInSPOJ {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int a;
        
        while(true) {
            a = sc.nextInt();
            if(a!=42)   list.add(a);
            else break;
        }
        
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
