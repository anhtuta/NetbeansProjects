/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class MainDiagram extends javax.swing.JFrame {

    /**
     * Creates new form MainDiagram
     */
    
    private DiagramPanel diaPanel;
    private KhuNha nha;  //KhuNha tương đương với tòa nhà
    private Phong phong;
    private SinhVienInfo svInfo;
    private MoveTo mov;
    
    String strKhuNha;   //vi du: B9
    String strSoNha; //vi du: 102
    String strPhong; //vi du: B9-102
    String imagePath;
    String mssvMove;
    String phongMoi;
    String phongCu;
    
    MyConnect myConnect = new MyConnect();
    ResultSet rs;
    PreparedStatement pst;
    Connection conn;
    
    boolean isUpdate = false;
    int soSVTrong1Phong = 0;
    PhongTroFrame ptf = new PhongTroFrame();
    
    public MainDiagram() {
        initComponents();
        
        diaPanel = new DiagramPanel();
        nha = new KhuNha();
        phong = new Phong();
        svInfo = new SinhVienInfo();
        mov = new MoveTo();
        
        svInfo.setVisible(false);
        
        //chú ý thứ tự add sau:
        bgPanel.add(diaPanel);
        bgPanel.add(nha);
        bgPanel.add(phong);
        bgPanel.add(svInfo);
        bgPanel.add(mov);
        
        /////add event handle for diaPanel:
        diaPanel.getB9().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                strKhuNha = "B9";
                mousePressedDiaPanel();
            }
        });
        diaPanel.getB6().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                strKhuNha = "B6";
                mousePressedDiaPanel();
            }
        });
        
        
        /////add event handle for nha:
        nha.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                nha.setVisible(false);
                diaPanel.setVisible(true);
            }
        });
        
        nha.get109().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                strSoNha = "109";
                displaySVInPhong();
            }
        });
        
        nha.get108().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                strSoNha = "108";
                displaySVInPhong();
            }
        });
        
        nha.get107().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                strSoNha = "107";
                displaySVInPhong();
            }
        });
        
        
        /////add event handle for phong:
        phong.getLbName1().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(1);
                isUpdate = !phong.getLbName1().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName2().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(2);
                isUpdate = !phong.getLbName2().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName3().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(3);
                isUpdate = !phong.getLbName3().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName4().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(4);
                isUpdate = !phong.getLbName4().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName5().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(5);
                isUpdate = !phong.getLbName5().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName6().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(6);
                isUpdate = !phong.getLbName6().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName7().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(7);
                isUpdate = !phong.getLbName7().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        phong.getLbName8().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                displaySVInSVInfo(8);
                isUpdate = !phong.getLbName8().getText().equals(" Click để thêm sinh viên ");
                if(isUpdate) svInfo.viewMode();
                else svInfo.addNewMode();
            }
        });
        
        phong.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                phong.setVisible(false);
                nha.setVisible(true);
                phong.reset();
            }
        });
        
        
        /////add event handle for svInfo:
        svInfo.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if(svInfo.getIsChange()) {
                    int choice = JOptionPane.showConfirmDialog(null, "Lưu thay đổi?", "Chú ý", JOptionPane.YES_NO_CANCEL_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        svInfo.updateSV();
                        
                        svInfo.setVisible(false);
                        phong.setVisible(true);
                        svInfo.reset();
                        svInfo.setIsChange(false);
                        reloadSVInPhong();
                    }
                    else if(choice == JOptionPane.NO_OPTION) {
                        svInfo.setVisible(false);
                        phong.setVisible(true);
                        svInfo.reset();
                        svInfo.setIsChange(false);
                        reloadSVInPhong();
                    }
                } else {
                    svInfo.setVisible(false);
                    phong.setVisible(true);
                    svInfo.reset();
                    svInfo.setIsChange(false);
                    reloadSVInPhong();
                }
            }
        });
        svInfo.getMove().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                svInfo.setVisible(false);
                mov.setVisible(true);
                mssvMove = svInfo.getTfMSSV().getText().trim();
                phongCu = svInfo.getTfPhong().getText().trim();
            }
        });
        
        ////add event handle for mov:
        mov.get107().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                phongMoi = strKhuNha + "-" + "107";
                try {
                    moveToNewRoom();
                } catch (SQLException ex) {
                    Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mov.get108().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                phongMoi = strKhuNha + "-" + "108";
                try {
                    moveToNewRoom();
                } catch (SQLException ex) {
                    Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mov.get109().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                phongMoi = strKhuNha + "-" + "109";
                try {
                    moveToNewRoom();
                } catch (SQLException ex) {
                    Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mov.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                mov.setVisible(false);
                svInfo.setVisible(true);
                reloadSVInPhong();
            }
        });
        
    }    
    
    /////các phương thức để truy vấn CSDL qly ktx sinh vien:
    
    private ResultSet getData(String ph) {
        conn = myConnect.connect();
        ResultSet rs2 = null;
        try {
            pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE Phong_tenPhong LIKE '" + ph +"';");
            rs2 = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs2;
    }
    
    public void mousePressedDiaPanel() {
        diaPanel.setVisible(false);
        nha.setVisible(true);
        nha.setLbTenKhuNha(strKhuNha);
    }
    
    private void displaySVInPhong() {
        nha.setVisible(false);
        phong.setVisible(true);
        
        strPhong = strKhuNha + "-" + strSoNha;

        rs = getData(strPhong);
        String[] nameSV = new String[9];  //vì chỉ có tối đa 8 sv 1 phòng. Mỗi phần tử của mảng này chứa tên của 1 sinhvien trong phòng strPhong
        int i = 0;
        try {
            while (rs.next()) {
                i++;
                nameSV[i] = rs.getString(2);  //vì cột thứ 2 trong CSDL là cột Họ Tên
                byte[] byteImage = rs.getBytes(9);  //hoặc: byteImage = rs.getBytes("anh"); //lấy byte của ảnh của sinh viên
                if(byteImage!=null) {
                    if(i==1) phong.getLbImage1().setIcon(ResizeImage(phong.getLbImage1(), byteImage));
                    if(i==2) phong.getLbImage2().setIcon(ResizeImage(phong.getLbImage2(), byteImage));
                    if(i==3) phong.getLbImage3().setIcon(ResizeImage(phong.getLbImage3(), byteImage));
                    if(i==4) phong.getLbImage4().setIcon(ResizeImage(phong.getLbImage4(), byteImage));
                    if(i==5) phong.getLbImage5().setIcon(ResizeImage(phong.getLbImage5(), byteImage));
                    if(i==6) phong.getLbImage6().setIcon(ResizeImage(phong.getLbImage6(), byteImage));
                    if(i==7) phong.getLbImage7().setIcon(ResizeImage(phong.getLbImage7(), byteImage));
                    if(i==8) phong.getLbImage8().setIcon(ResizeImage(phong.getLbImage8(), byteImage));
                }
//                else {  //phòng trường hợp khi đã xóa 1 sv nhưng thông tin vẫn đc hiển thị ở Phong
//                    //chú ý: ko thể thực hiện các lệnh sau vì khi xóa 1 sv thì byteImage của sv đó = null, nhưng máy sẽ ko chạy tới sv đó vì rs.next() = false nên sẽ thoát luôn khỏi vòng lặp while
//                    if(i==1) phong.getLbImage1().setIcon(null);
//                    if(i==2) phong.getLbImage2().setIcon(null);
//                    if(i==3) phong.getLbImage3().setIcon(null);
//                    if(i==4) phong.getLbImage4().setIcon(null);
//                    if(i==5) phong.getLbImage5().setIcon(null);
//                    if(i==6) phong.getLbImage6().setIcon(null);
//                    if(i==7) phong.getLbImage7().setIcon(null);
//                    if(i==8) phong.getLbImage8().setIcon(null);
//                }
//                
                if(nameSV[i] != null) soSVTrong1Phong = i;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(nameSV[1] != null) phong.getLbName1().setText(nameSV[1]);
        else {
            phong.getLbName1().setText(" Click để thêm sinh viên ");
            phong.getLbImage1().setIcon(null);
        }
        if(nameSV[2] != null) phong.getLbName2().setText(nameSV[2]);
        else {
            phong.getLbName2().setText(" Click để thêm sinh viên ");
            phong.getLbImage2().setIcon(null);
        }
        if(nameSV[3] != null) phong.getLbName3().setText(nameSV[3]);
        else {
            phong.getLbName3().setText(" Click để thêm sinh viên ");
            phong.getLbImage3().setIcon(null);
        }
        if(nameSV[4] != null) phong.getLbName4().setText(nameSV[4]);
        else {
            phong.getLbName4().setText(" Click để thêm sinh viên ");
            phong.getLbImage4().setIcon(null);
        }
        if(nameSV[5] != null) phong.getLbName5().setText(nameSV[5]);
        else {
            phong.getLbName5().setText(" Click để thêm sinh viên ");
            phong.getLbImage5().setIcon(null);
        }
        if(nameSV[6] != null) phong.getLbName6().setText(nameSV[6]);
        else {
            phong.getLbName6().setText(" Click để thêm sinh viên ");
            phong.getLbImage6().setIcon(null);
        }
        if(nameSV[7] != null) phong.getLbName7().setText(nameSV[7]);
        else {
            phong.getLbName7().setText(" Click để thêm sinh viên ");
            phong.getLbImage7().setIcon(null);
        }
        if(nameSV[8] != null) phong.getLbName8().setText(nameSV[8]);
        else {
            phong.getLbName8().setText(" Click để thêm sinh viên ");
            phong.getLbImage8().setIcon(null);
        }

        try {
            phong.setEnableLabel(ptf.getSoLuongCho(strPhong));
        } catch (SQLException ex) {
            Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
        }
        phong.setLbTenKhuNha(strPhong);
    }
    
    private void reloadSVInPhong() {
        displaySVInPhong();
    }
    
    private void displaySVInSVInfo(int positionOfSV) {  //hiển thị thông tin của sinhvien thứ positionOfSV trong phòng strPhong
        phong.setVisible(false);
        svInfo.setVisible(true);
        svInfo.setjTextField_Phong(strPhong);
        
        rs = getData(strPhong);
        String[] strColumn = new String[8];
        int i = 0;
        
        //display student's info:
        try {
            while (rs.next()) {
                i++;
                if (i == positionOfSV) {
                    for (int j = 0; j < 8; j++) {
                        strColumn[j] = rs.getString(j + 1);
                    }
                    svInfo.setjTextField_mssv(strColumn[0]);
                    svInfo.setjTextField_name(strColumn[1]);
                    svInfo.setJTextfield_gioiTinh(strColumn[2]);
                    svInfo.setjNgaySinh(strColumn[3]);
                    svInfo.setjTextField_KhoaVien(strColumn[4]);
                    svInfo.setjTextField_k(strColumn[5]);
                    svInfo.setjTextField_QQ(strColumn[6]);
                    
                    //display SV's image:
                    byte[] byteImage = rs.getBytes(9);
                    if(byteImage!=null) {
                        svInfo.getLbImage().setIcon(ResizeImage(svInfo.getLbImage(), byteImage));
                    }
                    
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDiagram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void moveToNewRoom() throws SQLException {
        int slCu = ptf.getSoLuongChoTrong(phongCu);
        int slMoi = ptf.getSoLuongChoTrong(phongMoi);
        
        if(slMoi == 0) JOptionPane.showMessageDialog(null, "Phòng này đã full rồi!");
        else {
            int choice = JOptionPane.showConfirmDialog(null, "Di chuyển đến phòng "+phongMoi+"?", "Bạn có chắc?", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                conn = myConnect.connect();
                pst = conn.prepareStatement("UPDATE `quan_ly_sv_ktx`.`sinhvien` SET `Phong_tenPhong`='" + phongMoi + "' WHERE `MSSV`='" + mssvMove + "';");
                if (pst.executeUpdate() > 0) JOptionPane.showMessageDialog(null, "Chuyển phòng thành công!");

                ptf.updateSoLuongChoTrong(phongCu, ++slCu);
                ptf.updateSoLuongChoTrong(phongMoi, --slMoi);

                conn.close();
            }
        }
    }
    
    
    ///2 hàm sau xem bên SinhVienFrame.java:
     public ImageIcon ResizeImage(JLabel lbAnh, String imagePath){  //imagePath = đường dẫn đến file ảnh
        ImageIcon imageIcon1 = new ImageIcon(imagePath);  //lấy icon trong đường dẫn vừa rồi
        Image img = imageIcon1.getImage();   //lấy ảnh trong cái icon vừa rồi
        Image newImage = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(),Image.SCALE_SMOOTH);  //để ảnh hiển thị khớp với kích thước của lbAnh và co dãn đúng kích cỡ
        ImageIcon imageIcon2 = new ImageIcon(newImage);  //lấy cái ảnh trên làm icon
        return imageIcon2;
    }
    
    // Function To Resize The Image To Fit Into lbAnh
    //hàm này dành cho việc chỉnh kích thước của ảnh được tải lên table từ database do đó tham số của hàm là ảnh dưới dạng byte
    public ImageIcon ResizeImage(JLabel lbAnh, byte[] byteOfImage) {
        ImageIcon MyImage;
        MyImage = new ImageIcon(byteOfImage);
        
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newImg);
        //System.out.println("Byte of image is: "+Arrays.toString(byteOfImage)); //cái byteOfImage là dạng byte của ảnh, có thể xem trên database, nó rất dài!
        return imageIcon;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainDiagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDiagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDiagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDiagram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainDiagram().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    // End of variables declaration//GEN-END:variables
}
