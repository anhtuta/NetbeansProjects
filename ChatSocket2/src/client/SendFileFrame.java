/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AnhTu
 */
public class SendFileFrame extends javax.swing.JFrame {

    String name;
    Socket socketOfClient;
    BufferedWriter bw;
    BufferedReader br;
    
    
    public SendFileFrame() {
        initComponents();
    }

    public JTextField getTfFilePath() {
        return tfFilePath;
    }

    public JTextField getTfReceiver() {
        return tfReceiver;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfFilePath = new javax.swing.JTextField();
        btBrowse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfReceiver = new javax.swing.JTextField();
        btSendFile = new javax.swing.JButton();
        lbNote = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        lbNote2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Select a file:");

        tfFilePath.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btBrowse.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btBrowse.setText("...");
        btBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBrowseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter reciever:");

        tfReceiver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btSendFile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSendFile.setText("Send");
        btSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendFileActionPerformed(evt);
            }
        });

        lbNote.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbNote.setText("Note that:");

        lbNote2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbNote2.setText("    -Make sure to enter the right receiver's name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSendFile))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNote2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFilePath))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfReceiver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNote2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBrowseActionPerformed
        displayOpenDialog();
    }//GEN-LAST:event_btBrowseActionPerformed

    private void btSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendFileActionPerformed
        String filePath = tfFilePath.getText();
        String reciever = tfReceiver.getText();
        File file = new File(filePath);
        
        this.sendToServer("CMD_SENDFILE_REQUEST|"+name+"|"+reciever+"|"+file.getName());
        System.out.println("(SendFileFrame.java) CMD_SENDFILE_REQUEST|"+name+"|"+reciever+"|"+file.getName());
    }//GEN-LAST:event_btSendFileActionPerformed

    private void displayOpenDialog() {
        JFileChooser chooser = new JFileChooser();
        int kq = chooser.showOpenDialog(this);
        if(kq == JFileChooser.APPROVE_OPTION) {
            tfFilePath.setText(chooser.getSelectedFile().getAbsolutePath());
        } else tfFilePath.setText("");
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
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SendFileFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBrowse;
    private javax.swing.JButton btSendFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbNote;
    private javax.swing.JLabel lbNote2;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField tfFilePath;
    private javax.swing.JTextField tfReceiver;
    // End of variables declaration//GEN-END:variables

}
/*
send file: giả sử client A muốn gửi file cho client B
khi ấn nút send, client A gửi thông tin file và receiver cho server = command: CMD_SENDFILE_REQUEST
sau đó server nhận gói tin đó bóc ra và lấy tên người gửi là receiver B, và gửi 1 bản tin tới
B với command: CMD_SENDFILE_COMFIRM, nếu B đồng ý thì B gửi lại cho server với command:
CMD_SENDFILE_ACCEPT, sau đó bên A gửi file lên server với command: CMD_SENDFILETOSERVER và server gửi
lại file cho B với command CMD_SENDFILETOCLIENT; nếu B ko đồng ý nhận thì B gửi command tới server: CMD_SENDFILE_DENY,
sau đó server thông báo với A rằng B ko muốn nhận
*/