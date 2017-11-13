/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class ReceivingFileThread extends Thread {

    StringTokenizer tokenizer;
    private final int BUFFER_SIZE = 100;
    Socket socketOfReceiver;
    String myDownloadFolder;
    String fileName;

    public ReceivingFileThread(Socket socketOfReceiver, String myDownloadFolder, String fileName) {
        this.socketOfReceiver = socketOfReceiver;
        this.myDownloadFolder = myDownloadFolder;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socketOfReceiver.getInputStream()));
                String data = reader.readLine();
                tokenizer = new StringTokenizer(data, "|");
                String cmd = tokenizer.nextToken();
                
                if (cmd.equals("CMD_SENDFILETOCLIENT")) {
                    //receiver file:
                    String sender = tokenizer.nextToken();
                    String receiver = tokenizer.nextToken();
                    String filename = tokenizer.nextToken();

                    String path = myDownloadFolder + "\\" + filename;
                    System.out.println("path = " + path);
                    
                    FileOutputStream fos = new FileOutputStream(path);
                    BufferedInputStream bis = new BufferedInputStream(socketOfReceiver.getInputStream());

                    byte[] buffer = new byte[BUFFER_SIZE];
                    int count, percent = 0;

                    while ((count = bis.read(buffer)) > 0) {
                        fos.write(buffer, 0, count);
                    }

                    fos.close();
                    bis.close();
                    
                    System.out.println("File has saved in "+path);
                    JOptionPane.showMessageDialog(null, "File has saved in "+path);
                }
            } catch (IOException ex) {
                //Logger.getLogger(ReceivingFileThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("This socket for receiving file has benn close, so you don't need to worry about that!");
                break;
            }
            
        }
    }
}
