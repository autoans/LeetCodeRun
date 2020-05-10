package bitmanipulation;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int total = 0;
        int[] bits = new int[32];
        
        for (int i = 0 ; i < 32; i++) {
            for (int num : nums) {
                bits[i]+=(num >> i) & 1;
            }
            
            total += bits[i] * (len-bits[i]);
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        int[] nums = {4,14,2};
        
        TotalHammingDistance thd = new TotalHammingDistance();
        System.out.println(thd.totalHammingDistance(nums));
    }
}
