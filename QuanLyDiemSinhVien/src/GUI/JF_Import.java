package GUI;

import ExCel.ExcelPorter;
import MeThodShow.MyMethod;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DBO.DBO_KHOA;
import DBO.DBO_DIEM;
import DBO.DBO_SINH_VIEN;
import DBO.DBO_GIANG_VIEN;
import DLL.DLL_HocPhan;
import DLL.DLL_Lop;
import DLL.DLL_Khoa;
import DLL.DLL_Diem;
import DLL.DLL_SinhVien;
import DLL.DLL_GiangVien;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JF_Import extends javax.swing.JFrame {

    // Array
    ArrayList<DBO_KHOA> lstKhoa = null;
    ArrayList<DBO_LOP> lstLop = null;
    ArrayList<DBO_HOC_PHAN> lstHP = null;
    ArrayList<DBO_SINH_VIEN> lstSV = null;
    ArrayList<DBO_GIANG_VIEN> lstGV = null;
    // DLL tr data
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    DLL_Lop dLL_Lop = new DLL_Lop();
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_SinhVien dLL_SinhVien = new DLL_SinhVien();
    DLL_GiangVien dLL_GiangVien = new DLL_GiangVien();
    
    private ExcelPorter ex = new ExcelPorter();
    MyMethod method = new MyMethod();
    private int ext = 0;
    
    public JF_Import() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnBro = new javax.swing.JButton();
        cbTable = new javax.swing.JComboBox<>();
        btnRefest = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        lblTest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Import From Excel To Database");

        btnBro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Places-folder-system-icon.png"))); // NOI18N
        btnBro.setText("Brose");
        btnBro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroActionPerformed(evt);
            }
        });

        cbTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Điểm", "Giảng Viên", "Học Phần", "Khoa", "Lớp", "Sinh Viên" }));
        cbTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTableActionPerformed(evt);
            }
        });

        btnRefest.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnRefest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.ico-32x32.png"))); // NOI18N
        btnRefest.setText("Xóa trùng lặp");
        btnRefest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefestActionPerformed(evt);
            }
        });

        btnImport.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myImport.png"))); // NOI18N
        btnImport.setText("Import To DB");
        btnImport.setEnabled(false);
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBro)
                .addGap(18, 18, 18)
                .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefest)
                .addGap(18, 18, 18)
                .addComponent(btnImport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTable)
                        .addComponent(btnRefest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnBro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblMain.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMain);

        lblTest.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTest.setForeground(new java.awt.Color(51, 51, 255));
        lblTest.setText("Test");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroActionPerformed
        lblTest.setText(ex.readExcel(tblMain, cbTable.getSelectedIndex()));
        //cbTable.getSelectedIndex()
    }//GEN-LAST:event_btnBroActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Manager jF_Manager = new JF_Manager();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnRefestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefestActionPerformed
        if (tblMain.getRowCount() == 0) {
            btnImport.setEnabled(false);
            method.showMessegaNo("not data in table");
        } else {
            int index = cbTable.getSelectedIndex();
            Resfresh(index);
            deleteExist(index);
            if (tblMain.getRowCount() != 0) {
                btnImport.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnRefestActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        if (tblMain.getRowCount() == 0) {
            method.showMessegaNo("not data in table");
        } else {
            int index = cbTable.getSelectedIndex();
            insertData(index);
            btnImport.setEnabled(false);
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void cbTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTableActionPerformed
        btnImport.setEnabled(false);
    }//GEN-LAST:event_cbTableActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Import.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Import.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Import.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Import.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Import().setVisible(true);
            }
        });
    }
    
    public void Resfresh(int index) {
        ext = 0;
        int rowMax = tblMain.getRowCount();
        TableModel model = tblMain.getModel();
        DefaultTableModel Deletemodel;
        if (index != 0) {
            for (int i = 0; i < rowMax - 1; i++) {
                for (int j = i + 1; j < rowMax; j++) {
                    if (model.getValueAt(i, 1) == model.getValueAt(j, 1)) {
                        Deletemodel = (DefaultTableModel) tblMain.getModel();
                        Deletemodel.removeRow(j);
                        ext++;
                    }
                }
            }
        } else {
            for (int i = 0; i < rowMax - 1; i++) {
                for (int j = i + 1; j < rowMax; j++) {
                    if (model.getValueAt(i, 1) == model.getValueAt(j, 1) && model.getValueAt(i, 2) == model.getValueAt(j, 2)) {
                        Deletemodel = (DefaultTableModel) tblMain.getModel();
                        Deletemodel.removeRow(j);
                        ext++;
                    }
                }
            }
        }
    }
    
    public void deleteExist(int index) {
        int count = 0;
        int rowMax = tblMain.getRowCount();
        TableModel model = tblMain.getModel();
        if (index == 0) {
            int i = 0;
            while (true) {
                if (i == tblMain.getRowCount()) {
                    break;
                }
                if (dLL_Diem.Check(model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString())) {
                    DefaultTableModel Deletemodel = (DefaultTableModel) tblMain.getModel();
                    Deletemodel.removeRow(i);
                    count++;
                } else {
                    i++;
                }
            }
        } else if (index == 1) {
            int i = 0;
            while (true) {
                if (i == tblMain.getRowCount()) {
                    break;
                }
                if (dLL_GiangVien.Check(model.getValueAt(i, 0).toString())) {
                    DefaultTableModel Deletemodel = (DefaultTableModel) tblMain.getModel();
                    Deletemodel.removeRow(i);
                    count++;
                } else {
                    i++;
                }
            }
        } else if (index == 2) {
            int i = 0;
            while (true) {
                if (i == tblMain.getRowCount()) {
                    break;
                }
                if (dLL_HocPhan.Check(model.getValueAt(i, 0).toString())) {
                    count++;
                    DefaultTableModel Deletemodel = (DefaultTableModel) tblMain.getModel();
                    Deletemodel.removeRow(i);
                    rowMax = tblMain.getRowCount();
                } else {
                    i++;
                }
            }
        } else if (index == 3) {
            int i = 0;
            while (true) {
                if (i == tblMain.getRowCount()) {
                    break;
                }
                if (dLL_Khoa.Check(model.getValueAt(i, 0).toString())) {
                    DefaultTableModel Deletemodel = (DefaultTableModel) tblMain.getModel();
                    Deletemodel.removeRow(i);
                    count++;
                } else {
                    i++;
                }
            }
        } else if (index == 4) {
            int i = 0;
            while (true) {
                if (i == tblMain.getRowCount()) {
                    break;
                }
                if (dLL_Lop.Check(model.getValueAt(i, 0).toString())) {
                    DefaultTableModel Deletemodel = (DefaultTableModel) tblMain.getModel();
                    Deletemodel.removeRow(i);
                    count++;
                } else {
                    i++;
                }
            }
        } else if (index == 5) {
            int i = 0;
            while (true) {
                if (i == tblMain.getRowCount()) {
                    break;
                }
                if (dLL_SinhVien.Check(model.getValueAt(i, 0).toString())) {
                    DefaultTableModel Deletemodel = (DefaultTableModel) tblMain.getModel();
                    Deletemodel.removeRow(i);
                    count++;
                } else {
                    i++;
                }
            }
        }
        method.showMessegaNo("Có " + ext + " Dữ Liệu Bị Trùng và\nĐã Xóa " + count + " Trùng lặp trong cơ sở dữ liệu");
    }
    
    public void insertData(int index) {
        int countSS = 0;
        int countFail = 0;
        int rowMax = tblMain.getRowCount();
        int ColoumnMax = tblMain.getColumnCount();
        TableModel model = tblMain.getModel();
        if (index == 0) {
            for (int i = 0; i < rowMax; i++) {
                DBO_DIEM obj = new DBO_DIEM();
                obj.setMaSoSinhVien(model.getValueAt(i, 1).toString());
                obj.setMaHocPhan(model.getValueAt(i, 2).toString());
                obj.setDiem_C(Float.parseFloat(model.getValueAt(i, 3).toString()));
                obj.setDiem_B(Float.parseFloat(model.getValueAt(i, 4).toString()));
                obj.setDiem_TL1(Float.parseFloat(model.getValueAt(i, 5).toString()));
                obj.setDiem_TL2(Float.parseFloat(model.getValueAt(i, 6).toString()));
                if (dLL_Diem.Insert(obj)) {
                    countSS++;
                } else {
                    countFail++;
                }
            }
        } else if (index == 1) {
            for (int i = 0; i < rowMax; i++) {
                DBO_GIANG_VIEN obj = new DBO_GIANG_VIEN();
                obj.setMaGiangVien(model.getValueAt(i, 0).toString());
                obj.setHoTenGiangVien(model.getValueAt(i, 1).toString());
                obj.setGioiTinh(Boolean.parseBoolean(model.getValueAt(i, 3).toString()));
                obj.setSoDienThoai(model.getValueAt(i, 4).toString());
                if (dLL_GiangVien.Insert(obj)) {
                    countSS++;
                } else {
                    countFail++;
                }
            }
        } else if (index == 2) {
            for (int i = 0; i < rowMax; i++) {
                DBO_HOC_PHAN obj = new DBO_HOC_PHAN();
                obj.setMaHocPhan(model.getValueAt(i, 0).toString());
                obj.setTenHocPhan(model.getValueAt(i, 1).toString());
                obj.setSoTinChi(Integer.parseInt(model.getValueAt(i, 3).toString()));
                obj.setPhongHoc(model.getValueAt(i, 4).toString());
                obj.setMaGiangVien(model.getValueAt(i, 5).toString());
                obj.setNamHoc(Integer.parseInt(model.getValueAt(i, 6).toString()));
                if (dLL_HocPhan.Insert(obj)) {
                    countSS++;
                } else {
                    countFail++;
                }
            }
        } else if (index == 3) {
            for (int i = 0; i < rowMax; i++) {
                DBO_KHOA obj = new DBO_KHOA();
                obj.setMaKhoa(model.getValueAt(i, 0).toString());
                obj.setTenKhoa(model.getValueAt(i, 1).toString());
                if (dLL_Khoa.Insert(obj)) {
                    countSS++;
                } else {
                    countFail++;
                }
            }
        } else if (index == 4) {
            for (int i = 0; i < rowMax; i++) {
                DBO_LOP obj = new DBO_LOP();
                obj.setMaLop(model.getValueAt(i, 0).toString());
                obj.setTenLop(model.getValueAt(i, 1).toString());
                obj.setMaKhoa(model.getValueAt(i, 2).toString());
                obj.setKhoaHoc(model.getValueAt(i, 3).toString());
                if (dLL_Lop.Insert(obj)) {
                    countSS++;
                } else {
                    countFail++;
                }
            }
        } else if (index == 5) {
            for (int i = 0; i < rowMax; i++) {
                DBO_SINH_VIEN obj = new DBO_SINH_VIEN();
                obj.setMaSoSinhVien(model.getValueAt(i, 0).toString());
                obj.setHoTen(model.getValueAt(i, 1).toString());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate;
                try {
                    startDate = df.parse(model.getValueAt(i, 2).toString());
                    obj.setNgaySinh(startDate);
                } catch (ParseException ex) {
                    Logger.getLogger(JF_Import.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj.setGioiTinh(Boolean.parseBoolean(model.getValueAt(i, 3).toString()));
                obj.setMaLop(model.getValueAt(i, 4).toString());
                obj.setSoDienThoai(model.getValueAt(i, 5).toString());
                if (dLL_SinhVien.Insert(obj)) {
                    countSS++;
                } else {
                    countFail++;
                }
            }
        }
        method.showMessegaNo("Have " + countSS + " data insert successly to datababase\n Have " + countFail + " cata insert fail to datababase");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBro;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnRefest;
    private javax.swing.JComboBox<String> cbTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTest;
    private javax.swing.JTable tblMain;
    // End of variables declaration//GEN-END:variables
}
