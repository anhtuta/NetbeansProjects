package sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * So sánh tốc độ 2 giải thuật Quicksort trên dãy ĐÃ ĐƯỢC SẮP XẾP: 1 bên dùng pivot là phần tử cuối,
 * 1 bên dùng pivot là phần tử giữa. Kết quả sau vài lần chạy thử:
 * 
 * QuickSort: 94ms
 * QuickSortMiddle: 3ms
 * 
 * QuickSort: 60ms
 * QuickSortMiddle: 3ms
 * 
 * QuickSort: 67ms
 * QuickSortMiddle: 2ms
 * 
 * QuickSort: 56ms
 * QuickSortMiddle: 4ms
 * 
 * QuickSort: 111ms
 * QuickSortMiddle: 28ms
 */
public class CompareQuickSort {

    public static void main(String[] args) throws FileNotFoundException {

        // Note: nếu dãy từ 20000 phần tử trở lên, trong trường hợp dãy đã sắp xếp rồi, sẽ bị
        // lỗi StackOverFlow, do có nhiều duplicate: https://stackoverflow.com/a/33887098/7688028.
        String filename = "sort_input2.txt";
        ArrayUtil.genRandomArray(10000, filename);

        System.setIn(new FileInputStream(filename));
        Scanner sc = new Scanner(System.in);

        int[] arr1;
        int temp;
        int len = sc.nextInt();
        arr1 = new int[len];
        SortAlgorithm mergeSort = new MergeSort();
        SortAlgorithm quickSort = new QuickSort();
        SortAlgorithm quickSortMiddle = new QuickSortMiddle();

        for (int i = 0; i < len; i++) {
            temp = sc.nextInt();
            arr1[i] = temp;
        }
        sc.close();

        mergeSort.sort(arr1);
        quickSort.calSortTime(arr1);
        quickSortMiddle.calSortTime(arr1);
    }
}
