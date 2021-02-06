/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        String filename = "sort_input1.txt";
        ArrayUtil.genRandomArray(100000, filename);

        System.setIn(new FileInputStream(filename));
        Scanner sc = new Scanner(System.in);

        int[] arr1, arr2;
        int temp;
        int len = sc.nextInt();
        arr1 = new int[len];
        arr2 = new int[len];
        SortAlgorithm selectionSort = new SelectionSort();
        SortAlgorithm insertionSort = new InsertionSort();
        SortAlgorithm bubbleSort = new BubbleSort();
        SortAlgorithm mergeSort = new MergeSort();
        SortAlgorithm quickSort = new QuickSortMiddle();
        SortAlgorithm heapSort = new HeapSort();

        for (int i = 0; i < len; i++) {
            temp = sc.nextInt();
            arr1[i] = temp;
        }
        sc.close();

        System.out.println("\nRandom:");

        ArrayUtil.copyArray(arr1, arr2);
        selectionSort.calSortTime(arr2);

        ArrayUtil.copyArray(arr1, arr2);
        insertionSort.calSortTime(arr2);

        ArrayUtil.copyArray(arr1, arr2);
        bubbleSort.calSortTime(arr2);

        ArrayUtil.copyArray(arr1, arr2);
        mergeSort.calSortTime(arr2);

        ArrayUtil.copyArray(arr1, arr2);
        quickSort.calSortTime(arr2);

        ArrayUtil.copyArray(arr1, arr2);
        heapSort.calSortTime(arr2);

        System.out.println("\nAlready sorted:");

        selectionSort.calSortTime(arr2);
        insertionSort.calSortTime(arr2);
        bubbleSort.calSortTime(arr2);
        mergeSort.calSortTime(arr2);
        quickSort.calSortTime(arr2);
        heapSort.calSortTime(arr2);

        System.out.println("\nReverse:");

        ArrayUtil.reverseArray(arr2);
        selectionSort.calSortTime(arr2);

        ArrayUtil.reverseArray(arr2);
        insertionSort.calSortTime(arr2);

        ArrayUtil.reverseArray(arr2);
        bubbleSort.calSortTime(arr2);

        ArrayUtil.reverseArray(arr2);
        mergeSort.calSortTime(arr2);

        ArrayUtil.reverseArray(arr2);
        quickSort.calSortTime(arr2);

        ArrayUtil.reverseArray(arr2);
        heapSort.calSortTime(arr2);
    }
}
