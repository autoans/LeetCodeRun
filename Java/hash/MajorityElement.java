package hash;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numsOccur = new HashMap<>();
        int majorityOccurance = nums.length/2;
        for (int num: nums) {
            numsOccur.put(num, numsOccur.getOrDefault(num, 0) + 1);
            if (numsOccur.get(num) > majorityOccurance)
                return num;
        }
        
        return -1;
    }
}
