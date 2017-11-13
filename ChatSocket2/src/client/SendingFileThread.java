/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author AnhTu
 */
//Thread này làm nhiệm vụ gửi file lên server, chú ý rằng phải có việc xác nhận của bên receiver trước đó, rồi mới tới việc thread này start
public class SendingFileThread extends Thread {

    String sender, receiver;
    String filePath;
    Socket socketOfSender;
    BufferedWriter bw;
    BufferedReader br;
    JProgressBar progressBar;
    SendFileFrame frameToDisplayDialog;

    private final int BUFFER_SIZE = 100;
    
    public SendingFileThread(String sender, String receiver, String filePath, Socket socket, SendFileFrame frameToDisplayDialog, JProgressBar progressBar) {
        this.sender = sender;
        this.receiver = receiver;
        this.filePath = filePath;
        this.socketOfSender = socket;
        this.frameToDisplayDialog = frameToDisplayDialog;
        this.progressBar = progressBar;
        
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socketOfSender.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfSender.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(SendingFileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void sendToServer(String line) {
        try {
            this.bw.write(line);
            this.bw.newLine();   //phải có newLine thì mới dùng đc hàm readLine()
            this.bw.flush();
        } catch (java.net.SocketException e) {
            JOptionPane.showMessageDialog(null, "Server is close, can't send message!", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    @Override
    public void run() {
        try {
            File file = new File(filePath);     //we need to send this file to server, and then server will deliver this file to the receiver
            int leng = (int) file.length();     //ví dụ: leng = 4979 byte
            
            this.sendToServer("CMD_SENDFILETOSERVER|"+sender+"|"+receiver+"|"+file.getName()+"|"+leng);
            
            System.out.println("[SendingFileThread.java] CMD_SENDFILETOSERVER|"+sender+"|"+receiver+"|"+file.getName()+"|"+leng);   //dòng này thì có hiển thị ra
            
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));       //đầu vào của stream, từ file đó, nghĩa là dữ liệu cần gửi đi là file đó
            OutputStream out = socketOfSender.getOutputStream();    //đầu ra của stream, tới server
            
            byte []buffer = new byte[BUFFER_SIZE];
            int count=0, percent=0;
            while((count = bis.read(buffer)) > 0) {
                //percent = percent + count;
                out.write(buffer, 0, count);    //liên tục gửi từng phần của file tới server
                //progressBar.setValue(percent/leng);
            }
            out.flush();
            
            out.close();
            bis.close();
            
            JOptionPane.showMessageDialog(frameToDisplayDialog, "File successfully sent!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            socketOfSender.close();
        } catch (IOException ex) {
            Logger.getLogger(SendingFileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
giả sử file có kích thước 1000byte
số lần cần gửi là timeSend = 1000/BUFFER_SIZE = 10 lần
count là biến đếm số byte mỗi lần gửi, do đó trừ lần cuốn cùng thì count = 100
sau mỗi lần gửi thì percent = percent + count;
giả sử tại lần 4, percent = 400 byte
*/