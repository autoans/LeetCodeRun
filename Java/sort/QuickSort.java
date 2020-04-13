package sort;

import utility.IO;

public class QuickSort {
    /**
     * Partition an arr within index [p, r], both inclusive
     * @param arr: array to be sorted
     * @param p: starting index
     * @param r: ending index
     */
    public int partition(int[] arr, int p, int r) {
        int i = p-1;
        int pivot = arr[r];
        for (int j = p; j < r; j++) {
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
            quickSort(arr, p, pivotIndex-1);
            quickSort(arr, pivotIndex+1, r);
        }
    }
    
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {5,3,8,7,90,4,11,89,35};
        qs.quickSort(arr, 0, arr.length-1);
        IO.printArray(arr);
    }
}
