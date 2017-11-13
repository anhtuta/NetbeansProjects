/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_vs_client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author AnhTu
 */
public class ServerFrame extends JFrame {    //nếu ko cần giao diện thì ko cần extends jframe, nghĩa là ko cần class này làm j, chỉ cần ServerThread là đủ
    
    JButton btStop;
    JTextArea taInfo;
    ServerSocket serverSocket;
    
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    public ServerFrame() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JLabel lbStateServer = new JLabel("     Server's status\n");
        lbStateServer.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        
        taInfo = new JTextArea();
        taInfo.setEditable(false);
        taInfo.setFont(new java.awt.Font("Serif", 0, 17));
        taInfo.setBackground(new java.awt.Color(0, 0, 0));  //màu nền
        taInfo.setForeground(new java.awt.Color(0, 255, 255));  //màu chữ
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(taInfo);
        scroll.setPreferredSize(new Dimension(400, 400));
        
        btStop = new JButton("Stop server");
        btStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btStopEvent(ae);
            }
        });
        
        JPanel panelBtn = new JPanel();
        panelBtn.add(btStop);
        
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(30, 30));
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(30, 30));
        
        panel.add(lbStateServer, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(panelBtn, BorderLayout.SOUTH);
        panel.add(p1, BorderLayout.WEST);
        panel.add(p2, BorderLayout.EAST);
        
        
        this.add(panel);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void startServer() {
        try {
            serverSocket = new ServerSocket(9999); //chỉ có 1 đối tượng serverSocket duy nhất, đối tượng này sẽ tạo từng socket để giao tiếp với socket của client
            taInfo.append("["+sdf.format(new Date())+"] Server is running and ready to server any client...");
            taInfo.append("\n["+sdf.format(new Date())+"] Now there's no one is connecting to server\n");
            
            while(true) {
                Socket socketOfServer = serverSocket.accept();      //cứ có 1 client kết nối thì lệnh này mới đc thực hiện, sau đó 1 thread mới đc tạo ra để xử lý client đó, nghĩa là có 1 socket mới bên server để nối với socket của client
                ServerThread serverThread = new ServerThread(socketOfServer);
                serverThread.taServer = this.taInfo;
                serverThread.start();
            }
            
        } catch (java.net.SocketException e) {
            System.out.println("Server is closed");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi xảy ra, có thể là: Cổng này đang có server chiếm dụng!");
            System.out.println("Hoặc server đã close");
            JOptionPane.showMessageDialog(this, "Cổng này đang có server chiếm dụng", "Error", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
            System.exit(0);
        }
    }
    
    private void btStopEvent(ActionEvent ae) {
        try {
            //notify to all clients that server is closed:
            //code here
            
            //then close server:
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        ServerFrame serverFrame = new ServerFrame();
        serverFrame.setVisible(true);
        serverFrame.startServer();
        
    }
}