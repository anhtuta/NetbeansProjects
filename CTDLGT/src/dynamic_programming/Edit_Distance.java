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
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

1.Insert
2.Remove
3.Replace

All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

======
What are the subproblems in this case?
The idea is process all characters one by one staring from either from left or right sides of both strings.
Let we traverse from right corner, there are two possibilities for every pair of character being traversed.

m: Length of str1 (first string)
n: Length of str2 (second string)
- If last characters of two strings are same, nothing much to do. Ignore last characters 
and get count for remaining strings. So we recur for lengths m-1 and n-1.
- Else (If last characters are not same), we consider all operations on ‘str1’, 
consider all three operations on last character of first string, recursively compute 
minimum cost for all three operations and take minimum of three values:
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1
VD: str1 = sunday, str2 = June, m=6,n=3. Cần tính editDist_naive(str1,str2,m,n)
do 'y' và 'e' khác nhau nên editDist_naive(str1,str2,m,n) = MIN(editDist_naive(str1,str2,m,n-1), editDist_naive(str1,str2,m-1,n), editDist_naive(str1,str2,m-1,n-1))
 - editDist_naive(str1,str2,m,n-1) nghĩa là: chèn 'e' vào cuối str1 và gọi đệ quy lúc này str1 = sundaye (độ dài m' = 7), str2 = June (độ dài n = 4), do có phần tử cuối giống nhau nên bây giờ bỏ nó đi và gọi đệ quy với str1[0..m'-1] và str2[0..n-1], nghĩa là str1[0..m-2] và str2[0..n-1]
 - editDist_naive(str1,str2,m-1,n) nghĩa là xóa 'y' của str1, do đó str1 = sunda (m'=5), str2 = June, rõ ràng độ dài của str1 giảm 1 đơn vị, do đó gọi đệ quy với 2 str này: str1[0..m'-1] = str1[0..m-2] và str2[0..n-1]
 - editDist_naive(str1,str2,m-1,n-1) nghĩa là: replace 'y' bởi 'e', do đó str1 = sundae, str2 = June, do đó chỉ cần gọi đệ quy với str1[0..m-2] và str2[0..n-2]
*/
public class Edit_Distance {
    static int lookup[][];
    
    static int min(int a, int b, int c) {
        if(a < b) return a<c?a:c;
        else return b<c?b:c;
    }
    
    static int editDist_naive(char []a, char[]b, int m, int n) {
        if(m==0) return n;
        if(n==0) return m;
        
        if(a[m-1] == b[n-1]) return editDist_naive(a, b, m-1, n-1);
        else return 1+min(editDist_naive(a, b, m, n-1),     //insert
                          editDist_naive(a, b, m-1, n),     //remove
                          editDist_naive(a, b, m-1, n-1)    //replace
        );
    }
    
    // this problem has Overlapping Subprolems property
    // Cách giải trên có các bài toán con gối nhau, do đó có thể dùng DP đc
    static int editDist_DP_TopDown(char []a, char[]b, int m, int n) {
        lookup = new int[a.length+1][b.length+1];
        return editDist_TopDown(a, b, m, n);
    }
    
    static int editDist_TopDown(char []a, char[]b, int m, int n) {
        if(lookup[m][n] == 0) {
            if(m==0) lookup[m][n] = n;
            else if(n==0) lookup[m][n] = m;
            else if(a[m-1] == b[n-1]) lookup[m][n] = editDist_TopDown(a, b, m-1, n-1);
            else lookup[m][n] = 1 + min(editDist_TopDown(a, b, m, n-1),     //insert
                                        editDist_TopDown(a, b, m-1, n),     //remove
                                        editDist_TopDown(a, b, m-1, n-1)    //replace
            );
        }
        return lookup[m][n];
    }
    
    static int editDist_DP_BottomUp(char [] a, char [] b) {
        int m = a.length, n = b.length;
        int [][] solution = new int[m+1][n+1];
        //cách làm: tính lần lượt editDist(a[0..i], b[0..j]) sau đó lưu vào solution[i][j]
        //kết quả của bài toán chính là solution[m][n]
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                //base case
                //If any of the string if empty then number of operations
                //needed would be equal to the length of other string
                //(Either all characters will be removed or inserted):
                if(i==0) solution[i][j] = j;    //base case: nếu 1 trong 2 dãy có độ dài = 0 (nghĩa là rỗng)
                else if(j==0) solution[i][j] = i;
                
                //If last characters are matching, ignore the last character, then the solution will be same as without the last character.:
                else if(a[i-1] == b[j-1]) solution[i][j] = solution[i-1][j-1];
                
                else solution[i][j] = 1 + min(solution[i][j-1],     //insert
                                              solution[i-1][j],     //remove
                                              solution[i-1][j-1]    //replace
                );
            }
        }
        return solution[m][n];
    }
    
    static int editDist_DP_BottomUp(String s1, String s2) {
        int [][] solution = new int[s1.length()+1][s2.length()+1];
        
        //base case
        //If any of the string if empty then number of operations
        //needed would be equal to the length of other string
        //(Either all characters will be removed or inserted)
        for (int i = 0; i <=s2.length(); i++) {//all elements will be inserted
            solution[0][i] =i;
        }

        for (int i = 0; i <=s1.length(); i++) {//all elements will be removed
            solution[i][0] =i;
        }

        //solving it bottom-up manner
        int m = s1.length();
        int n = s2.length();
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                //If last characters are matching, ignore the last character
                // then the solution will be same as without the last character.
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    solution[i][j] = solution[i-1][j-1];
                else
                    solution[i][j] = 1 +    Math.min(solution[i][j-1], //Insert
                                            Math.min(solution[i-1][j], // Remove
                                            solution[i-1][j-1])); //Replace
            }
        }
        return solution[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
        String str1 = "todayisrainingheavy";
        String str2 = "yesterdayisveryhot";
        char []a = str1.toCharArray();
        char []b = str2.toCharArray();
        int m = a.length, n = b.length;
        
        long curr = System.currentTimeMillis();
        //System.out.println(editDist_naive(a, b, m, n));             //Couldn't solve! It takes lots of time!
        System.out.println(editDist_DP_TopDown(a, b, m, n));      //3ms
        //System.out.println(editDist_DP_BottomUp(str1, str2));           //1ms
        //System.out.println(editDist_DP_BottomUp(a, b));             //1ms
        System.out.println("Executing time: "+(System.currentTimeMillis() - curr) + "(ms)");
    }
}
