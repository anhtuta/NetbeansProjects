/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author AnhTu
 */
public class MaximumTest {
    // determines the largest of three Comparable objects

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // assume x is initially the largest
        if (y.compareTo(max) > 0) {
            max = y; // y is the largest so far
        }
        if (z.compareTo(max) > 0) {
            max = z; // z is the largest now
        }
        return max; // returns the largest object
        
    }

    public static <E extends Double> E max2(E x, E y, E z) {
        E max=x;
        if(y > max) max = y;
        if(z>max) max=z;
        
        return max;
    }
    
    public static void main(String args[]) {
        System.out.printf("Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum(3, 4, 5));
        System.out.printf("Maxm of %.1f,%.1f and %.1f is %.1f\n\n",
                6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear",
                "apple", "orange", maximum("pear", "apple", "orange"));
        
        System.out.println(max2(1.2, 9.2, 7.2));
        
    }
    
}

