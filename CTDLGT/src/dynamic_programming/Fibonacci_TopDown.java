/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 *
 * @author AnhTu
 */
/*
Memoization (Top Down): The memoized program for a problem is similar to the recursive version with a small
modification that it looks into a lookup table before computing solutions. We initialize a lookup array with
all initial values as NIL. Whenever we need solution to a subproblem, we first look into the lookup table. 
If the precomputed value is there then we return that value, otherwise we calculate the value and put the 
result in lookup table so that it can be reused later.

Tạm dịch: nếu tính đc Fib(k) thì lưu vào lookup[k] để sau này nếu cần tính lại Fib[k] thì chỉ cần tra bảng lookup
và ko cần phải tính lại nữa
*/
public class Fibonacci_TopDown {
    static final int MAX = 100;
    static int lookup[] = new int[MAX];
    
    static int Fib_TopDown(int n) {
        lookup = new int[n+1];
        return Fib(n);
    }
    
    static int Fib(int n) {
        
        if(lookup[n] == 0) {
            if(n <= 1) lookup[n] = n;
            else lookup[n] = Fib(n-1) + Fib(n-2);
        }
        
        return lookup[n];
    }
    
    public static void main(String[] args) {
        long curr = System.currentTimeMillis();
        System.out.println(Fib_TopDown(43));
        System.out.println("Thời gian thực hiện là: "+(System.currentTimeMillis() - curr) + "(ms)");
    }
}
/*
Fib(43):
433494437
Thời gian thực hiện là: 2(ms)
*/