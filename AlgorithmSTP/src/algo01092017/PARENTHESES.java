/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo01092017;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author AnhTu
 */
public class PARENTHESES {
    private boolean match(char c, char cc) {
        if(c=='(' && cc==')') return true;
        if(c=='[' && cc==']') return true;
        if(c=='{' && cc=='}') return true;
        return false;
    }
    
    public int checkParentheses(String str) {
        int i;
        char c, cc;
        Stack <Character> s = new Stack<>();
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if(c=='(' || c=='[' || c=='{') s.push(c);
            else if(c==')' || c==']' || c=='}') {
                if(s.isEmpty()) {
                    return 0;
                }
                cc = s.pop();
                if(!match(cc, c)) {
                    return 0;
                }
            }
        }

        if(s.isEmpty()) return 1;
        else return 0;
    }
    
    public static void main(String[] args) {
        PARENTHESES p = new PARENTHESES();
        int testCase = 0;
        int []kq;
        Scanner sc = new Scanner(System.in);
        
        testCase = sc.nextInt();
        kq = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            String str = new Scanner(System.in).nextLine();
            //System.out.println(p.checkParentheses(str));
            kq[i] = p.checkParentheses(str);
        }
        
        for (int i = 0; i < testCase; i++) {
            System.out.println(kq[i]);
        }
    }
}

/*
input:
3
()()[[]]
[[]]{{}}
[[[[[[]]]][]

output:
0
1
1
*/