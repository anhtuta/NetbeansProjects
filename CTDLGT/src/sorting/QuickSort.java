package sorting;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        int N = arr.length;
        quickSort(arr, 0, N - 1);
    }

    @Override
    public String getSortName() {
        return "QuickSort";
    }

    private int partition(int arr[], int L, int R) {
        // Chọn 1 số ở giữa dãy làm pivot, sau đó chuyển pivot về cuối dãy
        // Nếu chọn số đầu/cuối là pivot, thì trong trường hợp dãy đã sắp xếp rồi, sẽ bị
        // lỗi StackOverFlow, do có nhiều duplicate: https://stackoverflow.com/a/33887098/7688028.
        // Còn nữa, với pivot là đầu/cuối, và dãy đã được sắp xếp, thì thời gian sắp xếp
        // lâu hơn rất nhiều mergesort/quicksort (có khi gấp 10 lần) (Đã test thử với n = 10000)
//        swap(arr, (L + R) / 2, R);

        int pivot = arr[R];
        int i = (L - 1); // index of smaller element
        for (int j = L; j < R; j++) {
            // If current element is smaller than the pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[R] (or pivot)
        swap(arr, i + 1, R);

        return i + 1;
    }

    private void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, L, R);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, L, pi - 1);
            quickSort(arr, pi + 1, R);
        }
    }


}
