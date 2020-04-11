package sort;

public class HeapSort {
    /**
     * Use heap sort to sort an arr in asc order
     * First build a max heap
     * Then extract each of the max value, heapify, iterate
     * Namely, move the largest value to the end of the array, heapify prior to the end
     * @param arr
     */
    public void heap_sort(int[] arr) {
        build_max_heap(arr);
        
        for (int i = arr.length - 1; i > 0; i--) {
            int current_max = arr[0];
            arr[0] = arr[i];
            arr[i] = current_max;
            max_heapify(arr, i-1, 0);
        }
    }
    /**
     * Build a max heap with a given arr
     * @param arr
     */
    public void build_max_heap(int[] arr) {
        for(int i = arr.length/2; i >= 0; i--) {
            max_heapify(arr, arr.length-1, i);
        }
    }
    
    /**
     * Maintaining the heap property.
     * Heapify the ith element in the given array arr to meet max heap property.
     * Assumes binary tree that root at left(i), right(i) are max heaps
     * But arr[i] might be smaller than its children
     * @param arr
     * @param n: n is the last index of arr that needs to be heapified
     * @param i
     */
    public void max_heapify(int[] arr, int n, int i) {
        int max_index = i;
        int left_index = i*2 + 1;
        int right_index = i * 2 + 2;
        
        if (left_index <= n && arr[left_index] > arr[max_index]) {
            // swap i and left_index in arr
            max_index = left_index;
        }
        if (right_index <= n && arr[right_index] > arr[max_index]) {
            max_index = right_index;
        }
        
        if (max_index != i) {
            int tmp = arr[max_index];
            arr[max_index] = arr[i];
            arr[i] = tmp;
            max_heapify(arr, n, max_index);
        }
    }
    
    /** A utility function to print array of size n.
     */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }
    
    public static void main(String[] args) {
        int[] arr = {5,3,8,7,90,4,11,89,35};
        
        HeapSort hs = new HeapSort();
        hs.heap_sort(arr);
        
        printArray(arr);
    }
}
