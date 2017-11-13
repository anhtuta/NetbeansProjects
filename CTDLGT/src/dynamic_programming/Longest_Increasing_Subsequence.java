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
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence 
such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

More Examples:
Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

Optimal Substructure:
Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
(arr là mảng đầu vào và L[i] là độ dài của dãy con tăng dài nhất có phần tử cuối là arr[i] (nghĩa là phần tử cuối cùng của dãy đó là arr[i] và dãy đó là dãy tăng dài nhất)
Then, L(i) can be recursively written as:
L(i) = 1 + max{L(j)} nếu arr[j] < arr[i] với j=1 đến i-1,  or
L(i) = 1, if no such j exists.

To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n. (sau đó tìm phần tử lớn nhất trong mảng L[] là đc)
Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using solutions to subproblems.

Example:

A[] = {3, 4, 1, 5}

i=1 , LIS(1) = 1

i=2 , LIS(2) = 1+ Max(LIS(1)) = 1 +1 =2 (4>3)

i=3 , LIS(3) = 1 (1>3, 1>4)

i=4 , LIS(4) = 1+ Max(LIS(1),LIS(2), LIS(3))

= 1 + Max(1,2,1) = 3
*/

//see more: http://algorithms.tutorialhorizon.com/dynamic-programming-longest-increasing-subsequence/
//and: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

public class Longest_Increasing_Subsequence {
    static int LIS(int [] a) {  //chắc theo kiểu Bottom-up
        int n = a.length;
        int [] L = new int[n];
        
        int i,j;
        for (i = 0; i < n; i++) {
            int Li = 1;    //biến tạm để tính L[i], chú ý rằng L[i] là độ dài của dãy con tăng dài nhất có phần tử cuối là a[i], do đó L[i] luôn >= 1, với mọi i
            for (j = 0; j < i; j++) {   //mỗi phần tử a[i], ta phải duyệt từ đầu mảng tới vị trí i để tìm L[i]
                if(a[i] > a[j] && Li <= L[j]) Li = L[j] + 1;
            }
            
            L[i] = Li;
            //Xem minh họa quá trình với i=5 ở hình ảnh LIS.png
        }
        
        //Tìm giá trị lớn nhất trong mảng L[]:
        int max = L[0];
        for (i = 1; i < n; i++) {
            if(L[i] > max) max = L[i];
        }
        
        //in ra kết quả dãy con đó, bắt buộc phải duyệt theo thứ tự ngược lại để in, nghĩa là duyệt từ cuối của dãy a:
        System.out.println("Dãy con tăng dài nhất là:");
        int temp = max;
        StringBuilder builder = new StringBuilder();
        
        for (i=n-1; i>=0; i--) {
            if(L[i] == temp) {
                builder.insert(0, a[i]+" ");
                temp--;
            }
        }
        
        System.out.println(builder);
        System.out.println("Chiều dài của dãy con trên là: "+max+"\n");
        return max;
    }
    
    public static void main(String[] args) {
        int [] a = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
        int [] b = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int arr[] = {50, 3, 10, 7, 40, 80};
        LIS(a);     //7
        LIS(b);     //5
        LIS(arr);   //4
    }
}
