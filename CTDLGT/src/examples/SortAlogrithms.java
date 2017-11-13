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
public class SortAlogrithms {
    public static void swap(int [] A, int x, int y) {  //swap(A[x], A[y])
        int temp = A[x];
        A[x] = A[y]; A[y] = temp;
    }
    
    //////////////selectionSort: Sort by descending////////////////////////
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = array[i]; // Lưu phần tử lớn nhất
            int index = i; // lưu vị trí chứa phần tử lớn nhất
            for (int j = i + 1; j < array.length; j++) {
                if(max < array[j]){
                    max = array[j];
                    index = j;
                }
            }
            // Nếu chỉ số đã thay đổi, ta sẽ hoán vị
            if(index != i) swap(array, index, i);
        }
    }
    
    //////////////insertionSort: Sort by ascending////////////////////////
    public static void insertionSort(int[] a) {
        int N = a.length;
        int i,j;
        for (i = 1; i < N; i++) {
            for (j = 0; j < i; j++)
                if(a[i] < a[j]) {
                    //dịch chuyển a[i] về trước a[j], chú ý i đang lớn hơn j:
                    int temp = a[i];
                    for (int k = i; k >j; k--) {
                        a[k]=a[k-1];
                    }
                    a[j]=temp;
                }
        }
    }
    
    ///////////////shell sort://///////////////////////////
    public static void shellSort(int []a) { //áp dụng cho n>701
        int n = a.length;
        int [] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        for (int m = 0; m < gaps.length; m++) {
            int gap = gaps[m];
            
//            # Do a gapped insertion sort for this gap size.
//            # The first gap elements a[0..gap-1] are already in gapped order
//            # keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                int temp = a[i];
                int j = i;

                for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = temp;
            }
        }
    }
    
    
    //////////////bubbleSort: Sort by descending////////////////////////
    public static void bubbleSort(int [] a) {
        int i,j; int N = a.length;
        for (i = 0; i < N; i++) {
            for (j = i+1; j < N; j++) {
                if(a[i] < a[j]) swap(a,i,j);
            }
        }
    }
    
    //////////////mergeSort: Sort by ascending////////////////////////
    public static void mergeSort(int [] a) {
        int N=a.length;
        if(N<2) return;
        merge(a,0,N-1);
    }
    
    public static void merge(int []a, int L, int R) {  //L=left, R=right
        if(L>=R) return;
        int n=(L+R)/2;
        
        merge(a,L,n);
        merge(a,n+1,R);
        mergeArrays(a,L,n,R);
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
    
    ////////////quick sort: sort by ascending/////////////////
    public static void patition(int []a, int L, int R) { //L = left, R = right
        if(L>=R) return;
        int i,j,p; //p = pivot
        i=L+1; j=R; p=a[L];
        while(i<=j) {
            while(i<=j && a[i]<=p) i++;
            while(i<=j && a[j]>=p) j--;
            if(i<j) {
                swap(a, i, j);
                i++; j--;
            }
        }
        
        //nếu i>j thì đã phân đoạn xong dãy trên, 
        swap(a,L,j); //cho chốt p vào đúng vị trí
        //ta làm tương tự với 2 dãy bên trái và bên phải chốt p:
        patition(a, L, j-1);
        patition(a, j+1, R);
    }
    
    public static void quickSort(int []a) {
        int N=a.length;
        patition(a, 0, N-1);
    }
    
    
    /////////////heap sort//////////////////////
    //Hoán vị nút cha thứ i phải lớn hơn nút con(vun đống)
    public static void heapify(int A[], int n, int i) {
        int Left = 2 * (i + 1) - 1;
        int Right = 2 * (i + 1);
        int Largest;
        if (Left < n && A[Left] > A[i]) {
            Largest = Left;
        } else {
            Largest = i;
        }
        if (Right < n && A[Right] > A[Largest]) {
            Largest = Right;
        }
        if (i != Largest) {
            swap(A,i,Largest);
            heapify(A, n, Largest);
        }
    }
    
    //xây dựng Heap sao cho mỗi nút cha luôn lớn hơn nút con trên cây (tạo cây)
    public static void buildHeap(int A[], int n) {
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }
    }
    
    // heap-sort
    public static void heapSort(int A[], int n) {
        buildHeap(A, n);
        for (int i = n - 1; i > 0; i--) {
            swap(A, 0, i);
            heapify(A, i, 0);  //vun đống cho i phần tử đầu tiên. ban đầu i=n-1, tức là vun đống cho cả dãy.
                               //sau mỗi lần vun đống phần tử cuối cùng đã đc sắp xếp nên ta loại nó khỏi cây
                              //và vun đống phần còn lại. cứ như vậy đến hết.
        }
    }
}

class Test {
    public static void main(String[] args) {
        SortAlogrithms sa = new SortAlogrithms();
        
        int[] arr = {10, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1};
        System.out.println("arr.length = "+arr.length);
        
        long t = System.currentTimeMillis();
        //SortAlogrithms.heapSort(arr, arr.length);  //arr cũng bị thay đổi, do tham số truyền vào hàm là mảng
        SortAlogrithms.shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        long t2 = System.currentTimeMillis()-t;
        System.out.println("\nTime to sort and print result = "+t2+"ms");
        
    }
    
}

//chú ý: hàm sort ko cần để static cũng đc, khi đó trong hàm main phải làm như sau:
//SelectionSort ss = new SortAlogrithms();
//int[] arr = {10, 6, 3, 7, 12, 4, 4, 16, 8, 0, 12, 12, 12, 45, 2, 41, 5, 2, 1, 34};
//ss.sort(arr);
//int [] b = arr;
//như vậy ko hay lắm vì ss ko có thuộc tính gì thì ta nên để hàm sort là static thì
//khi sử dụng nó ko cần khởi tạo 1 đối tượng
