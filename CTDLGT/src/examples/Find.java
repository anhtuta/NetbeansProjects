/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author AnhTu
 */
public class Find {
    public static int binaryFind(int []A, int s, int e, int key) {  //s = start position of A, e = end position of A
	if(s>e) return -1;
	int mid = (s+e)/2;
	if(A[mid] == key) return mid;
        if(A[mid] < key) return binaryFind(A, mid+1, e, key);
        else return binaryFind(A, s, mid-1, key);     //(A[mid] > key)
    }
    
    public static int doDaiDayConTangDaiNhat(int []A, int s, int e) {
        if(s==e) return 1;
        int mid = (s+e)/2;
        int L = doDaiDayConTangDaiNhat(A, s, mid);      //chú ý rằng việc tính doDaiDayConTangDaiNhat() cũng dựa vào hàm doDaiDayConOGiua()
        int R = doDaiDayConTangDaiNhat(A, mid+1, e);
        int midLen = doDaiDayConOGiua(A, s, mid, e);
        return max(L, R, midLen);
    }
    
    private static int doDaiDayConOGiua(int[] A, int s, int mid, int e) {
        int i = mid, len = 1;   //chú ý ràng len bắt đầu = 1
        while((i > s) && (A[i] >= A[i-1])) {
            i--;
            len++;
        }
        i=mid;
        while((i < e) && (A[i] < A[i+1])) {
            i++;
            len++;
        }
        return len;
    }
    
    private static int max(int a, int b, int c) {
        if(a >= b) {
            return a>c ? a:c;
        } else return b>c ? b:c;
    }
    
    public static void main(String[] args) {
        int [] A = {2,3,5,6,9,10,11,13,32,44,55,56,89,99,101,111,121,134,156,178,199,202};
        int key=9;
        System.out.println("Vị trí của phần tử "+key+" trong mảng A: "+Find.binaryFind(A, 0, A.length-1, key));
        System.out.println("Độ dài dãy con tăng dài nhất của mảng A: "+Find.doDaiDayConTangDaiNhat(A, 0, A.length-1));
        System.out.println("A.length = "+A.length);
        
        int [] B = {2,3,5,6,9,10,18,13,32,44,55,56,89,99,101,111,121,134,156,122,199,202};
        System.out.println("Độ dài dãy con tăng dài nhất của mảng B: "+Find.doDaiDayConTangDaiNhat(B, 0, B.length-1));
        
    }


}
