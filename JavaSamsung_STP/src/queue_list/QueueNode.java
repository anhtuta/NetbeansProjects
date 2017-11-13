/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_list;

/**
 *
 * @author AnhTu
 */
public class QueueNode {
    Object data;
    QueueNode next;

    public QueueNode(Object data) {
        this.data = data;
        this.next = null;
    }
    
}
