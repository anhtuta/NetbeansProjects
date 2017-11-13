/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author AnhTu
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.ServerFrame;
import server.ServerThread;

/**
 *
 * @author AnhTu
 */
//CHÚ Ý: do chat = đồ họa nên ko cần vòng lặp while nữa
//nếu chat trên console thì phải dùng while để chờ server (hoặc client) gửi tin sau đó client hiển thị (hoặc server gửi lại)
//bây giờ client gửi tin tới server sau khi ấn nút send, do đó ko cần while nữa

public class ClientFrame extends JFrame implements Runnable {
    String serverHost = "localhost";
    
    String name;
    Socket socketOfClient;
    BufferedWriter bw;
    BufferedReader br;
    
    JPanel mainPanel;
    LoginPanel loginPanel;
    ClientPanel clientPanel;
    
    Thread clientThread;
    boolean isRunning;
    
    JMenuBar menuBar;
    JMenu menuShareFile;
    JMenuItem itemSendFile;
    SendFileFrame sendFileFrame;
    
    StringTokenizer tokenizer;
    
    Socket socketOfSender, socketOfReceiver;
    
    String myDownloadFolder;
    
    DefaultListModel<String> listModel;
            
    public ClientFrame(String name) {
        this.name = name;
        socketOfClient = null;
        bw = null;
        br = null;
        isRunning = true;
        listModel = new DefaultListModel<>();
        
        mainPanel = new JPanel();
        loginPanel = new LoginPanel();
        clientPanel = new ClientPanel();
        
        mainPanel.setSize(570, 450);
        loginPanel.setVisible(true);
        clientPanel.setVisible(false);
        
        mainPanel.add(clientPanel);
        mainPanel.add(loginPanel);
        loginPanel.getTfNickname().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) btOkEvent();
            }
            
        });
        loginPanel.getBtOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btOkEvent();
            }
        });
        
        clientPanel.getBtSend().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btSendEvent();
            }
        });
        clientPanel.getBtClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btClearEvent();
            }
        });
        clientPanel.getBtExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btExitEvent();
            }
        });
        clientPanel.getTaInput().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    btSendEvent();
                    btClearEvent();
                }
            }
        });
        
        
        menuBar = new JMenuBar();   //menuBar
        menuShareFile = new JMenu();    //menu, cái này là item của menuBar
        itemSendFile = new JMenuItem();     //menuItem: cái này là item của menu
        
        menuShareFile.setText("File sharing");
        itemSendFile.setText("Send a file");
        menuShareFile.add(itemSendFile);
        menuBar.add(menuShareFile);
        
        itemSendFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                openSendFileFrame();
            }
        });
        menuBar.setVisible(false);
        
        setJMenuBar(menuBar);
        pack();
        add(mainPanel);
        setSize(570, 520);
        setLocation(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(name);
    }
    
    ////////////////////////Events////////////////////////////
    private void btOkEvent() {
        String hostname = loginPanel.getTfHost().getText().trim();
        String nickname = loginPanel.getTfNickname().getText().trim();
        serverHost = hostname;
        
        if(hostname.equals("") || nickname.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill up all fields", "Notice!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.connectToServer(hostname);     //tạo 1 socket kết nối tói server
        this.name = nickname;
        
        this.sendToServer("CMD_CHECK_NAME|" +this.name);       //sau đó gửi tên đến để yêu cầu đăng nhập =  tên đó
        
        //server phản hồi rằng tên vừa nhập có hợp lệ hay ko:
        String response = this.recieveFromServer();
        if(response != null) {
        if (response.equals(ServerThread.NICKNAME_NOT_VALID)) {
            JOptionPane.showMessageDialog(this, response, "Error", JOptionPane.ERROR_MESSAGE);
            
        } else {
            //Tên hợp lệ, vào phòng chat:
            loginPanel.setVisible(false);
            clientPanel.setVisible(true);
            this.setTitle(this.name);
            
            menuBar.setVisible(true);
            
            //1 thread của client đc tạo ra để giao tiếp với server, chú ý rằng nhiệm vụ của thread này chỉ chờ server gửi tin tới
            //và in kq lên textarea, còn việc gửi tin tới server dùng sự kiện của btSend
            clientThread = new Thread(this);
            clientThread.start();
            
            System.out.println("this is \""+name+"\"");
        }
        } else System.out.println("[btOkEvent()] Server is not open yet, or already closed!");
    }
    
    private void btSendEvent() {
        String message = clientPanel.getTaInput().getText().trim();
        if(message.equals("")) clientPanel.getTaInput().setText("");
        else {
            this.sendToServer("CMD_CHAT|" + message);       //gửi data tới server
            this.btClearEvent();
        }
        //chú ý rằng việc chờ server phản hồi thực hiện trong hàm run của thread chứ ko phải ở đây
    }

    private void btClearEvent() {
        clientPanel.getTaInput().setText("");
    }

    private void btExitEvent() {
        try {
            isRunning = false;
            clientThread.stop();
            //this.disconnect();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void openSendFileFrame() {
        sendFileFrame = new SendFileFrame();
        
        //gửi tất cả thông tin của client này sang frame đó:
        sendFileFrame.name = this.name;
        sendFileFrame.socketOfClient = this.socketOfClient;
        sendFileFrame.bw = this.bw;
        sendFileFrame.br = this.br;
        
        sendFileFrame.setVisible(true);
        sendFileFrame.setLocation(450, 250);
        sendFileFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    ////////////////////////End of Events////////////////////////////   
    
    public void connectToServer(String hostAddress) {
        try {
            socketOfClient = new Socket(hostAddress, 9999);
            bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            
        } catch (java.net.UnknownHostException e) {
            JOptionPane.showMessageDialog(this, "Host IP is not correct.\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch (java.net.ConnectException e) {
            JOptionPane.showMessageDialog(this, "Server is unreachable, maybe server is not open yet, or can't find this host.\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch(java.net.NoRouteToHostException e) {
            JOptionPane.showMessageDialog(this, "Can't find this host!\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void sendToServer(String line) {
        try {
            this.bw.write(line);
            this.bw.newLine();   //phải có newLine thì mới dùng đc hàm readLine()
            this.bw.flush();
        } catch (java.net.SocketException e) {
            JOptionPane.showMessageDialog(this, "Server is close, can't send message!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NullPointerException e) {
            System.out.println("[sendToServer()] Server is not open yet, or already closed!");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieveFromServer() {
        try {
            return this.br.readLine();  //chú ý rằng chỉ nhận 1 dòng từ server gửi về thôi, nếu server gửi nhiều dòng thì các dòng sau ko đọc
        } catch (java.lang.NullPointerException e) {
            System.out.println("[recieveFromServer()] Server is not open yet, or already closed!");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void disconnect() {
        System.out.println("disconnect()");
        try {
            this.br.close();
            this.bw.close();
            this.socketOfClient.close();
            System.out.println("trong khoi try catch");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClientFrame client = new ClientFrame(null);
        client.setVisible(true);
    }

    @Override
    public void run() {
        String response;
        String sender, receiver, fileName;
        StringBuffer str;
        StringBuffer msg;
        
        StringTokenizer token2;
        
        while(isRunning) {
            response = this.recieveFromServer();   //nhận phản hồi từ server sau khi đã gửi data ở trên
            tokenizer = new StringTokenizer(response, "|");
            String cmd = tokenizer.nextToken();
            switch (cmd) {
                case "CMD_CHAT":    //giả sử nhận được gói tin: CMD_CHAT|anh tu: today is very cool!
                    str = new StringBuffer(response);
                    str = str.delete(0, 9);     //str = "anh tu: today is very cool!"
                    
                    token2 = new StringTokenizer(str.toString(), ":");
                    sender = token2.nextToken();    //sender = anh tu
                    
                    str = str.delete(0, sender.length()+1);     //xóa cả dấu 2 chấm đằng sau tên sender
                    msg = new StringBuffer();
                    msg = str;  //msg = " today is very cool!"
                    
                    if(sender.equals(this.name)) this.clientPanel.appendMessage(sender+": ", msg.toString(), Color.BLACK, new Color(0, 102, 204));
                    else this.clientPanel.appendMessage(sender+": ", msg.toString(), Color.MAGENTA, new Color(56, 224, 0));

                    //phải lằng nhằng như trên vì tránh trường hợp tin nhắn có ký tự |, nếu cứ dùng StringTokenizer và lấy ký tự '|' làm cái phân chia thì tin nhắn ko thể hiển thị kí tự | đc
                    break;
                    
                case "CMD_ONLINE_USERS":
                    listModel.clear();
                    
                    while(tokenizer.hasMoreTokens()) {
                        cmd = tokenizer.nextToken();
                        listModel.addElement(cmd);
                    }
                    clientPanel.getOnlineList().setModel(listModel);
                    break;
                    
                case "CMD_SENDFILE_REQUEST":
                    
                    sender = tokenizer.nextToken();
                    receiver = tokenizer.nextToken();
                    fileName = tokenizer.nextToken();
                    
                    int choose = JOptionPane.showConfirmDialog(this, "\""+sender+"\" want to send a file to you\nFile name: "+fileName+"\nDo you want to accept?", "Notice", JOptionPane.YES_NO_OPTION);
                    if(choose == JOptionPane.YES_OPTION) {
                        JFileChooser chooser = new JFileChooser();
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        int kq = chooser.showSaveDialog(this);
                        if(kq == JFileChooser.APPROVE_OPTION) {
                            myDownloadFolder = chooser.getSelectedFile().getAbsolutePath();
                        } else {
                            myDownloadFolder = "D:";
                            JOptionPane.showMessageDialog(this, "The default folder to save file is in D:\\", "Notice", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        try {
                            socketOfReceiver = new Socket(serverHost, 9999);    //tạo mới 1 socket để nhận file, xong việc thì nó TỰ ĐỘNG CLOSE
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketOfReceiver.getOutputStream()));
                            writer.write("CMD_SENDFILE_I_AM_THE_RECEIVER|"+this.name);
                            writer.newLine();   //phải có newLine thì mới dùng đc hàm readLine()
                            writer.flush();
                            
                            new ReceivingFileThread(socketOfReceiver, myDownloadFolder, fileName).start();    //socketOfClient chính là thằng nhận file
                            System.out.println("start receiving file");
                        } catch (IOException ex) {
                            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        sendToServer("CMD_SENDFILE_ACCEPT|"+sender+"|"+receiver);
                    } else {
                        sendToServer("CMD_SENDFILE_DENY|"+sender+"|"+receiver);
                    }
                    break;
                    
                case "CMD_RECEIVER_NOT_EXIST":
                    JOptionPane.showMessageDialog(sendFileFrame, "The receiver's name is wrong", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                    
                case "CMD_SENDFILE_DENY":
                    sender = tokenizer.nextToken();
                    receiver = tokenizer.nextToken();
                    JOptionPane.showMessageDialog(sendFileFrame, "\""+receiver+"\" don't want to receive your file!", "Send failed!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                case "CMD_SENDFILE_ACCEPT":     //khi server báo rằng bên nhận đồng ý nhận file
                    //now we send file to server:
                    String filePath = sendFileFrame.getTfFilePath().getText();
                    receiver = sendFileFrame.getTfReceiver().getText();
                
                    try {
                        socketOfSender = new Socket(serverHost, 9999);     //tạo 1 socket mới nối với server để thực hiện gửi file, socket này gửi file tới server để nó gửi cho reveiver. Xong việc thì socket này TỰ ĐỘNG CLOSE
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketOfSender.getOutputStream()));
                        writer.write("CMD_SENDFILE_I_AM_SENDER|"+this.name);
                        writer.newLine();
                        writer.flush();
                        
                        new SendingFileThread(this.name, receiver, filePath, socketOfSender, sendFileFrame, null).start();    //socketOfSender chính là thằng gửi file
                        System.out.println("start sending file");
                    } catch (IOException ex) {
                        Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                    
                default:
                    if(!response.startsWith("CMD_")) {      //trường hợp response chỉ là 1 tin nhắn thông thường
                        this.clientPanel.appendMessage(response, new Color(153, 153, 153));
                    }
                    //do bên server có hàm notifyToAllUsers(clientName+" has just entered!"); 
                    //hàm trên ko có định dạng nào cả, tức là ko có CMD_ ở đầu message, nên ta chỉ cần in ra thông điệp server gửi tới là đc
                    
            }
        }
        System.out.println("Disconnected to server!");
    }
}