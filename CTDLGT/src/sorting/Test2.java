package sorting;

/**
 * Thử với trường hợp: dãy đã sắp xếp, thêm 1 phần tử vào dãy và sắp xếp lại. KQ:
 * InsertionSort: 464ms
 * MergeSort: 27ms
 * QuickSortMiddle: 7ms
 * HeapSort: 47ms
 * => QuickSort vẫn nhanh nhất
 */
public class Test2 {

    public static void initArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 2;
        }
        arr[arr.length - 1] = 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[50000];

        Test2.initArray(arr);
        SortAlgorithm insert = new InsertionSort();
        insert.calSortTime(arr);

        Test2.initArray(arr);
        SortAlgorithm merge = new MergeSort();
        merge.calSortTime(arr);

        Test2.initArray(arr);
        SortAlgorithm quick = new QuickSortMiddle();
        quick.calSortTime(arr);

        Test2.initArray(arr);
        SortAlgorithm heap = new HeapSort();
        heap.calSortTime(arr);
    }
}
