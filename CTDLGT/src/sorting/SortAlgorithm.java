package sorting;

public interface SortAlgorithm {

    public void sort(int[] arr);
    
    public String getSortName();

    public default void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public default void calSortTime(int[] arr) {
        long t1 = System.currentTimeMillis();
        sort(arr);
        long t2 = System.currentTimeMillis() - t1;
        System.out.println(getSortName() + ": " + t2 + "ms");
    }
}
