/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_vs_muiti_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */

public class ServerThread extends Thread {
    //chú ý: các client khác nhau đc phân biệt bởi thuộc tính socketOfServer, nghĩa là cứ có 1 đối tượng client mới kết nối thì sẽ tạo ra
    // 1 đói tượng ServerThread mới. Các đối tượng ServerThread này phân biệt nhau bởi socketOfServer
    Socket socketOfServer;
    BufferedWriter bw;
    BufferedReader br;
    String clientName;
    public static Hashtable<String, ServerThread> listUser = new Hashtable<>();
    //tham số thứ nhất là tên của client, chính là clientName
    //tham số thứ 2 là 1 đối tượng thuộc lớp này. Mỗi khi có 1 client tới yêu cầu kết nối với server thì server sẽ tạo 1 đối tượng mới có kiểu là ServerThread để xử lý riêng thằng client đó
    //do đó cần cho thằng ServerThread đó vào list để lúc nào muốn gửi tin tới bất kỳ thằng client khác hoặc gửi tin tới mọi client thì lấy thằng ServerThread trong listUser ra, và từ thằng ServerThread đó
    //ta lấy đc 2 tham số quan trọng là bw và br. bw để gửi data tới client và br để đọc data từ client gửi về
    //tuy nhiên ở package này thì chỉ làm việc gửi tin từ 1 socketOfServer tới 1 client thôi do đó ko cần thiết thêm ServerThread trong listUser
    //package khác sẽ gửi tin giữa các client với nhau và phải cần thằng này
    
    public static final String NICKNAME_NOT_VALID = "This nick name is already exist! please using another nickname";
    public static final String NICKNAME_VALID = "This nick name is OK";

    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
        this.bw = null;
        this.br = null;
    }
    
    
    public String recieveFromClient() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Client stop running");
            System.out.println("Ngắt kết nối với client "+clientName+"\n");
        }
        return null;
    }
    
    public void sendToClient(String response) {
        try {
            bw.write(response);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeServerThread() {
        try {
            br.close();
            bw.close();
            socketOfServer.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String displayAllUsers() {
        StringBuffer kq = new StringBuffer();
        String temp = null;
        System.out.println("online users:");
        
        Enumeration<String> keys = listUser.keys();
        if(keys.hasMoreElements()) {
            String str = keys.nextElement();
            System.out.println(str);
            kq.append(str);
        }
        
        while(keys.hasMoreElements()) {
            temp = keys.nextElement();
            System.out.println(temp);
            kq.append(", "+temp);
        }
        
        return kq.toString();
    }
    
    @Override
    public void run() {
        try {
            //tạo các luồng vào và ra với socket của client
            bw = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            boolean isUserExist = true; 
            
            //kiểm tra xem tên có hợp lệ ko:
            while(true) {
                clientName = recieveFromClient();   //đầu tiên server nhận lấy tên của client, nhưng ko phản hồi lại client
                isUserExist = listUser.containsKey(clientName);
                if(isUserExist) {
                    sendToClient(NICKNAME_NOT_VALID);
                }
                else {
                    sendToClient(NICKNAME_VALID);
                    break;
                }
            }
            
            //sau đó nếu tên hợp lệ thì cho nick đó vào Hashtable và chát với client:
            System.out.println("Client "+clientName+" is connecting to server");
            listUser.put(this.clientName, this);     //thêm tên của đối tượng này và thêm cả đối tượng này vào listUser
            String message="";
            
            while(true) {   //sau đó cứ chờ client gửi tin tới và phản hồi
                try {
                    message = recieveFromClient();
                
                    if(message.equalsIgnoreCase("quit")) {
                        System.out.println("Client "+clientName+" is disconnected!");
                        sendToClient("quit");
                        listUser.remove(clientName);
                        if(listUser.isEmpty()) System.out.println("Now there's no one is connecting to server\n");
                        break;
                    } else if(message.equalsIgnoreCase("online users")) {
                        sendToClient(displayAllUsers());
                    } else {
                        //gửi tin cho client:
                        sendToClient(message.toUpperCase());
                    }
                } catch (Exception e) {
                    listUser.remove(clientName);
                    if(listUser.isEmpty()) System.out.println("Now there's no one is connecting to server\n");
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeServerThread();
    }
}