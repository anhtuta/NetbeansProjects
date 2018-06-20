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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Dijkstra {
    //Giả sử đồ thị G = {V,E}
    private int n;      // quantity of node
    private int s, t;   //source node and destination node
    private int[] d;    //d[k] = shortest path's cost from sourceNode to node-k
    private Set<Integer> T; //Dùng cái này để lưu tập các node để sử dụng trong thuật toán. Ban đầu T = V, sau mỗi bước T = T\{u}. Khi T rỗng thì xong thuật toán!
    private int[][] w;  //ma trận trọng số của đồ thị
    public int[] p;    //p[k] = parent of k on the shortest path
    public int []steps;    //steps là thứ tự duyệt node (ko tính node nguồn). Chú ý rằng: nếu có n node thì chỉ cần n-1 step là duyệt xong
    public int len;     //Độ dài DDNN, áp dụng cho t != 0
    public static final int INF = 99999999;
    
    public Dijkstra() {}

    public Dijkstra(int n, int s, int t, int[][] w) {
        this.n = n;
        this.s = s;
        this.t = t;
        this.w = w;
        
        d = new int[n+1];
        p = new int[n+1];
        T = new HashSet<>();
        steps = new int[n+1];
        
        init();
    }

    public int[] getP() {
        return p;
    }
    
    public int[] getD() {
        return d;
    }
    
    public void setSourceNode(int source) {
        this.s = source;
    }
    
    public void setDestNode(int dest) {
        this.t = dest;
    }
    
    
    // khởi tạo
    private void init() {
        System.out.println("init dijkstra: s = " + s + ", t = " + t);
        for (int u = 1; u <= n; u++) {
            if (u == s) {
                //T[u] = -1;	// T = V\{s}, trong ddos V laf taapj cacs ddinhr cuar ddoof thij: G = {V,E}
                d[s] = 0;
                p[u] = s;
                continue;
            }

            d[u] = (w[s][u] > 0 ? w[s][u] : INF);
            System.out.println("\td[" + u + "] = " + d[u]);
            p[u] = s;
            T.add(u);
            //T[u] = u;	//ban dau mang T se chua cac dinh cua do thi, do do T = {1,2,3,...,n}. Chu y: bat dau mang la chi so 1, nen ta se bo thang T[0]
        }
    }

    public void input(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            
            Scanner sc = new Scanner(dis);
            n = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            
            d = new int[n+1];
            p = new int[n+1];
            T = new HashSet<>();
            steps = new int[n+1];
            w = new int[n+1][n+1];
            
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
        
        init();
    }
    
    public void output() {
        System.out.println("n = " + n);
        System.out.println("s = " + s);
        System.out.println("t = " + t);
    
        System.out.println("Mang w:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
            
	for(int i = 1; i <= n; i++) {
            System.out.println("d[" + i + "] = " + d[i]);
	}
	
	for(int i = 1; i <= n; i++) {
            System.out.println("p[" + i + "] = " + p[i]);
	}
	
        System.out.println("Steps = ");
        for(int i = 1; i < n; i++) {
            System.out.print(steps[i] + " ");
	}
        System.out.println();
    }
    
    public void dijsktra() {
        int step = 1;
        while(!T.isEmpty()) { //lawpj cho towis khi mangr T roongx
            // Laays ddinhr u laf ddinhr trong T maf d[u] laf nhor nhaats. CHU Y: u phair laf ddinhr trong T
            System.out.println(T.size());
            int u = 0;
            int min = INF;
            //for (int i = 1; i <= n; i++) {
            for(Integer i : T) {
                if (d[i] < min) {
                    u = i;
                    min = d[i];
                }
            }
            
            T.remove(u);    //Do đã tìm đc đường ngắn nhất tới u nên ta loại nó khỏi T
            steps[step] = u;    //lưu lại bước này duyệt node u
            //len += w[u][p[u]];
            step++;
            if(u == t) break;  //Duyệt tới node đích rồi thì dừng lại luôn

            // Lấy các đỉnh v kề với đỉnh u để cập nhập đường đi từ nguồn tới v, và cập nhập p[v]
            for (int v = 1; v <= n; v++) {
                if (v == s) {
                    continue;
                }
                if (w[u][v] > 0) {
                    if (d[v] > d[u] + w[u][v]) {
                        d[v] = d[u] + w[u][v];
                        p[v] = u;
                    }
                }
            }
        }
        
        output();
    }
    
    public int printShortestPath() {
        if(t == 0) {
            len = -1;
            return -1;
        }
        int currNode = t;   //t phải khác 0, nghĩa là phải có 1 node đích cụ thể, chứ ko phải tất cả các node
        len = 0;
        while(currNode != s) {
            System.out.print(currNode + " <- ");
            len += w[currNode][p[currNode]];
            currNode = p[currNode];
        }
        System.out.println(currNode);
        return len;
    }
    
    public static void main(String[] args) {
        Dijkstra ds = new Dijkstra();
        ds.input("D:\\Documents\\C,C++\\dijkstra.txt");
        ds.dijsktra();
        System.out.println("Do dai DDNN = " + ds.printShortestPath());
    }
}
