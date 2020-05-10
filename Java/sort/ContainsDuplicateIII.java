package sort;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        
        TreeSet<Long> kNums = new TreeSet<>(); 
        
        for (int i = 0; i < nums.length; i++) {
            long currentNum = nums[i];
            
            Long ceil = kNums.ceiling(currentNum);
            Long floor = kNums.floor(currentNum);
            
            if ((ceil != null && ceil - currentNum <= t) ||
                (floor != null && currentNum - floor <= t)) return true;
            
            kNums.add((long)currentNum);
            if (i >= k) {
                kNums.remove((long)nums[i-k]);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        ContainsDuplicateIII cd = new ContainsDuplicateIII();
        int[] nums = {1,2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println(cd.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
