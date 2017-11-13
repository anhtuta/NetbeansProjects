/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author AnhTu
 */
public class HeapSort {
    public static int max(int a, int b, int c) {
        int m = max(a,b);
        return m>c?m:c;
    }
    
    private static int max(int a, int b) {
        return a>b?a:b;
    }
    
    private static void swap(int[] a, int m, int i) {
        int temp = a[m];
        a[m] = a[i];
        a[i] = temp;
    }
    
    public static void maxHeapify(int []a, int i, int n) {  //n=arr.length
        int l = 2*i+1;
        int r = 2*i+2;
        int largest;
        
        //tìm số lớn nhất trong 3 số: A[r], A[l], A[i], sau đó largest = chỉ số của số lớn nhất đó
        if(l<n && a[l] > a[i]) largest=l;
        else largest = i;
        if(r<n && a[r] > a[largest]) largest=r;
        
        if(largest != i) {
            swap(a, largest, i);
            maxHeapify(a, largest, n);  // Recursively heapify the affected sub-tree
        }
    }

    public static void buildMapHeap(int []a) {
        int n = a.length;
        for (int i = (n-1)/2; i >= 0; i--) {    //ko ap dụng với các phần tử là lá, do đó chỉ cần áp dụng với các phần tử a[0] -> a[(n-1)/2]
            maxHeapify(a, i, n);
        }
    }
    
    public static void heapSort(int []a) {
        buildMapHeap(a);
        int n =a.length;
        for (int i = n - 1; i >= 0;i--) {
            swap(a, 0, i);
            maxHeapify(a, 0, i);
        }
    }

    public static void printArr(int []a) {
        int n=a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        //int[] arr = {10, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1};
        //int [] arr = {10, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0};
        int []arr = {4,1,3,2,16,9,10,14,8,7};
        int n = arr.length;
        printArr(arr);
        //buildMapHeap(arr);
        heapSort(arr);
        System.out.println("\nAfter sorting:");
        printArr(arr);
    }
}
