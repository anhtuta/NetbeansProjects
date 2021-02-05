package sorting;

public class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        int i, j;
        int N = arr.length;
        for (i = 0; i < N; i++) {
            for (j = i + 1; j < N; j++) {
                if (arr[i] < arr[j])
                    swap(arr, i, j);
            }
        }
    }

    @Override
    public String getSortName() {
        return "BubbleSort";
    }

}
