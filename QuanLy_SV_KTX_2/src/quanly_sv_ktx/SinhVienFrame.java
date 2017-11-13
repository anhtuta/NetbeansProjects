/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.Color;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import javax.swing.filechooser.FileNameExtensionFilter;

public class SinhVienFrame extends javax.swing.JFrame {

    private final MyConnect myConnect2 = new MyConnect();
    private boolean isUpdate = false; //kiểm tra xem người dùng đang muốn update hay add
    private boolean isClear = false; //nếu isClear = true thì mới cho phép xóa cái Input
    private Connection conn; 
    
    private final String [] itemTuongUngVoiItemChonTrongCb = {"name", "MSSV", "khoaVien", "khoa", "queQuan", "Phong_tenPhong", "Tất cả"}; //item tương ứng với item đã đc chọn trong combobox
    private String itemChoiced = "name"; //biến này xác định kiểu tìm kiếm, nếu itemChoiced = "Phong_tenPhong" thì tìm kiếm sv theo phòng trọ. mặc định ban đầu là tìm kiếm sv theo tên
    private final String [] columnName = {"MSSV", "Họ tên", "Giới tính", "Ngày sinh", "Khoa, viện", "Khóa", "Quê quán", "Phòng trọ"}; //tên các cột của bảng trên frame, chứ ko phải tên các cột trong database 
    private final String[] sapXepTheo = {"MSSV", "name", "gioiTinh", "birthday","khoaVien","Khoa","queQuan","Phong_tenPhong"}; //tên các cột trên database
    private String sapXepTheoWhat = "MSSV";
    private boolean isOk = false; //nếu isOk = true thì mới ấn đc , nếu = false thì yêu cầu người dùng phải ấn nút add hoặc update trước
    byte [] image = null;
    FileInputStream fileInput;
    String imagePath;
    String khoavien = "Chương trình Việt-Nhật";
    String [] contentOfCBKhoaVien = {"Chương trình Việt-Nhật",
        "Khoa Giáo dục thể chất",
        "Viện Cơ khí",
        "Viện Dệt may - Da giầy và Thời trang",
        "Viện Công nghệ Thông tin và Truyền thông",
        "Viện Kỹ thuật Hoá học",
        "Viện Điện",
        "Viện Điện tử - Viễn thông",
        "Khoa Giáo dục Quốc phòng",
        "Viện Kinh tế & Quản lý",
        "Viện Khoa học và Kỹ thuật Vật liệu",
        "Khoa Lý luận chính trị",
        "Viện Ngoại ngữ",
        "Viện Sư phạm Kỹ thuật",
        "Viện Toán ứng dụng và Tin học"};
    String [] gioiTinhSelected = {"Nam", "Nữ", "Gay", "Lesbian"};
    boolean isDeletedImage = false;
    String rbGioiTinh;
    boolean inCoTable = false;
    String itemToaNha = "B6";
    String itemPhong = "101"; //default value
    String phongCu;
    String phongMoi;
    
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Statement st;
    
    PhongTroFrame ptf = new PhongTroFrame();
    
    public SinhVienFrame() {
        initComponents();
        showDataInTable(sapXepTheoWhat);
        setDisplayInput(false);
        setLocationRelativeTo(null);
        setTitle("Danh sách sinh viên");
        
        //hiển thị thời gian lên đầu table:
        showCurrentDate();
    }
    
    public ResultSet getData(String what) { //lấy dữ liệu trên database cho vào biến rs, dữ liệu này đc sắp xếp theo what
        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("SELECT * FROM sinhvien ORDER BY "+what);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void showDataInTable(String what2) { //hiển thị và sắp xếp dữ liệu theo what2
        //sẽ tạo mới 1 model sau đó thêm vào table để mỗi lần add, update thì dùng hàm này để refresh cái table luôn
        DefaultTableModel model = new DefaultTableModel();
        rs = getData(what2);
        String [] arr = new String[8];  //8 = số cột trong database cần hiển thị lên table
        
        model.setColumnIdentifiers(columnName);  //đặt tên các cột
        
        try {
            while(rs.next()) {
                for (int i = 0; i < 8; i++) {
                    arr[i] = rs.getString(i+1);
                }
                model.addRow(arr);         //thếm các hàng
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setModel(model);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDisplayInput(boolean display) { //hàm này thiết lập cho phép cái Input hiển thị hay ko, trong đó cái Input là 5 button và 8 trường textfield và btTaiAnhLen, btXoaAnh
        tfMSSV.setEnabled(display);
        tfName.setEnabled(display);
        Formatted_tfNSinh.setEnabled(display);
        cbKhoaVien.setEnabled(display);
        tfK.setEnabled(display);
        tfQQ.setEnabled(display);
        tfPhongTro.setEnabled(display); 
        btTaiAnhLen.setEnabled(display);
        btXoaAnh.setEnabled(display);
        
        rbNam.setEnabled(display);
        rbNu.setEnabled(display);
        rbGay.setEnabled(display);
        rbLes.setEnabled(display);
        
        cbToaNha.setEnabled(display);
        cbPhong.setEnabled(display);
        
        isOk = display; //cho phép hiển thị Input thì ấn OK mới có tác dụng
    }

    public void add() { //thêm 1 bản ghi = cách chèn thêm 1 bản ghi vào database sau đó hiển thị lại cái database ý
        conn = myConnect2.connect();
        String phong = tfPhongTro.getText();
        int sl = 0;
        try {
            sl = ptf.getSoLuongChoTrong(phong);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sl == 0) {
            JOptionPane.showMessageDialog(null, "Phòng này hết chỗ trống rồi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {

        try {
            pst = conn.prepareStatement("INSERT INTO sinhvien VALUE(?,?,?,?,?,?,?,?,?);");
            //ví dụ: INSERT INTO sinhvien VALUE('21212112','anhtu','nam','199526262','dtvt',58,'hanoi','B9-201',null);
            pst.setInt(1, Integer.valueOf(tfMSSV.getText()));
            pst.setString(2, tfName.getText());
            pst.setString(3, rbGioiTinh);
            pst.setString(4, Formatted_tfNSinh.getText());
            khoavien = String.valueOf(cbKhoaVien.getSelectedItem());
            pst.setString(5, khoavien);
            pst.setInt(6, Integer.valueOf(tfK.getText()));
            pst.setString(7, tfQQ.getText());
            pst.setString(8, tfPhongTro.getText());
            fileInput = new FileInputStream(imagePath);
            pst.setBinaryStream(9, fileInput); //thêm ảnh lấy từ fileInput, bên SinhVienInfo dùng hàm này ko đc, phải dùng pst.setBlob(9, fileInput); mới đc. đếch hiểu!
            
            if(pst.executeUpdate()> 0) {
                JOptionPane.showMessageDialog(null, "Add successful!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                if(fileInput != null) System.out.println("fileInput ở dạng String là: "+fileInput.toString());
                else JOptionPane.showMessageDialog(null, "Bạn chưa thêm ảnh cho sv vừa thêm, bạn có thể cập nhập ảnh sau", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                isClear = true;
                imagePath = null;
                ptf.updateSoLuongChoTrong(phong, (--sl));
            }
            else {
                JOptionPane.showMessageDialog(null, "Add failed! Đã tồn tại sinh viên đó", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                isClear = false;
            }
        } catch(java.sql.SQLIntegrityConstraintViolationException e) {
            //lỗi này là nhập trùng MSSV
            JOptionPane.showMessageDialog(null, "MSSV đã tồn tại!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Add failed! Định dạng ko hợp lệ, có thể do MSSV hoặc Khóa sai định dạng, hoặc có thể Giới tính quá dài, hoặc Phòng ko tồn tại!", "Chú ý", JOptionPane.ERROR_MESSAGE);
            isClear = false;
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            if (imagePath != null) {
                pst = conn.prepareStatement("UPDATE sinhvien SET name = ?,gioiTinh = ?,birthday = ?,khoaVien = ?,khoa = ?,queQuan = ?,Phong_tenPhong = ?,anh = ? WHERE MSSV = ?");
                pst.setString(1, tfName.getText());
                pst.setString(2, rbGioiTinh);
                pst.setString(3, Formatted_tfNSinh.getText());
                pst.setString(4, String.valueOf(cbKhoaVien.getSelectedItem()));
                pst.setInt(5, Integer.valueOf(tfK.getText()));
                pst.setString(6, tfQQ.getText());
                pst.setString(7, tfPhongTro.getText());
                fileInput = new FileInputStream(imagePath);  //imagePath là đường dẫn tới ảnh ở máy tính muốn tải lên database để update. đường dẫn này đã lấy đc khi ta ấn nút btTaiAnhLen
                pst.setBlob(8, fileInput); //hoặc : pst.setBinaryStream(8, fileInput); giống như hàm add()
                pst.setInt(9, Integer.valueOf(tfMSSV.getText()));
                
            }
            
            else //nếu imagePath == null: 
            //trường hợp 1: ko tải ảnh từ máy lên lbAnh, tức là ko muốn thay đổi ảnh, thì sẽ ko update ảnh trên database nữa
            //trường hợp 2: có ảnh rồi nhưng muốn xóa ảnh đi
            //tóm lại có 2 trường hợp trên thôi!
            if (!isDeletedImage) {  //trường hợp 1:
                pst = conn.prepareStatement("UPDATE sinhvien SET name = ?,gioiTinh = ?,birthday = ?,khoaVien = ?,khoa = ?,queQuan = ?,Phong_tenPhong = ? WHERE MSSV = ?");
                pst.setString(1, tfName.getText());
                pst.setString(2, rbGioiTinh);
                pst.setString(3, Formatted_tfNSinh.getText());
                pst.setString(4, String.valueOf(cbKhoaVien.getSelectedItem()));
                pst.setInt(5, Integer.valueOf(tfK.getText()));
                pst.setString(6, tfQQ.getText());
                pst.setString(7, tfPhongTro.getText());
                pst.setInt(8, Integer.valueOf(tfMSSV.getText()));

                System.out.println("Bạn đã ko thay đổi ảnh.");
            }
            
            else { //trường hợp 2:
                pst = conn.prepareStatement("UPDATE sinhvien SET name = ?,gioiTinh = ?,birthday = ?,khoaVien = ?,khoa = ?,queQuan = ?,Phong_tenPhong = ?,anh = null WHERE MSSV = ?");
                pst.setString(1, tfName.getText());
                pst.setString(2, rbGioiTinh);
                pst.setString(3, Formatted_tfNSinh.getText());
                pst.setString(4, String.valueOf(cbKhoaVien.getSelectedItem()));
                pst.setInt(5, Integer.valueOf(tfK.getText()));
                pst.setString(6, tfQQ.getText());
                pst.setString(7, tfPhongTro.getText());
                pst.setInt(8, Integer.valueOf(tfMSSV.getText()));
                
                //ko thể dùng: pst.setBlob(9, null); vì nó báo lỗi mập mờ!
                //cũng ko thể dùng: pst.setBinaryStream(9, null);  vì: ko hiểu sao!
                System.out.println("Bạn đã xóa ảnh.");
            }
            
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Update successful!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                isClear = true;
                imagePath = null;
            }
            else {
                //lỗi do thay đổi MSSV
                JOptionPane.showMessageDialog(null, "Bạn ko đc thay đổi MSSV, nếu muốn vậy b phải thêm 1 sinh viên", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                isClear = false;
            }
        } catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation e) {
            JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh!\nHãy nhập theo định dạng: YYYY-MM-DD");
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nhập sai định dạng!", "update failed!", JOptionPane.ERROR_MESSAGE);
            isClear = false;
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
                try {
                    String id = String.valueOf(table.getValueAt(row, 0));
                    deleteID(Integer.valueOf(id));
                    //update empty slot
                    String phong = tfPhongTro.getText();
                    int sl = ptf.getSoLuongChoTrong(phong);
                    ptf.updateSoLuongChoTrong(phong, ++sl);
                    //refresh data
                    showDataInTable(sapXepTheoWhat);
                    JOptionPane.showMessageDialog(null, "Xóa thành công!", "chú ý", JOptionPane.INFORMATION_MESSAGE);
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            }
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<SinhVien> getSVList(String keyWord, String what) {
        conn = myConnect2.connect();
        
        ArrayList<SinhVien> svList = new ArrayList<SinhVien>();
       

        if(itemChoiced.equals("Tất cả")) {  //tìm kiếm trên tất cả các trường
            try {
//                pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE MSSV LIKE \"%"+keyWord+"%\" "
//                        + "OR name LIKE \"%"+keyWord+"%\" "
//                        + "OR gioiTinh LIKE \"%"+keyWord+"%\" "
//                        + "OR birthday LIKE \"%"+keyWord+"%\" "
//                        + "OR khoaVien LIKE \"%"+keyWord+"%\" "
//                        + "OR khoa LIKE \"%"+keyWord+"%\" "
//                        + "OR queQuan LIKE \"%"+keyWord+"%\" "
//                        + "OR Phong_tenPhong LIKE \"%"+keyWord+"%\" ORDER BY " +what);

                //cách trên dễ bị lỗi, nên làm cách dưới đây:
                pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE CONCAT(`MSSV`, `name`, `gioiTinh`, `khoaVien`, `queQuan`, `Phong_tenPhong`) LIKE \"%"+keyWord+"%\"");
                rs = pst.executeQuery();
                SinhVien svTemp;
                while (rs.next()) {
                    svTemp = new SinhVien(rs.getInt("MSSV"), rs.getString("name"), rs.getString("gioiTinh"), rs.getString("birthday"), rs.getString("khoaVien"), rs.getInt("khoa"), rs.getString("queQuan"), rs.getString("Phong_tenPhong"));
                    svList.add(svTemp);
                }
            System.out.println("Đang tìm kiếm sv: Lấy danh sách sv thành công");
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi hệ thống! Bạn ko nên gõ dấu nếu chọn tìm kiếm theo \"Tất cả\" \nLỗi: java.sql.SQLException: Illegal mix of collations for operation 'LIKE'", "Chú ý!", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        else {
            try {
                pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE " + itemChoiced + " LIKE \"%" + keyWord + "%\" ORDER BY " + what); //ví dụ : SELECT * FROM sinhvien WHERE name LIKE "%tu%" ORDER BY queQuan; //(ko pb chữ hoa chữ thường)
                rs = pst.executeQuery();
                SinhVien svTemp;
                while (rs.next()) {
                    svTemp = new SinhVien(rs.getInt("MSSV"), rs.getString("name"), rs.getString("gioiTinh"), rs.getString("birthday"), rs.getString("khoaVien"), rs.getInt("khoa"), rs.getString("queQuan"), rs.getString("Phong_tenPhong"));
                    svList.add(svTemp);
                }
                System.out.println("Đang tìm kiếm sv: Lấy danh sách sv thành công");
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Lấy danh sách sv thất bại");
            }
        }
        
        
        return svList;
    }
    
    public void showDataFoundInTableWhenSearching(String what) { //hiển thị dssv khi tìm kiếm, dssv này sắp xếp theo what
        ArrayList<SinhVien> svList = getSVList(tfFind.getText().trim(), what); //keyWord để tifm kiếm = tfFind.getText(), keyWord này cắt dấu cách ở đầu và đuôi
        //tạo 1 model mới
        DefaultTableModel model = new DefaultTableModel(); 
        
        model.setColumnIdentifiers(columnName);  ///thêm tiêu đề các cột vào model trên

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
            
            //thử in ra màn hình
            //System.out.println(column[0] +", "+ column[1] + ", "+ column[2] + ", "+ column[3] + ", "+ column[4] + ", "+ column[5] + ", "+ column[6] + ", "+ column[7]); //thử thành công

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
    
    
    //Methode To Resize The ImageIcon To Fit Into lbAnh, trả về 1 biến có kiểu icon (ImageIcon), chứ ko phải là ảnh (Image) nhé
    //hàm này dành cho việc chỉnh kích thước của ảnh được tải lên table từ máy tính do đó tham số của hàm là đường dẫn tới file ảnh trong máy tính
    public ImageIcon ResizeImage(String imagePath){  //imagePath = đường dẫn đến file ảnh
        ImageIcon imageIcon1 = new ImageIcon(imagePath);  //lấy icon trong đường dẫn vừa rồi
        Image img = imageIcon1.getImage();   //lấy ảnh trong cái icon vừa rồi
        Image newImage = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(),Image.SCALE_SMOOTH);  //để ảnh hiển thị khớp với kích thước của lbAnh và co dãn đúng kích cỡ
        ImageIcon imageIcon2 = new ImageIcon(newImage);  //lấy cái ảnh trên làm icon
        return imageIcon2;
    }
    
    // Function To Resize The Image To Fit Into lbAnh
    //hàm này dành cho việc chỉnh kích thước của ảnh được tải lên table từ database do đó tham số của hàm là ảnh dưới dạng byte
    public ImageIcon ResizeImage(byte[] byteOfImage) {
        ImageIcon MyImage;
        MyImage = new ImageIcon(byteOfImage);
        
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newImg);
        //System.out.println("Byte of image is: "+Arrays.toString(byteOfImage)); //cái byteOfImage là dạng byte của ảnh, có thể xem trên database, nó rất dài!
        return imageIcon;
    }
    
    public void printDSSVWithoutTable() {
        //lấy các bản ghi để in:
        rs = getData("MSSV");  //Nếu viết: ResultSet rs = getData("MSSV"); thì LỆNH NÀY TẠO MỚI 1 ĐỐI TƯỢNG ResultSet. 
        //Nếu dùng lệnh này: rs = getData("MSSV"); thì cái rs này chính là thuộc tính rs khai báo ở đầu class
        String [] arr = new String[8];
        Boolean isFileEmpty = false;
        //mở hộp thoại để chọn file để in vào file đó:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("docx", "doc", "txt");
        fileChooser.addChoosableFileFilter(filter);
        
        //ghi các bản ghi vào file:
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            //kiểm tra file trống hay ko:
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                if (line == null) {
                    isFileEmpty = true;
                }
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                //Nếu ko tìm thấy file tức là muốn tạo 1 file mới để lưu. khi đó máy sẽ tự động tạo 1 file mới, ta ko phải quan tâm :v
                System.out.println("tạo file mới");
                isFileEmpty = true;
            } catch (IOException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (isFileEmpty == false) {
                int choice = JOptionPane.showConfirmDialog(null, "File này có dữ liệu. Bạn có muốn ghi đè lên ko?", "Chú ý", JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    try (PrintWriter outFile = new PrintWriter(file)) {
                        outFile.printf("%-9s %-20s %-7s %-12s %-42s %-2s %-12s %-7s", columnName[0], columnName[1], columnName[2], columnName[3], columnName[4], columnName[5], columnName[6], columnName[7]);  //in tiêu đề cột trước
                        outFile.println(); //xuống dòng
//xuống dòng
                        while (rs.next()) {
                            for (int i = 0; i < 8; i++) {
                                arr[i] = rs.getString(i + 1);
                            }
                            outFile.printf("%-9s %-20s %-9s %-12s %-42s %-4s %-12s %-7s", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                            outFile.println(); //xuống dòng
                        }
                        //nếu ko close thì ko ghi vào file đc. CHÚ Ý!

                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "In thành công, vào đường dẫn: " + file + " để xem kết quả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                try (PrintWriter outFile = new PrintWriter(file)) {
                    outFile.printf("%-9s %-20s %-7s %-12s %-42s %-2s %-12s %-7s", columnName[0], columnName[1], columnName[2], columnName[3], columnName[4], columnName[5], columnName[6], columnName[7]);  //in tiêu đề cột trước
                    outFile.println(); //xuống dòng
//xuống dòng
                    while (rs.next()) {
                        for (int i = 0; i < 8; i++) {
                            arr[i] = rs.getString(i + 1);
                        }
                        outFile.printf("%-9s %-20s %-9s %-12s %-42s %-4s %-12s %-7s", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                        outFile.println(); //xuống dòng
                    }
                    //nếu ko close thì ko ghi vào file đc. CHÚ Ý!

                } catch (IOException | SQLException ex) {
                    Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "In thành công, mở " + file + " để xem kết quả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    public void printDSSVWithTable() {
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            table.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cannot print: "+ex.getMessage());
        }
    }
    
    public void showInfoSVIntoInput() {
        if(isUpdate) setDisplayInput(false);  //đang update mà chọn sv khác thì hủy update sv trước đó
        
        int r = table.getSelectedRow();
        //CHÚ Ý: hàng và cột đầu tiên đều có chỉ số = 0
        
        //hiển thị thông tin sv lên Input
        tfMSSV.setText(String.valueOf(table.getValueAt(r, 0)));
        tfName.setText(String.valueOf(table.getValueAt(r, 1)));
        Formatted_tfNSinh.setText((String) table.getValueAt(r, 3));
        
        for (int i = 0; i < contentOfCBKhoaVien.length; i++) {
            if(String.valueOf(table.getValueAt(r, 4)).equals(contentOfCBKhoaVien[i])) 
                cbKhoaVien.setSelectedIndex(i);
        }
        
        tfK.setText(String.valueOf(table.getValueAt(r, 5)));
        //thử thay đổi màu:
        String khoa = String.valueOf(table.getValueAt(r, 5));
        int k = Integer.valueOf(khoa);
        if(k <= 58) tfK.setBackground(Color.GREEN);
        else tfK.setBackground(Color.YELLOW);
        
        tfQQ.setText((String) table.getValueAt(r, 6));
        tfPhongTro.setText((String) table.getValueAt(r, 7));
        cbKhoaVien.setSelectedItem(r);
        
        //hiển thị lên các radioButton
        if(table.getValueAt(r, 2).equals("Nam")) rbNam.setSelected(true);
        if(table.getValueAt(r, 2).equals("Nữ")) rbNu.setSelected(true);
        if(table.getValueAt(r, 2).equals("Gay")) rbGay.setSelected(true);
        if(table.getValueAt(r, 2).equals("Lesbian")) rbLes.setSelected(true);
        
        
        //hiển thị ảnh sv lên lbAnh:
        conn = myConnect2.connect();
        try {
            pst = conn.prepareStatement("SELECT * FROM sinhvien WHERE MSSV = " + table.getValueAt(r, 0));
            rs = pst.executeQuery();
            if(rs.next()) {
                byte[] byteImage = rs.getBytes("anh"); //lấy byte của ảnh của sinh viên
                if(byteImage!=null) { //nếu như sv đó đã có ảnh
                    lbAnh.setIcon(ResizeImage(byteImage));  //thiết lập icon cho lbAnh
                } else {
                    lbAnh.setIcon(new ImageIcon(getClass().getResource("/images/profile.png")));
                    System.out.println("Sinh viên đang chọn chưa có ảnh");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public final void showCurrentDate() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        lbDate.setText("Ngày: "+day+"/"+(month+1)+"/"+year);
        
        int sec = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        lbTime.setText("Giờ: "+hour+":"+minute+":"+sec);
    }
    
    private void clearInput() {
        tfMSSV.setText("");
        tfName.setText("");
        Formatted_tfNSinh.setText("");
        //cbKhoaVien: ko set gì cả!
        tfK.setText("");
        tfQQ.setText("");
        tfPhongTro.setText("");
        rbGioiTinh = null;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfMSSV = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Formatted_tfNSinh = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cbKhoaVien = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfK = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfQQ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfPhongTro = new javax.swing.JTextField();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        rbLes = new javax.swing.JRadioButton();
        rbGay = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        btXemAnh = new javax.swing.JButton();
        lbAnh = new javax.swing.JLabel();
        btTaiAnhLen = new javax.swing.JButton();
        btXoaAnh = new javax.swing.JButton();
        cbToaNha = new javax.swing.JComboBox<>();
        cbPhong = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbFind = new javax.swing.JComboBox<>();
        tfFind = new javax.swing.JTextField();
        cbSapXep = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbIn = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH SINH VIÊN Ở KÍ TÚC XÁ");

        btAdd.setBackground(new java.awt.Color(0, 204, 51));
        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setForeground(new java.awt.Color(0, 153, 0));
        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Add-icon.png"))); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setBackground(new java.awt.Color(255, 153, 51));
        btUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(255, 153, 0));
        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-validated-icon.png"))); // NOI18N
        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(204, 0, 51));
        btDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 0, 0));
        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Actions-window-close-icon.png"))); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(0, 51, 204));
        btCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancel.setForeground(new java.awt.Color(102, 102, 255));
        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel-your-last-action-icons-54526_2.png"))); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btOK.setBackground(new java.awt.Color(102, 255, 0));
        btOK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btOK.setForeground(new java.awt.Color(102, 204, 0));
        btOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Accept-icon (2).png"))); // NOI18N
        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("MSSV");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Họ tên");

        tfMSSV.setBackground(new java.awt.Color(153, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ngày sinh");

        try {
            Formatted_tfNSinh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Formatted_tfNSinh.setToolTipText("nhập theo định dạng: YYYY-MM-dd");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Khoa, viện");

        cbKhoaVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chương trình Việt-Nhật", "Khoa Giáo dục thể chất", "Viện Cơ khí", "Viện Dệt may - Da giầy và Thời trang", "Viện Công nghệ Thông tin và Truyền thông", "Viện Kỹ thuật Hoá học", "Viện Điện", "Viện Điện tử - Viễn thông", "Khoa Giáo dục Quốc phòng", "Viện Kinh tế & Quản lý", "Viện Khoa học và Kỹ thuật Vật liệu", "Khoa Lý luận chính trị", "Viện Ngoại ngữ", "Viện Sư phạm Kỹ thuật", "Viện Toán ứng dụng và Tin học" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Khóa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Quê quán");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Phòng trọ");

        buttonGroup1.add(rbNam);
        rbNam.setText("Nam");
        rbNam.setFocusPainted(false);
        rbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNu);
        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbLes);
        rbLes.setText("Lesbian");
        rbLes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbGay);
        rbGay.setText("Gay");
        rbGay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGayActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Giới tính");

        btXemAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btXemAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Images-icon.png"))); // NOI18N
        btXemAnh.setText("Xem ảnh");
        btXemAnh.setToolTipText("Xem ảnh với kích thước to hơn :)");
        btXemAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXemAnhActionPerformed(evt);
            }
        });

        lbAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N
        lbAnh.setToolTipText("ảnh 3x4");

        btTaiAnhLen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btTaiAnhLen.setText("Tải ảnh lên");
        btTaiAnhLen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaiAnhLenActionPerformed(evt);
            }
        });

        btXoaAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btXoaAnh.setForeground(new java.awt.Color(255, 0, 0));
        btXoaAnh.setText("Xóa ảnh");
        btXoaAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaAnhActionPerformed(evt);
            }
        });

        cbToaNha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbToaNha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B6", "B8", "B9", "B10" }));
        cbToaNha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbToaNhaItemStateChanged(evt);
            }
        });
        cbToaNha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbToaNhaMouseClicked(evt);
            }
        });
        cbToaNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbToaNhaActionPerformed(evt);
            }
        });

        cbPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413" }));
        cbPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPhongItemStateChanged(evt);
            }
        });
        cbPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPhongMouseClicked(evt);
            }
        });
        cbPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfK, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbNam)
                                            .addComponent(rbGay))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbNu)
                                            .addComponent(rbLes)))
                                    .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMSSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfQQ, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfPhongTro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(tfName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Formatted_tfNSinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btXoaAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTaiAnhLen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAnh))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXemAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUpdate))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Formatted_tfNSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rbNam)
                            .addComponent(rbNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbGay)
                            .addComponent(rbLes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(tfQQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfPhongTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btXemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)))
                            .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btTaiAnhLen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btXoaAnh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin sv", jPanel2);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tìm kiếm theo:");

        cbFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbFind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Họ tên", "MSSV", "Khoa,viện", "Khóa", "Quê quán", "Phòng trọ", "Tất cả" }));
        cbFind.setToolTipText("Nếu chọn \"Tất cả\" thì sẽ tìm kiếm sv theo cả 6 thuộc tính bên trên");
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

        tfFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFindKeyReleased(evt);
            }
        });

        cbSapXep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MSSV", "Họ tên", "Giới tính", "Ngày sinh", "Khoa,viện", "Khóa", "Quê quán", "Phòng trọ" }));
        cbSapXep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSapXepItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Sắp xếp theo:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("In DSSV");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print-icon.png"))); // NOI18N
        jButton1.setText("In");
        jButton1.setToolTipText("(CHÚ Ý: nên chọn file có đuôi .txt)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ko có table", "Có table" }));
        cbIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbIn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFind, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSapXep, 0, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbIn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel13))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tìm kiếm, sắp xếp, in", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        if(rbNam.isSelected()) rbGioiTinh = "Nam";
        if(rbNu.isSelected()) rbGioiTinh = "Nữ";
        if(rbGay.isSelected()) rbGioiTinh = "Gay";
        if(rbLes.isSelected()) rbGioiTinh = "Lesbian";
        //phải có 4 lệnh trên, khi update hoặc add thì dù ta chưa chọn cá rb nào nhưng 1 cái vẫn đc chọn do lần chọn trước đó
        //và ta ko cần chọn lại nữa
        //nếu ko có 4 lệnh đó: khi ấn update, nếu giả sử rbNam đã đc chọn trước đó, nếu ta ko chọn lại rbNam mà ấn OK thì rbGioiTinh vẫn mang giá trị null
        
        //xóa ảnh ở lbAnh
        Icon iconDefault = new ImageIcon(getClass().getResource("/images/profile.png"));
        lbAnh.setIcon(iconDefault);
        
        //Hiển thị cái Input lên và ko cho phép update
        setDisplayInput(true);
        isUpdate = false;
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        delete();
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        int r = table.getSelectedRow();
        if(r<0) JOptionPane.showMessageDialog(null, "Bạn chưa chọn sv nào cần update", "Chú ý", JOptionPane.WARNING_MESSAGE);
        else {
            phongCu = tfPhongTro.getText();
            if(rbNam.isSelected()) rbGioiTinh = "Nam";
            if(rbNu.isSelected()) rbGioiTinh = "Nữ";
            if(rbGay.isSelected()) rbGioiTinh = "Gay";
            if(rbLes.isSelected()) rbGioiTinh = "Lesbian";
            //phải có 4 lệnh trên, khi update hoặc add thì dù ta chưa chọn cá rb nào nhưng 1 cái vẫn đc chọn do lần chọn trước đó
            //và ta ko cần chọn lại nữa
            //nếu ko có 4 lệnh đó: khi ấn update, nếu giả sử rbNam đã đc chọn trước đó, nếu ta ko chọn lại rbNam mà ấn OK thì rbGioiTinh vẫn mang giá trị null

            //tfPhongTro.setText(itemToaNha + "-" + itemPhong);
            setDisplayInput(true);

            //cho phép update
            isUpdate = true;

            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        if(isOk == false) {
            System.out.println("Bạn chưa chọn add hoặc update mà đã ấn OK");
        }
        else {
            try {
                phongMoi = tfPhongTro.getText();
                int slCu = ptf.getSoLuongChoTrong(phongCu);
                int slMoi = ptf.getSoLuongChoTrong(phongMoi);
                
                if (isUpdate) { //nếu muốn update
                    if(!phongMoi.equals(phongCu)) {  //nếu muốn chuyển phòng:
                        if (slMoi == 0) {
                            JOptionPane.showMessageDialog(null, "Phòng muốn chuyển đến đã đầy!");
                        }
                        else {
                            update();
                            if (isClear == true) { //chú ý: if(isClear = true) là sai!
                                clearInput();
                                setDisplayInput(false);
                            }
                            ptf.updateSoLuongChoTrong(phongCu, ++slCu);
                            ptf.updateSoLuongChoTrong(phongMoi, --slMoi);
                        }
                    }
                    else { //nếu ko muốn chuyển phòng:
                        update();
                        if (isClear == true) { //chú ý: if(isClear = true) là sai!
                            clearInput();
                            setDisplayInput(false);
                        }
                    }
                    
                    //if(isClear == false) thì chờ người dùng nhập lại rồi chờ họ ấn OK.
                    //giả sử như họ nhập sai 1 lỗi nhỏ rồi bấm OK, ta ko nên xóa tất thông tin trong Input vì họ lại mất công nhập lại
                } else { //nếu ko phải update thì muốn add
                    add();
                    if (isClear == true) {
                        clearInput();
                        setDisplayInput(false);
                    }
                    ptf.updateSoLuongChoTrong(phongMoi, --slMoi);
                }
                showDataInTable(sapXepTheoWhat);
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        //clear Input và ẩn nó đi
        clearInput();
        setDisplayInput(false);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCancelActionPerformed

    private void tfFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFindKeyReleased
        showDataFoundInTableWhenSearching(sapXepTheoWhat);
    }//GEN-LAST:event_tfFindKeyReleased

    private void cbFindItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFindItemStateChanged
        int choice = cbFind.getSelectedIndex();
        itemChoiced = itemTuongUngVoiItemChonTrongCb[choice];
        //chú ý: 2 lệnh này viết ở đây hoặc ở hàm cbFindActionPerformed ngay bên dưới cũng đc
    }//GEN-LAST:event_cbFindItemStateChanged

    private void cbFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFindActionPerformed
//        int choice = cbFind.getSelectedIndex();
//        itemChoiced = itemTuongUngVoiItemChonTrongCb[choice];
//        hàm cbFindItemStateChanged đã thực hiện rồi!
    }//GEN-LAST:event_cbFindActionPerformed

    private void cbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSapXepItemStateChanged
        int choice = cbSapXep.getSelectedIndex();
        System.out.println(choice);
        sapXepTheoWhat = sapXepTheo[choice];
        System.out.println("sapXepTheoWhat = "+sapXepTheoWhat) ;
        showDataInTable(sapXepTheoWhat);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSapXepItemStateChanged

    private void btTaiAnhLenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaiAnhLenActionPerformed
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
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Ko chọn ảnh nữa");
        }
    }//GEN-LAST:event_btTaiAnhLenActionPerformed

    private void btXoaAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaAnhActionPerformed
        Icon iconDefault;
        iconDefault = new ImageIcon(getClass().getResource("/images/profile.png"));
        String iconDefaultString = iconDefault.toString();
        String lbAnhString = lbAnh.getIcon().toString();
        if(lbAnhString.equals(iconDefaultString))  {  //lúc này iconDefaultString = lbAnhString = /D:/Documents/NetBeansProjects/QuanLy_SV_KTX_2/build/classes/images/profile.png
            JOptionPane.showMessageDialog(null, "Ko có ảnh nảo để xóa!");
            
        }
        else {
            
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "Chú ý!", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) {
                lbAnh.setIcon(iconDefault);
                isDeletedImage = true;
            }
            else if(choice == JOptionPane.NO_OPTION) {
                String lbAnhStringCurrent = lbAnh.getIcon().toString();
                System.out.println("Ảnh trên lbAnh khi chuyển sang String là: " + lbAnhStringCurrent); //ví dụ: lbAnhStringCurrent = javax.swing.ImageIcon@29fbcbbc
                isDeletedImage = false;
            }
        }
    }//GEN-LAST:event_btXoaAnhActionPerformed

    private void btXemAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXemAnhActionPerformed
        //hiển thị frame SinhVienImage, sau đó thiết lập icon cho lbSVImage của frame đấy
        //lấy dữ liệu từ daatabase để thiết lập icon
        SinhVienImage svImg = new SinhVienImage();
        //svImg.setVisible(false);
        int r = table.getSelectedRow();
        if(r == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sv nào để xem ảnh", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            conn = myConnect2.connect();
            try {
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM sinhvien WHERE MSSV = " + String.valueOf(table.getValueAt(r, 0)));
                if (rs.next()) {
                    byte[] byteOfImg = rs.getBytes("anh");
                    if (byteOfImg != null) {
                        svImg.setVisible(true);
                        svImg.setIconForLbSVImage(byteOfImg);
                        //System.out.println("byte of image is: " + Arrays.toString(byteOfImg));
                    } else {
                        JOptionPane.showMessageDialog(null, "Sinh viên này chưa có ảnh\nBạn có thể ấn Update để cập nhập ảnh cho sv này", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                } else {
                    System.out.println("error");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btXemAnhActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if(table.getSelectedRow() >= 0) showInfoSVIntoInput(); //chú ý là phải >= 0 vì hàng đầu tiên = 0, nếu chỉ có > 0 thì khi chọn hàng đầu tiên sẽ ko hiển thị
    }//GEN-LAST:event_tableMouseClicked

    private void rbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNamActionPerformed
//        buttonGroup1.setSelected((ButtonModel) rbNam, true);
//        System.out.println(buttonGroup1.getSelection());
//        thử searcg google cách làm với buttonGroup1 xem
        //làm = cách khác: 
        rbGioiTinh = "Nam";
    }//GEN-LAST:event_rbNamActionPerformed

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        rbGioiTinh = "Nữ";
    }//GEN-LAST:event_rbNuActionPerformed

    private void rbGayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGayActionPerformed
        rbGioiTinh = "Gay";
    }//GEN-LAST:event_rbGayActionPerformed

    private void rbLesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLesActionPerformed
        rbGioiTinh = "Lesbian";
    }//GEN-LAST:event_rbLesActionPerformed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        //tương tự như chức năng tableMouseClicked
        if((evt.getKeyCode()==38)||(evt.getKeyCode()==40)) showInfoSVIntoInput(); //38 và 40 là keycode của 2 phím lên và xuống. muốn biết code của 1 phím bất kì là gì thì thử lệnh: System.out.println(evt.getKeyCode());
        //hoặc cách khác: if((evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)) showInfoSVIntoInput();
    }//GEN-LAST:event_tableKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(inCoTable) printDSSVWithTable();
        else printDSSVWithoutTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInActionPerformed
        int choice = cbIn.getSelectedIndex();
        if(choice == 1) inCoTable = true;
        else inCoTable = false;
    }//GEN-LAST:event_cbInActionPerformed

    private void cbToaNhaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbToaNhaItemStateChanged
        itemToaNha = cbToaNha.getSelectedItem().toString();
        itemPhong = cbPhong.getSelectedItem().toString();
        tfPhongTro.setText(itemToaNha + "-" + itemPhong);
        
    }//GEN-LAST:event_cbToaNhaItemStateChanged

    private void cbPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPhongItemStateChanged
        //do the same thing with cbToaNhaItemStateChanged above
        itemToaNha = cbToaNha.getSelectedItem().toString();
        itemPhong = cbPhong.getSelectedItem().toString();
        tfPhongTro.setText(itemToaNha + "-" + itemPhong);
    }//GEN-LAST:event_cbPhongItemStateChanged

    private void cbToaNhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbToaNhaMouseClicked
        tfPhongTro.setText(itemToaNha + "-" + itemPhong);
    }//GEN-LAST:event_cbToaNhaMouseClicked

    private void cbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPhongMouseClicked
        tfPhongTro.setText(itemToaNha + "-" + itemPhong);
    }//GEN-LAST:event_cbPhongMouseClicked

    private void cbToaNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbToaNhaActionPerformed
        itemToaNha = (String) cbToaNha.getSelectedItem();
    }//GEN-LAST:event_cbToaNhaActionPerformed

    private void cbPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPhongActionPerformed
        itemPhong = (String) cbPhong.getSelectedItem();
    }//GEN-LAST:event_cbPhongActionPerformed

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
            java.util.logging.Logger.getLogger(SinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                ///////////phần code sau chỉnh sửa giao diện giống với hệ điều hành đang dùng
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////
                
                new SinhVienFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Formatted_tfNSinh;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btOK;
    private javax.swing.JButton btTaiAnhLen;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btXemAnh;
    private javax.swing.JButton btXoaAnh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbFind;
    private javax.swing.JComboBox<String> cbIn;
    private javax.swing.JComboBox<String> cbKhoaVien;
    private javax.swing.JComboBox<String> cbPhong;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JComboBox<String> cbToaNha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTime;
    private javax.swing.JRadioButton rbGay;
    private javax.swing.JRadioButton rbLes;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfFind;
    private javax.swing.JTextField tfK;
    private javax.swing.JTextField tfMSSV;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhongTro;
    private javax.swing.JTextField tfQQ;
    // End of variables declaration//GEN-END:variables
}
