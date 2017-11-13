/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_vs_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

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
    
    public static final String NICKNAME_NOT_VALID = "This nick name is already exist! Please using another nickname";
    public static final String NICKNAME_VALID = "This nick name is OK";

    public JTextArea taServer;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    StringTokenizer tokenizer;
    
    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
        this.bw = null;
        this.br = null;
    }
    
    
    public String recieveFromClient() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            //Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            this.taServer.append("\n["+sdf.format(new Date())+"] Client stop running");
            this.taServer.append("\n["+sdf.format(new Date())+"] Disconnect with client "+clientName+"\n");
        }
        return null;
    }
    
    public void sendToClient(String response) {
        try {
            bw.write(response);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendToAllClients(String response) {
        //nguyên tắc hoạt động: giả sử client A gửi tin tới server, và đang có các client B,C,D khác cũng đang kết nối tới server
        //đầu tiên server lấy socketOfClient trong listUser, socketOfClient lấy tương ứng với tên A
        //server sẽ lấy tên và message từ thằng client A, sau đó gửi bản tin có nột dung: "A: message" tới tất cả client khác thông
        //qua các socketOfServer của chúng
        //tóm lại server gửi bản tin "A: message" tới A,B,C,D thông qua 4 socket: socketOfServer của A, socketOfServer của B, socketOfServer của C, socketOfServer của D
        //các socketOfServer lưu trong listUser
        
        Enumeration<ServerThread> clients = listUser.elements();
        ServerThread st;
        BufferedWriter writer;
        BufferedReader reader;
        String name = this.clientName;  //tên client gửi tin tới
        
        while(clients.hasMoreElements()) {
            st = clients.nextElement();
            writer = st.bw;
            reader = st.br;

            try {
                writer.write(name+": "+response);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void notifyToAllUsers(String message) {
        Enumeration<ServerThread> clients = listUser.elements();
        ServerThread st;
        BufferedWriter writer;
        
        while(clients.hasMoreElements()) {
            st = clients.nextElement();
            writer = st.bw;

            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void closeServerThread() {
        try {
            br.close();
            bw.close();
            socketOfServer.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAllUsers() {
        StringBuffer kq = new StringBuffer();
        String temp = null;
        
        Enumeration<String> keys = listUser.keys();
        if(keys.hasMoreElements()) {
            String str = keys.nextElement();
            kq.append(str);
        }
        
        while(keys.hasMoreElements()) {
            temp = keys.nextElement();
            kq.append(","+temp);
        }
        
        return kq.toString();
    }
    
    public void clientQuit() {
        this.taServer.append("\n["+sdf.format(new Date())+"] Client "+clientName+" is disconnected!");
        listUser.remove(clientName);
        if(listUser.isEmpty()) this.taServer.append("\n["+sdf.format(new Date())+"] Now there's no one is connecting to server\n");
        notifyToAllUsers("CMD_ONLINE_USERS,"+getAllUsers());
        notifyToAllUsers(clientName+" has quitted");
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
            this.taServer.append("\n["+sdf.format(new Date())+"] Client "+clientName+" is connecting to server");
            listUser.put(this.clientName, this);     //thêm tên của đối tượng này và thêm cả đối tượng này vào listUser
            notifyToAllUsers("CMD_ONLINE_USERS,"+getAllUsers());
            notifyToAllUsers(clientName+" just has entered!");
            String message="";
            
            while(true) {   //sau đó cứ chờ client gửi tin tới và phản hồi
                try {
                    message = recieveFromClient();
                    tokenizer = new StringTokenizer(message);
                    String cmd = tokenizer.nextToken();
                    
                    switch (cmd) {
                        case "CMD_SENDFILE":
                            //handleCommandSendFile();
                            String sender = tokenizer.nextToken();
                            String receiver = tokenizer.nextToken();
                            String fileName = tokenizer.nextToken();
                            int fileSize = Integer.valueOf(tokenizer.nextToken());
                            
                            break;
                        case "CMD_ONLINE_USERS":
                            sendToClient("CMD_ONLINE_USERS,"+getAllUsers());
                            break;
                        default:
                            sendToAllClients(message);
                            break;
                    }
                    
                } catch (Exception e) {
                    clientQuit();
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeServerThread();
    }

    
}