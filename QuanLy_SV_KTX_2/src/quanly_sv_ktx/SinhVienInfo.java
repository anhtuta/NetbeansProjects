/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
//import obj.DBC;
//import obj.Room;
//import obj.Student;

/**
 *
 * @author tungt
 */
public class SinhVienInfo extends javax.swing.JPanel {
    BufferedImage image;
    FileInputStream fileInput;
    Boolean isChange = false;
    
    private MyConnect myConnect = new MyConnect();
    private Connection conn;
    private PreparedStatement pst = null;
    
    String imagePath;
    boolean isUpdate;
    PhongTroFrame ptf = new PhongTroFrame();
    
    /**
     * Creates new form StudentInfo
     */
    public SinhVienInfo() {
        initComponents();
        this.setSize(1100, 650);
        viewMode();
        this.setSize(1100, 650);
        try {
            image = ImageIO.read(new File("src/res/r2.png"));
        } catch (Exception e) {
            System.out.println("Can't find image");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1100, 650, this);
    }

    public void reset() {
        tfMSSV.setText("");
        tfTen.setText("");
        tfGT.setText("");
        ftfNs.setText("");
        tfKhoa.setText("");
        tfK.setText("");
        tfQQ.setText("");
        tfPhong.setText("");
        
        jComboBox_gentl.setSelectedIndex(0);
        lbAnh.setIcon(null);
    }

    void viewMode() {
        enableTextFields(false);
        
        edit.setVisible(true);
        save.setVisible(false);
        move.setVisible(false);
        delete.setVisible(false);
        import_image.setVisible(false);
        
        isUpdate = true;
    }
    
    void editMode() {
        enableTextFields(true);

        import_image.setVisible(true);
        edit.setVisible(false);
        save.setVisible(true);
        move.setVisible(true);
        delete.setVisible(true);
    }
    
    void addNewMode() {
        enableTextFields(true);
        
        import_image.setVisible(true);
        edit.setVisible(false);
        save.setVisible(true);
        move.setVisible(false);
        delete.setVisible(true);
        
        isUpdate = false;
    }
    
    void enableTextFields(boolean b) {
        tfMSSV.setEditable(b);
        tfTen.setEditable(b);
        tfGT.setEditable(b);
        ftfNs.setEditable(b);
        tfKhoa.setEditable(b);
        tfK.setEditable(b);
        tfQQ.setEditable(b);
        jComboBox_gentl.setVisible(b);
        cbKhoaVien.setVisible(b);
    }
    
    public void addSV() {
        conn = myConnect.connect();
        try {
            pst = conn.prepareStatement("INSERT INTO sinhvien VALUE(?,?,?,?,?,?,?,?,?);");
            //ví dụ: INSERT INTO sinhvien VALUE('21212112','anhtu','nam','199526262','dtvt',58,'hanoi','B9-201',null);
            pst.setInt(1, Integer.valueOf(tfMSSV.getText().trim()));
            pst.setString(2, tfTen.getText().trim());
            pst.setString(3, tfGT.getText().trim());
            pst.setString(4, ftfNs.getText().trim());
            pst.setString(5, tfKhoa.getText().trim());
            pst.setInt(6, Integer.valueOf(tfK.getText().trim()));
            pst.setString(7, tfQQ.getText().trim());
            pst.setString(8, tfPhong.getText().trim());
            fileInput = new FileInputStream(imagePath);
            pst.setBlob(9, fileInput); //thêm ảnh lấy từ fileInput
            
            if(pst.executeUpdate()> 0) {
                JOptionPane.showMessageDialog(null, "Add successful!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                if(fileInput != null) System.out.println("fileInput ở dạng String là: "+fileInput.toString());
                else JOptionPane.showMessageDialog(null, "Bạn chưa thêm ảnh cho sv vừa thêm, bạn có thể cập nhập ảnh sau", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                
                imagePath = null;
                String phong = tfPhong.getText().trim();
                int sl = ptf.getSoLuongChoTrong(phong);
                ptf.updateSoLuongChoTrong(phong, --sl);
            }
            else {
                JOptionPane.showMessageDialog(null, "Add failed! Đã tồn tại sinh viên đó", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                
            }
        } catch(java.sql.SQLIntegrityConstraintViolationException e) {
            //lỗi này là nhập trùng MSSV
            JOptionPane.showMessageDialog(null, "MSSV đã tồn tại!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            System.out.println("imagePath = "+imagePath);
            System.out.println(fileInput.toString());
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Add failed! Định dạng ko hợp lệ, có thể do MSSV hoặc Khóa sai định dạng, hoặc có thể Giới tính quá dài, hoặc Phòng ko tồn tại!", "Chú ý", JOptionPane.ERROR_MESSAGE);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVienInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSV() {
        conn = myConnect.connect();
        
        try {
            if (imagePath != null) {
                pst = conn.prepareStatement("UPDATE sinhvien SET name = ?,gioiTinh = ?,birthday = ?,khoaVien = ?,khoa = ?,queQuan = ?,Phong_tenPhong = ?,anh = ? WHERE MSSV = ?");
                pst.setString(1, tfTen.getText().trim());
                pst.setString(2, tfGT.getText().trim());
                pst.setString(3, ftfNs.getText().trim());
                pst.setString(4, tfKhoa.getText().trim());
                pst.setInt(5, Integer.valueOf(tfK.getText().trim()));
                pst.setString(6, tfQQ.getText().trim());
                pst.setString(7, tfPhong.getText().trim());
                fileInput = new FileInputStream(imagePath);  //imagePath là đường dẫn tới ảnh ở máy tính muốn tải lên database để update. đường dẫn này đã lấy đc khi ta ấn nút btTaiAnhLen
                pst.setBlob(8, fileInput); //hoặc : pst.setBinaryStream(8, fileInput); giống như hàm add()
                pst.setInt(9, Integer.valueOf(tfMSSV.getText().trim()));
            }
            
            else //nếu imagePath == null: ko tải ảnh từ máy lên lbAnh, tức là ko muốn thay đổi ảnh, thì sẽ ko update ảnh trên database nữa
            {
                pst = conn.prepareStatement("UPDATE sinhvien SET name = ?,gioiTinh = ?,birthday = ?,khoaVien = ?,khoa = ?,queQuan = ?,Phong_tenPhong = ? WHERE MSSV = ?");
                pst.setString(1, tfTen.getText().trim());
                pst.setString(2, tfGT.getText().trim());
                pst.setString(3, ftfNs.getText().trim());
                pst.setString(4, tfKhoa.getText().trim());
                pst.setInt(5, Integer.valueOf(tfK.getText().trim()));
                pst.setString(6, tfQQ.getText().trim());
                pst.setString(7, tfPhong.getText().trim());
                pst.setInt(8, Integer.valueOf(tfMSSV.getText().trim()));

                System.out.println("Bạn đã ko thay đổi ảnh.");
            }
            
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Update successful!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                imagePath = null;
            }
            else {
                //lỗi do thay đổi MSSV
                JOptionPane.showMessageDialog(null, "Bạn ko đc thay đổi MSSV, nếu muốn vậy b phải thêm 1 sinh viên", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                
            }
        } catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation e) {
            JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh!\nHãy nhập theo định dạng: YYYY-MM-DD");
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nhập sai định dạng!", "update failed!", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi ảnh!");
        } catch(java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nhập sai khóa: bạn phải nhập số!\n"+e.toString());
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void deleteSV() {
        conn = myConnect.connect();
        try {
            pst = conn.prepareStatement("DELETE FROM sinhvien WHERE MSSV = " + tfMSSV.getText().trim());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa!");

                String phong = tfPhong.getText().trim();
                int sl = ptf.getSoLuongChoTrong(phong);
                ptf.updateSoLuongChoTrong(phong, ++sl);
            }
            else JOptionPane.showMessageDialog(null, "Ko thể xóa!");
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ImageIcon ResizeImage(String imagePath){  //imagePath = đường dẫn đến file ảnh
        ImageIcon imageIcon1 = new ImageIcon(imagePath);  //lấy icon trong đường dẫn vừa rồi
        Image img = imageIcon1.getImage();   //lấy ảnh trong cái icon vừa rồi
        Image newImage = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(),Image.SCALE_SMOOTH);  //để ảnh hiển thị khớp với kích thước của lbAnh và co dãn đúng kích cỡ
        ImageIcon imageIcon2 = new ImageIcon(newImage);  //lấy cái ảnh trên làm icon
        return imageIcon2;
    }
    public ImageIcon ResizeImage(byte[] byteOfImage) {
        ImageIcon MyImage;
        MyImage = new ImageIcon(byteOfImage);
        
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newImg);
        //System.out.println("Byte of image is: "+Arrays.toString(byteOfImage)); //cái byteOfImage là dạng byte của ảnh, có thể xem trên database, nó rất dài!
        return imageIcon;
    }
    
    public void resetBackGround() {
        edit.setBackground(new java.awt.Color(51,51,255));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        back = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfQQ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_gentl = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ftfNs = new javax.swing.JFormattedTextField();
        lbAnh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfGT = new javax.swing.JTextField();
        tfMSSV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfKhoa = new javax.swing.JTextField();
        import_image = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        tfPhong = new javax.swing.JTextField();
        move = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        cbKhoaVien = new javax.swing.JComboBox<>();

        jFileChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jFileChooser1MousePressed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(1100, 650));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SDM\\rs\\back.png")); // NOI18N

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã số sinh viên");
        jLabel2.setOpaque(true);

        tfQQ.setBackground(new java.awt.Color(51, 51, 255));
        tfQQ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfQQ.setForeground(new java.awt.Color(255, 255, 255));
        tfQQ.setCaretColor(new java.awt.Color(255, 255, 0));
        tfQQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfQQKeyPressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quê quán");
        jLabel6.setOpaque(true);

        jComboBox_gentl.setBackground(new java.awt.Color(0, 0, 102));
        jComboBox_gentl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox_gentl.setForeground(new java.awt.Color(0, 0, 153));
        jComboBox_gentl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Nam", " Nữ", " Gay", " Lesbian" }));
        jComboBox_gentl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_gentlItemStateChanged(evt);
            }
        });
        jComboBox_gentl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox_gentlMousePressed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Phòng");
        jLabel9.setOpaque(true);

        tfK.setBackground(new java.awt.Color(51, 51, 255));
        tfK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfK.setForeground(new java.awt.Color(255, 255, 255));
        tfK.setCaretColor(new java.awt.Color(255, 255, 0));
        tfK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfKKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Khoa - Viện");
        jLabel3.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Họ Tên");
        jLabel1.setOpaque(true);

        ftfNs.setBackground(new java.awt.Color(51, 51, 255));
        ftfNs.setForeground(new java.awt.Color(255, 255, 255));
        try {
            ftfNs.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfNs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftfNs.setCaretColor(new java.awt.Color(255, 255, 0));
        ftfNs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ftfNs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfNsActionPerformed(evt);
            }
        });
        ftfNs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfNsKeyPressed(evt);
            }
        });

        lbAnh.setBackground(new java.awt.Color(51, 51, 255));
        lbAnh.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ngày sinh");
        jLabel4.setOpaque(true);

        tfGT.setBackground(new java.awt.Color(51, 51, 255));
        tfGT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfGT.setForeground(new java.awt.Color(255, 255, 255));
        tfGT.setCaretColor(new java.awt.Color(255, 255, 0));
        tfGT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfGTKeyPressed(evt);
            }
        });

        tfMSSV.setBackground(new java.awt.Color(51, 51, 255));
        tfMSSV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfMSSV.setForeground(new java.awt.Color(255, 255, 255));
        tfMSSV.setCaretColor(new java.awt.Color(255, 255, 0));
        tfMSSV.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfMSSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMSSVKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("YYYY-MM-DD");
        jLabel10.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(51, 51, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Giới tính");
        jLabel5.setOpaque(true);

        tfTen.setBackground(new java.awt.Color(51, 51, 255));
        tfTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfTen.setForeground(new java.awt.Color(255, 255, 255));
        tfTen.setCaretColor(new java.awt.Color(255, 255, 0));
        tfTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTenKeyPressed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(51, 51, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Khóa");
        jLabel8.setOpaque(true);

        tfKhoa.setBackground(new java.awt.Color(51, 51, 255));
        tfKhoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfKhoa.setForeground(new java.awt.Color(255, 255, 255));
        tfKhoa.setCaretColor(new java.awt.Color(255, 255, 0));
        tfKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKhoaActionPerformed(evt);
            }
        });
        tfKhoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfKhoaKeyPressed(evt);
            }
        });

        import_image.setBackground(new java.awt.Color(51, 51, 255));
        import_image.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        import_image.setForeground(new java.awt.Color(255, 255, 255));
        import_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        import_image.setText("Chọn ảnh từ máy tính");
        import_image.setOpaque(true);
        import_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                import_imageMousePressed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(51, 51, 255));
        edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit.setText("Sửa thông tin");
        edit.setOpaque(true);
        edit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                editMouseMoved(evt);
            }
        });
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editMousePressed(evt);
            }
        });

        save.setBackground(new java.awt.Color(51, 51, 255));
        save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Lưu");
        save.setOpaque(true);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveMousePressed(evt);
            }
        });

        tfPhong.setEditable(false);
        tfPhong.setBackground(new java.awt.Color(51, 51, 255));
        tfPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfPhong.setForeground(new java.awt.Color(255, 255, 255));

        move.setBackground(new java.awt.Color(51, 51, 255));
        move.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        move.setForeground(new java.awt.Color(255, 255, 255));
        move.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        move.setText("Chuyển phòng");
        move.setOpaque(true);

        delete.setBackground(new java.awt.Color(51, 51, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("Xóa SV");
        delete.setOpaque(true);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteMousePressed(evt);
            }
        });

        cbKhoaVien.setBackground(new java.awt.Color(51, 51, 255));
        cbKhoaVien.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cbKhoaVien.setForeground(new java.awt.Color(51, 51, 255));
        cbKhoaVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chương trình Việt-Nhật", "Khoa Giáo dục thể chất", "Viện Cơ khí", "Viện Dệt may - Da giầy và Thời trang", "Viện Công nghệ Thông tin và Truyền thông", "Viện Kỹ thuật Hoá học", "Viện Điện", "Viện Điện tử - Viễn thông", "Khoa Giáo dục Quốc phòng", "Viện Kinh tế & Quản lý", "Viện Khoa học và Kỹ thuật Vật liệu", "Khoa Lý luận chính trị", "Viện Ngoại ngữ", "Viện Sư phạm Kỹ thuật", "Viện Toán ứng dụng và Tin học" }));
        cbKhoaVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKhoaVienItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(168, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(tfQQ, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ftfNs, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                            .addComponent(tfGT))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox_gentl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfK, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(cbKhoaVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(move, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addComponent(lbAnh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(import_image, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(212, 212, 212))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfK, tfKhoa, tfMSSV, tfQQ, tfTen});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_gentl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(ftfNs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfQQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(import_image, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(move, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(145, 145, 145))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfGT, tfK, tfKhoa, tfMSSV, tfPhong, tfQQ, tfTen});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel8, jLabel9});

    }// </editor-fold>//GEN-END:initComponents

    private void tfKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKhoaActionPerformed

    private void ftfNsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfNsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfNsActionPerformed

    private void import_imageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_import_imageMousePressed
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty(""))); //thiết lập đường dẫn mặc định là C:/Users/AnhTu/Desktop/image for java project
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(null); //showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String str = String.valueOf(selectedFile); //str là đường dẫn tới file, ví dụ:  C:\Users\AnhTu\Documents\image for java project\bejeweled3.png.  chú ý dấu \ chứ ko phải /
            
            try {
                fileInput = new FileInputStream(str);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String path = selectedFile.getAbsolutePath(); //path cũng giống hệt cái str ở trên, ví dụ:  C:\Users\AnhTu\Documents\image for java project\bejeweled3.png
            lbAnh.setIcon(ResizeImage(path));
            imagePath = path; //đường dẫn tới ảnh trong máy tính
            
            isChange = true;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Ko chọn ảnh nữa");
        }
    }//GEN-LAST:event_import_imageMousePressed

    private void editMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMousePressed
        editMode();
    }//GEN-LAST:event_editMousePressed

    private void saveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMousePressed
        if(isUpdate && getIsChange()) {
            updateSV();
            isChange = false;
        }
        if(!isUpdate) {
            addSV();
            isChange = false;
        }
        viewMode();
    }//GEN-LAST:event_saveMousePressed

    private void tfMSSVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMSSVKeyPressed
        isChange = true;
    }//GEN-LAST:event_tfMSSVKeyPressed

    private void tfTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTenKeyPressed
        isChange = true;
    }//GEN-LAST:event_tfTenKeyPressed

    private void tfGTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfGTKeyPressed
        isChange = true;
    }//GEN-LAST:event_tfGTKeyPressed

    private void tfKhoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKhoaKeyPressed
        isChange = true;
    }//GEN-LAST:event_tfKhoaKeyPressed

    private void tfKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKKeyPressed
        isChange = true;
    }//GEN-LAST:event_tfKKeyPressed

    private void tfQQKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQQKeyPressed
        isChange = true;
    }//GEN-LAST:event_tfQQKeyPressed

    private void jComboBox_gentlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_gentlMousePressed
        isChange = true;
    }//GEN-LAST:event_jComboBox_gentlMousePressed

    private void ftfNsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfNsKeyPressed
        isChange = true;
    }//GEN-LAST:event_ftfNsKeyPressed

    private void jComboBox_gentlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_gentlItemStateChanged
        isChange = true;
        tfGT.setText(jComboBox_gentl.getItemAt(jComboBox_gentl.getSelectedIndex()));
    }//GEN-LAST:event_jComboBox_gentlItemStateChanged

    private void deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMousePressed
        if(isUpdate == true) { //nghĩa là đang ở chế độ viewMode hoặc editMode
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sv này khỏi phòng trọ?", "Chú ý", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) {
                deleteSV();
            }
        }
    }//GEN-LAST:event_deleteMousePressed

    private void jFileChooser1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFileChooser1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1MousePressed

    private void editMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseMoved
        edit.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_editMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        resetBackGround();
    }//GEN-LAST:event_formMouseMoved

    private void cbKhoaVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKhoaVienItemStateChanged
        tfKhoa.setText((String) cbKhoaVien.getSelectedItem());
        isChange = true;
    }//GEN-LAST:event_cbKhoaVienItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JComboBox<String> cbKhoaVien;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    private javax.swing.JFormattedTextField ftfNs;
    private javax.swing.JLabel import_image;
    private javax.swing.JComboBox<String> jComboBox_gentl;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JLabel move;
    private javax.swing.JLabel save;
    private javax.swing.JTextField tfGT;
    private javax.swing.JTextField tfK;
    private javax.swing.JTextField tfKhoa;
    private javax.swing.JTextField tfMSSV;
    private javax.swing.JTextField tfPhong;
    private javax.swing.JTextField tfQQ;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables

    //////////getters:
    public JLabel getDelete(){
        return delete;
    }
    public JLabel getBack() {
        return back;
    }
    public JLabel getMove(){
        return move;
    }

    public JLabel getEdit() {
        return edit;
    }

    public JLabel getSave() {
        return save;
    }
    
    public JLabel getLbImage() {
        return lbAnh;
    }

    public Boolean getIsChange() {
        return isChange;
    }

    public JTextField getTfMSSV() {
        return tfMSSV;
    }

    public JTextField getTfPhong() {
        return tfPhong;
    }
    
    /////////setters:
    public void setjTextField_KhoaVien(String name) {
        this.tfKhoa.setText(" " + name);
    }

    public void setJTextfield_gioiTinh(String name) {
        this.tfGT.setText(" " + name);
    }

    public void setjTextField_k(String name) {
        this.tfK.setText(" " + name);
    }

    public void setjTextField_mssv(String name) {
        this.tfMSSV.setText(" " + name);
    }

    public void setjTextField_name(String name) {
        this.tfTen.setText(" " + name);
    }

    public void setjTextField_Phong(String name) {
        this.tfPhong.setText(" " + name);
    }

    public void setjTextField_QQ(String name) {
        this.tfQQ.setText(" " + name);
    }

    public void setjNgaySinh(String name) {
        this.ftfNs.setText(name);
    }

    public void setjComboBox(int i) {
        this.jComboBox_gentl.setSelectedIndex(i);
    }

    public void setIsChange(Boolean isChange) {
        this.isChange = isChange;
    }
}
