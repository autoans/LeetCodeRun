package sort;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSelect {
    /**
     * Partition an arr within index [p, r], both inclusive
     * @param arr: array to be sorted
     * @param p: starting index
     * @param r: ending index
     */
    public int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p-1;
        for (int j = p; j < r-1; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap i, j
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        
        // swap i+1 and r
        arr[r] = arr[i+1];
        arr[i+1] = pivot;
        
        return i+1;
    }
    
    /**
     * Select a randomized index i between p and r, exchange arr[i] with arr[r]
     * then partition on arr
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public int randomizedPartition(int[] arr, int p, int r) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomIndex = ThreadLocalRandom.current().nextInt(p, r + 1);
        int pivot = arr[randomIndex];
        
        // swap randomIndex and r
        arr[randomIndex] = arr[r];
        arr[r] = pivot;
        return partition(arr, p, r);
    }
    
    /**
     * 
     * @param arr
     * @param p
     * @param r
     * @param i
     * @return ith smallest number in arr[p, r]
     */
    public int randomizedSelect(int[] arr, int p, int r, int i) {
        if (p == r) return arr[p];
        int q = randomizedPartition(arr, p, r);
        int k = q - p + 1;
        if (i == k)
            return arr[q];
        else if (i < k)
            return randomizedSelect(arr, p, q, i);
        else
            return randomizedSelect(arr, q, r, i-k);
    }
    
    public static void main(String args[]) {
        RandomizedSelect rs = new RandomizedSelect();
        int[] arr = {2,8,3,6,9,1};
        System.out.println(rs.randomizedSelect(arr, 0, arr.length-1, 4));
    }
}
