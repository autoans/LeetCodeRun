package sort;

public class QuickSort {
    /**
     * Partition an arr within index [p, r], both inclusive
     * @param arr: array to be sorted
     * @param p: starting index
     * @param r: ending index
     */
    public int partition(int[] arr, int p, int r) {
        int i = -1;
        int pivot = arr[r];
        for (int j = p; j < r-1; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                // swap arr[i] and arr[j]
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        
        //swap arr[i+1] and pivot
        arr[r] = arr[i+1];
        arr[i+1] = pivot;
        return i+1;
    }
    
    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int pivotIndex = partition(arr, p, r);
            quickSort(arr, p, pivotIndex);
            quickSort(arr, pivotIndex, r);
        }
    }
}
