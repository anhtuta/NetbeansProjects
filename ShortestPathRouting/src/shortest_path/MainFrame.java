/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public final class MainFrame extends JFrame {
    Node []nodes;
    int nodeQuantites;
    static final int DISTANCE = 70;
    int [][]a;      //a là matrix chứa giá của đồ thị

    public MainFrame() {
        nodeQuantites = 10;
        nodes = new Node[nodeQuantites];
        a = new int[nodeQuantites][nodeQuantites];
        
        //int currXCoor = 0, currYCoor = 0;
        Random rd = new Random();
        for (int i = 0; i < nodeQuantites; i++) {
            int x, y, h1, h2, w1, w2;   //x, y là tọa độ nodes[i] đc tạo ngẫu nhiên; h1, h2 là 2 hàng xóm đc tạo ngẫu nhiên; w1, w2 là giá của nodes[i] tới 2 hàng xóm đó
            do {
                x = rd.nextInt(300)+50;
                y = rd.nextInt(300)+50;
            } while(!checkNode(i, x, y));
            nodes[i] = new Node(i, x, y, this);
            //String neighbors = (1+rd.nextInt(10)) + "," + (1+rd.nextInt(10)) + ",";
            //String neighbors = ((i+2) + ",");
            h1 = rd.nextInt(10);
            h2 = rd.nextInt(10);
            int []neighbors = {h1, h2};
            nodes[i].setNeighbors(neighbors);
            
            // Tạo giá ngẫu nhiên cho đồ thị. CHÚ Ý: ta thiết lập đây là đồ thị vô hướng, do đó a[i][j] = a[j][i];
            if(a[h1][i] != 0) a[i][h1] = a[h1][i];
            else {
                w1 = rd.nextInt(20) + 10;
                a[i][h1] = w1;
                a[h1][i] = w1;
            }
            if(a[h2][i] != 0) a[i][h2] = a[h2][i];
            else {
                w2 = rd.nextInt(20) + 10;
                a[i][h2] = w2;
                a[h2][i] = w2;
            }
        }
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void printA() {
        for (int i = 0; i < nodeQuantites; i++) {
            for (int j = 0; j < nodeQuantites; j++) {
                if(a[i][j]==0) System.out.print("0");
                System.out.print(a[i][j] + " ");
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
                    if(a[i][temp] != 0) g.drawString(a[i][temp]+"", (nodes[i].getX() + nodes[temp].getX())/2, (nodes[i].getY() + nodes[temp].getY())/2);
                }
            }
        }
        
        // Vẽ các node
        for (int i = 0; i < nodeQuantites; i++) {
            nodes[i].drawNode(g);
        }
        
    }
//    
//    double DISTANCE(Node a, Node b) {
//        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
//    }
//    
//    boolean checkNode(int k) {
//        if(k == 0) return true;
//        for (int i = 0; i < k; i++) {
//            if(DISTANCE(nodes[k], nodes[i]) < this.DISTANCE) return false;
//        }
//        return true;
//    }
    
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
    
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.printA();
    }
}
