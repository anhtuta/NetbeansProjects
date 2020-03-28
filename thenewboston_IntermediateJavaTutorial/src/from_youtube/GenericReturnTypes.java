/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

/**
 *
 * @author AnhTu
 */
//Mở rộng của bài GenericMethods: bài này áp dụng đc cho cả integer và string
public class GenericReturnTypes {
    public static void main(String[] args) {
        System.out.println(max(21,33,1));
        System.out.println(max("apple", "grape", "chicken"));
        System.out.println(max(2,92,4,22));
        
    }
    
    public static <T extends Comparable<T>> T max(T a, T b, T c) {
        T m = a;
        if(b.compareTo(a) > 0) m = b;
        if(c.compareTo(m) > 0) m = c;
        return m;
    }
    public static <T extends Comparable<T>> T max(T a, T b, T c, T d) {
        T m = null;
        m = (b.compareTo(a) > 0) ? b : a;
        m = (c.compareTo(m) > 0) ? c : m;
        m = (d.compareTo(m) > 0) ? d : m;
        return m;
    }
}
