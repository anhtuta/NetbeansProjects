/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnhTu
 * class này sẽ lấy dữ liệu các sv, hiển thị nó lên frame; thêm, sửa, xóa, tìm kiếm sv
 * chú ý: Input là 8 cái textfield nhé
 * 
 */
public class SinhVienFrameTheoToaNha extends javax.swing.JFrame {

    private MyConnect myConnect2 = new MyConnect();
    private boolean isUpdate = false; //kiểm tra xem người dùng đang muốn update hay add
    private boolean isClear = false; //nếu isClear = true thì mới cho phép xóa cái Input
    private Connection conn ; //thuộc tính conn dùng để kết nối tới CSDL, để các đối tượng Statemet, PreparedStatement sử dụng
    
    private final String [] itemTuongUngVoiItemDaDuocChonTrongComboBox = {"name", "MSSV", "khoaVien", "khoa", "queQuan", "Phong_tenPhong"}; //item tương ứng với item đã đc chọn trong combobox
    private String itemChoiced = "name"; //biến này xác định kiểu tìm kiếm, nếu itemChoiced = "Phong_tenPhong" thì tìm kiếm sv theo phòng trọ. mặc định ban đầu là tìm kiếm sv theo tên
    private final String [] columnName = {"MSSV", "Họ tên", "Giới tính", "Ngày sinh", "Khoa, viện", "Khóa", "Quê quán", "Phòng trọ"}; //tên các cột của bảng trên frame, chứ ko phải tên các cột trong database 
    private boolean isOk = false; //nếu isOk = true thì mới ấn đc , nếu = false thì yêu cầu người dùng phải ấn nút add hoặc update trước
    
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    private String tenToaNha = "B9";
    private final String [] tenCacPhongTrongToaNha = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    private final String [] tenCacTang = {"1","2","3","4","5"};
    private String tenPhong;
    private boolean nhapDungToaNha = false;

    public void setTenToaNha(String tenToaNha) {
        this.tenToaNha = tenToaNha;
    }

    public String getTenToaNha() {
        return tenToaNha;
    }
    
//    public SinhVienFrameTheoToaNha() {
//        initComponents();
//        showDataInTable();
//        setDisplayInput(false); //tạm thời ẩn Input đi
//        setLocationRelativeTo(null); //hiển thị frame giữa màn hình
//    }
    
    public SinhVienFrameTheoToaNha(String str) {
        this.setTenToaNha(str);
        initComponents();
        showDataInTable();
        setDisplayInput(false); //tạm thời ẩn Input đi
        setLocationRelativeTo(null); //hiển thị frame giữa màn hình
        lbTenToaNha.setText(str);
    }
    
    public ResultSet getData() { //lấy dữ liệu trên database cho vào biến rs
        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE Phong_tenPhong LIKE \"%"+tenToaNha+"%\"");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void showDataInTable() {
        //hiển thị cái tfTenToaNhaDangQuanLy để trang trí thôi. hehe
        tfTenToaNhaDangQuanLy.setFont(new java.awt.Font("Tahoma", 2, 13)); //chú ý: 2 nghĩa là Italic, 13 là kích thước font
        tfTenToaNhaDangQuanLy.setText("Chú ý: bạn chỉ được quản lý sinh viên tại tòa nhà "+tenToaNha);
        
        //lấy dữ liệu các bản ghi
        rs = getData();
        
        //sau đó hiển thị lên frame
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] column = new Object[8]; //so cot = 8
        try {
            if(rs.first() == false) JOptionPane.showMessageDialog(null, "Ko có bản ghi nào để hiển thị", "Chú ý!", JOptionPane.INFORMATION_MESSAGE);
            else { //nếu ko rỗng thì hiển thị hết 
                while(rs.next()) {  //while(rs.next()) nghĩa là cứ làm liên tục khi rs.next() = true, nghĩa là vẫn còn bản ghi tiếp theo
                    //hiển thị:
                    column[0] = rs.getInt("MSSV"); //hoặc rs.getInt(1) cũng đc, 1 là cột thứ nhất
                    column[1] = rs.getString(2);
                    column[2] = rs.getString(3);
                    column[3] = rs.getString(4);
                    column[4] = rs.getString(5);
                    column[5] = rs.getInt(6);
                    column[6] = rs.getString(7);
                    column[7] = rs.getString(8);
                    
                    model.addRow(column);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi ko hiển thị đc: "+ex.toString()+"\nKiểm tra lại cú pháp SQL trong code đi!");
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setDisplayInput(boolean display) { //hàm này thiết lập cho phép cái Input hiển thị hay ko, trong đó cái Input là 5 button và 8 trường textfield
        tfMSSV.setEnabled(display);
        tfName.setEnabled(display);
        tfNSinh.setEnabled(display);
        tfGioiTinh.setEnabled(display);
        tfKhoa.setEnabled(display);
        tfK.setEnabled(display);
        tfQQ.setEnabled(display);
        tfPhongTro.setEnabled(display); 
        isOk = display;
    }

    public void add() { //thêm 1 bản ghi = cách chèn thêm 1 bản ghi vào database sau đó hiển thị lại cái database ý

        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("INSERT INTO sinhvien VALUE(?,?,?,?,?,?,?,?);");
            //ví dụ: INSERT INTO sinhvien VALUE('21212112','anhtu','nam','199526262','dtvt',58,'hanoi','B9-201');
            pst.setInt(1, Integer.valueOf(tfMSSV.getText()));
            pst.setString(2, tfName.getText());
            pst.setString(3, tfGioiTinh.getText());
            pst.setString(4, tfNSinh.getText());
            pst.setString(5, tfKhoa.getText());
            pst.setInt(6, Integer.valueOf(tfK.getText()));
            pst.setString(7, tfQQ.getText());
            pst.setString(8, tfPhongTro.getText());

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 12; j++) {
                    tenPhong = tenToaNha + "-" + tenCacTang[i] + tenCacPhongTrongToaNha[j];
                    if (tfPhongTro.getText().trim().equals(tenPhong)) {
                        nhapDungToaNha = true;
                        break;
                    }
                }
            }

            if (nhapDungToaNha == true) {
                if (pst.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Add successful!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    isClear = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Add failed! Đã tồn tại sinh viên đó", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                    isClear = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn nhập sai tòa nhà, bạn chỉ có quyền xử lý ở tòa nhà " + tenToaNha, "Lỗi!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(java.sql.SQLIntegrityConstraintViolationException e) {
            //lỗi này là nhập trùng MSSV, khi chạy mới biết có lỗi này nên mới biết mà thêm vào đây
            JOptionPane.showMessageDialog(null, "MSSV đã tồn tại!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Add failed! Định dạng ko hợp lệ, có thể do MSSV hoặc Khóa sai định dạng, hoặc có thể Giới tính quá dài, hoặc Phòng ko tồn tại!", "Chú ý", JOptionPane.ERROR_MESSAGE);
            isClear = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Add failed! Định dạng ko hợp lệ, có thể do MSSV hoặc Khóa sai định dạng, hoặc có thể Giới tính quá dài, hoặc Phòng ko tồn tại!", "Chú ý", JOptionPane.ERROR_MESSAGE);

        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update() { //cập nhập lại sv, chú ý là thông tin sv đó phải hiện lên các textfield rồi
        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("UPDATE sinhvien SET name = ?,gioiTinh = ?,birthday = ?,khoaVien = ?,khoa = ?,queQuan = ?,Phong_tenPhong = ? WHERE MSSV = ?");
            pst.setString(1, tfName.getText());
            pst.setString(2, tfGioiTinh.getText());
            pst.setString(3, tfNSinh.getText());
            pst.setString(4, tfKhoa.getText());
            pst.setInt(5, Integer.valueOf(tfK.getText()));
            pst.setString(6, tfQQ.getText());
            pst.setString(7, tfPhongTro.getText());
            pst.setInt(8, Integer.valueOf(tfMSSV.getText()));
            
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Update successful!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                isClear = true;
            }
            else {
                //lỗi do thay đổi MSSV
                JOptionPane.showMessageDialog(null, "Bạn ko đc thay đổi MSSV, nếu muốn vậy b phải thêm 1 sinh viên", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                isClear = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "update failed!", "Có lỗi j đó! Kiểm tra lại cú pháp SQL trong code đi!", JOptionPane.ERROR_MESSAGE);
            isClear = false;
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteID(int id) {
        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("DELETE FROM sinhvien WHERE MSSV = "+id);
            if(pst.executeUpdate() > 0) System.out.println("Delete successful");
            else System.out.println("Cannot delete. sinh vien đó ko tồn tại");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi ko delete đc");
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete() { //xóa 1 bản ghi sau khi chọn bản ghi đó
        conn = myConnect2.connect();
        int row = table.getSelectedRow();
        if(row < 0) JOptionPane.showMessageDialog(null, "Bạn chưa chọn sv nào muốn xóa", "chú ý!", JOptionPane.WARNING_MESSAGE);
        else {
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ko?", "Chú ý: Xóa xong ko thể khôi phục", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) {
                String id =  String.valueOf(table.getValueAt(row, 0));
                deleteID(Integer.valueOf(id));
                refresh();
            }
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refresh() {
        //1. đầu tiên cần tạo 1 cái table model để thay đổi dữ liệu
        DefaultTableModel model = new DefaultTableModel();
        
        //2. sau đó lấy dữ liệu từ database
        rs = getData();
        try {
            //2.1. load tiêu đề các cột
            ResultSetMetaData rsMD = rs.getMetaData(); //lấy số cột và tiêu đề các cột trong bảng
            int columnNumber = rsMD.getColumnCount(); 	//lấy số lượng các cột
            String[] arr = new String[columnNumber];  //mảng chứa tiêu đề cột, cũng dùng để lấy dữ liệu từ các bản ghi
            //lấy tên của các cột
            for (int i = 0; i < columnNumber; i++) {
                //arr[i] = rsMD.getColumnName(i + 1); nếu làm ntnay thì nó lấy tên các cột trên database 
                arr[i] = columnName[i]; //lấy tên các cột trong frame
            }

            //sau đó add các tên vào 1 model
            model.setColumnIdentifiers(arr);

            //2.2. load dữ liệu lên từ database lên cái table
            while (rs.next()) { //trong khi các bản ghi vẫn còn thì làm gì đó...
                for (int i = 0; i < columnNumber; i++) {
                    arr[i] = rs.getString(i + 1); //lấy dữ liệu từ bản ghi ra 1 mảng
                }
                model.addRow(arr);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        table.setModel(model); //add cái model vào cái bảng, dữ liệu trong model chính là dữ liệu trên database
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<SinhVien> getSVList(String keyWord) {
        ArrayList<SinhVien> svList = new ArrayList<SinhVien>();
        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE "+itemChoiced+" LIKE \"%"+keyWord+"%\" AND Phong_tenPhong LIKE \"%" +tenToaNha+ "%\""); //ví dụ : SELECT * FROM sinhvien WHERE name LIKE "%tu%" (ko pb chữ hoa chữ thường)
            rs = pst.executeQuery();
            SinhVien svTemp;
            while(rs.next()) {
                svTemp = new SinhVien(rs.getInt("MSSV"), rs.getString("name"), rs.getString("gioiTinh"), rs.getString("birthday"), rs.getString("khoaVien"), rs.getInt("khoa"), rs.getString("queQuan"), rs.getString("Phong_tenPhong"));
                svList.add(svTemp);
            }
            System.out.println("Lấy danh sách sv thành công");
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lấy danh sách sv thất bại");
        }
        
        return svList;
    }
    
    public void showDataFoundInTableWhenSearching() {
        ArrayList<SinhVien> svList = getSVList(tfFind.getText().trim()); //keyWord để tifm kiếm = tfFind.getText(), keyWord này cắt dấu cách ở đầu và đuôi
        //tạo 1 model mới
        DefaultTableModel model = new DefaultTableModel(); 
        
        ///thêm tiêu đề các cột vào model trên
        String[] arr = new String[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = columnName[i]; //lấy tên các cột trong frame
        }
        model.setColumnIdentifiers(arr);

        //thêm dữ liệu vào model:
        Object [] column = new Object[8];
        for (int i = 0; i < svList.size(); i++) {
            column[0] = svList.get(i).getMSSV();
            column[1] = svList.get(i).getName();
            column[2] = svList.get(i).getGioiTinh();
            column[3] = svList.get(i).getBirthday();
            column[4] = svList.get(i).getKhoaVien();
            column[5] = svList.get(i).getKhoa();
            column[6] = svList.get(i).getQueQuan();
            column[7] = svList.get(i).getPhongTro();
            
            //add lần lượt từng hàng vào model
            model.addRow(column);
        }
        //cho cái model ở trên vào table
        table.setModel(model);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfPhongTro = new javax.swing.JTextField();
        tfMSSV = new javax.swing.JTextField();
        tfK = new javax.swing.JTextField();
        tfQQ = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfKhoa = new javax.swing.JTextField();
        tfNSinh = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        cbFind = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfGioiTinh = new javax.swing.JTextField();
        tfFind = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfTenToaNhaDangQuanLy = new javax.swing.JLabel();
        lbTenToaNha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSSV", "Họ tên", "Giới tính", "Ngày sinh", "Khoa, viện", "Khóa", "Quê quán", "Phòng trọ"
            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH SINH VIÊN Ở TÒA NHÀ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("MSSV");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Họ tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Khoa, viện");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Khóa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Quê quán");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Phòng trọ");

        btOK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        cbFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbFind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Họ tên", "MSSV", "Khoa,viện", "Khóa", "Quê quán", "Phòng trọ" }));
        cbFind.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFindItemStateChanged(evt);
            }
        });
        cbFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFindActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Giới tính");

        tfFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFindKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tìm kiếm theo:");

        lbTenToaNha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfNSinh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfMSSV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfK, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfPhongTro))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addComponent(tfKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfQQ, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfTenToaNhaDangQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbFind, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTenToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTenToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfQQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfPhongTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(tfTenToaNhaDangQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        setDisplayInput(true);
        isUpdate = false;
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        setDisplayInput(true);

        int row = table.getSelectedRow();
        if(row < 0) JOptionPane.showMessageDialog(null, "Bạn chưa chọn sv nào cần update", "chú ý!", JOptionPane.WARNING_MESSAGE);
        else {
            //hiển thị thông tin sv lên các textfield
            tfMSSV.setText(String.valueOf(table.getValueAt(row, 0)));
            tfName.setText((String) table.getValueAt(row, 1));
            tfGioiTinh.setText((String) table.getValueAt(row, 2));
            tfNSinh.setText((String) table.getValueAt(row, 3));
            tfKhoa.setText((String) table.getValueAt(row, 4));
            tfK.setText(String.valueOf(table.getValueAt(row, 5)));
            tfQQ.setText((String) table.getValueAt(row, 6));
            tfPhongTro.setText((String) table.getValueAt(row, 7));

            isUpdate = true;
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        if(isOk == false) {
            System.out.println("Bạn chưa chọn add hoặc update mà đã ấn OK");
        }
        else {
        if(isUpdate) { //nếu muốn update
            update();
            if(isClear == true) { //chú ý: if(isClear = true) là sai!
                clearInput();
                setDisplayInput(false);
            }
            //if(isClear == false) thì chờ người dùng nhập lại rồi chờ họ ấn OK
        }
        else { //nếu ko phải update thì muốn add
            add();
            if(isClear == true) {
                clearInput();
                setDisplayInput(false);
            }
            //if(isClear == false) thì chờ người dùng nhập lại rồi chờ họ ấn OK
        }
        refresh();
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        //clear Input và ẩn nó đi
        clearInput();
        setDisplayInput(false);
    }//GEN-LAST:event_btCancelActionPerformed

    private void tfFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFindKeyReleased
        showDataFoundInTableWhenSearching();
        
    }//GEN-LAST:event_tfFindKeyReleased

    private void cbFindItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFindItemStateChanged
        
    }//GEN-LAST:event_cbFindItemStateChanged

    private void cbFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFindActionPerformed
        int choice = cbFind.getSelectedIndex();
        itemChoiced = itemTuongUngVoiItemDaDuocChonTrongComboBox[choice];
    }//GEN-LAST:event_cbFindActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // = table.getSelectedColumn();
        System.out.println(evt);
    }//GEN-LAST:event_tableKeyPressed

    private void clearInput() {
        tfMSSV.setText("");
        tfName.setText("");
        tfGioiTinh.setText("");
        tfNSinh.setText("");
        tfKhoa.setText("");
        tfK.setText("");
        tfQQ.setText("");
        tfPhongTro.setText("");
    }
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
            java.util.logging.Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ///////////phần code sau chỉnh sửa giao diện giống với hệ điều hành đang dùng
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SinhVienFrameTheoToaNha.class.getName()).log(Level.SEVERE, null, ex);
                }
                ////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////
                
                new SinhVienFrameTheoToaNha("B9").setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btOK;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTenToaNha;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfFind;
    private javax.swing.JTextField tfGioiTinh;
    private javax.swing.JTextField tfK;
    private javax.swing.JTextField tfKhoa;
    private javax.swing.JTextField tfMSSV;
    private javax.swing.JTextField tfNSinh;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhongTro;
    private javax.swing.JTextField tfQQ;
    private javax.swing.JLabel tfTenToaNhaDangQuanLy;
    // End of variables declaration//GEN-END:variables
}
