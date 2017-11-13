/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back_tracking;

/**
 *
 * @author AnhTu
 */
/*
Write a program to print all permutations of a given string
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.
Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB
*/
public class LietKeHoanVi_2 {
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param s starting index
     * @param e end index
     */
    static int count=0;
    
    static void permute(String str, int s, int e) {
        if(s == e) {
            System.out.println(str); //print result
            count++;
        }
        else  {
            for (int i = s; i <= e; i++) {
                str = swap(str, s, i);
                permute(str, s+1, e);
                str = swap(str, s, i);
            }
        }
    }

    private static String swap(String str, int s, int e) {
        if(s==e) return str;
        char []arr = str.toCharArray();
        char temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        return String.valueOf(arr);
    }
    
    ////////cách trên làm theo trang http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    //cách sau đây làm theo thầy Nghĩa:
    static char []a = new char[100];      //a là mảng chứa các phần tử của tập hoán vị, nghĩa là mảng kết quả
    static char []str = new char[100];      //mảng này chứa string đầu vào, ví dụ str = "anhtu" thì mảng này str= {'a', 'n', 'h', 't', 'u'}
    static int n;   //nhập n nhỏ thôi để thử
    
    static boolean thuocTapUCV(int i, int k) {     //kiểm tra xem str[i] có thuộc tập UCV Sk hay ko, 
        //nghĩa là ta cần kiểm tra xem từ a[0]-a[k-1] có thằng nào = str[i] hay ko, 
        //nếu có 1 thằng = str[i] rồi thì a[k] ko thể = str[i] đc nữa, nghĩa là str[i] ko thuộc Sk
        for (int j = 0; j <= k-1; j++) {
            if(a[j] == str[i]) return false;
        }
        return true;
    }
    
    static void ghiNhan() {
        count++;
        printArray(a);
    }
    
    public static void printArray(char []a) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    static void hoanVi(int k) {
        for (int i = 0; i < n; i++) {
            if(thuocTapUCV(i, k)) {     //với mỗi vòng lặp của i, kiểm tra xem str[i] có thuộc tập UCV Sk hay ko, nếu có thì cho a[k] = str[i]
                a[k] = str[i];
                if(k==(n-1)) ghiNhan();
                else hoanVi(k+1);
            }
        }
    }
    
    public static void main(String[] args) {
        String str1 = "ABC";
//        int m = str1.length();
//        LietKeHoanVi_2.permute(str1, 0, m-1);
//        System.out.println("Number of permutations: "+count);
        
        str = str1.toCharArray();
        n = str1.length();
        hoanVi(0);
        System.out.println("Số hoán vị là: "+count);
        
    }
}
