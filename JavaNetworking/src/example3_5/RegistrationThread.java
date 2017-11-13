/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class RegistrationThread extends Thread { //định nghĩa luồng để nhận yêu cầu đký từ client
    private Socket socket;
    private int clientNum;
    private BufferedReader in; //tạo 1 vùng đệm để nhận tin

    public RegistrationThread(Socket socket, int clientNum) {
        this.socket = socket;
        this.clientNum = clientNum;
        RegistrationServer.getTaLog().append(new Date()+": Thread: "+clientNum+" được khởi động\n");
        
        //tạo 1 dòng vào để nhận từ client:
        try {
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (IOException ex) {
            RegistrationServer.getTaLog().append(new Date()+": "+ex);
        }
    }

    @Override
    public void run() {
        String name,street,city;
        try {
            //nhận từ client:
            name=in.readLine();
            street=in.readLine();
            city=in.readLine();
            
            //tạo 1 đối tượng sv:
            Student st=new Student(name, street, city);
            RegistrationServer.writeToFile(st);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
