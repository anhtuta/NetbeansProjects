/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class ConRan {
    private int doDai = 3;
    private int [] x; int [] y; //tọa độ của rắn
    private long t = 0; //, t2 = 0;
    
    public static int GO_UP = 1;
    static int GO_DOWN = -1;
    static int GO_LEFT = 2;
    static int GO_RIGHT = -2;
    
    private int vector = ConRan.GO_DOWN; //vector là chiều di chuyển của rắn
    
    int currImage = 0;
    int speed = 200; //speed càng nhỏ thì rắn chạy càng nhanh
    int maxLeng = 10;
    boolean updateAfterChangeVt = true;
    
    public ConRan() {
        x = new int[20];
        y = new int[20]; //do dai toi da = 20
        
        x[0] = 5; y[0] = 4; //đầu của con rắn
        x[1] = 5; y[1] = 3;
        x[2] = 5; y[2] = 2;
        
    }

    public void setVector(int v) {
        if(vector != -v && updateAfterChangeVt) {
            this.vector = v;
            updateAfterChangeVt = false;
        }
    }
    
    public void veRan(Graphics g1) {
        //g1.setColor(Color.red);
        for (int i = 0; i < doDai; i++) { //vẽ từng ô vuông, các ô xếp lại thành hình con rắn
            //vẽ thân rắn:
            //g1.fillRect(x[i]*20+5, y[i]*20+5, 18, 18); //lần lượt là tọa độ và kích thước, với 5 là khoảng hở giữa lưới và frame (theo chiều ngang và dọc)
            g1.drawImage(Data.imageBody, x[i]*20+5 + GameScreen.padding, y[i]*20+5 + GameScreen.padding, null);
            
            //vẽ đầu rắn:
            if(vector == GO_UP) g1.drawImage(Data.headGoUp.getCurrImage(), (x[0]*20+5) - 6 + GameScreen.padding, (y[0]*20+5) - 6 + GameScreen.padding, null);
            else if(vector == GO_DOWN) g1.drawImage(Data.headGoDown.getCurrImage(), (x[0]*20+5) - 6 + GameScreen.padding, (y[0]*20+5) - 6 + GameScreen.padding, null); 
            else if(vector == GO_LEFT) g1.drawImage(Data.headGoLeft.getCurrImage(), (x[0]*20+5) - 6 + GameScreen.padding, (y[0]*20+5) - 6 + GameScreen.padding, null); 
            else if(vector == GO_RIGHT) g1.drawImage(Data.headGoRight.getCurrImage(), (x[0]*20+5) - 6 + GameScreen.padding, (y[0]*20+5) - 6 + GameScreen.padding, null); 
            
        }
    }
    
    public void update() {
//        if(System.currentTimeMillis() - t2 > 200) {  //tạo tốc độ thay đổi animation cho mồm rắn
//            Data.headGoUp.update();
//            Data.headGoDown.update();
//            Data.headGoLeft.update();
//            Data.headGoRight.update();
//            
//        }
        if(doDai == maxLeng) {
            GameScreen.isPlaying = false;
            resetGame();
            //speed = (int) (speed*0.8);
            GameScreen.currLevel++;
            maxLeng += 5;
            speed = getCurrSpeed();
        }

        for (int i = 1; i < doDai; i++) {
            if(x[0]==x[i] && y[0]==y[i]) {
                System.out.println("Game over!");
                GameScreen.isPlaying = false;
                GameScreen.isGameOver = true;

                GameScreen.diem = 0;
                GameScreen.currLevel = 1;
            }
        }
        
        if(System.currentTimeMillis() - t > speed) {
            
            updateAfterChangeVt = true;
            Data.headGoUp.update();
            Data.headGoDown.update();
            Data.headGoLeft.update();
            Data.headGoRight.update();
            
            if(GameScreen.bg[x[0]][y[0]] == 2) {
                doDai++;
                GameScreen.bg[x[0]][y[0]] = 0;
                GameScreen.bg[layToaDoConMoi().x][layToaDoConMoi().y] = 2; //chú ý x,y là tọa độ của hàm layToaDoConMoi(), chứ ko phải thuộc tính x,y khai báo đầu class
                GameScreen.diem += 100;
            }
            for (int i = (doDai - 1); i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            
            if(vector == ConRan.GO_UP) y[0]--;
            if(vector == ConRan.GO_DOWN) y[0]++;
            if(vector == ConRan.GO_LEFT) x[0]--;
            if(vector == ConRan.GO_RIGHT) x[0]++;
            
            if(x[0] < 0) x[0] = 19; //=20-1, với 20 là kích thước của lưới, vì kích thước của lưới là 20x20
            if(x[0] > 19) x[0] = 0;
            if(y[0] < 0) y[0] = 19;
            if(y[0] > 19) y[0] = 0;
            
            t = System.currentTimeMillis();
        }
        
    }
    
    public boolean toaDoNamTrongThanRan(int x1, int y1) {
        boolean b = false;
        for (int i = 0; i < doDai; i++) {
            b = (x[i] == x1) && (y[i] == y1); //nghĩa là: if((x[i] == x1) && (y[i] == y1)) b = true;
        }
        return b;
    }
    
    public Point layToaDoConMoi() {
        int x_coord,y_coord;
        Random r = new Random();
        do {
            x_coord = r.nextInt(19);
            y_coord = r.nextInt(19);
        } while (toaDoNamTrongThanRan(x_coord, y_coord));
        return new Point(x_coord, y_coord);
    }
    
    
    public void resetGame() { //làm giống như khởi tạo 1 con rắn mới
        x = new int[20];
        y = new int[20]; //do dai toi da = 20
        
        x[0] = 5; y[0] = 4; //đầu của con rắn
        x[1] = 5; y[1] = 3;
        x[2] = 5; y[2] = 2;
        
        doDai = 3;
        vector = ConRan.GO_DOWN;
    }
    
    public int getCurrSpeed() {
        int sp = 200;
        for (int i = 0; i < GameScreen.currLevel; i++) {
            sp *= 0.8;
        }
        return sp;
    }
}
