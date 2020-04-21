package binarySearch;

import java.util.Arrays;
import java.util.Collections;

public class CocoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = getMax(piles);
        
        while (low < high) {
            int total = 0;
            int mid = low + (high - low) / 2;
            for (int pile : piles) {
                total+= (pile + mid - 1)/mid;
            }
            
            if (total <= H) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    public int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        
        for (int a: arr) {
            max = Math.max(a, max);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        CocoEatingBananas sa = new CocoEatingBananas();
        //int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        int[] arr = {3,6,7,11};
        System.out.println(sa.minEatingSpeed(arr, 8));
    }
}
