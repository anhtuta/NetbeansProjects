/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_vs_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

/**
 *
 * @author AnhTu
 */
public class ClientThread extends Thread {

    //nếu tạo 1 thread riêng của mỗi client thì cần các thuộc tính sau:
    String name;
    Socket socketOfClient;
    BufferedWriter bw;
    BufferedReader br;
    //khá dài dòng, do đó cho cái frame của client là 1 thread luôn = cách implement Runnable, do đó ko cần class này nữa
    
    @Override
    public void run() {
        
    }
    
}
