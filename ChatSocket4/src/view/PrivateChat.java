/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ReceivingFileThread;
import controller.SendFileFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author AnhTu
 */
public class PrivateChat extends javax.swing.JFrame {

    public String sender, receiver;     //receiver là thằng mà cái frame này đang chat cùng, sender chính là thằng chủ của frame này. sender ko cần thiết lắm
    public String serverHost;
    public BufferedWriter bw;
    public BufferedReader br;
    HTMLEditorKit htmlKit;
    HTMLDocument htmlDoc;   //dùng để insert văn bản dạng html vào tpMessage_pc
    
    public PrivateChat() {
        initComponents();
        htmlKit = new HTMLEditorKit();
        htmlDoc = new HTMLDocument();
        tpMessage_pc.setEditorKit(htmlKit);
        tpMessage_pc.setDocument(htmlDoc);
    }

    public PrivateChat(String sender, String receiver, String serverHost, BufferedWriter bw, BufferedReader br) {
        initComponents();
        this.sender = sender;
        this.receiver = receiver;
        this.serverHost = serverHost;
        this.bw = bw;
        this.br = br;
        
        htmlKit = new HTMLEditorKit();
        htmlDoc = new HTMLDocument();
        tpMessage_pc.setEditorKit(htmlKit);
        tpMessage_pc.setDocument(htmlDoc);
    }

    public JLabel getLbReceiver() {
        return lbReceiver;
    }
    
    public void sendToServer(String line) {
        try {
            this.bw.write(line);
            this.bw.newLine();   //phải có newLine thì mới dùng đc hàm readLine()
            this.bw.flush();
        } catch (java.net.SocketException e) {
            JOptionPane.showMessageDialog(this, "Server is closed, can't send message!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NullPointerException e) {
            System.out.println("[sendToServer()] Server is not open yet, or already closed!");
        } catch (IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieveFromServer() {
        try {
            return this.br.readLine();  //chú ý rằng chỉ nhận 1 dòng từ server gửi về thôi, nếu server gửi nhiều dòng thì các dòng sau ko đọc
        } catch (java.lang.NullPointerException e) {
            System.out.println("[recieveFromServer()] Server is not open yet, or already closed!");
        } catch (IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //hiện tại chưa cần phương thức này:
    public void appendMessage(String msg1, String msg2, Color c1, Color c2) {  //thiết lập 2 loại text khác màu nhau trên 1 dòng
        //chèn msg1 trước:
        int len = tpMessage_pc.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage_pc.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Tahoma");
        StyleConstants.setBold(sas, true);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c1);
        //StyleConstants.setAlignment(sas, StyleConstants.ALIGN_RIGHT);
        
        try {
            doc.insertString(len, msg1, sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sau đó chèn msg2 ngay sau msg1:
        doc = (StyledDocument) tpMessage_pc.getDocument();
        len = len+msg1.length();
        
        sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Arial");
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c2);
        //StyleConstants.setAlignment(sas, StyleConstants.ALIGN_RIGHT);
        
        try {
            doc.insertString(len, msg2+"\n", sas);      //phai xuong dong
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage_pc.setCaretPosition(len+msg2.length());
    }
    
    public void appendMessage_Left(String msg1, String msg2) {      //dành cho người mà user này đang chat cùng
        try {
            htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), "<p style=\"color:black; padding: 3px; margin-top: 4px; margin-right:35px; text-align:left; font:normal 12px Tahoma;\"><span style=\"background-color:#f3f3f3;\"><b>" + msg1 + "</b><span style=\"color:black;\">" + msg2 + "</span></span></p>", 0, 0, null);
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        tpMessage_pc.setCaretPosition(tpMessage_pc.getDocument().getLength());
    }
    
    public void appendMessage_Left(String msg1, String msg2, String color1, String color2) {      //dành cho người mà user này đang chat cùng
        try {
            htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), "<p style=\"color:" + color1 + "; padding: 3px; margin-top: 4px; margin-right:35px; text-align:left; font:normal 12px Tahoma;\"><span><b>" + msg1 + "</b><span style=\"color:" + color2 + ";\">" + msg2 + "</span></span></p><br/>", 0, 0, null);
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        tpMessage_pc.setCaretPosition(tpMessage_pc.getDocument().getLength());
    }
    
    public void appendMessage_Right(String msg1, String msg2) {     //dành cho người user này
        try { 
            //htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), "<p style=\"color:blue; margin-left:30px; text-align:right; font:normal 12px Tahoma;\"><b>" + msg1 + "</b><span style=\"color:black;\">" + msg2 + "</span></p>", 0, 0, null);
            htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), "<p style=\"color:white; padding: 3px; margin-top: 4px; margin-left:35px; text-align:right; font:normal 12px Tahoma;\"><span style=\"background-color: #889eff; -webkit-border-radius: 10px;\">" + msg2 + "</span></p>", 0, 0, null);
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        tpMessage_pc.setCaretPosition(tpMessage_pc.getDocument().getLength());
    }
    
    public void appendMessage_Right(String msg1) {     //dành cho người user này
        try { 
            //htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), "<p style=\"color:blue; margin-left:30px; text-align:right; font:normal 12px Tahoma;\"><b>" + msg1 + "</b><span style=\"color:black;\">" + msg2 + "</span></p>", 0, 0, null);
            htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), "<p style=\"color:white; padding: 3px; margin-top: 4px; margin-left:35px; text-align:right; font:normal 12px Tahoma;\"><span style=\"background-color: #889eff; -webkit-border-radius: 10px;\">" + msg1 + "</span></p>", 0, 0, null);
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        tpMessage_pc.setCaretPosition(tpMessage_pc.getDocument().getLength());
    }

    public void insertButton(String sender, String fileName) {
        JButton bt = new JButton(fileName);
        bt.setName(fileName);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                downloadFile(fileName);
            }
        });
        appendMessage_Left(sender, " sends a file ", "#00dddd", "#00ee11");
        tpMessage_pc.setCaretPosition(tpMessage_pc.getDocument().getLength() - 1);
        tpMessage_pc.insertComponent(bt);
    }

    private void downloadFile(String buttonName) {
        String myDownloadFolder;
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
            Socket socketOfReceiver = new Socket(serverHost, 9999);    //tạo mới 1 socket để nhận file, xong việc thì nó TỰ ĐỘNG CLOSE
            new ReceivingFileThread(socketOfReceiver, myDownloadFolder, buttonName, this).start();    //socketOfClient chính là thằng nhận file
            System.out.println("start receiving file");
        } catch (IOException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbReceiver = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpMessage_pc = new javax.swing.JTextPane();
        tfInput_pc = new javax.swing.JTextField();
        btSend_pc = new javax.swing.JButton();
        btFile_pc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbReceiver.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbReceiver.setText("Receiver");

        tpMessage_pc.setEditable(false);
        jScrollPane1.setViewportView(tpMessage_pc);

        tfInput_pc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfInput_pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfInput_pcActionPerformed(evt);
            }
        });

        btSend_pc.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btSend_pc.setText("Send");
        btSend_pc.setToolTipText("send a message");
        btSend_pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSend_pcActionPerformed(evt);
            }
        });

        btFile_pc.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btFile_pc.setText("File");
        btFile_pc.setToolTipText("send a file");
        btFile_pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFile_pcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(tfInput_pc)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbReceiver)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSend_pc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFile_pc)))
                        .addGap(0, 156, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbReceiver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfInput_pc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSend_pc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btFile_pc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfInput_pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfInput_pcActionPerformed
        sendMessage();
    }//GEN-LAST:event_tfInput_pcActionPerformed

    private void btSend_pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSend_pcActionPerformed
        sendMessage();
    }//GEN-LAST:event_btSend_pcActionPerformed

    private void btFile_pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFile_pcActionPerformed
        openSendFileFrame();
    }//GEN-LAST:event_btFile_pcActionPerformed

    private void sendMessage() {
        String msg = tfInput_pc.getText();
        if(msg.equals("")) return;
        appendMessage_Right(msg);
        sendToServer("CMD_PRIVATECHAT|" + this.sender + "|" + this.receiver + "|" + msg);
        tfInput_pc.setText("");
    }
    
    private void openSendFileFrame() {
        SendFileFrame sendFileFrame = new SendFileFrame(serverHost, sender);
        
        sendFileFrame.thePersonIamChattingWith = receiver;
        sendFileFrame.getTfReceiver().setText(receiver);
        sendFileFrame.setVisible(true);
        sendFileFrame.setLocation(450, 250);
        sendFileFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrivateChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFile_pc;
    private javax.swing.JButton btSend_pc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbReceiver;
    private javax.swing.JTextField tfInput_pc;
    private javax.swing.JTextPane tpMessage_pc;
    // End of variables declaration//GEN-END:variables
}
