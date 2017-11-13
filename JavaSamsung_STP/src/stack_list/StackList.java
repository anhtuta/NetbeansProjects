/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_list;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
public class StackList {
    private StackNode top = null;
    
    private void push(Object element) {
        StackNode temp = new StackNode(element);
        if(top == null) top = temp;
        else {
            temp.next = top;
            top = temp;
        }
    }
    
    private Object pop() {
        if(top == null) {
            System.out.println("stack is empty now!");
            return null;
        }
        else {
            Object temp = top.data;
            top = top.next;
            return temp;
        }
    }
    
    private Object peek() {
        return top.data;
    }
    
    public boolean isEmpty() {
        if(top == null) return true;
        else return false;
    }
    
    public void printStack() {
        if(top == null) System.out.println("stack is empty now!");
        else {
            StackNode temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    
    ////main method to test out program:
    public static void main(String[] args) {
        StackList sl = new StackList();
        
        sl.push("Anh tu");
        sl.push(22);
        sl.push("DHBK HN");
        sl.push("DTVT is shit!");
        sl.push("I love BK");
        
        sl.printStack();
        System.out.println("\nTop of stack is: "+sl.peek());
        System.out.println("\nIs stack empty?: "+sl.isEmpty());
        
        sl.pop();
        sl.pop();
        System.out.println("\nstack after pop somethings:");
        sl.printStack();
        
        sl.pop();
        sl.pop();
        sl.pop();
        sl.pop();
        System.out.println("\nstack after pop somethings:");
        sl.printStack();
        sl.pop();
        sl.pop();
        
        System.out.println("\n=======example 2===========\n");
        System.out.println("Enter a number in decimal: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int temp, remainder;
        temp = a;
        
        StackList sl2 = new StackList();
        while(temp!=0) {
            remainder = temp%2;
            sl2.push(remainder);
            temp = temp/2;
        }
        
        System.out.printf("the binary of %d number is: ",a);
        while(sl2.top != null) System.out.print(sl2.pop());
    }

}
