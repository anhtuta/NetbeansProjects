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
Given two string sequences write an algorithm to find, find the length of longest substring present in both of them.
This problem has been asked in Ama­zon and Microsoft inter­views. Approach to solve this problem will be slightly 
dif­fer­ent than the approach in “Longest Com­mon Sub­se­quence”

What is Longest Common Substring: A longest substring is a sequence that appears in the same order and necessarily contiguous in both the strings.
Given two string sequences write an algo­rithm to find, find the length of longest sub­string present in both of them.This prob­lem has been asked in Amazon and Microsoft interviews. Approach to solve this prob­lem will be slightly dif­fer­ent than the approach in “Longest Com­mon Sub­se­quence”What is Longest Com­mon Sub­string: A longest sub­string is a sequence that appears in the same order and nec­es­sar­ily con­tigu­ous in both the strings.

Exam­ple:

String A = "tutorialhorizon";

String B = "dynamictutorialProgramming";

Output: Length of Longest Common Substring: 8 ("tutorial").

solution using DP:
Base Cases: If any of the string is null then LCS will be 0.

Check if ith character in one string A is equal to jth character in string B

Case 1: both characters are same

LCS[i][j] = 1 + LCS[i-1][j-1] (add 1 to the result and remove the last character from both the strings and check the result for the smaller string.)

Case 2: both characters are not same.

LCS[i][j] = 0

At the end, traverse the matrix and find the maximum element in it, This will the length of Longest Common Substring.
*/
public class Longest_Common_String {
    private static int max(int a, int b) {
        return a>b?a:b;
    }
    
    private static int max(int a, int b, int c) {
        return a>max(b, c) ? a:max(b, c);
    }
    /*
    bài này ko làm đc kiểu đệ quy vì đây là so sánh chuỗi chung lớn nhất
    Ví dụ: String A = "anhtuta";  String B = "utabk95ta";
    nếu là bài Longest Common Sequence thì có thể làm đc:
    if(a[m-1] == b[n-1]) return 1+LCS_naive(a, b, m-1, n-1);
    else return max(LCS_naive(a, b, m-1, n), LCS_naive(a, b, m, n-1));
    
    Nhưng đây là kiểm tra chuỗi, do đó với 2 String ở trên, ban đầu tìm đc "ta" là phần tử chung, nhưng kết quả LCS của 2 dãy đó ko chứa ta ở vị trí đó mà là uta
    Với Longest Common Sequence sau khi tìm đc 'ta' chung ta bỏ qua và tiếp tục đệ quy với 2 chuỗi: "anhtu" và "utabk95" thì sẽ ra kq
    Nhưng với Longest Common String nếu bỏ đi như thế thì ko tìm đc kq
    */
//    static int LCS_naive(char []a, char []b, int m, int n) {
//        if(m==0 || n==0) return 0;
////        if((a[m-1] == b[n-1]) && m==a.length && n==b.length) return 1 + LCS_naive(a, b, m-1, n-1);
////        if((a[m-1] == b[n-1]) && a[m] == b[n]) return 1 + LCS_naive(a, b, m-1, n-1);
////        if(a[m-1] == b[n-1] && a[m] != b[n]) return max(LCS_naive(a, b, m-1, n), LCS_naive(a, b, m, n-1));
////        if(a[m-1] == b[n-1]) return 1 + LCS_naive(a, b, m-1, n-1);
////        if(a[m-1] == b[n-1]) return 1+LCS_naive(a, b, m-1, n-1);
//        if(a[m-1] == b[n-1]) {
//            if(m>=2 && n>=2) if(a[m-2] == b[m-2]) return 1 + max(LCS_naive(a, b, m-1, n-1), LCS_naive(a, b, m-1, n), LCS_naive(a, b, m, n-1));
//            else return 0;
//            else return 0;
//        }
//        else return max(LCS_naive(a, b, m-1, n), LCS_naive(a, b, m, n-1));
//    }
    
    
    //Ví dụ: str1 = "Javaiseasytolearn", str2 = "JavalearningJavais"
    //ban đầu có LCS là "Java" với độ dài = 4, nhưng sau đó lại có LCS là "Javais" độ dài =6
    //do đó kết quả là 6. Nghĩa là, ban đầu ta thấy LCS của 2 dãy là Java, ta ko thể bỏ qua "Java" và tìm LCS của "iseasytolearn" và "learningJavais"
    //nếu như vậy thì bỏ sót trường hợp
    //Tóm lại, CÁCH LÀM NHƯ SAU: tại vòng lặp thứ i, ta tìm LCS của a[0..i-1] và "cả mảng b" sau đó lưu vào mảng lookup[i]
    //cuối cùng sau khi i lặp đc m lần, tìm phần tử lớn nhất trong mảng lookup[][] sẽ ra kq
    //lookup[i][j] là LCS của dãy a[0..i-1] và b[0..j-1] (i và j phần tử đầu tiên của a và b)
    static int LCS_BottomUp(char []a, char []b) {
        int m = a.length, n = b.length;
        int lookup [][] = new int [m+1][n+1];   //với kí hiệu lookup[i][j] lưu LCS giữa i phần tử đầu của dãy a và j phần tử đầu của dãy b
        int i,j;
        int max = -1;
        
        for (i = 0; i <= m; i++) {      //nếu mảng b rỗng
            lookup[i][0] = 0;
        }
        
        for (i = 0; i <= n; i++) {       //nếu mảng a rỗng
            lookup[0][i] = 0;
        }
        
        for (i = 1; i <= m; i++) {      //chú ý rằng ta ký hiệu i là i phần tử đầu mảng a, nghĩa là mảng a[0..i-1], chứ ko phải a[0..i]
            for (j = 1; j <= n; j++) {
                if(a[i-1] == b[j-1]) {
                    lookup[i][j] = lookup[i-1][j-1] + 1;
                    if(lookup[i][j] > max) max = lookup[i][j];
                }
                else lookup[i][j] = 0;
            }
        }
        
        //thay vì phải tìm max như sau, ta đã tìm max ở trên luôn rồi!
//        for (i = 1; i <= m; i++) {
//            for (j = 1; j <= n; j++) {
//                if(lookup[i][j] > max) max = lookup[i][j];
//            }
//        }
        
        return max;
    }
    
    public static void main(String[] args) {
//        String A = "tutorialhorizon";
//        String B = "dynamictutorialProgramming";
        String A = "anhtuta";
        String B = "utabk95ta";
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        String str1 = "Javaiseasytolearn", str2 = "JavalearningJavais";
        
        char []a = A.toCharArray();
        char []b = B.toCharArray();
        
        
        System.out.println(LCS_BottomUp(a, b));
    }
}
