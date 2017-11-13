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
public class MergeSort {
    public static void mergeSort(int [] a) {
        int N=a.length;
        if(N<2) return;
        merge(a,0,N-1);
    }

    private static void merge(int[] a, int L, int R) {
        if(L>=R) return;
        int mid = (L+R)/2;
        merge(a, L, mid);
        merge(a, mid+1, R);
        mergeArrays(a, L, mid, R);
    }
    
    public static void mergeArrays(int []a, int L, int n, int R) {
        int i=L, j=n+1, k=0;
        int bleng = R-L+1;
        int [] b= new int[bleng];
        while((i<=n) && (j<=R)) {
            if(a[i] < a[j]) {
                b[k] = a[i];
                i++; k++;
            }
            else {
                b[k]=a[j];
                j++; k++;
            }
        }
        
        while(i<=n) {
            b[k] = a[i];
            i++; k++;
        }
        
        while(j<=R) {
            b[k] = a[j];
            j++; k++;
        }
        
        //now a = b:
        i=L;
        for (k = 0; k < bleng; k++) {
            a[i] = b[k];
            i++;
        }
    }
    
}
