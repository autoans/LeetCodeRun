package binarySearch;

public class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int mid = start + (end - start)/ 2;
            if (nums[mid] == nums[mid + 1]) {
                // should be even amount of numbers in the second half
                if ((end - mid + 1) % 2 == 0) {
                    end = mid-1; // in the first half
                } else {
                    start = mid; // in the second half
                }
            } else if (nums[mid] == nums[mid - 1]){
                // should be even amount of number in the 0~mid
                if ((mid - start + 1) % 2 == 0) {
                    start = mid+1; // in the second half
                } else {
                    end = mid; // in the first half
                }
            } else {
                return nums[mid];
            }
        }
        
        return nums[start];
    }
    
    public static void main(String[] args) {
        SingleElementinaSortedArray se = new SingleElementinaSortedArray();
        int[] nums = {1,1,2,2,3,4,4};
        System.out.println(se.singleNonDuplicate(nums));
    }
}
