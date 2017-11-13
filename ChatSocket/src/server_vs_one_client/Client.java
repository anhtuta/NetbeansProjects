/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_vs_one_client;

/**
 *
 * @author AnhTu
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Client {
    final String serverHost = "localhost";
    
    String name;
    Socket socketOfClient;
    BufferedWriter bw;
    BufferedReader br;

    public Client(String name) {
        this.name = name;
        socketOfClient = null;
        bw = null;
        br = null;
    }
    
    public void connectToServer() {
        try {
            socketOfClient = new Socket(serverHost, 9999);
            bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendToServer(String line) {
        try {
            this.bw.write(line);
            this.bw.newLine();   //phải có newLine thì mới dùng đc hàm readLine()
            this.bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieveFromServer() {
        try {
            return this.br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void disconnect() {
        try {
            this.br.close();
            this.bw.close();
            this.socketOfClient.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Client client = new Client("anhtu");
        client.connectToServer();
        
        String request;
        String response;
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.print(client.name+": ");
            request = sc.nextLine();

            client.sendToServer(request);       //gửi data tới server
            
            response = client.recieveFromServer();   //nhận phản hồi từ server sau khi đã gửi data ở trên
            System.out.println("Server: "+response);    //in ra kq vua nhan duoc
            if(response.equalsIgnoreCase("quit")) break;
        }
        
        System.out.println("Disconnected to server!");
        client.disconnect();
    }
}