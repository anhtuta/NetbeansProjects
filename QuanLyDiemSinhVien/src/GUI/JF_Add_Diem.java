/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.DLL_SinhVien;
import DLL.DLL_Diem;
import DLL.DLL_HocPhan;
import DBO.DBO_DIEM;
import DBO.DBO_SINH_VIEN;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DLL.DLL_Lop;
import MeThodShow.MyMethod;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author asus tp300l
 */
public class JF_Add_Diem extends javax.swing.JFrame {

    MyMethod method = new MyMethod();
    ArrayList<DBO_SINH_VIEN> lstSV = null;
    ArrayList<DBO_HOC_PHAN> lstHP = null;
    ArrayList<DBO_DIEM> lstDiem = null;
    ArrayList<DBO_LOP> lstLop = null;
    DLL_SinhVien dLL_SinhVien = new DLL_SinhVien();
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Lop dLL_Lop = new DLL_Lop();
    private boolean flag = false;

    public JF_Add_Diem() {
        initComponents();
        this.setLocation(200, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSoSinhVien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCheck = new javax.swing.JTextArea();
        btnCheck = new javax.swing.JButton();
        j1 = new javax.swing.JLabel();
        txtMaHocPhan = new javax.swing.JTextField();
        j2 = new javax.swing.JLabel();
        txtDiemC = new javax.swing.JTextField();
        txtMaHocPhan2 = new javax.swing.JLabel();
        txtDiemB = new javax.swing.JTextField();
        txtMaHocPhan3 = new javax.swing.JLabel();
        txtDiemTL1 = new javax.swing.JTextField();
        txtMaHocPhan4 = new javax.swing.JLabel();
        txtDiemTL2 = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbTL2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm Điểm Sinh Viên");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Thêm Điểm Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã Số Sinh Viên");

        txtMaSoSinhVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtCheck.setColumns(20);
        txtCheck.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtCheck.setLineWrap(true);
        txtCheck.setRows(5);
        txtCheck.setWrapStyleWord(true);
        txtCheck.setEnabled(false);
        jScrollPane1.setViewportView(txtCheck);

        btnCheck.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        j1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        j1.setText("Mã Học Phần");

        txtMaHocPhan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        j2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        j2.setText("Điểm C");

        txtDiemC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDiemC.setEnabled(false);
        txtDiemC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemCKeyTyped(evt);
            }
        });

        txtMaHocPhan2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaHocPhan2.setText("Điểm B");

        txtDiemB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDiemB.setEnabled(false);
        txtDiemB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemBKeyTyped(evt);
            }
        });

        txtMaHocPhan3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaHocPhan3.setText("Điểm Thi Lần 1");

        txtDiemTL1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDiemTL1.setEnabled(false);
        txtDiemTL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemTL1KeyTyped(evt);
            }
        });

        txtMaHocPhan4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaHocPhan4.setText("Điểm Thi Lần 2");

        txtDiemTL2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDiemTL2.setEnabled(false);
        txtDiemTL2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemTL2KeyTyped(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add-event-icon.png"))); // NOI18N
        btnAdd.setText("Thêm Điểm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cbTL2.setText("Thi Lần 2");
        cbTL2.setEnabled(false);
        cbTL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTL2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j1)
                            .addComponent(jLabel2)
                            .addComponent(j2)
                            .addComponent(txtMaHocPhan2)
                            .addComponent(txtMaHocPhan3)
                            .addComponent(txtMaHocPhan4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiemTL1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(btnCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDiemTL2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTL2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j1)
                            .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j2)
                            .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHocPhan2)
                            .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHocPhan3)
                            .addComponent(txtDiemTL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHocPhan4)
                            .addComponent(txtDiemTL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTL2))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnCheck)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnCancel))
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiemCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemCKeyTyped
        onlynumber(evt, txtDiemC);
    }//GEN-LAST:event_txtDiemCKeyTyped

    private void txtDiemBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemBKeyTyped
        onlynumber(evt, txtDiemB);
    }//GEN-LAST:event_txtDiemBKeyTyped

    private void txtDiemTL1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemTL1KeyTyped
        onlynumber(evt, txtDiemTL1);
    }//GEN-LAST:event_txtDiemTL1KeyTyped

    private void txtDiemTL2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemTL2KeyTyped
        onlynumber(evt, txtDiemTL2);
    }//GEN-LAST:event_txtDiemTL2KeyTyped

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        JF_Diem jf_d = new JF_Diem();
        jf_d.setVisible(true);
        jf_d.setLocation(200, 50);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        String mssv = txtMaSoSinhVien.getText();
        String mahp = txtMaHocPhan.getText();
        String kqsv = "";
        String gach = "\n----------------------------------\n";
        String kqHP = "";
        if (mssv.isEmpty() || mahp.isEmpty()) {
            method.showMessegaWa("Không có dữ liệu để check");
            flag = false;
        } else {
            lstSV = dLL_SinhVien.getAllGV_dk(mssv);
            lstHP = dLL_HocPhan.getAllHocPhan_dk(mahp);
            if (lstSV.size() > 0 && lstHP.size() > 0) {
                lstLop = dLL_Lop.getAllLop_dk(lstSV.get(0).getMaLop());
                kqsv = "Mã số sinh viên : " + mssv + "\nHọ Và Tên : " + lstSV.get(0).getHoTen() + "\nTên Lớp : " + lstLop.get(0).getTenLop();
                kqHP = "Mã Học Phần : " + lstHP.get(0).getMaHocPhan() + "\nTên Học Phần : " + lstHP.get(0).getTenHocPhan();
                txtCheck.setText(kqsv + gach + kqHP);
                lstDiem = dLL_Diem.Check_Diem(mssv, mahp);
                if (lstDiem.size() > 0) {
                    method.showMessegaWa("Điểm Số Học Phần :" + lstHP.get(0).getTenHocPhan() + "\n của sinh viên " + lstSV.get(0).getHoTen() + " Đã Tồn Tại");
                    flag = false;
                } else {
                    flag = true;
                }

            } else {
                method.showMessegaQue("Không Có Sinh Viên Hoặc Lớp Học Phần");
                flag = false;
            }
        }
        txtDiemC.setEnabled(flag);
        txtDiemB.setEnabled(flag);
        txtDiemTL1.setEnabled(flag);
        cbTL2.setEnabled(flag);
        txtDiemTL2.setEnabled(cbTL2.isSelected());
    }//GEN-LAST:event_btnCheckActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Diem jf_d = new JF_Diem();
        jf_d.setVisible(true);
        jf_d.setLocation(200, 50);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean check = false;
        if (txtDiemC.getText().isEmpty() || txtDiemB.getText().isEmpty() || txtDiemTL1.getText().isEmpty()) {
            method.showMessegaWa("Không có dữ liệu trong 1 textfiled");
            check = false;
        } else {
            String mssv = txtMaSoSinhVien.getText();
            String mahp = txtMaHocPhan.getText();
            Float diemC = Float.parseFloat(txtDiemC.getText());
            Float diemB = Float.parseFloat(txtDiemB.getText());
            Float diemTL1 = Float.parseFloat(txtDiemTL1.getText());
            Float diemTL2 = null;
            DBO_DIEM obj = new DBO_DIEM();
            if (cbTL2.isSelected()) {
                if (txtDiemTL2.getText().isEmpty()) {
                    method.showMessegaWa("Điểm thi lần 2 không được rỗng");
                    check = false;
                } else {
                    diemTL2 = Float.parseFloat(txtDiemTL2.getText());
                    obj.setDiem_TL2(diemTL2);
                    check = true;
                }
            } else {
                check = true;
            }
            if (check) {
                obj.setMaSoSinhVien(mssv);
                obj.setMaHocPhan(mahp);
                obj.setDiem_C(diemC);
                obj.setDiem_B(diemB);
                obj.setDiem_TL1(diemTL1);

                if (dLL_Diem.Insert(obj)) {
                    method.showMessegaNo("insert data success");
                    JF_Diem jf_diem = new JF_Diem();
                    jf_diem.setVisible(true);
                    jf_diem.setLocation(200, 100);
                    this.setVisible(false);
                } else {
                    method.showMessegaNo("insert data Fail");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbTL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTL2ActionPerformed
        txtDiemTL2.setEnabled(cbTL2.isSelected());
    }//GEN-LAST:event_cbTL2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Add_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Add_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Add_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Add_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Add_Diem().setVisible(true);
            }
        });
    }

    private void onlynumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (vchar == KeyEvent.VK_PERIOD) {
            temp.setText(temp.getText() + ".");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheck;
    private javax.swing.JCheckBox cbTL2;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCheck;
    private javax.swing.JTextField txtDiemB;
    private javax.swing.JTextField txtDiemC;
    private javax.swing.JTextField txtDiemTL1;
    private javax.swing.JTextField txtDiemTL2;
    private javax.swing.JTextField txtMaHocPhan;
    private javax.swing.JLabel txtMaHocPhan2;
    private javax.swing.JLabel txtMaHocPhan3;
    private javax.swing.JLabel txtMaHocPhan4;
    private javax.swing.JTextField txtMaSoSinhVien;
    // End of variables declaration//GEN-END:variables
}
