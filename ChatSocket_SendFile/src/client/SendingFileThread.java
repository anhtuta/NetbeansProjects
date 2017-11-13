/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Hunk501
 */
public class SendingFileThread implements Runnable {
    
    protected Socket socket;
    private DataOutputStream dos;
    protected SendFile form;
    protected String file;
    protected String receiver;
    protected String sender;
    protected DecimalFormat df = new DecimalFormat("##,#00");
    private final int BUFFER_SIZE = 100;
    
    public SendingFileThread(Socket soc, String file, String receiver, String sender, SendFile frm){
        this.socket = soc;
        this.file = file;
        this.receiver = receiver;
        this.sender = sender;
        this.form = frm;
    }

    @Override
    public void run() {
        try {
            form.disableGUI(true);
            System.out.println("Sending File..!");
            dos = new DataOutputStream(socket.getOutputStream());
            /** Write filename, recipient, username  **/
            //  Format: CMD_SENDFILE [Filename] [Size] [Recipient] [Consignee]
            File filename = new File(file);
            int len = (int) filename.length();  //ví dụ len = 4979 byte
            int filesize = (int)Math.ceil(len / BUFFER_SIZE); // get the file size  //thì filesize = 49
            String clean_filename = filename.getName();
            dos.writeUTF("CMD_SENDFILE "+ clean_filename.replace(" ", "_") +" "+ filesize +" "+ receiver +" "+ sender);
            System.out.println("From: "+ sender);
            System.out.println("To: "+ receiver);
            /** Create an stream **/
            InputStream input = new FileInputStream(filename);
            OutputStream output = socket.getOutputStream();     //chú ý rằng socket này nối tới server, do đó sender gừi file lên server và server gửi lại cho receiver 
            /*  Monitor progress   */
            //ProgressMonitorInputStream pmis = new ProgressMonitorInputStream(form, "Sending file please wait...", input);
            /** Read file ***/
            BufferedInputStream bis = new BufferedInputStream(input);
            /** Create a temporary file storage **/
            byte[] buffer = new byte[BUFFER_SIZE];
            int count, percent = 0;
            while((count = bis.read(buffer)) > 0){
                percent = percent + count;
                int p = (percent / filesize);
                //form.setMyTitle(p +"% Sending File...");
                form.updateProgress(p);
                output.write(buffer, 0, count);
            }
            /* Update AttachmentForm GUI */
            form.setMyTitle("File was sent.!");
            form.updateAttachment(false); //  Update Attachment 
            JOptionPane.showMessageDialog(form, "File successfully sent.!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            form.closeThis();
            /* Close Streams */
            output.flush();
            output.close();
            System.out.println("File was sent..!");
        } catch (IOException e) {
            form.updateAttachment(false); //  Update Attachment
            System.out.println("[SendFile]: "+ e.getMessage());
        }
    }
}
