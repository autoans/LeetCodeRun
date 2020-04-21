package binarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int low = 0;
        int high = nums.length;
        
        while (low < high) {
            int mid = low + (high - low)/2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    public static void main(String[] args) {
        SearchInsertPosition si = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        
        System.out.println(si.searchInsert(nums, 4));
    }
}
