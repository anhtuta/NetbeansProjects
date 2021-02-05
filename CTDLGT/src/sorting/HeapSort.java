package sorting;

public class HeapSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) { // tại sao ko phải là i>=0 nhỉ?
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    @Override
    public String getSortName() {
        return "HeapSort";
    }

    ///////////// heap sort//////////////////////
    // Hoán vị nút cha thứ i phải lớn hơn nút con(vun đống)
    private void heapify(int arr[], int n, int i) {
        int Left = 2 * (i + 1) - 1;
        int Right = 2 * (i + 1);
        int Largest;
        if (Left < n && arr[Left] > arr[i]) {
            Largest = Left;
        } else {
            Largest = i;
        }
        if (Right < n && arr[Right] > arr[Largest]) {
            Largest = Right;
        }
        if (i != Largest) {
            swap(arr, i, Largest);
            heapify(arr, n, Largest);
        }
    }

    // xây dựng Heap sao cho mỗi nút cha luôn lớn hơn nút con trên cây (tạo cây)
    private void buildHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

}
