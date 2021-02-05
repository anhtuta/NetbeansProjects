/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package sorting;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void genRandomArray(int length) {
        try {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter("SortAlogrithms_input.txt"));
            bufferedWriter.write(length + "");
            bufferedWriter.newLine();
            Random rd = new Random();
            int bound = (int) (length);

            for (int i = 0; i < length; i++) {
                bufferedWriter.write(rd.nextInt(bound) + " ");
            }
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }

    public static void copyArray(int[] from, int[] to) {
        int len = from.length;
        for (int i = 0; i < len; i++) {
            to[i] = from[i];
        }
    }

    public static void reverseArray(int[] arr) {
        SortAlgorithm sa = new QuickSort();
        int len = arr.length;
        for (int i = 0; i < (len - 1) / 2; i++) {
            sa.swap(arr, i, len - 1 - i);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        // genRandomArray(100000);

        System.setIn(new FileInputStream("SortAlogrithms_input.txt"));
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
        SortAlgorithm quickSort = new QuickSort();
        SortAlgorithm heapSort = new HeapSort();

        for (int i = 0; i < len; i++) {
            temp = sc.nextInt();
            arr1[i] = temp;
        }
        sc.close();

        System.out.println("\nRandom:");

        copyArray(arr1, arr2);
        selectionSort.calSortTime(arr2);

        copyArray(arr1, arr2);
        insertionSort.calSortTime(arr2);

        copyArray(arr1, arr2);
        bubbleSort.calSortTime(arr2);

        copyArray(arr1, arr2);
        mergeSort.calSortTime(arr2);

        copyArray(arr1, arr2);
        quickSort.calSortTime(arr2);

        copyArray(arr1, arr2);
        heapSort.calSortTime(arr2);

        System.out.println("\nAlready sorted:");

        selectionSort.calSortTime(arr2);
        insertionSort.calSortTime(arr2);
        bubbleSort.calSortTime(arr2);
        mergeSort.calSortTime(arr2);
        quickSort.calSortTime(arr2);
        heapSort.calSortTime(arr2);

        System.out.println("\nReverse:");

        reverseArray(arr2);
        selectionSort.calSortTime(arr2);

        reverseArray(arr2);
        insertionSort.calSortTime(arr2);

        reverseArray(arr2);
        bubbleSort.calSortTime(arr2);

        reverseArray(arr2);
        mergeSort.calSortTime(arr2);

        reverseArray(arr2);
        quickSort.calSortTime(arr2);

        reverseArray(arr2);
        heapSort.calSortTime(arr2);
    }
}
