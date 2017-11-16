/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_3;

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
public class Dijkstra {

    int n;
    private int s, t;
    int[] d;
    int[] p;
    int[] T;
    int[][] w;
    final int INF = 99999999;
    int []steps;    //steps là thứ tự duyệt node (ko tính node nguồn). Chú ý rằng: nếu có n node thì chỉ cần n step là duyệt xong

    public Dijkstra() {}

    public void setSourceNode(int source) {
        this.s = source;
    }
    
    public Dijkstra(int n, int s, int t, int[][] w) {
        this.n = n;
        this.s = s;
        this.t = t;
        this.w = w;
        
        d = new int[n+1];
        p = new int[n+1];
        T = new int[n+1];
        steps = new int[n];
        
        // khởi tạo
        init();
    }
    
    private void init() {
        // khởi tạo
        for (int u = 1; u <= n; u++) {
            if (u == s) {
                T[u] = -1;	// T = V\{s}, trong ddos V laf taapj cacs ddinhr cuar ddoof thij: G = {V,E}
                d[s] = 0;
                p[u] = s;
                continue;
            }

            d[u] = (w[s][u] > 0 ? w[s][u] : INF);
            p[u] = s;

            T[u] = u;	//ban dau mang T se chua cac dinh cua do thi, do do T = {1,2,3,...,n}. Chu y: bat dau mang la chi so 1, nen ta se bo thang T[0]
        }
    }
    
    public boolean isEmpty() {
        for (int u = 1; u <= n; u++) {
            if (T[u] > 0) {
                return false;
            }
        }
        return true;
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
            T = new int[n+1];
            steps = new int[n];
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
        
        // khởi tạo
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
	
	for(int i = 1; i <= n; i++) {
            System.out.println("T[" + i + "] = " + T[i]);
	}
        
        System.out.println("Steps = ");
        for(int i = 1; i < n; i++) {
            System.out.print(steps[i] + " ");
	}
    }
    
    public void dijsktra() {
        int step = 1;
        while(!isEmpty()) { //lawpj cho towis khi mangr T roongx
            // Laays ddinhr u laf ddinhr trong T maf d[u] laf nhor nhaats. CHU Y: u phair laf ddinhr trong T
            int u = 0;
            int min = INF;
            for (int i = 1; i <= n; i++) {
                if (i == s) {
                    continue;
                }
                if (T[i] == -1) {
                    continue;	// Chir xets ddinhr u thuoocj taapj T
                }
                //cout << "\td[" << i << "] = "<<d[i]<<endl;
                if (d[i] < min) {
                    u = T[i];
                    min = d[i];
                }
            }

            T[u] = -1; // T = T\{u}: Do ddax timf dc dduwowngf ddi ngawns nhaats twf s towis u neen ta ko xets u nwax!
            steps[step] = u;
            step++;

            // laays cacs ddinhr v keef voiws ddinhr u
            for (int v = 1; v <= n; v++) {
                if (v == s) {
                    continue;
                }
                if (w[u][v] > 0) {
                    if (d[v] > d[u] + w[u][v]) {
                        d[v] = d[u] + w[u][v];
                        p[v] = u;
                        //cout << "\tdv = "<<d[v]<<endl;
                    }
                }
            }
            
        }
        output();
    }
    
    public static void main(String[] args) {
        Dijkstra ds = new Dijkstra();
        ds.input("D:\\Documents\\C,C++\\dijkstra.txt");
        ds.dijsktra();
    }
}
