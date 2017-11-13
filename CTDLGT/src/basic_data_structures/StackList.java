/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_data_structures;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
//quy ước: p = head = current node (if has the statement: p=p.next), p1 = new Node(value) trong các hàm
public class StackList {
    int size;
    private Node top = null;
    
    public void push(int v) {
        Node p1 = new Node(v);
        if(top == null) top = p1;
        else {
            p1.next = top;
            top = p1;
        }
        size++;
    }
    
    public int pop() {
        if(top == null) {
            System.out.println("stack is emtpy, can't pop!");
            return 0;
        }
        else {
            int result = top.value;
            top = top.next;
            if(size!=0)size--;
            return result;
        }
    }
    
    public int peek() {
        return top.value;
    }
    public boolean isEmpty() {
        return top == null;
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
    
    public void printStackWithoutBackspace() {
        if(top == null) {
            System.out.println("Stack is empty now. Can't print!");
            return;
        }
        Node p = top;
        while(p != null) {
            System.out.print(p.value);
            p = p.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        StackList sl = new StackList();
        Scanner sc = new Scanner(System.in);
        
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
        
    }
    
    
    
    
    ///inner class Node:
    private class Node {  //để cho đơn giản thì mỗi node chỉ gồm data là 1 số nguyên, và có 1 con trỏ trỏ tới phần tử tiếp theo (và 1 con trỏ tới phần tử trước đó nếu là danh sách đôi)
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
}
