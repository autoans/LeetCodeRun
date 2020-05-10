package LeetcodeChallenge;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int maxReach = 0;
        for (int j = 0 ; j < nums.length; j++) {
            maxReach = Math.max(maxReach, j + nums[j]);
            
            // can not reach the next index
            if (maxReach <= j && j!=nums.length-1) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {2,0,0};
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(nums));
    }
}
