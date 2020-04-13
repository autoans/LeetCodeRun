package sort;

import utility.IO;

public class CountingSort {
    /**
     * Counting sort determines, for each input element x, the number of elements less than x.
     * It uses this information to place element x directly into its position in the output array.
     * @param arrA: array to be sorted
     * @param arrB: result of the sorted array
     * @param k: all the numbers in a are integer, and they are < k, >=0
     */
    public void countingSort(int[] arrA, int[] arrB, int k) {
        int[] arrC = new int[k];
        for(int a: arrA) {
            arrC[a]++;
        }
        // arrC now contains the number of elements equal to index in arrC

        for (int i = 1; i < k; i++) {
            arrC[i] = arrC[i] + arrC[i-1];
        } // arrC now contains the number of elements smaller or equal to i
        
        for (int j = arrA.length-1; j > 0; j--) {
            arrB[arrC[arrA[j]]-1] = arrA[j];
            arrC[arrA[j]]--;
        }
    }
    
    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int[] arrA = {2,5,3,0,2,3,0,3};
        int[] arrB = {0,0,0,0,0,0,0,0};
        int k = 6;
        cs.countingSort(arrA, arrB, k);
        
        IO.printArray(arrB);
    }
}
