/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_list;

import java.util.Stack;

/**
 *
 * @author AnhTu
 */
public class StackApp {

    public static void main(String[] args) {
        Stack s = new Stack();
        int i = 0;
        while (i++ < 10) {
            if (i % 2 == 0) {
                s.push(i);
            } else {
                s.push(i + 0.5);
            }
        }
        System.out.println("The top element is: " + s.peek());
        System.out.println("The position of 4 is: " + s.search(4));
        System.out.print("The stack contains: ");

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();

    }
}
