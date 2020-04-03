package LeetcodeChallenge;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (prev, i) -> prev ^ i);
    }
}
