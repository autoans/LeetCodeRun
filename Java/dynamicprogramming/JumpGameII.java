package dynamicprogramming;

import java.util.Arrays;

/**
 * 45. Jump Game II
 * @author Katherine
 *
 */
public class JumpGameII {
    // Exceed time limit
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0 ; i < nums.length; i++) {
            int jump = nums[i];
            
            for (int j = 1; j <= jump && i + j < nums.length; j++) {
                dp[j+i] = Math.min(dp[j+i], dp[i]+1);
            }
        }
        
        return dp[nums.length-1];
    }

    public int jump(int[] nums) {
        int current_jump_max = 0;
        int count = 0;
        int last_jump_max = 0;
        
        for (int i = 0 ; i < nums.length-1; i++) {
            int jump = nums[i];
            
            current_jump_max = Math.max(current_jump_max, jump+i);
            
            if (i == last_jump_max) {
                // To reach last_jump_max, needs count steps
                count++;
                last_jump_max = current_jump_max;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(jg.jump(nums));
    }
}
