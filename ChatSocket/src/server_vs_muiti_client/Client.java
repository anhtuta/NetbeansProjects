/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_vs_muiti_client;

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
            return this.br.readLine();  //chú ý rằng chỉ nhận 1 dòng từ server gửi về thôi, nếu server gửi nhiều dòng thì các dòng sau ko đọc
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
        Scanner sc = new Scanner(System.in);
        String nickname="";
        
        System.out.println("LOGIN");
        System.out.println("Enter your nickname: ");
        nickname = sc.nextLine();

        Client client = new Client(nickname);
        client.connectToServer();
        client.sendToServer(client.name);   //client lập tức gửi tên của mình tới server
        
        String request;
        String response;
        
        //ban đầu nhận kq kiểm tra xem tên có hợp lệ hay ko:
        while(true) {
            response = client.recieveFromServer();

            if(response.equals(ServerThread.NICKNAME_NOT_VALID)) {
                System.out.println(response);
                System.out.println("Enter another nickname: ");
                nickname = sc.nextLine();
                client.sendToServer(nickname);
            } else {
                break;
            }
            
        }
        
        //sau đó bắt đầu chat nếu tên hợp lệ:
        client.name = nickname;
        while(true) {
            System.out.print(client.name+": ");
            request = sc.nextLine();

            client.sendToServer(request);       //gửi data tới server
            
            response = client.recieveFromServer();   //nhận phản hồi từ server sau khi đã gửi data ở trên
            if(response.equalsIgnoreCase("quit")) {
                System.out.println("Server accept your wanting to quit!");
                break;
            }
            if(!response.equalsIgnoreCase("")) 
                System.out.println("Server: "+response);    //in ra kq vua nhan duoc
        }
        
        System.out.println("Disconnected to server!");
        client.disconnect();
    }
}