/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 *
 * @author AnhTu
 */
//Giống Min_Cost_Path, khác ở chỗ chỉ đc đi phải hoặc xuống dưới, ko đc đi chéo, sang trái
public class Min_Cost_Path_Version2 {
    static int lookup[][];
    
    static int min(int a, int b) {
        if(a < b) return a;
        else return b;
    }
    
    static int MCP_naive(int [][] cost, int m, int n) {     //tính chi phí nhỏ nhất đi từ [0][0] tới [m][n], với matrix cost là matrix chi phí, ví dụ: chi phí đi qua ô (i,j) là cost[i][j]
        if(m == 0 && n == 0) return cost[m][n];
        if(m == 0) return cost[m][n] + MCP_naive(cost, m, n-1);
        if(n == 0) return cost[m][n] + MCP_naive(cost, m-1, n);
        return cost[m][n] + min(MCP_naive(cost, m-1, n), MCP_naive(cost, m, n-1));
    }
    
    static int MCP_TopDown(int [][] cost, int m, int n) {
        //phải clear mảng lookup trước, hoặc tạo mới mảng đó, vì nếu ko thì mảng này vẫn lưu kq của lần tính toán trước đó:
        lookup = new int[cost.length+1][cost.length+1];
        return MCP_DP_TopDown(cost, m, n);
    }
    
    static int MCP_DP_TopDown(int [][] cost, int m, int n) {     //tính chi phí nhỏ nhất đi từ [0][0] tới [m][n], với matrix cost là matrix chi phí, ví dụ: chi phí đi qua ô (i,j) là cost[i][j]
        if(lookup[m][n] == 0) {
            if(m == 0 && n == 0) lookup[m][n] = cost[m][n];
            else if(m == 0) lookup[m][n] = cost[m][n] + MCP_DP_TopDown(cost, m, n-1);
            else if(n == 0) lookup[m][n] = cost[m][n] + MCP_DP_TopDown(cost, m-1, n);
            else lookup[m][n] = cost[m][n] + min(MCP_DP_TopDown(cost, m-1, n), MCP_DP_TopDown(cost, m, n-1));
        }
        return lookup[m][n];
    }
    
    static int MCP_BottomUp(int [][] cost, int m, int n) {      //(m,n) là tọa độ cần đi tới từ (0,0)
        int L[][] = new int[m+1][n+1];
        int i,j;
        /*
        Ví dụ với hình vẽ ở images, ta có L[][] = new int[4][4]
        CHÚ Ý; L[i][j] là quãng đường ngắn nhất đi từ (0,0) tới (i,j)
        do đó làm theo cách này ta phải tìm quãng đường ngắn nhất đi từ (0,0) tới tất các các ô
        sau đó return L[3][3] (vì bảng này có 4 hàng và 4 cột và ô cần đến là ô cuối cùng (3,3))
        
        */
        
        L[0][0] = cost[0][0];
        for (i = 1; i <= m; i++) {      //các ô ở cột đầu tiên của các hàng i
            L[i][0] = cost[i][0] + L[i-1][0];
        }
        for (i = 1; i <= n; i++) {      //các ô ở hàng đầu tiên của các cột i
            L[0][i] = cost[0][i] + L[0][i-1];
        }
        
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                L[i][j] = cost[i][j] + min(L[i][j-1], L[i-1][j]);
            }
        }
        
        return L[m][n];
    }
    
    public static void main(String[] args) {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println(MCP_naive(cost, 2, 2));
        System.out.println(MCP_TopDown(cost, 2, 2));
        System.out.println(MCP_BottomUp(cost, 2, 2));
        
        int cost2 [][] = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 }, { 2, 9, 8, 2 } };
        System.out.println(MCP_naive(cost2, 3, 3));
        System.out.println(MCP_TopDown(cost2, 3, 3));
        System.out.println(MCP_BottomUp(cost2, 3, 3));
    }
}
