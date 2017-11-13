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
//Tính tổ hợp C(n,k) theo kiểu Top Down
public class Cnk {
    static int [][] D;
    
    static int C(int n, int k) {
        initArrayD(n);
        return toHop(n,k);
    }

    private static void initArrayD(int n) {
        D = new int [n+1][n+1];
        for (int i = 0; i <= n; i++) {
            D[i][0] = 1;
            D[i][i] = 1;
        }
    }

    private static int toHop(int n, int k) {
        if(D[n][k] > 0) return D[n][k];
        D[n][k] = toHop(n-1,k-1) + toHop(n-1, k);
        return D[n][k];
    }
    
    public static void main(String[] args) {
        System.out.println(C(61,4));
    }
}
