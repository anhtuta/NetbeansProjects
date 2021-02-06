package sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArrayUtil {

    public static void genRandomArray(int length, String filename) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
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
        System.out.print(arr[arr.length - 1] + "]\n");
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
}
