package GUI;

import DBO.DBO_SINH_VIEN;
import DBO.DBO_DIEM;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DBO.DBO_Finding;
import DLL.DLL_Diem;
import DLL.DLL_SinhVien;
import DLL.DLL_HocPhan;
import DLL.DLL_Lop;
import DLL.DLL_Finding;
import MeThodShow.MyMethod;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class JF_Search_SV extends javax.swing.JFrame {

    // this is method show message
    MyMethod method = new MyMethod();
    // lst cac thanh phan
    ArrayList<DBO_SINH_VIEN> lstSinhVien = null;
    ArrayList<DBO_HOC_PHAN> lstHocPhan = null;
    ArrayList<DBO_DIEM> lstDiem = null;
    ArrayList<DBO_LOP> lstLop = null;
    ArrayList<DBO_Finding> lstketQua = null;
    // dll cac thanh phan
    DLL_SinhVien dLL_SinhVien = new DLL_SinhVien();
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Lop dLL_Lop = new DLL_Lop();
    DLL_Finding dLL_Finding = new DLL_Finding();
    //
    private DefaultTableModel dtm;

    public JF_Search_SV() {
        initComponents();
        this.setLocation(200, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFiding = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfor = new javax.swing.JTextArea();
        scrollPanen = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finding Student");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Finding Student HUMG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        txtFiding.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        txtFiding.setText("MSSV");
        txtFiding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFidingMouseClicked(evt);
            }
        });

        btnFind.setText("Finding");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 204, 255));
        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 102, 102));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reload.png"))); // NOI18N
        btnClear.setText("Reload");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFiding, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFiding, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnClear)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtInfor.setBackground(new java.awt.Color(255, 204, 204));
        txtInfor.setColumns(20);
        txtInfor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtInfor.setLineWrap(true);
        txtInfor.setRows(5);
        txtInfor.setText("This is your information of your id");
        txtInfor.setWrapStyleWord(true);
        txtInfor.setEnabled(false);
        jScrollPane1.setViewportView(txtInfor);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        tblDiem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPanen.setViewportView(tblDiem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanen, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        FindStudent();
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtFidingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFidingMouseClicked
        txtFiding.setText("");
    }//GEN-LAST:event_txtFidingMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Manager jF_Manager = new JF_Manager();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtInfor.setText("This is your information of your id");
        txtFiding.setText("Nhập mã số sinh viên");
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Điểm C");
        Column.add("Điểm B");
        Column.add("Điểm TL1");
        Column.add("Điểm TL2");
        Column.add("Điểm Trung Bình");
        Column.add("Điểm Chữ");
        Vector data = new Vector();
        dtm = new DefaultTableModel(data, Column);
        tblDiem.setModel(dtm);
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Search_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Search_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Search_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Search_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Search_SV().setVisible(true);
            }
        });
    }

    public void FindStudent() {
        String mssv = txtFiding.getText();
        String resultStudent = "";
        String gach = "\n----------------------------------\n";
        String resultSubjects = "";
        if (mssv.isEmpty()) {
            method.showMessegaWa("Bạn Phải Nhập đúng sinh viên cần tìm");
        } else {
            lstSinhVien = dLL_SinhVien.getAllGV_dk(mssv);
            if (lstSinhVien.size() > 0) {
                lstLop = dLL_Lop.getAllLop_dk(lstSinhVien.get(0).getMaLop());
                lstketQua = dLL_Finding.getFinding(mssv);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateFormat.format(lstSinhVien.get(0).getNgaySinh());
                resultStudent = "Mã sinh viên : " + mssv + "\nTên Sinh Viên : " + lstSinhVien.get(0).getHoTen() + "\nNgày Sinh : " + date + "\nLớp : " + lstLop.get(0).getMaLop() + " ( " + lstLop.get(0).getTenLop();
                resultSubjects = "Điểm trung bình tích lũy (hệ 4): " + lstketQua.get(0).getDiemTrungBinh() + "\nSố tín chỉ tích lũy: " + lstketQua.get(0).getSoTinChiDat();
                txtInfor.setText(resultStudent + gach + resultSubjects);
                BidingData(mssv);
            } else {
                method.showMessegaQue("Không Có Sinh Viên nào có mã số là : " + mssv);
            }
        }

    }

    public void BidingData(String mssv) {
        int i = 1;
        lstDiem = dLL_Diem.getAllDiem_dk_mssv(mssv);
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Điểm C");
        Column.add("Điểm B");
        Column.add("Điểm TL1");
        Column.add("Điểm TL2");
        Column.add("Điểm Trung Bình");
        Column.add("Điểm Chữ");
        Vector data = new Vector();
        try {
            for (DBO_DIEM item : lstDiem) {
                Vector row = new Vector();
                lstHocPhan = dLL_HocPhan.getAllHocPhan_dk(item.getMaHocPhan());
                row.add(i);
                i++;
                if (lstHocPhan.size() > 0) {
                    row.add(lstHocPhan.get(0).getMaHocPhan());
                } else {
                    row.add("Is Null");
                }
                if (lstHocPhan.size() > 0) {
                    row.add(lstHocPhan.get(0).getTenHocPhan());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getDiem_C());
                row.add(item.getDiem_B());
                row.add(item.getDiem_TL1());
                row.add(item.getDiem_TL2());
                row.add(item.getDiem_Trung_Binh());
                row.add(item.getDiem_Chu());
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Diem : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDiem.setModel(dtm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPanen;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtFiding;
    private javax.swing.JTextArea txtInfor;
    // End of variables declaration//GEN-END:variables
}
