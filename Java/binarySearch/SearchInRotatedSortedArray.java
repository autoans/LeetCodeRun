package binarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        
        while (lowIndex < highIndex) {
            int midIndex = lowIndex + (highIndex-lowIndex)/2;
            int low = nums[lowIndex];
            //int high = nums[highIndex];
            int mid = nums[midIndex];
            if (low > mid) {
                // rotate is between lowIndex and midIndex
                if (target > mid && target < low) {
                    lowIndex = midIndex+1;
                } else {
                    highIndex = midIndex;
                }
            } else {
                // low to mid is normal sorted array
                if (target > mid || target < low) lowIndex = midIndex+1;
                else highIndex = midIndex;
            }
        }
        
        return nums[lowIndex] == target? lowIndex:-1;
    }
    
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchInRotatedSortedArray si = new SearchInRotatedSortedArray();
        System.out.println(si.search(nums, 0));
    }
}
