/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.Stack;

/**
 *
 * @author AnhTu
 */
public class StackDemo { //LIFO
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("bottom");  //đẩy phần tử vào stack, phần tử đầu tiên có chỉ số 0
        stack.push("the second"); //phần tử này vị trí thứ 2
        stack.push("the third");
        
        System.out.println(stack);
        System.out.println(stack.peek()); //phần tử ở đỉnh, là phần tử có chỉ số cao nhất, tức là là phần tử cuối cùng của mảng stack
        
        try {
            stack.pop(); //xóa phần tử có chỉ số cao nhất
            System.out.println(stack);
            stack.pop();
            System.out.println(stack);
            stack.pop();
            System.out.println(stack);
            stack.pop();
            System.out.println(stack);
            stack.pop();
            System.out.println(stack);
            stack.pop();
            System.out.println(stack);
        } catch (java.util.EmptyStackException e) {
            System.out.println("stack is empty now. can't pop anymore!");
        }
        
        
    }
}
