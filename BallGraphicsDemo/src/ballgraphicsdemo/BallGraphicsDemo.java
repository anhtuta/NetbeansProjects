/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballgraphicsdemo;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class BallGraphicsDemo extends JFrame implements Runnable, MouseMotionListener, MouseListener {

    private Thread thread;
    int x;
    Ball ball;
    
    public static double Gravity = 0.2; //trọng lượng
    public static double Fc = -0.02; //sức cản theo trục x
    
    public BallGraphicsDemo() {
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ball = new Ball(100, 100);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        thread = new Thread(this);
        thread.start();
        
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        super.paint(g); //phải gọi lại phương thức cha trước khi override hàm paint()
        //g.drawRect(40, 40, 50, 50); //vẽ 1 hình chữ nhật ở tọa độ (40,40)
        ball.paintBall(g);
        
    }
    
    public static void main(String[] args) {
        new BallGraphicsDemo();
    }
    
    public void update() {
//        x++;
//        System.out.println(""+x);
        ball.Update();
        repaint(); //vẽ lại quả bóng ở vị trí mới vì sau khi gọi ball.Update() y đã thay đổi
        
    }

    @Override
    public void run() {
        
        while(true) {
            update();
            System.out.println("ball is dropping");
            try {
                thread.sleep(20); //hoac viet: sleep(200) cung dc
            } catch (InterruptedException ex) {
                Logger.getLogger(BallGraphicsDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        ball.setPoint(me.getX(), me.getY());
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX(); 
        y1 = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        x2 = me.getX();
        y2 = me.getY();
        
        //thiết lập lực tác động vào quả bóng
        ball.setVX((x2 - x1)/10);
        ball.setVY((y2 - y1)/10);
    }
    
    double x1, y1, x2, y2;
    
    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}

class Ball {
    private double x,y;
    private double vX = 0;
    private double vY = 0; //độ tăng tung độ của quả bóng để cho nó rơi
    private int timeLoopAfterColy = 5; //số vòng lặp sau khi va chạm
    private int timeLoopAfterColx = 5; //số vòng lặp sau khi va chạm
   
    
    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void setVX(double v) {
        vX = v;
    }
    
    public void setVY(double v) {
        vY = v;
    }
    
    public void paintBall(Graphics g) {
        g.drawRect((int)x, (int)y, 1, 1);
        g.drawOval((int)x - 30, (int)y - 30, 60, 60); //chiều dài chiều rộng của hình elip = 60,60 (tức là hình tròn)
        //tọa độ tâm là (x-chiều dài/2, y-chiều rộng/2) = (x-60/2, y-60/2) như vậy tâm mới ở chính giữa hình elip
        
    }
    
    public void setPoint(double x1, double y1) { //set tọa độ của ball
        x = x1; y = y1;
    }
    
    public void Update(){ //hàm này tạo 1 môi trường vật lý
        //chú ý coi như độ cao = 600, 2 vách tường cách nhau 600
        //nói cách khác: coi như quả bóng ở trong 1 cái hộp 600x600
        
        //kiểm tra xem chạm đất hay ko
        if (timeLoopAfterColy <= 0) vY += BallGraphicsDemo.Gravity;
        
        y = y + vY; //cho quả bóng rơi.
        
        if (timeLoopAfterColy <= 0) {
            if (y + 30 >= 600) { //y chỉ là tâm, phần 30 là vành của hình tròn
                vY = -(vY) / 1.4; //khi bóng chạm đất thì cho nó nảy lên
                timeLoopAfterColy = 5;  
            }
        } else timeLoopAfterColy--;
        //ban đầu timeLoopAfterCol = 5, bóng cứ rơi, sau 5 vòng lặp nó mới kiểm tra if (y + 30 >= 600), nếu thỏa mãn thì nó đổi chiểu rơi, thực sự để thỏa mãn thì phải sau rất nhiều vòng lặp nữa
        //và sau khi đổi chiều rơi, sau 5 vòng lặp tiếp nó mới kiểm tra if (y + 30 >= 600)
        //nếu thỏa mãn nó lại đổi chiều rơi...
        
        
        //kiểm tra xem bóng có chạm tường hay ko
        if (timeLoopAfterColx <= 0 && vX > 0)  vX += BallGraphicsDemo.Fc;
        
        x = x + vX; //cho quả bóng bật từ bên này sang bên kia
        
        if (timeLoopAfterColx <= 0) {
            if (x + 30 >= 600 || x-30 <= 0) { //y chỉ là tâm, phần 30 là vành của hình tròn
                vX = -(vX) / 1.4; //khi bóng chạm đất thì cho nó nảy lên
                timeLoopAfterColx = 5;
            }
        } else timeLoopAfterColx--;
        
        System.out.println(timeLoopAfterColx + ", " + timeLoopAfterColy);
    }
    
}
