/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_vs_client;

/**
 *
 * @author AnhTu
 */

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
//CHÚ Ý: do chat = đồ họa nên ko cần vòng lặp while nữa
//nếu chat trên console thì phải dùng while để chờ server (hoặc client) gửi tin sau đó client hiển thị (hoặc server gửi lại)
//bây giờ client gửi tin tới server sau khi ấn nút send, do đó ko cần while nữa

public class ClientFrame extends JFrame implements Runnable {
    final String serverHost = "localhost";
    
    String name;
    Socket socketOfClient;
    BufferedWriter bw;
    BufferedReader br;
    
    JPanel mainPanel;
    LoginPanel loginPanel;
    ClientPanel clientPanel;
    
    Thread clientThread;
    boolean isRunning;
    
    
    public ClientFrame(String name) {
        this.name = name;
        socketOfClient = null;
        bw = null;
        br = null;
        isRunning = true;
        
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
        
        if(hostname.equals("") || nickname.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill up all fields", "Notice!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.connectToServer(hostname);     //tạo 1 socket kết nối tói server
        this.name = nickname;
        
        this.sendToServer(this.name);       //sau đó gửi tên đến để yêu cầu đăng nhập =  tên đó
        
        //server phản hồi rằng tên vừa nhập có hợp lệ hay ko:
        String response = this.recieveFromServer();
        if (response.equals(ServerThread.NICKNAME_NOT_VALID)) {
            JOptionPane.showMessageDialog(this, response, "Error", JOptionPane.ERROR_MESSAGE);
            
        } else {
            //Tên hợp lệ, vào phòng chat:
            loginPanel.setVisible(false);
            clientPanel.setVisible(true);
            this.setTitle(this.name);
            
            
            //1 thread của client đc tạo ra để giao tiếp với server, chú ý rằng nhiệm vụ của thread này chỉ chờ server gửi tin tới
            //và in kq lên textarea, còn việc gửi tin tới server dùng sự kiện của btSend
            clientThread = new Thread(this);
            clientThread.start();
        }
    }
    
    private void btSendEvent() {
        String message = clientPanel.getTaInput().getText().trim();
        this.sendToServer(message);       //gửi data tới server
        this.btClearEvent();
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
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieveFromServer() {
        try {
            return this.br.readLine();  //chú ý rằng chỉ nhận 1 dòng từ server gửi về thôi, nếu server gửi nhiều dòng thì các dòng sau ko đọc
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
        ClientFrame client = new ClientFrame(null);
        client.setVisible(true);
    }

    @Override
    public void run() {
        String response;
        
        while(isRunning) {
            response = this.recieveFromServer();   //nhận phản hồi từ server sau khi đã gửi data ở trên
            if(response.startsWith("CMD_ONLINE_USERS")) {    //chỉ hiển thị ds các người đang online lên taOnline, chứ ko hiển thị lên taMessage:
                clientPanel.getTaOnline().setText("");
                StringTokenizer users = new StringTokenizer(response, ",");
                String user = users.nextToken().trim();
                
                while(users.hasMoreTokens()) {
                    user = users.nextToken();
                    clientPanel.getTaOnline().append(user+"\n");
                }
            } else if(!response.equalsIgnoreCase("")) 
                this.clientPanel.getTaMessage().append("\n"+response);    //in ra kq vua nhan duoc
        }
        System.out.println("Disconnected to server!");
    }
}