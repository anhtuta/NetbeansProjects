/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Divide_and_Conquer;

/**
 *
 * @author AnhTu
 */
//Write a program to calculate pow(x,n)
//Chú ý: kí hiệu DC = Divide and Conquer
public class Power {
    static int pow_naive(int x, int n) {
        if(n == 0) return 1;
        else return x*pow_naive(x, n-1);
    }
    
    static int pow_DC(int x, int n) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        if(n == 0) return 1;
        if(n%2 == 0) return pow_DC(x, n/2)*pow_DC(x, n/2);
        else return x*pow_DC(x, n/2)*pow_DC(x, n/2);
    }
    
    static int pow_DC_using_store(int x, int n) {
        //Time Complexity of optimized solution: O(logn)

        if(n == 0) return 1;
        int temp = pow_DC(x, n/2);
        if(n%2 == 0) return temp*temp;
        else return x*temp*temp;
    }
    
    static float pow_DC_float(float x, int n) {
        if(n == 0) return 1;
        float temp = pow_DC_float(x, n/2);
        if(n%2 == 0) return temp*temp;
        else {
            if(n > 0) return x*temp*temp;
            else return temp*temp/x;
        }
    }
    
    public static void main(String[] args) {
        int a = pow_naive(2, 4);
        System.out.println(a);
        
        a = pow_DC(2, 5);
        System.out.println(a);
        
        a = pow_DC_using_store(2, 5);
        System.out.println(a);
        
        float b = pow_DC_float(2, -2);
        System.out.println(b);
    }
}
