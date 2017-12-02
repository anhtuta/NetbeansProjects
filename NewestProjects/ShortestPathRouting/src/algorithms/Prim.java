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
public class Prim {
    private int n;
    private int[][] w;
    private int s, t;   //bài này ko quan tâm s,t. Luôn là s = 1, t ko cần thiết vì đây là bài tìm cây khung nhỏ nhất
    private int []d;
    private boolean []mark;     //Có thể thay = hashset để tốc độ nhanh hơn
    public int []near;
    public int []steps;

    public Prim() {}
    
    public Prim(int n, int[][] w) {
        this.n = n;
        this.s = 1;
        this.w = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(w[i][j] == 0) this.w[i][j] = Dijkstra.INF;   //Nếu có 2 đỉnh ko nối với nhau thì giá của chúng = INF
                else this.w[i][j] = w[i][j];
            }
        }
        
        this.d = new int[n+1];
        this.near = new int[n+1];
        this.mark = new boolean[n+1];
        this.steps = new int[n];
    }
    
    public void input(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            
            Scanner sc = new Scanner(dis);
            n = sc.nextInt();
            s = sc.nextInt();
            s = 1;
            t = sc.nextInt();
            
            
            this.d = new int[n+1];
            this.near = new int[n+1];
            this.mark = new boolean[n+1];
            this.steps = new int[n];
            
            w = new int[n+1][n+1];
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int temp = sc.nextInt();
                    if(temp == 0) this.w[i][j] = Dijkstra.INF;   //Nếu có 2 đỉnh ko nối với nhau thì giá của chúng = INF
                    else this.w[i][j] = temp;
                }
            }
            
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dijkstra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        init();
    }
    
    private void init() {
        for (int i = 1; i <= n; i++) {
            d[i] = w[s][i];
            near[i] = s;
            mark[i] = false;
        }
        
        d[s] = 0;
        near[s] = s;
        mark[s] = true;
    }
    
    public int prim() {
        int len = 0;
        this.s = 1;
        init();
        for (int k = 1; k < n; k++) {   //chỉ cần n-1 bước lặp là xong
            int minVal = Dijkstra.INF;
            int u = 0;
            //Tìm đỉnh u thuộc V\S thỏa mãn: d[u] = min{d[v]: v thuộc V\S}, chú ý rằng V\S là tập các đỉnh mà mark[đỉnh đó] = false
            for (int i = 1; i <= n; i++) {
                if(d[i] < minVal && !mark[i]) {
                    minVal = d[i];
                    u = i;
                }
            }
            
            //đã tìm đc u
            mark[u] = true;     //S = {S} + u
            len += w[u][near[u]];
            steps[k] = u;
            
            //update các đỉnh kề với u
            for (int v = 1; v <= n; v++) {
                if(!mark[v] && d[v] > w[u][v]) {
                    d[v] = w[u][v];
                    near[v] = u;
                }
            }
        }
        return len;
    }
    
    void printEdges() {
	for(int i = 2; i <= n; i++) {
            System.out.println(near[i] + " " + i + " ");
	}
    }
    
    void printSteps() {
        System.out.println("Matrix step:");
        for(int i = 1; i < n; i++) {
            System.out.print(steps[i] + " ");
	}
        System.out.println("Thứ tự đi:");
        for(int i = 1; i < n; i++) {
            System.out.print(near[steps[i]] + " -> " + steps[i] +", ");
        }
    }
    
    public static void main(String[] args) {
        Prim p = new Prim();
        p.input("C:\\Users\\AnhTu\\Documents\\graph_nguyenvanquan.txt");
        System.out.println(p.prim());
        p.printEdges();
        System.out.println("s = " + p.s);
        p.printSteps();
    }
}
