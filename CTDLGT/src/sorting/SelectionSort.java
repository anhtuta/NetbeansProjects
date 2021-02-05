package sorting;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            // Nếu chỉ số đã thay đổi, ta sẽ hoán vị
            if (index != i)
                swap(arr, index, i);
        }
    }

    @Override
    public String getSortName() {
        return "SelectionSort";
    }

}
