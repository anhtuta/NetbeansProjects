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
Tabulation (Bottom Up): The tabulated program for a given problem builds a table in 
bottom up fashion and returns the last entry from table. For example, for the same 
Fibonacci number, we first calculate fib(0) then fib(1) then fib(2) then fib(3) and 
so on. So literally, we are building the solutions of subproblems bottom-up.

Tạm dịch: để tính Fib(10), ta tính từ dưới lên trên, nghĩa là tính Fib(0), Fib(1), Fib(2),...
sau đó tính đến Fib(10).
Chú ý rằng phần Top Down thì ta tính Fib(10) sau đó tính tới Fib(9), Fib(8),...
mỗi lần tính đc số Fib(k) thì lưu nó vào bảng lookup để sau này sử dụng lại
*/

//1,1,2,3,5,8,13,21,...
public class Fibonacci_BottomUp {
    static int Fib(int n) {
        int []F = new int[n+1];
        F[0] = 0;  F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        
        return F[n];
    }
    
    static int Fib_anotherWay(int n) {
        int Fk_1 = 1, Fk_2 = 1;     //Fk-1 = F[k-1], Fk_2 = F[k-2]
        int Fk = 0;
        for (int i = 2; i < n; i++) {
            Fk = Fk_1 + Fk_2;
            
            //cập nhập 2 số đằng trước để cho việc tính số Fib tiếp theo
            Fk_2 = Fk_1;
            Fk_1 = Fk;
            /*
            Ví dụ: tính Fib(5): Fk_1 = 5, Fk_2 = 3, do đó Fk = 8;
            Sau đó cập nhập Fk_1, Fk_2 để vòng lặp sau còn tính Fib(9): Fk_1 = 8, Fk_2 = 5
            */
        }
        
        return Fk;
    }
    
    
    public static void main(String[] args) {
        long curr = System.currentTimeMillis();
        System.out.println(Fib(43));
        System.out.println("Thời gian thực hiện là: "+(System.currentTimeMillis() - curr) + "(ms)");
    }
}
/*
Fib(43):
433494437
Thời gian thực hiện là: 1(ms)
*/
