/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.Stack;

/**
 *
 * @author AnhTu
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(5);
        st.push(11);
        st.push(1995);
        st.push("anhtu");
        st.push(st);
        System.out.println(st);
        st.pop();
        System.out.println("is stack empty?: "+st.empty());
        System.out.println(st);
        try {
            st.pop();
            st.pop();
            st.pop();
            st.pop();
            st.pop();
            st.pop();
        } catch (java.util.EmptyStackException e) {
            System.out.println("stack is empty now");
        }
        System.out.println("is stack empty?: "+st.empty());
        System.out.println(st);
    }
}
