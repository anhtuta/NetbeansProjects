/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back_tracking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


/**
 *
 * @author AnhTu
 */
/*
Bài này thì chuột có thể đi theo 4 hướng: lên, xuống, trái, phải (bài trước chỉ đi đc 2 hướng: đi sang phải hoặc đi xuống dưới)
cách làm bài này giống hệt bài KnightTour.java, do đó cách làm bài này và bài KnightTour.java chỉ tìm đc 1 lời giải
*/
public class RatMaze_Full2 {
    static int N;
    static int [][] sol;
    static int [][] maze;
    static int [] xMove = {-1,1,0,0};
    static int [] yMove = {0,0,-1,1};    //rat đi đc 4 hướng: đi lên(-1,0), đi xuống dướng(1,0), đi sang phải(0,-1), đi sang trái(0,1), 
    
    static Cell [][]cells;
    
    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RIGHT = 4;    //4 directions: up,down,left,right
    
    static HashMap<Integer, Cell> cellMap = new HashMap<>();
    
    private static boolean thuocTapUCV(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N && maze[x][y]==1;
    }
    
    static void ratMaze() {
        sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }
        sol[0][0] = 1;      //xuất phát từ vị trí (0,0)
        ratMazeUtil(0,0,DOWN,1);      //xuất phát từ vị trí (0,0) and go down
    }
    
    private static boolean ratMazeUtil(int x_curr, int y_curr, int direction, int numOfStep) {    //kiểm tra vị trí hiện tại có thể đi đc đến đich ko
        int nextStep = numOfStep + 1;
        if(x_curr==N-1 && y_curr==N-1) {
            sol[x_curr][y_curr] = numOfStep;
            cellMap.put(numOfStep, cells[x_curr][y_curr]);
            ghiNhan();
            return true;
        }
        
        //int x_next, y_next, i;
        if(thuocTapUCV(x_curr, y_curr))  {
            sol[x_curr][y_curr] = numOfStep;
            cellMap.put(numOfStep, cells[x_curr][y_curr]);
            
            if(direction != UP) {
                if(ratMazeUtil(x_curr+xMove[1], y_curr+yMove[1], DOWN, nextStep)) return true;
            }
            if(direction != DOWN) {
                if(ratMazeUtil(x_curr+xMove[0], y_curr+yMove[0], UP, nextStep)) return true;
            }
            if(direction != LEFT) {
                if(ratMazeUtil(x_curr+xMove[3], y_curr+yMove[3], RIGHT, nextStep)) return true;
            }
            if(direction != RIGHT) {
                if(ratMazeUtil(x_curr+xMove[2], y_curr+yMove[2], LEFT, nextStep)) return true;
            }
            sol[x_curr][y_curr] = 0;    //backtracking: từ ô hiện tại ko có bước tiếp theo nào có thể tới đc đích thì ô hiện tại ko thể đi qua đc
            cellMap.remove(numOfStep);
            return false;
        }

        return false;
    }
    
    
    static void ghiNhan() {
        //printSolution: print array sol[][]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static Cell findCell(int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(sol[i][j] == num) return cells[i][j];
            }
        }
        return null;
    }

    public static void main(String[] args) {
                
        maze = new int [][] {
            {1, 0, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 0, 1}
        };
        N = maze[0].length;
        int i,j;
        
        ////////create GUI///////////
        JFrame frame;
        JPanel panel;
    
        frame = new JFrame();
        panel = new JPanel(new BorderLayout());
        cells = new Cell[N][N];
        
        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(N, N));
        
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                cellPanel.add(cells[i][j] = new Cell());
                if(maze[i][j]==1) {
                    cells[i][j].setBackground(new java.awt.Color(51, 153, 255));
                }
            }
        }
        
        JButton btn = new JButton("Solution");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Graphics g;
                Cell c;
                int num;
                //Cách 1: khá tốn time và ko hiệu quả
//                int max = sol[N-1][N-1];
//                int i = 0;
//                while(i < max) {
//                    i++;
//                    c = findCell(i);
//                    g = c.getGraphics();
//                    g.setColor(Color.red);
//                    g.fillOval(c.getWidth()/2-10, c.getHeight()/2-10, 20, 20);
//                    try {
//                        Thread.sleep(70);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(RatMaze_Full2.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
//                }
                
                //cách 2:
                Iterator<Integer> iter = cellMap.keySet().iterator();
                while(iter.hasNext()) {
                    num = iter.next();
                    c = cellMap.get(num);
                    g = c.getGraphics();
                    g.setColor(Color.red);
                    g.fillOval(c.getWidth()/2-10, c.getHeight()/2-10, 20, 20);
                    g.setColor(Color.BLACK);
                    g.drawString(num+"", c.getWidth()/2-6, c.getHeight()/2+4);
                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RatMaze_Full2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(btn);
        
        panel.add(cellPanel, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 250);
        frame.setTitle("Rat maze");
        frame.setSize(400, 450);
        frame.setResizable(false);
        frame.setVisible(true);

        
        ///////Now solve the problem/////////
        ratMaze();
    }
}

//class Cell extends JPanel {
//    public Cell() {
//        setBorder(new LineBorder(Color.BLACK, 2));
//    }
//}