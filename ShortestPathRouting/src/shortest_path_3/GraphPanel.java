/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author AnhTu
 */
public final class GraphPanel extends JPanel {
    Node []nodes;       //chỉ số bắt đầu = 1
    int nodeQuantites;
    static final int DISTANCE = 70;
    int [][]w;      //w là matrix chứa giá của đồ thị, chỉ số bắt đầu = 1,1
    String [] names = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"};
    int s, t;   //source node and destination node
    boolean isRunningStep;
    Dijkstra ds;

    public GraphPanel() {
        isRunningStep = false;
        this.setSize(400, 400);
        setBorder(new LineBorder(Color.GREEN, 2));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //System.out.println("clicked");
                int mouseX = me.getX();
                int mouseY = me.getY();
                
                showNodeInfo(mouseX, mouseY);
            }

        });
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                int mouseX = me.getX();
                int mouseY = me.getY();
                for (int i = 1; i <= nodeQuantites; i++) {
                    if(mouseX < nodes[i].x + 10 && mouseX > nodes[i].x - 10 && mouseY < nodes[i].y + 10 && mouseY > nodes[i].y - 10) {
                        nodes[i].x = mouseX;
                        nodes[i].y = mouseY;
                        repaint();
                    }
                }
            }
        });
    }
    
    private void showNodeInfo(int mouseX, int mouseY) {
        for (int i = 1; i <= nodeQuantites; i++) {
            if(mouseX < nodes[i].x + 10 && mouseX > nodes[i].x - 10 && mouseY < nodes[i].y + 10 && mouseY > nodes[i].y - 10) {
                JOptionPane.showMessageDialog(this, "Node "+nodes[i].getIndex() + ", coordinate: (" + nodes[i].getX() + ", " + nodes[i].getY() + ")\n" + "Neighbors: " + nodes[i].getNeighborsName());
            }
        }
    }
    
    public void randomGraph() {
        nodeQuantites = 5;
        s = 1; t = nodeQuantites;
        nodes = new Node[nodeQuantites+1];
        w = new int[nodeQuantites+1][nodeQuantites+1];
        
        //int currXCoor = 0, currYCoor = 0;
        Random rd = new Random();
        for (int i = 1; i <= nodeQuantites; i++) {
            int x, y, h1, h2, w1, w2;   //x, y là tọa độ nodes[i] đc tạo ngẫu nhiên; h1, h2 là 2 hàng xóm đc tạo ngẫu nhiên; w1, w2 là giá của nodes[i] tới 2 hàng xóm đó
            do {
                x = rd.nextInt(300)+50;
                y = rd.nextInt(300)+50;
            } while(!checkNode(i, x, y));
            nodes[i] = new Node(i, x, y, this);
            nodes[i].setName(names[i]);
            
            h1 = rd.nextInt(nodeQuantites) + 1;
            h2 = rd.nextInt(nodeQuantites) + 1;
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
    }
    
    public void readGraphFromFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            
            Scanner sc = new Scanner(dis);
            nodeQuantites = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            
            w = new int[nodeQuantites+1][nodeQuantites+1];
            
            for (int i = 1; i <= nodeQuantites; i++) {
                for (int j = 1; j <= nodeQuantites; j++) {
                    int temp = sc.nextInt();
                    w[i][j] = temp;
                }
            }
            
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Random rd = new Random();
        nodes = new Node[nodeQuantites+1];
        for (int i = 1; i <= nodeQuantites; i++) {
            int x, y;
            do {
                x = rd.nextInt(300)+50;
                y = rd.nextInt(300)+50;
            } while(!checkNode(i, x, y));
            nodes[i] = new Node(i, x, y, this);
            nodes[i].setName(names[i]);
            
            // Tạo các hàng xóm của node i từ matrix trọng số w
            List<Integer> neighborList = new LinkedList<>();
            for (int j = 1; j <= nodeQuantites; j++) {
                if(w[i][j] > 0) neighborList.add(j);
            }
            nodes[i].setNeighbors(neighborList.stream().mapToInt(j->j).toArray());
            
        }
    }
    
    void printA() {
        for (int i = 1; i <= nodeQuantites; i++) {
            for (int j = 1; j <= nodeQuantites; j++) {
                System.out.print(w[i][j] + " ");
                if(w[i][j] < 10) System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        // Vẽ các đường nối các node trước
        g.setColor(Color.blue);
        for (int i = 1; i <= nodeQuantites; i++) {
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
        for (int i = 1; i <= nodeQuantites; i++) {
            nodes[i].drawNode(g);
        }
    }
    
    public void myPaint() {
        Graphics g = this.getGraphics();
        g.setColor(Color.BLACK);
        g.drawString("hello", 100, 100);
    }
    
    public void paintDijkstra() {
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setStroke(new BasicStroke(3.0f));
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        
        Dijkstra ds = new Dijkstra(nodeQuantites, s, t, w);
        ds.dijsktra();
        
        for (int i = 1; i <= nodeQuantites; i++) {
            int temp = ds.p[i];
            
            // Vẽ đường thằng nối nodes[temp] và nodes[i]
            if(i != temp) {
                g2.setColor(Color.RED);
                g2.drawLine(nodes[i].getX(), nodes[i].getY(), nodes[temp].getX(), nodes[temp].getY());
                
                // Vẽ lại giá của các đường đi trên đường đi ngắn nhất
                g2.setColor(Color.BLACK);
                g2.drawString(w[i][temp]+"", (nodes[i].getX() + nodes[temp].getX())/2, (nodes[i].getY() + nodes[temp].getY())/2);
            }
            
        }
        
        // Vẽ lại các node, để đường đi ko đè lên các node
        for (int i = 1; i <= nodeQuantites; i++) {
            nodes[i].drawNode(g2);
        }
    }
    
    /*
    * Chạy giải thuật Dijkstra từng bước
    */
    static int step = 1;
    public void paintDijkstraSteps() {
        //Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        g2.setStroke(new BasicStroke(3.0f));
        
        if(!isRunningStep) {
            ds = new Dijkstra(nodeQuantites, s, t, w);
            ds.dijsktra();
            isRunningStep = true;
        }
        
        int u = ds.steps[step];
        int u_parent = ds.p[u];

        // Vẽ đường thằng nối nodes[u] và nodes[u_parent]
        // Ko cần kiểm tra: if(u != u_parent)
        g2.setColor(Color.RED);
        g2.drawLine(nodes[u].getX(), nodes[u].getY(), nodes[u_parent].getX(), nodes[u_parent].getY());
        
        // Vẽ lại giá trên đường thẳng trên
        g2.setColor(Color.BLACK);
        g2.drawString(w[u][u_parent]+"", (nodes[u].getX() + nodes[u_parent].getX())/2, (nodes[u].getY() + nodes[u_parent].getY())/2);
        
        // Vẽ lại các node, để đường đi ko đè lên các node
        g2.setColor(Color.WHITE);
        for (int i = 1; i <= nodeQuantites; i++) {
            nodes[i].drawNode(g2);
        }
        
        step++;
        if(step == nodeQuantites) {
            step = 1;
            isRunningStep = false;
        }
    }

    double distance(Node a, int x, int y) {
        return Math.sqrt(Math.pow(a.getX() - x, 2) + Math.pow(a.getY() - y, 2));
    }
    
    boolean checkNode(int k, int x, int y) {
        if(k == 1) return true;
        for (int i = 1; i < k; i++) {
            if(distance(nodes[i], x, y) < DISTANCE) return false;
        }
        return true;    
    }
    
    public void printNodes() {
        for (int i = 1; i <= nodeQuantites; i++) {
            System.out.println("Node " + i + ", Toa do: x = " + nodes[i].getX() + ", y = " + nodes[i].getY());
            System.out.println("\tNeighbors: " + nodes[i].getNeighborsName());
        }
        System.out.println();
    }
}
