/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Hunk501
 */
public class OnlineListThread implements Runnable {
    
    MainForm main;
    
    public OnlineListThread(MainForm main){
        this.main = main;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                String msg = "";
                for(int x=0; x < main.clientList.size(); x++){
                    msg = msg+" "+ main.clientList.elementAt(x);
                }
                
                for(int x=0; x < main.socketList.size(); x++){
                    Socket tsoc = (Socket) main.socketList.elementAt(x);
                    DataOutputStream dos = new DataOutputStream(tsoc.getOutputStream());
                    /** CMD_ONLINE [user1] [user2] [user3] **/
                    if(msg.length() > 0){
                        dos.writeUTF("CMD_ONLINE "+ msg);
                    }
                }
                
                Thread.sleep(1900);
            }
        } catch(InterruptedException e){
            main.appendMessage("[InterruptedException]: "+ e.getMessage());
        } catch (IOException e) {
            main.appendMessage("[IOException]: "+ e.getMessage());
        }
    }
    
    
}
