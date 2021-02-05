package sorting;

public class InsertionSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        int N = arr.length;
        int i, j;
        for (i = 1; i < N; i++) {
            for (j = 0; j < i; j++)
                if (arr[i] < arr[j]) {
                    // dịch chuyển a[i] về trước a[j], chú ý i đang lớn hơn j:
                    int temp = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = temp;
                }
        }
    }

    @Override
    public String getSortName() {
        return "InsertionSort";
    }

}
