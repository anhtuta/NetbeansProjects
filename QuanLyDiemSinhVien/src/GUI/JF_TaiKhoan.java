package GUI;

import DBO.DBO_DANG_NHAP;
import DLL.DLL_DangNhap;
import MeThodShow.MyMethod;
import java.util.ArrayList;

public class JF_TaiKhoan extends javax.swing.JFrame {

    MyMethod method = new MyMethod();
    DLL_DangNhap dLL_DangNhap = new DLL_DangNhap();
    private String matkau = "";
    String hoten = "";
    String email = "";
    private boolean flag_Save = false;
    private boolean flag_Pass = false;
    private boolean flag_CloseWin = false;

    JF_Manager jF_Manager;
    ArrayList<DBO_DANG_NHAP> lstThongTinTaiKhoan = null;
//    public static DBO_DANG_NHAP Infor = new DBO_DANG_NHAP();

    public JF_TaiKhoan(JF_Manager tr) {
        initComponents();
        this.setLocation(500, 100);
        setVisebleToMK(flag_Pass);
        postData(tr.User);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbChangeInfor = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtQuyen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cbChangesPass = new javax.swing.JCheckBox();
        txtMKM2 = new javax.swing.JTextField();
        txtMKM1 = new javax.swing.JTextField();
        txtMKC = new javax.swing.JTextField();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        j3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setText("Thông Tin Tài Khoản Của Bạn");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Tên Đăng Nhập");

        txtTenDangNhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTenDangNhap.setEnabled(false);

        txtHoVaTen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtHoVaTen.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Họ Và Tên");

        cbChangeInfor.setText("Sửa Đổi Thông Tin");
        cbChangeInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChangeInforActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setEnabled(false);

        txtQuyen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtQuyen.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Quyền Hạn Sử dụng");

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 0, 0));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/45.png"))); // NOI18N
        btnSave.setText("Lưu Lại");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cbChangesPass.setText("Thay đổi mật khẩu");
        cbChangesPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChangesPassActionPerformed(evt);
            }
        });

        txtMKM2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtMKM1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtMKC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        j1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        j1.setText("Mật khẩu cũ");

        j2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        j2.setText("Mật khẩu mới");

        j3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        j3.setText("Nhập lại mật khẩu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbChangesPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbChangeInfor))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(txtHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(txtTenDangNhap)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(15, 15, 15)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j1)
                            .addComponent(j2)
                            .addComponent(j3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMKM2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMKM1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMKC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbChangeInfor)
                    .addComponent(cbChangesPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j1)
                    .addComponent(txtMKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j2)
                    .addComponent(txtMKM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j3)
                    .addComponent(txtMKM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbChangeInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChangeInforActionPerformed
        if (cbChangeInfor.isSelected()) {
            hoten = txtHoVaTen.getText();
            email = txtEmail.getText();
            flag_Save = true;
        } else {
            txtHoVaTen.setText(hoten);
            txtEmail.setText(email);
            if (cbChangesPass.isSelected()) {
                flag_Save = true;
            } else {
                flag_Save = false;
            }
        }
        txtHoVaTen.setEnabled(cbChangeInfor.isSelected());
        txtEmail.setEnabled(cbChangeInfor.isSelected());
        btnSave.setEnabled(flag_Save);
    }//GEN-LAST:event_cbChangeInforActionPerformed

    private void cbChangesPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChangesPassActionPerformed
        if (cbChangesPass.isSelected()) {
            flag_Pass = true;
            setVisebleToMK(flag_Pass);
            flag_Save = true;
        } else {
            flag_Pass = false;
            setVisebleToMK(flag_Pass);
            if (cbChangeInfor.isSelected()) {
                flag_Save = true;
            } else {
                flag_Save = false;
            }
        }
        btnSave.setEnabled(flag_Save);
    }//GEN-LAST:event_cbChangesPassActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (flag_CloseWin) {
//          / jF_Manager.User = dLL_DangNhap.showDangNhap(txtTenDangNhap.getText(), matkau);
//            jF_Manager.postDataFromTK();
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (cbChangeInfor.isSelected() && !cbChangesPass.isSelected()) {
            if (txtHoVaTen.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                method.showMessegaNo("Chua dien day du thong tin");
            } else {
                DBO_DANG_NHAP item = new DBO_DANG_NHAP();
                item.setTenDangNhap(txtTenDangNhap.getText());
                item.setMatKhau(matkau);
                item.setHoTen(txtHoVaTen.getText());
                item.setEmail(txtEmail.getText());
                if (dLL_DangNhap.Update(item)) {
                    method.showMessegaNo("Update is Success!");
                    flag_CloseWin = true;
                    loadData(txtTenDangNhap.getText(), matkau);
                    cbChangeInfor.setSelected(false);
                    cbChangesPass.setSelected(false);
                    txtHoVaTen.setEnabled(false);
                    txtEmail.setEnabled(false);
                    setVisebleToMK(false);
                } else {
                    method.showMessegaNo("Update is fail");
                }
            }
        } else if (!cbChangeInfor.isSelected() && cbChangesPass.isSelected()) {
            if (txtMKC.getText().isEmpty() || txtMKM1.getText().isEmpty() || txtMKM1.getText().isEmpty()) {
                method.showMessegaNo("Chua dien day du thong tin");
            } else {
                String a = txtMKM1.getText();
                String b = txtMKM2.getText();
                if (!a.equals(b)) {
                    method.showMessegaNo("Bạn phải nhập 2 mật khẩu mới trùng nhau");
                } else {
                    matkau = txtMKC.getText();
                    if (!dLL_DangNhap.checkTonTaiTaiKhoan(txtTenDangNhap.getText(), matkau)) {
                        method.showMessegaQue("Mật Khẩu cũ bạn điền không chính xác!");
                    } else {
                        DBO_DANG_NHAP item = new DBO_DANG_NHAP();
                        item.setTenDangNhap(txtTenDangNhap.getText());
                        item.setMatKhau(txtMKM1.getText());
                        item.setHoTen(txtHoVaTen.getText());
                        item.setEmail(txtEmail.getText());
                        if (dLL_DangNhap.Update(item)) {
                            method.showMessegaNo("Update is Success!");
                            flag_CloseWin = true;
                            loadData(txtTenDangNhap.getText(), txtMKM1.getText());
                            cbChangeInfor.setSelected(false);
                            cbChangesPass.setSelected(false);
                            txtHoVaTen.setEnabled(false);
                            txtEmail.setEnabled(false);
                            setVisebleToMK(false);
                        } else {
                            method.showMessegaNo("Update is fail");
                        }
                    }
                }
            }
        } else if (txtHoVaTen.getText().isEmpty() || txtEmail.getText().isEmpty() || txtMKC.getText().isEmpty() || txtMKM1.getText().isEmpty() || txtMKM1.getText().isEmpty()) {
            method.showMessegaNo("Chua dien day du thong tin");
        } else {
            String a = txtMKM1.getText();
            String b = txtMKM2.getText();
            if (!a.equals(b)) {
                method.showMessegaNo("Bạn phải nhập 2 mật khẩu mới trùng nhau");
            } else {
                matkau = txtMKC.getText();
                if (!dLL_DangNhap.checkTonTaiTaiKhoan(txtTenDangNhap.getText(), matkau)) {
                    method.showMessegaQue("Mật Khẩu cũ bạn điền không chính xác!");
                } else {
                    DBO_DANG_NHAP item = new DBO_DANG_NHAP();
                    item.setTenDangNhap(txtTenDangNhap.getText());
                    item.setMatKhau(txtMKM1.getText());
                    item.setHoTen(txtHoVaTen.getText());
                    item.setEmail(txtEmail.getText());
                    if (dLL_DangNhap.Update(item)) {
                        method.showMessegaNo("Update is Success!");
                        flag_CloseWin = true;
                        loadData(txtTenDangNhap.getText(), txtMKM1.getText());
                        cbChangeInfor.setSelected(false);
                        cbChangesPass.setSelected(false);
                        txtHoVaTen.setEnabled(false);
                        txtEmail.setEnabled(false);
                        setVisebleToMK(false);
                    } else {
                        method.showMessegaNo("Update is fail");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(JF_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new JF_TaiKhoan().setVisible(true);
            }
        });
    }

    private void setVisebleToMK(boolean flag) {
        if (!flag) {
            txtMKC.setText("");
            txtMKM1.setText("");
            txtMKM2.setText("");
        }
        j1.setVisible(flag);
        j2.setVisible(flag);
        j3.setVisible(flag);
        txtMKM1.setVisible(flag);
        txtMKM2.setVisible(flag);
        txtMKC.setVisible(flag);
    }

    public void postData(DBO_DANG_NHAP temp) {
        txtTenDangNhap.setText(temp.getTenDangNhap());
        txtHoVaTen.setText(temp.getHoTen());
        txtEmail.setText(temp.getEmail());
        txtQuyen.setText(temp.getQuyen());
        matkau = temp.getMatKhau();
    }

    public void loadData(String name, String pass) {
        lstThongTinTaiKhoan = dLL_DangNhap.checkLogin(name, pass);
        txtTenDangNhap.setText(lstThongTinTaiKhoan.get(0).getTenDangNhap());
        txtEmail.setText(lstThongTinTaiKhoan.get(0).getEmail());
        txtHoVaTen.setText(lstThongTinTaiKhoan.get(0).getHoTen());
        txtQuyen.setText(lstThongTinTaiKhoan.get(0).getQuyen());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox cbChangeInfor;
    private javax.swing.JCheckBox cbChangesPass;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMKC;
    private javax.swing.JTextField txtMKM1;
    private javax.swing.JTextField txtMKM2;
    private javax.swing.JTextField txtQuyen;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
