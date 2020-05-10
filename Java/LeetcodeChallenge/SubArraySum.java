package LeetcodeChallenge;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int total = 0;
        // sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
        int[] sum = new int[len+1];
        sum[0] = 0;
        
        for (int i = 1; i < len+1; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        for (int j = 1; j < len+1; j++) {
            for (int i = 0; i < j; i++) {
                int tmpSum = sum[j] - sum[i];
                if (tmpSum == k) total++;
            }
        }
        
        return total;
    }
    
    
    public static void main(String[] args) {
        SubArraySum ss = new SubArraySum();
        int[] nums = {1,1,1};
        int k = 3;
        System.out.println(ss.subarraySum(nums, k));
    }
}
