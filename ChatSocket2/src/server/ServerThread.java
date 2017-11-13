/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

//thread này tạo 1 socket để giao tiếp với 1 client, cứ coi như 1 client và server chỉ có 1 socket duy nhất nối chúng với nhau
//do đó server muốn giao tiếp với client nào thì cần có socket nối giữa nó và client đó
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
    private final int BUFFER_SIZE = 100;
    
    String senderName, receiverName;
    static Socket senderSocket, receiverSocket;     //tạm thời chỉ nhận và gửi file trên 2 client
    /*
    Chú ý: có 3 loại socket của server:
    - 1 loại đc tạo ra khi có 1 client tới kết nối bình thường, lúc này thuộc tính socketOfServer của class này đc khởi tạo, còn 2 thuộc tính senderSocket = receiverSocket = null
    - 1 loại đc tạo ra khi client sender tạo 1 socket mới tới server, lúc này thuộc tính socketOfServer của class này cũng đc khởi tạo. nhưng thuộc tính senderSocket cũng đc khởi tạo và receiverSocket = null
    - 1 loại đc tạo ra khi client receiver tạo 1 socket mới tới server, lúc này thuộc tính socketOfServer của class này cũng đc khởi tạo. nhưng thuộc tính receiverSocket cũng đc khởi tạo và senderSocket = null
    
    do đó 2 thuộc tính senderSocket và receiverSocket phải static để với mọi đối tượng đc tạo ra 2 thằng này ko đổi
    Nếu chúng ko phải static, giả sử socket của sender tới, 1 đối tượng của lớp này tạo ra và có senderSocket = socket của thằng gửi, nhưng receiverSocket=null, nghĩa là socket của thằng nhận ko có, do đó file chả ko đc đi đâu cả
    Tương tự, bên receiver có receiverSocket !=null, do đó nó ko biết nguồn gừi là ai
    */
    
    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
        this.bw = null;
        this.br = null;
    }
    
    public void appendMessage(String message) {
        taServer.append(message);
        taServer.setCaretPosition(taServer.getText().length() - 1);
    }
    
    public String recieveFromClient() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            System.out.println(clientName+" is disconnected!");
        }
        return null;
    }
    
    public void sendToClient(String response) {     //chỉ gửi tin tới client gắn kết với thread này
        try {
            bw.write(response);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendToSpecificClient(ServerThread socketOfClient, String response) {     //chỉ gửi tin tới client cụ thể nào đó
        try {
            BufferedWriter writer = socketOfClient.bw;
            writer.write(response);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendToSpecificClient(Socket socket, String response) {     //chỉ gửi tin tới client cụ thể nào đó
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(response);
            writer.newLine();
            writer.flush();
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
        
        while(clients.hasMoreElements()) {
            st = clients.nextElement();
            writer = st.bw;

            try {
                writer.write(response);
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
            kq.append("|").append(temp);
        }
        
        return kq.toString();
    }
    
    public void clientQuit() {
        //khi gửi file, ta sẽ tạo 1 socket mới để gửi file, và khi gửi xong socket đó tự động close
        //do socket đó ta tạo ra ko có tên của client nên socket_đó.clientName == null, do đó ko cần in
        //thông tin socket_đó close ra màn hình
        if(clientName != null) {
            this.appendMessage("\n["+sdf.format(new Date())+"] Client \""+clientName+"\" is disconnected!");
            listUser.remove(clientName);
            if(listUser.isEmpty()) this.appendMessage("\n["+sdf.format(new Date())+"] Now there's no one is connecting to server\n");
            notifyToAllUsers("CMD_ONLINE_USERS|"+getAllUsers());
            notifyToAllUsers(clientName+" has quitted");
        }
    }
    
    @Override
    public void run() {
        try {
            //tạo các luồng vào và ra với socket của client
            bw = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            
            boolean isUserExist = true;
            String message, sender, receiver, fileName;
            StringBuffer str;
            
            while(true) {   //cứ chờ client gửi tin tới và phản hồi
                try {
                    message = recieveFromClient();
                    tokenizer = new StringTokenizer(message, "|");
                    String cmd = tokenizer.nextToken();
                    
                    switch (cmd) {
                        case "CMD_CHAT":
                            str = new StringBuffer(message);
                            str = str.delete(0, 9);
                            sendToAllClients("CMD_CHAT|" + this.clientName+": "+str.toString());    //this.clientName = tên client gửi tin tới
                            break;
                            
                        case "CMD_CHECK_NAME":
                            clientName = tokenizer.nextToken();
                            isUserExist = listUser.containsKey(clientName);
                            if(isUserExist) {  //nickname is not valid
                                sendToClient(NICKNAME_NOT_VALID);
                            }
                            else {  //nickname is valid
                                sendToClient(NICKNAME_VALID);
                                //sau đó nếu tên hợp lệ thì cho nick đó vào Hashtable và chát với client:
                                this.appendMessage("\n["+sdf.format(new Date())+"] Client \""+clientName+"\" is connecting to server");
                                listUser.put(this.clientName, this);     //thêm tên của đối tượng này và thêm cả đối tượng này vào listUser
                                notifyToAllUsers("CMD_ONLINE_USERS|"+getAllUsers());
                                notifyToAllUsers(clientName+" has just entered!");
                            }
                            break;
                            
                        case "CMD_ONLINE_USERS":
                            sendToClient("CMD_ONLINE_USERS|"+getAllUsers());
                            break;
                        
                        case "CMD_SENDFILE_REQUEST":    //gửi bản tin request tới receiver:
                            sender = tokenizer.nextToken();
                            receiver = tokenizer.nextToken();
                            fileName = tokenizer.nextToken();
                            
                            ServerThread threadOfReceiver = listUser.get(receiver);
                            if(threadOfReceiver != null) {
                                sendToSpecificClient(threadOfReceiver, "CMD_SENDFILE_REQUEST|"+sender+"|"+receiver+"|"+fileName);
                            } else {
                                //
                                //JOptionPane.showMessageDialog(null, "The receiver is not exist, please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                                sendToClient("CMD_RECEIVER_NOT_EXIST|There's no receiver named "+receiver);     //gửi lại bản tin cho thằng định gửi file, báo rằng ko có người nhận nào tên như vậy!
                            }
                            
                            break;
                        
                        case "CMD_SENDFILE_DENY":   //gửi bản tin báo cho sender rằng thằng receiver ko muốn nhận file:
                            sender = tokenizer.nextToken();
                            receiver = tokenizer.nextToken();
                            
                            ServerThread threadOfSender = listUser.get(sender);
                            sendToSpecificClient(threadOfSender, "CMD_SENDFILE_DENY|"+sender+"|"+receiver);
                            break;
                            
                        case "CMD_SENDFILE_I_AM_SENDER":
                            senderSocket = this.socketOfServer;
                            System.out.println("(server) CMD_SENDFILE_I_AM_SENDER");
                            senderName = tokenizer.nextToken();
                            break;
                            
                        case "CMD_SENDFILE_I_AM_THE_RECEIVER":
                            receiverSocket = this.socketOfServer;   //lưu socket gửi gói tin này là socket của thằng receiver
                            System.out.println("(server) CMD_SENDFILE_I_AM_THE_RECEIVER");
                            receiverName = tokenizer.nextToken();   //hiện tại chưa quan tâm tới tên thằng receiver
                            break;
                            
                        case "CMD_SENDFILE_ACCEPT":   //gửi bản tin báo cho sender rằng thằng receiver muốn nhận file:
                            sender = tokenizer.nextToken();
                            receiver = tokenizer.nextToken();
                            
                            threadOfSender = listUser.get(sender);
                            sendToSpecificClient(threadOfSender, "CMD_SENDFILE_ACCEPT|"+sender+"|"+receiver);
                            break;
                            
                        case "CMD_SENDFILETOSERVER":    //the sender sends a file to server:
                            System.out.println("(server) message = "+message);
                            sender = tokenizer.nextToken();
                            receiver = tokenizer.nextToken();
                            fileName = tokenizer.nextToken();
                            int len = Integer.valueOf(tokenizer.nextToken());
                            
                            //thông báo cho receiver trước để chuẩn bị nhận file từ server
                            //sendToSpecificClient(threadOfReceiver, "CMD_SENDFILETOCLIENT "+sender+" "+receiver+" "+fileName);
                            sendToSpecificClient(receiverSocket, "CMD_SENDFILETOCLIENT|"+sender+"|"+receiver+"|"+fileName);
                            System.out.println("CMD_SENDFILETOCLIENT|"+sender+"|"+receiver+"|"+fileName);

                            //server liên tục gửi các phần của file sau khi nhận đc từ sender tới receiver:
                            InputStream is = senderSocket.getInputStream();   //lấy luồng vào là từ sender
                            OutputStream os = receiverSocket.getOutputStream();    //luồng ra là tới thằng receiver

                            byte[] buffer = new byte[BUFFER_SIZE];
                            int count;
                            while((count = is.read(buffer)) > 0) {  //is đọc được bao nhiêu từ sender sẽ lưu tạm vào mảng buffer
                                os.write(buffer, 0, count);         //và sau đó os lấy buffer gửi cho receiver
                            }

                            os.flush();
                            os.close();
                            is.close();
                            
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
        //this.closeServerThread();
    }
}