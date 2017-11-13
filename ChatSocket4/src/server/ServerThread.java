/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
//chú ý: gửi file thì vẫn ko gửi đc file .pdf, chỉ gửi đc file .txt, file ảnh. KO thiể hiểu nổi tại sao!
//thread này tạo 1 socket để giao tiếp với 1 client, cứ coi như 1 client và server chỉ có 1 socket duy nhất nối chúng với nhau
//do đó server muốn giao tiếp với client nào thì cần có socket nối giữa nó và client đó
public class ServerThread extends Thread {
    //chú ý: các client khác nhau đc phân biệt bởi thuộc tính socketOfServer, nghĩa là cứ có 1 đối tượng client mới kết nối thì sẽ tạo ra
    // 1 đói tượng ServerThread mới. Các đối tượng ServerThread này phân biệt nhau bởi socketOfServer
    Socket socketOfServer;      //socket để nối với socket của client kết nối tới
    BufferedWriter bw;
    BufferedReader br;
    String clientName, clientPass, clientRoom;
    public static Hashtable<String, ServerThread> listUser = new Hashtable<>();
    //tham số thứ nhất là tên của client, chính là clientName
    //tham số thứ 2 là 1 đối tượng thuộc lớp này. Mỗi khi có 1 client tới yêu cầu kết nối với server thì server sẽ tạo 1 đối tượng mới có kiểu là ServerThread để xử lý riêng thằng client đó
    //do đó cần cho thằng ServerThread đó vào list để lúc nào muốn gửi tin tới bất kỳ thằng client khác hoặc gửi tin tới mọi client thì lấy thằng ServerThread trong listUser ra, và từ thằng ServerThread đó
    //ta lấy đc 2 tham số quan trọng là bw và br. bw để gửi data tới client và br để đọc data từ client gửi về
    
    public static final String NICKNAME_EXIST = "This nickname is already login in another place! Please using another nickname";
    public static final String NICKNAME_VALID = "This nickname is OK";
    public static final String NICKNAME_INVALID = "Nickname or password is incorrect";
    public static final String SIGNUP_SUCCESS = "Sign up successful!";
    public static final String ACCOUNT_EXIST = "This nickname has been used! Please use another nickname!";
    
    public JTextArea taServer;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    StringTokenizer tokenizer;
    private final int BUFFER_SIZE = 1024;
    
    String senderName, receiverName;    //Tên 2 thằng gửi và nhận file
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
    
    UserDatabase userDB;
    
    static boolean isBusy = false;     //dùng để kiểm tra xem server có đang gửi và nhận file hay ko
    
    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
        this.bw = null;
        this.br = null;
        
        clientName = "";
        clientPass = "";
        clientRoom = "";
        
        userDB = new UserDatabase();
        userDB.connect();
    }
    
    public void appendMessage(String message) {
        taServer.append(message);
        taServer.setCaretPosition(taServer.getText().length() - 1);     //thiết lập vị trí con trỏ ngay sau đoạn text vừa chèn vào
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
    
    public void notifyToAllUsers(String message) {
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
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void notifyToUsersInRoom(String message) {
        Enumeration<ServerThread> clients = listUser.elements();
        ServerThread st;
        BufferedWriter writer;
        
        while(clients.hasMoreElements()) {
            st = clients.nextElement();
            if(st.clientRoom.equals(this.clientRoom)) {     //gửi tin cho những thằng (st.clientRoom) có room trùng với room của thằng gửi tin (this.clientRoom)
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
    }
    
    public void notifyToUsersInRoom(String room, String message) {      //gửi bản tin message tới phòng room
        Enumeration<ServerThread> clients = listUser.elements();
        ServerThread st;
        BufferedWriter writer;
        
        while(clients.hasMoreElements()) {
            st = clients.nextElement();
            if(st.clientRoom.equals(room)) {
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
    
    public String getUsersThisRoom() {
        StringBuffer kq = new StringBuffer();
        String temp = null;
        ServerThread st;
        Enumeration<String> keys = listUser.keys();
        
        while(keys.hasMoreElements()) {
            temp = keys.nextElement();
            st = listUser.get(temp);
            if(st.clientRoom.equals(this.clientRoom))  kq.append("|").append(temp);
        }
        
        if(kq.equals("")) return "|";
        return kq.toString();   //Chú ý kq bắt đầu bằng '|' nhé, ví dụ: kq = "|anh tu|huy|toan|nguyen"
    }
    
    public String getUsersAtRoom(String room) {
        StringBuffer kq = new StringBuffer();
        String temp = null;
        ServerThread st;
        Enumeration<String> keys = listUser.keys();
        
        while(keys.hasMoreElements()) {
            temp = keys.nextElement();
            st = listUser.get(temp);
            if(st.clientRoom.equals(room))  kq.append("|").append(temp);
        }
        
        if(kq.equals("")) return "|";
        return kq.toString();   //Chú ý kq bắt đầu bằng '|' nhé, ví dụ: kq = "|anh tu|huy|toan|nguyen"
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
            notifyToUsersInRoom("CMD_ONLINE_THIS_ROOM"+getUsersThisRoom());
            notifyToUsersInRoom(clientName+" has quitted");
        }
    }
    
    public void changeUserRoom() {      //cập nhật lại room cho chính đối tượng thuộc class này trong listUser
        ServerThread st = listUser.get(this.clientName);
        st.clientRoom = this.clientRoom;
        listUser.put(this.clientName, st);    //st chính là đối tượng serverThread gắn với client yêu cầu thay đổi room
        
        /*
        Để ý rằng đối tượng gắn với client yêu cầu thay đổi room chính là đối tượng thuộc lớp này, do đó chỉ cần 1 lệnh sau cũng 
        đủ để thay thế 3 lệnh trên:
        listUser.put(clientName, this);     //tham số thứ 2 là this, gắn với client muốn đổi room, và nó cũng thay đổi room rồi, do đó
        lệnh này update value có key=clientName trong hashtable đó thôi
        */
    }
    
    public void removeUserRoom() {
        ServerThread st = listUser.get(this.clientName);
        st.clientRoom = this.clientRoom;
        listUser.put(this.clientName, st);
        //  Tương tự hàm trên, chỉ cần 1 lệnh này là đủ: listUser.put(clientName, this);
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
            String cmd, icon;
            while(true) {   //cứ chờ client gửi tin tới và phản hồi
                try {
                    message = recieveFromClient();
                    tokenizer = new StringTokenizer(message, "|");
                    cmd = tokenizer.nextToken();
                    
                    switch (cmd) {
                        case "CMD_CHAT":
                            str = new StringBuffer(message);
                            str = str.delete(0, 9);
                            notifyToUsersInRoom("CMD_CHAT|" + this.clientName+"|"+str.toString());    //this.clientName = tên client gửi tin tới
                            break;
                            
                        case "CMD_PRIVATECHAT":
                            String privateSender = tokenizer.nextToken();
                            String privateReceiver = tokenizer.nextToken();
                            String messageContent = message.substring(cmd.length()+privateSender.length()+privateReceiver.length()+3, message.length());
                            
                            //ServerThread st_sender = listUser.get(privateSender);
                            ServerThread st_receiver = listUser.get(privateReceiver);
                            //sendToSpecificClient(st_sender, "CMD_PRIVATECHAT|" + privateSender + "|" + messageContent);
                            sendToSpecificClient(st_receiver, "CMD_PRIVATECHAT|" + privateSender + "|" + messageContent);
                            
                            System.out.println("[ServerThread] message = "+messageContent);
                            break;
                            
                        case "CMD_ROOM":
                            clientRoom = tokenizer.nextToken();
                            changeUserRoom();
                            notifyToAllUsers("CMD_ONLINE_USERS|"+getAllUsers());
                            notifyToUsersInRoom("CMD_ONLINE_THIS_ROOM"+getUsersThisRoom());
                            notifyToUsersInRoom(clientName+" has just entered!");
                            break;
                            
                        case "CMD_LEAVE_ROOM":
                            String room = clientRoom;
                            clientRoom = "";    //nếu cho clientRoom = null thì bị lỗi!
                            removeUserRoom();
                            notifyToUsersInRoom(room, "CMD_ONLINE_THIS_ROOM"+getUsersAtRoom(room));
                            notifyToUsersInRoom(room, clientName+" has just leaved this room!");      //chú ý phải dùng lệnh này trước lệnh clientRoom = ""; vì nếu clientRoom = "" thì biết room nào mà gửi tin :v 
                            
                            break;
                            
                        case "CMD_CHECK_NAME":
                            clientName = tokenizer.nextToken();
                            clientPass = tokenizer.nextToken();
                            isUserExist = listUser.containsKey(clientName);
                            
                            if(isUserExist) {  //nickname is exist, nghĩa là đang có người khác đăng nhập với nick đó rồi
                                sendToClient(NICKNAME_EXIST);
                            }
                            else {  //nickname vẫn chưa có ai đăng nhập
                                int kq = userDB.checkUser(clientName, clientPass);
                                if(kq == 1) {
                                    sendToClient(NICKNAME_VALID);
                                    //sau đó nếu tên hợp lệ thì cho nick đó vào Hashtable và chát với client:
                                    this.appendMessage("\n["+sdf.format(new Date())+"] Client \""+clientName+"\" is connecting to server");
                                    listUser.put(clientName, this);     //thêm tên của đối tượng này và thêm cả đối tượng này vào listUser
                                } else sendToClient(NICKNAME_INVALID);
                            }
                            break;
                            
                        case "CMD_SIGN_UP":
                            String name = tokenizer.nextToken();
                            String pass = tokenizer.nextToken();
                            System.out.println("name, pass = "+name+" - "+pass);
                            isUserExist = listUser.containsKey(name);
                            
                            if(isUserExist) {
                                sendToClient(NICKNAME_EXIST);
                            } else {
                                int kq = userDB.insertUser(new User(name, pass));
                                if(kq > 0) {
                                    sendToClient(SIGNUP_SUCCESS);
                                } else sendToClient(ACCOUNT_EXIST);
                            }
                            break;
                            
                        case "CMD_ONLINE_USERS":
                            sendToClient("CMD_ONLINE_USERS|"+getAllUsers());
                            notifyToUsersInRoom("CMD_ONLINE_THIS_ROOM"+getUsersThisRoom());
                            break;
                        
                        case "CMD_SENDFILETOSERVER":    //the sender sends a file to server:
                            sender = tokenizer.nextToken();
                            receiver = tokenizer.nextToken();
                            fileName = tokenizer.nextToken();
                            int len = Integer.valueOf(tokenizer.nextToken());
                            
                            String path = System.getProperty("user.dir") + "\\sendfile\\" +fileName;
                            
                            //InputStream bis = socketOfServer.getInputStream();
                            //OutputStream os = receiverSocket.getOutputStream();    //luồng ra là tới thằng receiver
                            //BufferedInputStream bis = new BufferedInputStream(socketOfServer.getInputStream());
                            //BufferedOutputStream bos = new BufferedOutputStream(fos);
                            //OutputStream fos = new FileOutputStream(path);
                            //BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(path));
                            //BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));

                            BufferedInputStream bis = new BufferedInputStream(socketOfServer.getInputStream());   //lấy luồng vào là từ sender
                            FileOutputStream fos = new FileOutputStream(path);   //luồng ra là tới file sẽ lưu ở ổ cứng của server
                            
                            byte[] buffer = new byte[BUFFER_SIZE];
                            int count = -1;
                            while((count = bis.read(buffer)) > 0) {  //is đọc được bao nhiêu từ sender sẽ lưu tạm vào mảng buffer
                                fos.write(buffer, 0, count);         //và sau đó os lấy buffer gửi cho receiver
                            }

                            Thread.sleep(300);
                            bis.close();
                            fos.close();
                            socketOfServer.close();
                            
                            ///thông báo cho sender và receiver rằng file vừa gửi lên rồi, sau đó họ muốn tải xuống thì là việc của họ:
                            ServerThread stSender = listUser.get(sender);       //chú ý rằng stSender ko phải là socketOfServer ở trên nhé, 
                            //vì socketOfServer là 1 socket kết nối với 1 socket tạm thời của sender. Cái socket tạm thời đó đc tạo ra khi sender muốn
                            //gửi 1 file tới server, và sau khi gửi xong file, socket tạm thời đó biến mất 
                            ServerThread stReceiver = listUser.get(receiver);
                            
                            sendToSpecificClient(stSender, "CMD_FILEAVAILABLE|"+fileName+"|"+receiver+"|"+sender);
                            sendToSpecificClient(stReceiver, "CMD_FILEAVAILABLE|"+fileName+"|"+sender+"|"+sender);
                            
                            isBusy = false;
                            break;
                            
                        case "CMD_DOWNLOADFILE":    //server sends file to someone who just pressed download file
                            fileName = tokenizer.nextToken();
                            path = System.getProperty("user.dir") + "\\sendfile\\" + fileName;
                            FileInputStream fis = new FileInputStream(path);
                            BufferedOutputStream bos = new BufferedOutputStream(socketOfServer.getOutputStream());
                            
                            byte []buffer2 = new byte[BUFFER_SIZE];
                            int count2=0;
                            
                            while((count2 = fis.read(buffer2)) > 0) {
                                bos.write(buffer2, 0, count2);    //liên tục gửi từng phần của file tới server
                            }

                            bos.close();
                            fis.close();
                            socketOfServer.close();
                            
                            break;
                            
                        case "CMD_ICON":
                            icon = tokenizer.nextToken();
                            notifyToUsersInRoom("CMD_ICON|"+icon+"|"+this.clientName);
                            break;
                            
                        default:
                            notifyToAllUsers(message);
                            break;
                    }
                    
                } catch (Exception e) {
                    clientQuit();
                    break;
                }
            }
        } catch (IOException ex) {
            clientQuit();
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.closeServerThread();
    }
}