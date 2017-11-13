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
Bài đầu tiên của sách CTDL&GT của thầy Nghĩa:
ví dụ cho dãy: -2,11,-4,13,-5,2 thì trọng lượng lớn nhất của dãy con là 20, là trọng lượng của dãy 11,-4,13

*/
public class Heaviest_Subsequence {
    static int [][]L;
    /*
    Cách đơn giản nhất là duyệt tất cả các dãy con có thể:
    Cách duyệt:
        duyệt tất cả các dãy con có phần tử đầu tiên là a[0]
        duyệt tất cả các dãy con có phần tử đầu tiên là a[1]
        duyệt tất cả các dãy con có phần tử đầu tiên là a[2]
        duyệt tất cả các dãy con có phần tử đầu tiên là a[3]
        ...
        duyệt tất cả các dãy con có phần tử đầu tiên là a[n-2]
        duyệt tất cả các dãy con có phần tử đầu tiên là a[n-1]
    
        tính maxSub từ từng trường hợp trên
    */
    static int maxSub_naive(int []a) {
        int n = a.length;
        int i,j;
        int maxSub = 0, sum = 0;
        
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = i; j < n; j++) {   
                sum = sum + a[j];
                if(sum > maxSub) maxSub = sum;
            }
        }
        
        return maxSub;
    }
    
    
    //Cách 2: dùng đệ qui: diễn giải chi tiết xem trong vở, bài này dùng Divide and conquer
    static int maxSub_Recursion(int []a, int s, int e) {
        if(s >= e) return a[s];
        int mid = (s+e)/2;
        int wL = maxSub_Recursion(a, s, mid);
        int wR = maxSub_Recursion(a, mid+1, e);
        int wM = maxSubMid(a, s, mid, e);
        return max(wL, wR, wM);
    }
    
    private static int max(int a, int b, int c) {
        int max;
        if(a > b) max = a;
        else max = b;
        if(c > max) max = c;
        
        return max;
    }
    
    private static int maxSubMid(int[] a, int s, int mid, int e) {
        int i;
        int sum = 0;
        int max = mid;
        
        //nửa trái của mid:
        for (i = mid; i >= s; i--) {
            sum = sum + a[i];
            if(max < sum) max = sum;
        }
        
        sum = max;
        
        //nửa phải của mid:
        for (i = mid+1; i <= e; i++) {
            sum = sum + a[i];
            if(max < sum) max = sum;
        }
        
        return max;
    }
    static int maxSub_DP_TopDown(int []a, int s, int e) {
        L = new int[500][500];
        return maxSub_TopDown(a, s, e);
    }
    
    static int maxSub_TopDown(int []a, int s, int e) {
        if(L[s][e] == 0) {
            if(s >= e) L[s][e] = a[s];
            else {
                int mid = (s+e)/2;
                int wL = maxSub_TopDown(a, s, mid);
                int wR = maxSub_TopDown(a, mid+1, e);
                int wM = maxSubMid(a, s, mid, e);
                L[s][e] = max(wL, wR, wM);
            }
        }
        return L[s][e];
    }
    
    
    //cách 3: dùng quy hoạch động: xem giải thích trong vở và sách
    static int maxSub_DP(int []a) {     //DP là kiểu Bottom-up
        int smax = a[0];
        int mEH = a[0];     //mEH = maxEndHere = khối lượng lớn nhất của "dãy con kết thúc tại a[i]"
        int imax = 0;
        int i;
        
        for (i = 1; i < a.length; i++) {
            if(mEH + a[i] > a[i]) mEH = mEH + a[i];		// sao ko ghi là if(mEH > 0) cho nhanh :))
            else mEH = a[i];
            
            if(mEH > smax) {
                smax = mEH;
                imax = i;
            }
        }
        
        return smax;
    }
    
    
    public static void main(String[] args) {
        //int [] a = {-2,11,-4,13,-5,2};
        int []a = {-2,11,-4,13,-5,2,3,5,2,1,-2,3,-4,12,-32,33,43,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,-4,12,-32,33,43,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,-4,12,-32,33,43,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,-4,12,-32,33,43,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,-4,12,-32,33,43,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,-4,12,-32,33,43,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3,99,4,33,-11,-19,33,-99,30,-03,33,31,55,-3,-33,9,-2,-22,-2,11,-4,13,-5,2,3,5,2,1,-2,3};
        int n = a.length;
        long curr;
        curr = System.currentTimeMillis();
        System.out.println(maxSub_naive(a));
        System.out.println("Thời gian thực hiện khi dùng maxSub_naive là: "+(System.currentTimeMillis() - curr) + "(ms)");
        
        curr = System.currentTimeMillis();
        System.out.println(maxSub_DP_TopDown(a, 0, n-1));
        System.out.println("Thời gian thực hiện khi dùng maxSub_TopDown là: "+(System.currentTimeMillis() - curr) + "(ms)");
        
        curr = System.currentTimeMillis();
        System.out.println(maxSub_Recursion(a, 0, n - 1));
        System.out.println("Thời gian thực hiện khi dùng maxSub_Recursion là: "+(System.currentTimeMillis() - curr) + "(ms)");
        
        curr = System.currentTimeMillis();
        System.out.println(maxSub_DP(a));
        System.out.println("Thời gian thực hiện khi dùng maxSub_BottomUp là: "+(System.currentTimeMillis() - curr) + "(ms)");
    }
}
/*
kq: 
- Trường hợp worst của TopDown:
1826
Thời gian thực hiện khi dùng maxSub_naive là: 9(ms)
1826
Thời gian thực hiện khi dùng maxSub_TopDown là: 9(ms)
1826
Thời gian thực hiện khi dùng maxSub_Recursion là: 3(ms)
1826
Thời gian thực hiện khi dùng maxSub_BottomUp là: 1(ms)

- Trường hợp bình thường:
1826
Thời gian thực hiện khi dùng maxSub_naive là: 5(ms)
1826
Thời gian thực hiện khi dùng maxSub_TopDown là: 3(ms)
1826
Thời gian thực hiện khi dùng maxSub_Recursion là: 2(ms)
1826
Thời gian thực hiện khi dùng maxSub_BottomUp là: 0(ms)

Rõ ràng đệ quy nhanh hơn top-down???
*/
