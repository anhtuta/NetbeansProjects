package sorting;

public class ShellSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) { // áp dụng cho n > 701
        int n = arr.length;
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        for (int m = 0; m < gaps.length; m++) {
            int gap = gaps[m];

            // # Do a gapped insertion sort for this gap size.
            // # The first gap elements a[0..gap-1] are already in gapped order
            // # keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j = i;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    @Override
    public String getSortName() {
        return "ShellSort";
    }

}
