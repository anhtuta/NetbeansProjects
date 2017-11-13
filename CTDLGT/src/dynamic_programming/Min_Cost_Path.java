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
/*
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that 
returns cost of minimum cost path to reach (m, n) from (0, 0). 
Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
You can only traverse down, right and diagonally lower cells from a given cell,: Chỉ được đi từ trên xuống dưới, đi chéo hoặc đi sang phải, ko đc đi lên trên hoặc sang trái
i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 
You may assume that all costs are positive integers.

see images for more details and illustrations

Optimal Substructure:
The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1). 
So minimum cost to reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”:
minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
*/
public class Min_Cost_Path {
    static int lookup[][];
    
    static int min(int a, int b, int c) {
        if(a < b) return a<c?a:c;
        else return b<c?b:c;
    }
    
    static int MCP_naive(int [][] cost, int m, int n) {     //tính chi phí nhỏ nhất đi từ [0][0] tới [m][n], với matrix cost là matrix chi phí, ví dụ: chi phí đi qua ô (i,j) là cost[i][j]
        if(m == 0 && n == 0) return cost[m][n];
        if(m == 0) return cost[m][n] + MCP_naive(cost, m, n-1);
        if(n == 0) return cost[m][n] + MCP_naive(cost, m-1, n);
        return cost[m][n] + min(MCP_naive(cost, m-1, n-1), MCP_naive(cost, m-1, n), MCP_naive(cost, m, n-1));
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
            else lookup[m][n] = cost[m][n] + min(MCP_DP_TopDown(cost, m-1, n-1), MCP_DP_TopDown(cost, m-1, n), MCP_DP_TopDown(cost, m, n-1));
        }
        return lookup[m][n];
    }
    
    static int MCP_BottomUp(int [][] cost, int m, int n) {
        int i,j;
        int solution [][] = new int[m+1][n+1];
        
        solution[0][0] = cost[0][0];
        for (i = 1; i <=m; i++) {
            solution[i][0] = cost[i][0] + solution[i-1][0];
        }
        for (j = 1; j <= n; j++) {
            solution[0][j] = cost[0][j] + solution[0][j-1];
        }
        
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                solution[i][j] = cost[i][j] + min(solution[i-1][j-1], solution[i-1][j], solution[i][j-1]);
            }
        }
        
        return solution[m][n];
    }
    
    public static void main(String[] args) {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println(MCP_naive(cost,2,2));
        System.out.println(MCP_TopDown(cost, 2, 2));
        
        int cost2 [][] = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 }, { 2, 9, 8, 2 } };
        System.out.println(MCP_naive(cost2, 3, 3));
        System.out.println(MCP_TopDown(cost2, 3, 3));
        System.out.println(MCP_BottomUp(cost2, 3, 3));
    }
}
