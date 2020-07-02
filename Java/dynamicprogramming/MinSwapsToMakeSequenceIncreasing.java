package dynamicprogramming;

/**
 * 801. Minimum Swaps To Make Sequences Increasing
 * credit: https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C%2B%2BJavaPython-DP-O(N)-Solution
 * @author Katherine
 *
 */
public class MinSwapsToMakeSequenceIncreasing {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        /**
         * swap[n] means the minimum swaps to make the A[i] and B[i] sequences increasing for 0 <= i <= n,
            in condition that we swap A[n] and B[n]
            not_swap[n] is the same with A[n] and B[n] not swapped.
         */
        int[] swap = new int[len];
        int[] not_swap = new int[len];
        swap[0] = 1;
        
        /**
         * if A[i] > A[i-1] && B[i] > B[i-1]
         *      -> not swap i && not swap i-1
         *      -> swap i && swap i-1
         * if A[i] > B[i-1] && B[i] > A[i-1]
         *      -> swap i-1 && keep i
         *      -> swap i && keep i-1
         */
        
        for (int i = 1; i < A.length; i++) {
            swap[i] = i;
            not_swap[i] = i;
            
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                swap[i] = swap[i-1]+1;
                not_swap[i] = not_swap[i-1];
            }
            
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                not_swap[i] = Math.min(not_swap[i], swap[i-1]);
                swap[i] = Math.min(not_swap[i-1]+1, swap[i]);
            }
        }
        
        return Math.min(swap[len-1], not_swap[len-1]);
    }
    
    public static void main(String[] args) {
        int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};
        
        MinSwapsToMakeSequenceIncreasing ms = new MinSwapsToMakeSequenceIncreasing();
        System.out.println(ms.minSwap(A, B));
    }
}
