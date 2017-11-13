/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_data_structures;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author AnhTu
 * @param <T>
 */
//quy ước: p = head, p1 = new Node(value) trong các hàm
public class StackListGeneric<T> {
    int size;
    private Node<T> top = null;
    
    public void push(T v) {
        Node p1 = new Node(v);
        if(top == null) top = p1;
        else {
            p1.next = top;
            top = p1;
        }
        size++;
    }
    
    public T pop() {
        if(top == null) {
            System.out.println("stack is emtpy, can't pop!");
            return null;
        }
        else {
            T result = top.value;
            top = top.next;
            if(size!=0)size--;
            return result;
        }
    }
    
    public T peek() {
        return top.value;
    }
    public boolean isEmpty() {
        return top == null;
    }
    
    public void clearStack() {
        top = null;
    }

    public void printStack() {
        if(top == null) {
            System.out.println("Stack is empty now. Can't print!");
            return;
        }
        Node p = top;
        while(p != null) {
            System.out.print(p.value+" ");
            p = p.next;
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        StackListGeneric<Integer> sl = new StackListGeneric();
        
        sl.push(3);
        sl.push(1);
        sl.push(4);
        sl.push(2);
        sl.push(6);
        sl.push(11);
        sl.push(9);
        sl.printStack();
        System.out.println("The size of stack = "+sl.size);    
        
        sl.pop();
        sl.printStack();
        sl.pop();
        sl.pop();
        sl.printStack();
        System.out.println("The size of stack = "+sl.size);    
        sl.pop();
        sl.pop();
        sl.pop();
        sl.pop();
        sl.pop();
        sl.pop();
        sl.pop();
        System.out.println(sl.pop());
        sl.printStack();
        System.out.println("The size of stack = "+sl.size);      
        
        StackListGeneric<String> sl2 = new StackListGeneric();
        sl2.push("anhtu");
        sl2.push("dhbk");
        sl2.push("1995");
        sl2.push("i'm not stupid");
        sl2.push("i love u");
        sl2.push("today is 23/3/17");
        sl2.printStack();
        
        StackListGeneric<Character> sl3 = new StackListGeneric();
        sl3.push('a');
        sl3.push('n');
        sl3.push('h');
        sl3.push(' ');
        sl3.push('t');
        sl3.push('u');
        sl3.push('{');
        sl3.push('[');
        sl3.push('(');
        sl3.push(')');
        sl3.push(']');
        sl3.push('}');
        sl3.clearStack();
        System.out.println("after clear:");
        System.out.println(sl3.pop());
        //sl3.printStack();
    }
    
    
    ///inner class Node:
    private class Node<T> {  //để cho đơn giản thì mỗi node chỉ gồm data là 1 số nguyên, và có 1 con trỏ trỏ tới phần tử tiếp theo (và 1 con trỏ tới phần tử trước đó nếu là danh sách đôi)
        public T value;
        public Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
    
}
