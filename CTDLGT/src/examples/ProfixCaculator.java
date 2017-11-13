/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import basic_data_structures.StackListGeneric;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author AnhTu
 */
//ứng dụng nhỏ để tính giá trị biểu thức dạng hậu tố, hạn chế: chỉ tính với số nguyên ko âm, các phép toán chỉ có: +,-,*,/
//chú ý: các toán hạng cách nhau = dấu cách, phép chia chỉ lấy phần nguyên
//VD: 1 6 + 6 2 * 3 / - có kết quả = 3
//5 9 8 - 7 1 - * + 7 * = 77
public class ProfixCaculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 biểu thức dạng hậu tố:");
        String bthuc = sc.nextLine();
        
        int kq = ProfixCaculator.calulate(bthuc);
        System.out.println("Kết quả phép tính trên là: "+kq);
    }
    
    public static int calulate(String bieuThuc) {  //tính giá trị của biểu thức nhập vào, chẳng hạn bieuThuc = 5 9 8 - 7 1 - * + 7 * = 77
        StackListGeneric<String> st = new StackListGeneric<>();
        StringTokenizer token = new StringTokenizer(bieuThuc, " ");
        while(token.hasMoreElements()) {
            //System.out.print(token.nextToken()+" ");
            String element = token.nextToken();
            if(!ProfixCaculator.isOperator(element)) { //nếu là toán hạng thì đưa nó vào stack
                st.push(element); //System.out.println("push: "+element);
            } else { //nếu là toán tử thì lấy 2 toán hạng trong stack ra và tính toán với toán tử đó,kết quả tính đc push vào stack
                int second = Integer.valueOf(st.pop()); //System.out.println("pop: "+second);
                int first = Integer.valueOf(st.pop()); //System.out.println("pop: "+first);
                int temp = ProfixCaculator.caculate2Operands(first, second, element); //System.out.println("temp = "+temp);
                st.push(String.valueOf(temp)); //System.out.println("push: "+temp);
            }
        }
        return Integer.valueOf(st.pop());
    }
    
    public static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") ||op.equals("/") || op.equals(":");
    }
    
    public static int caculate2Operands(int a, int b, String op) {  //tính giá trị 2 toán hạng với toán tử = op
        int result = 0;
        switch(op) {
            case "+": result = a+b; break;
            case "-": result = a-b; break;
            case "*": result = a*b; break;
            case "/": 
            case ":": result = a/b; break;
        }
        return result;
    } 
}
