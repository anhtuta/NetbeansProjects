package sorting;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        int N = arr.length;
        if (N < 2)
            return;
        merge(arr, 0, N - 1);
    }

    @Override
    public String getSortName() {
        return "MergeSort";
    }

    private void merge(int[] arr, int L, int R) { // L=left, R=right
        if (L >= R)
            return;
        int n = (L + R) / 2;

        merge(arr, L, n);
        merge(arr, n + 1, R);
        mergeArrays(arr, L, n, R);
    }

    private void mergeArrays(int[] arr, int L, int n, int R) {
        int i = L, j = n + 1, k = 0;
        int bleng = R - L + 1;
        int[] b = new int[bleng];
        while ((i <= n) && (j <= R)) {
            if (arr[i] < arr[j]) {
                b[k] = arr[i];
                i++;
                k++;
            } else {
                b[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= n) {
            b[k] = arr[i];
            i++;
            k++;
        }

        while (j <= R) {
            b[k] = arr[j];
            j++;
            k++;
        }

        // now a = b:
        i = L;
        for (k = 0; k < bleng; k++) {
            arr[i] = b[k];
            i++;
        }
    }
}
