package dynamicprogramming;

/**
 * 53. Maximum Subarray
 * @author Katherine
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //denote dp[i] as the max-sub-array-sum that ends with nums[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1 ; i < nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray ms  = new MaximumSubarray();
        System.out.println(ms.maxSubArray(nums));
    }
}
