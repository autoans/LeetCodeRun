package LeetcodeChallenge;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * @author Katherine
 *
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int p1 = -1; // slow pointer, keeps the position of 0
        
        for (int p2 = 0; p2 < nums.length; p2++) {
         // need to find the first 0's position
            if (p1 == -1 && nums[p2] == 0) 
                p1 = p2;
            
            if (nums[p2] != 0 && p1 != -1) {
                // swap in place
                nums[p1] = nums[p2];
                p1++;
            }
        }
        
        if (p1 != -1)
            IntStream.range(p1, nums.length).forEach(index -> nums[index]=0);
    }
    
    public void moveZeroes2(int[] nums) {
        int insertIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[insertIndex++] = nums[i];
        }
        
        while (insertIndex != 0 && insertIndex < nums.length)
            nums[insertIndex++]=0;
    }
    
    public static void main(String[] args) {
        int[] nums = {1};//{0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes2(nums);
        
        for (int i: nums) {
            System.out.print(i+" ");
        }
    }
}
