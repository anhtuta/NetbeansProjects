/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class SinhVienImage extends JFrame {
    
    JLabel lbSVImage;
    JButton btOK;
    
    public SinhVienImage() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel panelAnh = new JPanel();
        lbSVImage = new JLabel();
        lbSVImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile_bigger.png")));
        lbSVImage.setSize(new Dimension(150, 182));
        panelAnh.add(lbSVImage);
        
        JPanel panelBtn = new JPanel();
        btOK = new JButton();
        btOK.setText("OK");
        btOK.setFont(new Font("Tahoma", Font.BOLD, 15));
        btOK.setPreferredSize(new Dimension(100, 30)); //set kích thước (ngang, dọc)
        btOK.setToolTipText("Ấn OK để thoát");
        btOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        panelBtn.add(btOK);
        
        panel.add(panelAnh, BorderLayout.PAGE_START);
        panel.add(panelBtn, BorderLayout.CENTER);
        
        add(panel);
        
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ảnh 3x4 của sinh viên");
        
    }
    
    public ImageIcon ResizeImage(byte[] byteOfImage) { //hàm này lấy ảnh dạng byte[] trên database, rồi chuyển từ dạng byte[] sang dạng ImageIcon,
        //sau đó chỉnh kích cho phù hợp với lbSVImage rồi trả về kq thuộc kiểu ImageIcon
        ImageIcon MyImage = null;
        MyImage = new ImageIcon(byteOfImage);
        
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lbSVImage.getWidth(), lbSVImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public void setIconForLbSVImage(byte[] byteOfImageGotFromDatabase) {
        lbSVImage.setIcon(ResizeImage(byteOfImageGotFromDatabase));
    }
    
    public static void main(String[] args) {
        new SinhVienImage().setVisible(true);
        
    }
}
