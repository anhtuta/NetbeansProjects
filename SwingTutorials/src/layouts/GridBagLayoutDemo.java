/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */

//chú ý: quy tắc hiển thị giống excel: nghĩa là theo dạng lưới
//muốn thêm 1 btn tại ô (2,3) ta làm như sau: (chú ý ko phải tọa độ tại (2,3) mà btn tại ô giao nhau giữa hàng 2 và cột 3 của bảng excel, nghĩa là ô C3 trong excel) 
//gbc.gridx = 2;
//gbc.gridy = 3;
//p.add(btn, gbc);
public class GridBagLayoutDemo extends JFrame {
    
    JButton b1,b2,b3,b4,b5;
    GridBagConstraints gbc = new GridBagConstraints();
    
    public GridBagLayoutDemo() {
        JPanel p = new JPanel(new GridBagLayout());
        
        gbc.insets = new Insets(7, 7, 7, 7); //hở trên, trái, dưới, phải = 7,7,7,7 
        b1 = new JButton("Button 1");
        gbc.gridx = 0;
        gbc.gridy = 0; //vị trí ở hàng 0, cột 0 trong lưới
        gbc.gridheight = 5; //b1 sẽ chiếm 5 vị trí theo chiều dọc,
        gbc.fill = GridBagConstraints.VERTICAL; //duỗi thẳng b1 ra theo chiều dài của vị trí nó chiếm
        p.add(b1, gbc);
        
        b2 = new JButton("Button 2");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1; //định nghĩa lại vì ở trên đã cho nó = 4, mà ta chỉ muốn thằng b1 chiếm 4 chỗ, còn những đứa sau nó chiếm 1 thôi
        p.add(b2, gbc);
        
        b3 = new JButton("Button 3");
        gbc.gridx = 2;
        gbc.gridy = 2;
        p.add(b3, gbc);
        
        b4 = new JButton("Button 4");
        gbc.gridx = 3;
        gbc.gridy = 3;
        p.add(b4, gbc);
        
        b5 = new JButton("Button 5");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3; //b5 sẽ ở 1 vị trí có độ rộng = tổng độ rộng của 2 bt, nhưng kích thước của b5 ko thay đổi
        gbc.fill = GridBagConstraints.HORIZONTAL;
        p.add(b5, gbc);
        
        
        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new GridBagLayoutDemo();
    }
}
