/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example3_5;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author AnhTu
 */
//chương trình nhận các thông tin đký của sv và ghi lên tệp ngẫu nhiên
public class RegistrationServer extends JFrame {
    private static JTextArea taLog;
    private static RandomAccessFile raf=null;
    private final int PORT=8000;
    
    public RegistrationServer() {
        taLog=new JTextArea();
        JScrollPane scroll=new JScrollPane(taLog);
        getContentPane().add(scroll, BorderLayout.CENTER);
        
        setSize(300, 300);
        setTitle("Dịch vụ đăng ký");
        setVisible(true);
        
        try {
            raf=new RandomAccessFile("student.dat", "rw");
        } catch (FileNotFoundException ex) {
            taLog.append(new Date() + ": Error: "+ex);
            System.exit(0);
        }
        
        //tạo 1 socket:
        try {
            ServerSocket serverSocket=new ServerSocket(PORT);
            taLog.append(new Date()+": Khởi động server mới\n");
            int count=1;  //đếm số luồng=số sv đký
            while(true) {
                Socket connectToClient=serverSocket.accept();
                taLog.append(new Date() +": Client: "+connectToClient.getInetAddress().getHostAddress()+" đc kết nối\n");
                
                //khởi động 1 luồng mới phục vụ cho việc đký của client:
                new RegistrationThread(connectToClient, count++).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(RegistrationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static JTextArea getTaLog() {
        return taLog;
    }
    
    public static void writeToFile(Student st) { //viết thông tin đã đký vào tệp
        
        try {
            //chuyển về cuối tệp:
            raf.seek(raf.length());
            st.writeStudent(raf);
            
            //hiển thị thông tin đã nhận đc:
            taLog.append("---Thông tin sau đã được ghi vào tệp:\n");
            String s=st.getName()+"\n"+st.getStreet()+"\n"+st.getCity()+"\n";
            taLog.append(s);
        } catch (IOException ex) {
            taLog.append(new Date()+": "+ex);
        }
    }
    
    public static void main(String[] args) {
        RegistrationServer server=new RegistrationServer();
    }
}
