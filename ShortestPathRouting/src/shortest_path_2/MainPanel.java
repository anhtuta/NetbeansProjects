/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_2;

import shortest_path.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author AnhTu
 */
public final class MainPanel extends JPanel {
    Node []nodes;
    int nodeQuantites;
    static final int DISTANCE = 70;
    int [][]w;      //w là matrix chứa giá của đồ thị
    String [] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"};

    public MainPanel() {
        nodeQuantites = 5;
        nodes = new Node[nodeQuantites];
        w = new int[nodeQuantites][nodeQuantites];
        
        //int currXCoor = 0, currYCoor = 0;
        Random rd = new Random();
        for (int i = 0; i < nodeQuantites; i++) {
            int x, y, h1, h2, w1, w2;   //x, y là tọa độ nodes[i] đc tạo ngẫu nhiên; h1, h2 là 2 hàng xóm đc tạo ngẫu nhiên; w1, w2 là giá của nodes[i] tới 2 hàng xóm đó
            do {
                x = rd.nextInt(300)+50;
                y = rd.nextInt(300)+50;
            } while(!checkNode(i, x, y));
            nodes[i] = new Node(i, x, y, this);
            nodes[i].setName(names[i]);
            //String neighbors = (1+rd.nextInt(10)) + "," + (1+rd.nextInt(10)) + ",";
            //String neighbors = ((i+2) + ",");
            h1 = rd.nextInt(nodeQuantites);
            h2 = rd.nextInt(nodeQuantites);
            int []neighbors = {h1, h2};
            nodes[i].setNeighbors(neighbors);
            
            // Tạo giá ngẫu nhiên cho đồ thị. CHÚ Ý: ta thiết lập đây là đồ thị vô hướng, do đó w[i][j] = w[j][i];
            if(i == h1) w[i][h1] = w[h1][i] = 0;
            else {
                if(w[h1][i] != 0) w[i][h1] = w[h1][i];
                else {
                    w1 = rd.nextInt(20) + 10;
                    w[i][h1] = w1;
                    w[h1][i] = w1;
                }
            }
            
            if(i == h2) w[i][h2] = w[h2][i] = 0;
            else {
                if(w[h2][i] != 0) w[i][h2] = w[h2][i];
                else {
                    w2 = rd.nextInt(20) + 10;
                    w[i][h2] = w2;
                    w[h2][i] = w2;
                }
            }
        }
        this.setSize(400, 400);
        setBorder(new LineBorder(Color.GREEN, 2));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void printA() {
        for (int i = 0; i < nodeQuantites; i++) {
            for (int j = 0; j < nodeQuantites; j++) {
                if(w[i][j]==0) System.out.print("0");
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        // Vẽ các đường nối các node trước
        g.setColor(Color.red);
        for (int i = 0; i < nodeQuantites; i++) {
            // Nối nodes[i] với từng hàng xóng của nó
            for (int j = 0; j < nodes[i].getNeighbors().length; j++) {
                int temp = nodes[i].getNeighbors()[j];
                // CHÚ Ý: temp(chứ ko phải j) mới là index của node hàng xóm của nodes[i]
                if(i != temp) {
                    g.drawLine(nodes[i].getX(), nodes[i].getY(), nodes[temp].getX(), nodes[temp].getY());
                    
                    // Vẽ các giá
                    if(w[i][temp] != 0) g.drawString(w[i][temp]+"", (nodes[i].getX() + nodes[temp].getX())/2, (nodes[i].getY() + nodes[temp].getY())/2);
                }
            }
        }
        
        // Vẽ các node
        for (int i = 0; i < nodeQuantites; i++) {
            nodes[i].drawNode(g);
        }
    }
    
    public void myPaint() {
        Graphics g = this.getGraphics();
        g.setColor(Color.BLACK);
        g.drawString("hello", 100, 100);
    }
    
    public void paintShortestPath() {
        Graphics g = this.getGraphics();
        g.setColor(Color.BLUE);
        for (int i = 0; i < nodeQuantites; i++) {
            int temp = nodes[i].getNeighbors()[0];
            if(i != temp) {
                g.drawLine(nodes[i].getX(), nodes[i].getY(), nodes[temp].getX(), nodes[temp].getY());
            }
            
        }
        
        // Vẽ lại các node, để đường đi ko đè lên các node
        g.setColor(Color.WHITE);
        for (int i = 0; i < nodeQuantites; i++) {
            nodes[i].drawNode(g);
        }
    }

    double distance(Node a, int x, int y) {
        return Math.sqrt(Math.pow(a.getX() - x, 2) + Math.pow(a.getY() - y, 2));
    }
    
    boolean checkNode(int k, int x, int y) {
        if(k == 0) return true;
        for (int i = 0; i < k; i++) {
            if(distance(nodes[i], x, y) < DISTANCE) return false;
        }
        return true;
    }
    
    /**
     * Đầu vào: Đồ thị G=(V,E), n đỉnh, s = đỉnh nguồn, matrix trọng số = w
     * Đầu ra: Với mỗi đỉnh v, ta thu đc:
     *  - d[v] = khoảng cách ngắn nhất từ s -> v
     *  - p[v] = parent[v] trong ĐĐNN từ s -> v, nghĩa là: s -> a -> b -> ... -> p[v] -> v
     */
    public void Dijkstra() {
        int []d = new int[nodeQuantites];
        int []p = new int[nodeQuantites];
        
        int s = 0;  // source node
        for (int i = 0; i < nodeQuantites; i++) {
            d[i] = (w[s][i] > 0 ? w[s][i] : Integer.MAX_VALUE);
            p[i] = s;
        }
        
        d[s] = 0;
                
    }
}
