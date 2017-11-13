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
public class RatMaze_Full {
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
        ratMazeUtil(0,0,DOWN);      //xuất phát từ vị trí (0,0) and go down
    }
    
    private static boolean ratMazeUtil(int x_curr, int y_curr, int direction) {    //kiểm tra vị trí hiện tại có thể đi đc đến đich ko
        if(x_curr==N-1 && y_curr==N-1) {
            sol[x_curr][y_curr] = 1;
            ghiNhan();
            return true;
        }
        
        //int x_next, y_next, i;
        if(thuocTapUCV(x_curr, y_curr))  {
            sol[x_curr][y_curr] = 1;
            
            if(direction != UP) {   //nếu hiện tại ko phải đang đi lên thì bước tiếp theo chắc chắn sẽ đi xuống đc 
                //(chưa chắc đã đi sang phải hoặc trái hoặc lên đc vì:
                //  - nếu direction = DOWN thì ko thể đi lên đc
                //  - nếu direction = LEFT thì ko thể đi phải đc
                //  - nếu direction = RIGHT thì ko thể đi trái đc
                //nhưng cả 3 trường hợp trên đều đi xuống đc, do đó bưới tiếp theo ta sẽ đi xuống:
                if(ratMazeUtil(x_curr+xMove[1], y_curr+yMove[1], DOWN)) return true;
            }
            if(direction != DOWN) {
                if(ratMazeUtil(x_curr+xMove[0], y_curr+yMove[0], UP)) return true;
            }
            if(direction != LEFT) {
                if(ratMazeUtil(x_curr+xMove[3], y_curr+yMove[3], RIGHT)) return true;
            }
            if(direction != RIGHT) {
                if(ratMazeUtil(x_curr+xMove[2], y_curr+yMove[2], LEFT)) return true;
            }
            sol[x_curr][y_curr] = 0;    //backtracking: từ ô hiện tại ko có bước tiếp theo nào có thể tới đc đích thì ô hiện tại ko thể đi qua đc
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
        ratMaze();
        
        ////////create GUI///////////
        JFrame frame;
        JPanel panel;
    
        frame = new JFrame();
        panel = new JPanel(new BorderLayout());
        cells = new Cell[N][N];
        
        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(N, N));
        int i,j;
        
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
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        g = cells[i][j].getGraphics();
                        g.setColor(Color.red);
                        if(sol[i][j] == 1) g.fillOval(cells[i][j].getWidth()/2-10, cells[i][j].getHeight()/2-10, 20, 20);
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
    }
}

class Cell extends JPanel {
    public Cell() {
        setBorder(new LineBorder(Color.BLACK, 2));
    }
}