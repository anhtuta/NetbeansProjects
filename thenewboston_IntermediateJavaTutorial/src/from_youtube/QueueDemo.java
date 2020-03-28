/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.PriorityQueue;
import java.lang.String;
/**
 *
 * @author AnhTu
 */
public class QueueDemo { //FIFO
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        q.offer("first");
        q.offer("second");
        q.offer("third");
        System.out.println(q);
        System.out.println(q.peek());  //phần tử ở đỉnh, là phần tử có chỉ số thấp nhất, tức là là phần tử đầu tiên của mảng q
        
        q.poll(); //giống pop trong stack, nhưng poll lấy phần tử đầu tiên, tức là phần tử cho vào đầu tiên của q ra trước
        System.out.println(q);
        q.poll();
        System.out.println(q);
        q.poll();
        System.out.println(q);
        
        
    }
}
