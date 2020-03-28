/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class ButtonDemo extends JFrame implements ActionListener {
    
    private JLabel lb;  //hoặc private JLabel lb = new JLabel(); cũng đc
    private JButton button1, btn2, btn3, btn4;
    
    public ButtonDemo() {      //hàm khởi tạo 
        this.setSize(400, 250); //chieu dai = 200, chieu rong = 150
        setLocation(500, 300);
        setResizable(false);   //nếu setResizable(false);  thì ko thể thay đổi kích thước của frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lb = new JLabel("Anh tu");   //lb = label
        lb.setSize(20, 50);
        add(lb); //add lb vào frame và cho hiển thị
        
        ///////////////////tạo button1////////////////
        button1 = new JButton("Hit me");  //tên của button1 hiển thị trên frame là Hit me
        add(button1, "North", 1); //add button lên frame và điểu chỉnh vị trí button  
        button1.addActionListener(this);  //tạo action cho button1
        
        btn2 = new JButton("change text again!");
        add(btn2, "South", 1);
        ///tạo action cho btn2
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //do something for btn2
                lb.setText("Viet Nam Champion!");
            }
        });
        ////////////xong 2 button/////////////
        //nhận xét: khi thêm 1 button mới phải thực hiện các bước trên hơi dài nên ta dùng cách implement cái ActionListener như ở phần đầu của class
        
        /////thêm 2 button nữa luyện tập////////////
        btn3 = new  JButton("hit me third time!");
        add(btn3, "West", 1); 
        btn3.addActionListener(this); //tạo action chi tiết ở dưới nhé. đỡ phải dài dòng
         
        btn4 = new JButton("Lan thu 4");
        add(btn4, "East", 1); 
        btn4.addActionListener(this);
    }
      

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();  //casting hay ép kiểu về JButton
        if(b == button1) lb.setText("thu 5 ngay 28-9-16");
        else if(b==btn3) lb.setText("tao la ta anh tu");
        else if(b==btn4) lb.setText("di ngu di the la du roi");
    }
    
    public static void main(String[] args) {
        ButtonDemo buttondemo = new ButtonDemo();
        buttondemo.setVisible(true);
    }
}
