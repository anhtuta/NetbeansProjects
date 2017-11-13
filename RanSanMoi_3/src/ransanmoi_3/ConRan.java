/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransanmoi_3;

import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class ConRan {
    private int doDai = 3;
    public int []x;
    public int []y;
    
    public final int GO_UP = 1;
    public final int GO_DOWN = -1;
    public final int GO_LEFT = 2;
    public final int GO_RIGHT = -2;
    
    private int vector = GO_RIGHT;
    int speed;
    
    private long t = 0;
    
    private ArrayList<User> users;
    private final int MAX_USER = 7;
    
    boolean daNhapTen = false;
    
    public ConRan() {
        x = new int[200];
        y = new int[200];
        
        x[0] = 5; y[0] = 4; //đầu của con rắn
        x[1] = 4; y[1] = 4;
        x[2] = 3; y[2] = 4;
    }

    public void setVector(int v) {
        if(vector != -v) {
            this.vector = v;
        }
    }
    
    public void veRan(Graphics g) {
        //g.setColor(Color.RED);
        int i;
        for (i=0; i<doDai; i++) {
            //if(i==0) g.setColor(Color.GREEN);
            //else g.setColor(Color.RED);
            //g.fillRect(x[i]*20 + GameScreen.padding, y[i]*20 + GameScreen.padding, 18, 18);
            //vẽ thân rắn:
            if(i!=0) g.drawImage(Data.imageBody, x[i]*20 + GameScreen.padding, y[i]*20 + GameScreen.padding, null);
            
            //vẽ đầu rắn:
            if(i==0) {
                //g.drawImage(Data.imageHead, x[i]*20-5 + GameScreen.padding, y[i]*20-5 + GameScreen.padding, null);
                
                if(vector==GO_UP) g.drawImage(Data.headGoUp.getCurrImage(), x[0]*20-5 + GameScreen.padding, y[0]*20-5 + GameScreen.padding, null);
                if(vector==GO_DOWN) g.drawImage(Data.headGoDown.getCurrImage(), x[0]*20-5 + GameScreen.padding, y[0]*20-5  + GameScreen.padding, null);
                if(vector==GO_LEFT) g.drawImage(Data.headGoLeft.getCurrImage(), x[0]*20-5 + GameScreen.padding, y[0]*20-5 + GameScreen.padding, null);
                if(vector==GO_RIGHT) g.drawImage(Data.headGoRight.getCurrImage(), x[0]*20-5 + GameScreen.padding, y[0]*20-5 + GameScreen.padding, null);
                
            }
        }
    }
    
    public void update() {
        speed = 300/GameScreen.currLevel;
        
        //when you die: the snake's head go through its body
        int i;
        for (i = doDai-1; i > 0; i--) {
            if((x[0] == x[i] && y[0]==y[i]) || GameScreen.bg[x[0]] [y[0]] == GameScreen.WALL) {
                System.out.println("Game over!");
                GameScreen.isPlaying = false;
                
                GameScreen.isReadyForNewGameAfterGameOver = false;
                GameScreen.isGameOver = true;
                
                readData();
                int j;
                int k;
                for (j = 0; j < MAX_USER; j++) {
                    try {
                        if ((GameScreen.diem > Integer.valueOf(users.get(j).getScore())) && !daNhapTen) {
                            String input = "";

                            do {
                                if (j == 0) input = JOptionPane.showInputDialog(null, "Enter your name:", "Best score ever!", JOptionPane.INFORMATION_MESSAGE);
                                else input = JOptionPane.showInputDialog(null, "Enter your name:", "High score!", JOptionPane.INFORMATION_MESSAGE);

                                if (input.equals("")) JOptionPane.showMessageDialog(null, "Name can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                            } while (input.equals(""));

                            for (k = MAX_USER - 1; k > j; k--) {
                                users.get(k).setScore(users.get(k - 1).getScore());
                                users.get(k).setName(users.get(k - 1).getName());
                            }
                            users.get(j).setScore(String.valueOf(GameScreen.diem));
                            users.get(j).setName(input);

                            updateData();
                            daNhapTen = true;
                            break;
                        }
                    } catch (java.lang.NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "didn't save high score");
                        daNhapTen = true;
                        break;
                    }
                }
            }
            
//            if(GameScreen.bg[x[0]] [y[0]] == GameScreen.WALL) {
//                System.out.println("Rắn đâm vào tường: Game over!");
//                GameScreen.isPlaying = false;
//                
//                GameScreen.isReadyForNewGameAfterGameOver = false;
//                GameScreen.isGameOver = true;
//                
//                readData();
//                int j;
//                int k;
//                for (j = 0; j < MAX_USER; j++) {
//                    try {
//                        if (GameScreen.diem > Integer.valueOf(users.get(j).getScore())) {
//                            String input = "";
//
//                            do {
//                                if (j == 0) input = JOptionPane.showInputDialog(null, "Enter your name:", "Best score ever!", JOptionPane.INFORMATION_MESSAGE);
//                                else input = JOptionPane.showInputDialog(null, "Enter your name:", "High score!", JOptionPane.INFORMATION_MESSAGE);
//
//                                if (input.equals("")) JOptionPane.showMessageDialog(null, "Name can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
//                            } while (input.equals(""));
//
//                            for (k = MAX_USER - 1; k > j; k--) {
//                                users.get(k).setScore(users.get(k - 1).getScore());
//                                users.get(k).setName(users.get(k - 1).getName());
//                            }
//                            users.get(j).setScore(String.valueOf(GameScreen.diem));
//                            users.get(j).setName(input);
//
//                            updateData();
//                            break;
//                        }
//                    } catch (java.lang.NullPointerException e) {
//                        JOptionPane.showMessageDialog(null, "didn't save high score");
//                        break;
//                    }
//                }
//            }
        }
        
        //code to run the snake:
        if(System.currentTimeMillis() - t > speed) {
            
            //create animation for snake's head:
            Data.headGoUp.update();
            Data.headGoDown.update();
            Data.headGoLeft.update();
            Data.headGoRight.update();
            
            //code to create new lure after the snake eating the old lure:
            if (GameScreen.bg[x[0]][y[0]] == GameScreen.LURE) {
                doDai++;
                //create a new lure:
                GameScreen.bg[x[0]][y[0]] = 0;
                GameScreen.bg[getLuresCoordinates().x][getLuresCoordinates().y] = GameScreen.LURE;
                GameScreen.diem += 100*GameScreen.currLevel;
            }
            
            //move the snake's body:
            for (i = (doDai - 1); i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            
            //CHÚ Ý: VIẾT NHƯ SAU THÌ KO CHẠY ĐC, MẤT 2 TIẾNG MỚI TÌM ĐC LỖI SAI NÀY:
//            for (i = 1; i < doDai; i++) {
//                x[i] = x[i-1];
//                y[i] = y[i-1];
//            }
            
            //control the snake's direction:
            if(vector == GO_UP) y[0]--;
            if(vector == GO_DOWN) y[0]++;
            if(vector == GO_LEFT) x[0]--;
            if(vector == GO_RIGHT) x[0]++;
            
            if(x[0] < 0) x[0] = 19; //=20-1, với 20 là kích thước của lưới, nghĩa là lưới có 20 ô theo chiều ngang và dọc
            if(x[0] > 19) x[0] = 0;
            if(y[0] < 0) y[0] = 19;
            if(y[0] > 19) y[0] = 0;
            
            t = System.currentTimeMillis();
        }
    }
    
    public boolean isLuresCoordInSnakesBody(int x1, int y1) { //kiểm tra tọa độ (x1, y1) có nằm trong thân con rắn ko
        boolean b = false;
        for (int i = 0; i < doDai; i++) {
            if((x[i]==x1) && (y[i]==y1)) {
                b = true; break;
            }
        }
        return b;
    }
    
    public Point getLuresCoordinates() { //lấy tọa độ con mồi
        int x1,y1;
        Random rd = new Random();
        do {
            x1 = rd.nextInt(19); //vì kích thước background tối đa là 20 ô, nên chỉ cho phép các số từ 0-19
            y1 = rd.nextInt(19);
        } while (isLuresCoordInSnakesBody(x1, y1) || (GameScreen.bg[x1][y1] == 1));
        
        return new Point(x1, y1);
    }
    
    public void resetGame() {
        doDai = 3;
        vector = GO_RIGHT;
        GameScreen.currLevel = Integer.parseInt(RanSanMoi_3.cbLevel.getSelectedItem().toString());
        x = new int[200];
        y = new int[200];
        
        x[0] = 5; y[0] = 4; //đầu của con rắn
        x[1] = 4; y[1] = 4;
        x[2] = 3; y[2] = 4;
    }
    
    public String readData() {
        StringBuilder data = new StringBuilder();
        users = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/data.txt"));
            String line =  br.readLine();
            
            while(line != null) {
                String [] str = line.split("-");
                users.add(new User(str[0].trim(), str[1].trim()));
                
                data.append(line); data.append("\n");
                line = br.readLine();
                
            }
            
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConRan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConRan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return String.valueOf(data);
    }
    
    public void updateData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/data.txt"));
            PrintWriter pw = new PrintWriter(bw);
            
            for (int i = 0; i < MAX_USER; i++) {
                pw.println(users.get(i).getName() + " - " + users.get(i).getScore());
            }
            
            pw.close();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(ConRan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
