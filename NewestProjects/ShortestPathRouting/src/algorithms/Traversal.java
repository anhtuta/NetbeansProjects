/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Traversal {
    final int INF = 99999999;
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;
    
    private int n;
    private int s, t;
    private int[][] w;
    private int[] color;    // Các matrix vẫn bắt đầu từ 1
    private int []p;    //p[v] = cha của v trong quá trình đi thăm
    private int []d;    //d[k] = thời gian ghé thăm đỉnh k
    private int []f;    //f[k] = thời gian kết thúc thăm (duyệt) đỉnh k
    private int time;   //số bước duyệt, thăm trên toàn đồ thị. Cần khởi tạo = 0 trước khi duyệt
    public String []steps;    //steps là thứ tự duyệt node (ko tính node nguồn)

    public Traversal() {}
    
    public Traversal(int n, int s, int t, int[][] w) {
        this.n = n;
        this.s = s;
        this.t = t;
        this.w = w;
        
        d = new int[n+1];
        f = new int[n+1];
        p = new int[n+1];
        color = new int[n+1];
        steps = new String[2*n + 1];
        
        // khởi tạo
        init();
    }
    public void input_AdjacencyMatrix(String filePath) {    // đọc file đầu vào là ma trận kề. Các hàng xóm của node u là {tất cả đỉnh v mà w[u][v] != 0}
        try {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            
            Scanner sc = new Scanner(dis);
            n = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            
            d = new int[n+1];
            f = new int[n+1];
            p = new int[n+1];
            w = new int[n+1][n+1];
            color = new int[n+1];
            steps = new String[2*n + 1];
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
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
        
        // khởi tạo
        init();
    }
    
    public void DFS(int u) {
        color[u] = GRAY;
        time++;
        d[u] = time;    System.out.println(time + ": Tham " + u);   steps[time] = "Thăm " + u;
        for (int v = 1; v <= n; v++) {
            if(w[u][v] != 0) {
                if(color[v] == WHITE) {
                    p[v] = u;
                    DFS(v);
                }
            }
        }
        time++;
        color[u] = BLACK;   System.out.println(time + ": Duyet " + u);      steps[time] = "Duyệt " + u;
        f[u] = time;
    }

    private void init() {
        time = 0;
        for (int i = 1; i <= n; i++) {
            color[i] = WHITE;
            p[i] = -1;
            d[i] = -1;
            f[i] = -1;
        }
    }
    
    public void output() {
        System.out.println("\nMang d:");
        for (int i = 1; i <= n; i++) {
            System.out.print(d[i] + " ");
        }
        
        System.out.println("\nMang f:");
        for (int i = 1; i <= n; i++) {
            System.out.print(f[i] + " ");
        }
        
        System.out.println("\nMang p:");
        for (int i = 1; i <= n; i++) {
            System.out.print(p[i] + " ");
        }
        
        //Thử in ra các bước duyệt DFS
        System.out.println("\nMang steps:");
        for (int i = 1; i <= 2*n; i++) {
            System.out.print(steps[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Traversal tv = new Traversal();
        tv.input_AdjacencyMatrix("D:\\Documents\\C,C++\\dijkstra.txt");
        tv.init();
        tv.DFS(1);
        tv.output();
    }
}
