/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_3;

import algorithms.Dijkstra;
import algorithms.Prim;
import algorithms.Traversal;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author AnhTu
 */
public final class GraphPanel extends JPanel {
    Node []nodes;       //chỉ số bắt đầu = 1
    int nodeQuantity;
    static final int DISTANCE = 70;
    int [][]w;      //w là ma trận trọng số của đồ thị, chỉ số bắt đầu = 1,1
    private int s, t;   //source node and destination node
    boolean isRunningStep;
    static int step = 1;
    
    Dijkstra ds;
    Traversal ts;
    Prim pr;
    JTextArea taOut;
    int len;

    public GraphPanel() {
        isRunningStep = false;
        this.setSize(400, 400);
        setBorder(new LineBorder(Color.GREEN, 2));
        //setBackground(new java.awt.Color(0, 153, 255));
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if(!isRunningStep) {
                    int mouseX = me.getX();
                    int mouseY = me.getY();
                    for (int i = 1; i <= nodeQuantity; i++) {
                        if(mouseX < nodes[i].x + 10 && mouseX > nodes[i].x - 10 && mouseY < nodes[i].y + 10 && mouseY > nodes[i].y - 10) {
                            nodes[i].x = mouseX;
                            nodes[i].y = mouseY;
                            repaint();
                        }
                    }
                }
            }
        });
    }
    
    public int getSourceNode() {
        return this.s;
    }
    
    public void setSourceNode(int s) {
        this.s = s;
    }
    
    public int getDestNode() {
        return this.t;
    }
    
    public void setDestNode(int t) {
        this.t = t;
    }
    
    public void randomGraph(int n, int sourceNode, int destNode) {
        nodeQuantity = n;
        s = sourceNode; t = destNode;
        nodes = new Node[nodeQuantity+1];
        w = new int[nodeQuantity+1][nodeQuantity+1];
        
        //int currXCoor = 0, currYCoor = 0;
        Random rd = new Random();
        for (int i = 1; i <= nodeQuantity; i++) {
            int x, y, h1, h2, w1, w2;   //x, y là tọa độ nodes[i] đc tạo ngẫu nhiên; h1, h2 là 2 hàng xóm đc tạo ngẫu nhiên; w1, w2 là giá của nodes[i] tới 2 hàng xóm đó
            do {
                x = rd.nextInt(300)+50;
                y = rd.nextInt(300)+50;
            } while(!checkNode(i, x, y));
            nodes[i] = new Node(i, x, y);
            
            h1 = rd.nextInt(nodeQuantity) + 1;
            h2 = rd.nextInt(nodeQuantity) + 1;
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
    
    public boolean readGraphFromFile(String filePath, OpenGraphFrame ogf) {     //ogf chỉ để show message (Dùng JOptionPane)!
        int flag = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            
            Scanner sc = new Scanner(dis);
            nodeQuantity = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            
            w = new int[nodeQuantity+1][nodeQuantity+1];
            
            for (int i = 1; i <= nodeQuantity; i++) {
                for (int j = 1; j <= nodeQuantity; j++) {
                    int temp = sc.nextInt();
                    w[i][j] = temp;
                }
            }
            
            flag = sc.nextInt();
            if(flag == 1) {
                // read coordinates
                nodes = new Node[nodeQuantity+1];
                int x,y;
                for (int i = 1; i <= nodeQuantity; i++) {
                    x = sc.nextInt();
                    y = sc.nextInt();
                    nodes[i] = new Node(i, x, y);

                    // Tạo các hàng xóm của node i từ matrix trọng số w
                    List<Integer> neighborList = new LinkedList<>();
                    for (int j = 1; j <= nodeQuantity; j++) {
                        if(w[i][j] > 0) neighborList.add(j);
                    }
                    nodes[i].setNeighbors(neighborList.stream().mapToInt(j->j).toArray());
                }
            }
            
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(ogf, "File ko tồn tại!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ogf, "Không đọc đc file!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (java.util.InputMismatchException ex) {
            //Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(ogf, "File không đúng định dạng!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ogf, "Unknown error!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(flag == 0) {
            Random rd = new Random();
            nodes = new Node[nodeQuantity+1];
            for (int i = 1; i <= nodeQuantity; i++) {
                int x, y;
                do {
                    x = rd.nextInt(300)+50;
                    y = rd.nextInt(300)+50;
                } while(!checkNode(i, x, y));
                nodes[i] = new Node(i, x, y);

                // Tạo các hàng xóm của node i từ matrix trọng số w
                List<Integer> neighborList = new LinkedList<>();
                for (int j = 1; j <= nodeQuantity; j++) {
                    if(w[i][j] > 0) neighborList.add(j);
                }
                nodes[i].setNeighbors(neighborList.stream().mapToInt(j->j).toArray());
            }
        }
        
        return true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // Vẽ các đường nối các node trước
        g.setColor(Color.blue);
        for (int i = 1; i <= nodeQuantity; i++) {
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
        for (int i = 1; i <= nodeQuantity; i++) {
            nodes[i].drawNode(g);
        }
    }
    
    public void paintDijkstra() {
        taOut.append("Bắt đầu tìm đường đi ngắn nhất\n");
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setStroke(new BasicStroke(3.0f));
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        
        ds = new Dijkstra(nodeQuantity, s, t, w);
        ds.dijsktra();
        
        
        // Vẽ đường đi từ node nguồn tới đích, nếu t != 0
        if(t != 0) {
            drawPath(g2);
        } else {
            // Vẽ đường đi từ node nguồn tới tất cả các node khác, nếu t == 0
            taOut.append("Thứ tự thăm các node\n");
            for (int i = 1; i < nodeQuantity; i++) {
                int u = ds.steps[i];
                if(u == 0) break;
                int u_parent = ds.getP()[u];
                draw2Nodes(g2, u_parent, u);
            }
        }

        doneDijkstra();
    }

    public void paintDijkstraSteps() {
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        g2.setStroke(new BasicStroke(3.0f));
        
        if(!isRunningStep) {
            //repaint();   //Để xóa lần chạy trước đi
            taOut.append("Bắt đầu tìm đường đi ngắn nhất\n");
            ds = new Dijkstra(nodeQuantity, s, t, w);
            ds.dijsktra();
            isRunningStep = true;
            taOut.append("Thứ tự thăm các node\n");
            step = 1;
        }
        
        System.out.println("step = " + step + ", steps["+step+"] = " + ds.steps[step]);

        int u = ds.steps[step];
        if(u == 0 || step == nodeQuantity) {
            if(t != 0) drawPath(g2);
            doneDijkstra();
            return;
        }
        
        int u_parent = ds.getP()[u];
        draw2Nodes(g2, u_parent, u);
        step++;
    }
    
    private void drawPath(Graphics2D g2) {
        taOut.append("Đường đi tới node đích\n");
        Stack<Integer> stack = new Stack<>();
        int currNode = t;   //t phải khác 0, nghĩa là phải có 1 node đích cụ thể, chứ ko phải tất cả các node
        len = 0;
        g2.setColor(Color.blue);
        while(currNode != s) {
            stack.push(currNode);
            len += w[currNode][ds.p[currNode]];
            currNode = ds.p[currNode];
        }

        // vẽ các node trong stack
        while(!stack.isEmpty()) {
            int u = stack.pop();
            draw2Nodes(g2, Color.GREEN, ds.p[u], u);
        }
    }
    
    public void paintPrim() {
        taOut.append("Bắt đầu tìm cây khung nhỏ nhất\n");
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setStroke(new BasicStroke(3.0f));
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        
        pr = new Prim(nodeQuantity, w);
        len = pr.prim();
        
        // Vẽ đường đi thăm các node và in kq
        taOut.append("Thứ tự thăm các node\n");
        for (int i = 1; i < nodeQuantity; i++) {
            draw2Nodes(g2, pr.near[pr.steps[i]], pr.steps[i]);
        }
        
        donePrim();
    }
    
    public void paintPrimSteps() {
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        g2.setStroke(new BasicStroke(3.0f));
        
        if(!isRunningStep) {
            taOut.append("Bắt đầu tìm cây khung nhỏ nhất\n");
            pr = new Prim(nodeQuantity, w);
            len = pr.prim();
            isRunningStep = true;
            taOut.append("Thứ tự thăm các node\n");
            step = 1;
        }
        
        int u = pr.steps[step];
        int near_u = pr.near[u];
        draw2Nodes(g2, near_u, u);      //vẽ theo chiều thừ near_u -> u, nhưng hiện tại mới chỉ code đc vẽ ko có chiều
        step++;
        if(step == nodeQuantity) {      //sau n-1 bước là duyệt xong
            donePrim();
        }
    }
    
    // vẽ đường thẳng nối từ u_parent tới u
    private void draw2Nodes(Graphics g2, int u_parent, int u) {
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        g2.setColor(Color.RED);
        
        //Vẽ các đường đi
        g2.drawLine(nodes[u_parent].getX(), nodes[u_parent].getY(), nodes[u].getX(), nodes[u].getY());
        
        // Vẽ lại giá
        g2.setColor(Color.BLACK);
        g2.drawString(w[u_parent][u]+"", (nodes[u_parent].getX() + nodes[u].getX())/2, (nodes[u_parent].getY() + nodes[u].getY())/2);
        
        // Vẽ lại các node, để đường đi ko đè lên các node
        g2.setColor(Color.WHITE);
        nodes[u_parent].drawNode(g2);
        nodes[u].drawNode(g2);
        taOut.append(u_parent + " -> " + u + "\n");
        taOut.setCaretPosition(taOut.getDocument().getLength());
    }
    
    /**
     * vẽ đường thẳng nối từ u_parent tới u, với màu vẽ đường thẳng là c
     * @param g2 graphic của component để vẽ
     * @param c màu để vẽ đường thẳng nối 2 node u_parent -> u
     * @param u_parent node nguồn
     * @param u node đích
     */
    private void draw2Nodes(Graphics g2, Color c, int u_parent, int u) {
        g2.setFont(new java.awt.Font("Tahoma", 1, 11));
        g2.setColor(c);
        
        //Vẽ các đường đi
        g2.drawLine(nodes[u_parent].getX(), nodes[u_parent].getY(), nodes[u].getX(), nodes[u].getY());
        
        // Vẽ lại giá
        g2.setColor(Color.BLACK);
        g2.drawString(w[u_parent][u]+"", (nodes[u_parent].getX() + nodes[u].getX())/2, (nodes[u_parent].getY() + nodes[u].getY())/2);
        
        // Vẽ lại các node, để đường đi ko đè lên các node
        g2.setColor(Color.WHITE);
        nodes[u_parent].drawNode(g2);
        nodes[u].drawNode(g2);
        taOut.append(u_parent + " -> " + u + "\n");
        taOut.setCaretPosition(taOut.getDocument().getLength());
    }
    
    private void doneDijkstra() {
        step = 1;
        isRunningStep = false;
        taOut.append("done!\n");
        if(t != 0) taOut.append("Độ dài đường đi ngắn nhất từ " + s + " tới " + t + " là: " + len + "\n");
        taOut.setCaretPosition(taOut.getDocument().getLength());
    }
    
    private void donePrim() {
        step = 1;
        isRunningStep = false;
        taOut.append("done!\n");
        taOut.append("Tổng trọng số của cây khung nhỏ nhất = " + len + "\n");
        taOut.setCaretPosition(taOut.getDocument().getLength());
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
    
    public void traversalDFS(int sourceNode) {
        ts = new Traversal(nodeQuantity, s, t, w);
        ts.DFS(sourceNode);
        ts.output();
        
        // in kq
        taOut.append("Thứ tự thăm các node\n");
        for (int i = 1; i <= 2*nodeQuantity; i++) {
            taOut.append(ts.steps[i] + "\n");
        }
        taOut.append("done!\n");
        taOut.setCaretPosition(taOut.getDocument().getLength());
    }
    
    public void traversalDFSSteps(int sourceNode) {
        if(!isRunningStep) {    // lần đầu tiên click btTraversalStep thì thiết lập như sau
            taOut.append("Bắt đầu Duyệt DFS\n");
            ts = new Traversal(nodeQuantity, s, t, w);
            ts.DFS(s);
            isRunningStep = true;
            taOut.append("Thứ tự thăm các node\n");
            step = 1;
        }
        
        // Các lần sau click btTraversalStep thì chỉ cần làm những j ở dưới
        String str = ts.steps[step];
        taOut.append(str + "\n");
        step++;
        if(step == 2*nodeQuantity+1) {
            //Đã duyệt tất cả các đỉnh. Chú ý đồ thị này phải liên thông
            step = 1;
            isRunningStep = false;
            taOut.append("done!\n");
        }
        
        taOut.setCaretPosition(taOut.getDocument().getLength());
    }
    
    public void saveGraph(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(nodeQuantity+" "+s+" " +t); bw.newLine();
            for (int i = 1; i <= nodeQuantity; i++) {
                for (int j = 1; j <= nodeQuantity; j++) {
                    bw.write(w[i][j] + " ");
                }
                bw.newLine();
            }
            
            // lưu tọa độ các node
            bw.write("1");   //đánh dấu sẽ lưu tọa độ ở các dòng tiếp theo, để lúc đọc file còn biết
                             //nên dùng write("1") thay vì write(1)
            bw.newLine();
            for (int i = 1; i <= nodeQuantity; i++) {
                bw.write(nodes[i].x + " " + nodes[i].y); bw.newLine();
            }
            
            //đóng luồng lại:
            bw.close();
            JOptionPane.showMessageDialog(this, "Lưu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lưu thất bại!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

/*
C:\Users\AnhTu\Documents\graph_nguyenvanquan.txt
*/