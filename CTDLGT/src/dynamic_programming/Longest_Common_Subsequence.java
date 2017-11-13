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
LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs 
the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

Cách giải dùng đệ quy:
Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively.
And let L(X, Y, m, n) be the length of LCS of the two sequences X and Y.
Following is the recursive definition of L(X, Y, m-1, n-1):

If last characters of both sequences match (or X[m-1] == Y[n-1]) then
L(X, Y, m, n) = 1 + L(X, Y, m-1, n-1)

If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
L(X, Y, m, n) = MAX ( L(X, Y, m, n-1), L(X, Y, m-1, n) )

Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )

Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.

Considering the above implementation, following is a partial recursion tree for input strings “AXYT” and “AYZX”

                         lcs("AXYT", "AYZX")
                       /                 \
         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
         /            \                  /               \
lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
In the above partial recursion tree, lcs(“AXY”, “AYZ”) is being solved twice. If we draw the complete recursion tree, 
then we can see that there are many subproblems which are solved again and again. 
So this problem has Overlapping Substructure property and recomputation of same subproblems can be 
avoided by either using Memoization or Tabulation. Following is a tabulated implementation for the LCS problemm:

========
Cách giải dùng DP: Optimal Substructure: cách giải dựa trên cấu trúc con tối ưu:
Ta sẽ dùng 1 bảng lưu kq giống cách làm Top Down đối bài Fibonacci

*/
public class Longest_Common_Subsequence {
    static final int MAX = 100;
    static int lookup[][] = new int[MAX][MAX];
    
    private static int max(int a, int b) {
        return a>b?a:b;
    }
    
    
    //Cách đơn giản nhất là dùng đệ quy duyệt tất cả các dãy con của 2 dãy:
    static int LCS_naive(char []a, char []b, int m, int n) {    //m,n lần lượt là chiều dài của mảng a,b
        if(m == 0 || n == 0) return 0;
        if(a[m-1] == b[n-1]) return 1+LCS_naive(a, b, m-1, n-1);
        else return max(LCS_naive(a, b, m-1, n), LCS_naive(a, b, m, n-1));
    }
    
    //cách hiệu quả hơn: dùng DP, có 2 cách:
    //Chú ý rằng Top-down thì phải gọi đệ quy tới chính nó, còn Bottom-up thì ko cần đệ quy, chỉ cần vòng lặp for:
    static int LCS_DP_TopDown(char []a, char []b, int m, int n) {
        lookup = new int[a.length+1][b.length+1];
        return LCS_TopDown(a, b, m, n);
    }
    
    static int LCS_TopDown(char []a, char []b, int m, int n) {
        if(lookup[m][n] == 0) {
            if(m == 0 || n == 0) lookup[m][n] = 0;      //base case of recursion
            else if(a[m-1] == b[n-1]) lookup[m][n] = 1+LCS_TopDown(a, b, m-1, n-1);
            else lookup[m][n] =  max(LCS_TopDown(a, b, m-1, n), LCS_TopDown(a, b, m, n-1));
        }
        return lookup[m][n];
    }
    
    static int LCS_DP_BottomUp(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
         and m = X.length, n = Y.length */
        
        //CHÚ Ý: kí hiệu L[i][j] là LCS giữa 2 mảng X[0..i-1] và Y[0..j-1] 
        //hay nói các khác: L[i][j] là LCS giữa i và j phần tử đầu tiên của 2 mảng X,Y
        
        for (int i = 0; i <= m; i++) {      //base case: nếu mảng Y rỗng
            L[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {      //base case: nếu mảng X rỗng
            L[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {      //chú ý: i,j để chỉ phần tử thứ i,j của dãy X, Y, chứ ko phải ý nói đến X[i], Y[j]
                //Tính các L[i][j] = LCS_DP_BottomUp(X,Y,i,j), cuối cùng i=m, j=n thì tính đc L[m][n]:
                if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }
    
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char []a = s1.toCharArray();
        char []b = s2.toCharArray();
        int m = a.length, n = b.length;
        
        System.out.println(LCS_naive(a, b, m, n));
        System.out.println(LCS_DP_TopDown(a, b, m, n));
        System.out.println(LCS_DP_BottomUp(a, b, m, n));
    }
}
