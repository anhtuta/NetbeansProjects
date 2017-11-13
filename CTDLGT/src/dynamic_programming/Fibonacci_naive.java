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
//Chỉ số: 0,1,2,3,4,5,6,7 ,8 ,...
//Dãy số: 0,1,1,2,3,5,8,13,21,...
//Time: 1.6^n => T(n) = O(2^n)

/*
Giời thiệu về Quy hoạch động (Dynamic Programming - DP):

Two major properties of Dynamic programming

To decide whether problem can be solved by apply­ing Dynamic programming we check for two properties. 
If problem has these two properties then we can solve that problem using Dynamic programming.

Overlapping Sub-problems
Optimal Substructure.

Overlapping Sub-problems: Overlapping sub-problems, as the name sug­gests the sub-problems needs to be solved again and again. 
In recursion we solve those prob­lems every time and in dynamic pro­gram­ming we solve these sub problems 
only once and store it for future use. As we can see in the pic­ture below that we are solving 
many sub-problems repeatedly.

Optimal Substructure: If a prob­lem can be solved by using the solu­tions of the sub prob­lems then we say that prob­lem has a Opti­mal Sub­struc­ture Prop­erty.

Dynamic Programming Approaches:

Bottom-Up
Top-Down

Chú ý rằng Top-down thì phải gọi đệ quy tới chính nó, còn Bottom-up thì ko cần đệ quy, chỉ cần vòng lặp for
*/
public class Fibonacci_naive {
    static int Fib(int n) {
        if(n<=1) return n;
        return Fib(n-1)+Fib(n-2);
    }
    
    public static void main(String[] args) {
        long curr = System.currentTimeMillis();
        System.out.println(Fib(43));
        System.out.println("Thời gian thực hiện là: "+(System.currentTimeMillis() - curr) + "(ms)");
    }
}

//Fib(43):
//433494437
//Thời gian thực hiện là: 9812(ms)