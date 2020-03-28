/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
////////////
///BoxLayout(Container c, int axis): tạo một box layout mà sắp xếp các thành phần theo trục đã cho.
////////////
//các layout khác ta vừa khởi tạo JPanel, vừa set Layout cho nó được ngay theo dạng:
//[JPanel panel = new JPanel(new LayoutManager());
//Nhưng với BoxLayout chúng ta không thể làm như vậy được vì hàm khởi tạo của BoxLayout có đối chính là Container của chúng ta.
//BoxLayout(Container target, int axis): Tạo BoxLayout với cách bố trí là axis.
//Vì vậy chúng ta cần khởi tạo Container (JPanel) trước (1), sau đó khởi tạo BoxLayout (2), và cuối cùng dùng hàm setLayout để đặt Layout cho JPanel (3).
//Việc sắp xếp các đối tượng theo chiều ngang hay dọc phục thuộc vào đối số axis, X_AXIS sẽ sắp xếp theo chiều ngang, Y_AXIS là theo chiều dọc.

public class BoxLayoutDemo_2 extends JFrame {
    
    JButton[] btn;
    
    public BoxLayoutDemo_2() {
        JPanel p = new JPanel();    //(1)
        BoxLayout boxlayout = new BoxLayout(p, BoxLayout.Y_AXIS);  //(2)
        p.setLayout(boxlayout);   //(3)
        
        
        //bây giờ thêm các thành phần vào p và thêm p vào Frame
        btn = new JButton[15]; 
        for (int i = 0; i < 15; i++) {
            btn[i] = new JButton("Button "+i);
            p.add(btn[i]);
        }
        
        add(p);
        
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        new BoxLayoutDemo_2().setVisible(true);
    }
}
