/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo01092017;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
/*
input:
- n
- a1, a2,..., an
output: trọng lượng của dãy con lớn nhất
*/
public class SUBSEQMAX {
    static int maxSub_DP(int []a) {     //chắc là kiểu Bottom-up
        int smax = a[0];
        int mEH = a[0];     //mEH = maxEndHere = khối lượng lớn nhất của "dãy con kết thúc tại a[i]"
        int imax = 0;
        int i;
        
        for (i = 1; i < a.length; i++) {
            if(mEH + a[i] > a[i]) mEH = mEH + a[i];		// sao ko ghi là if(mEH > 0) cho nhanh :))
            else mEH = a[i];	//trường hợp này mEH <= 0
            
            if(mEH > smax) {
                smax = mEH;
                imax = i;
            }
        }
        
        return smax;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int kq = maxSub_DP(a);
        System.out.println(kq);
    }
}
