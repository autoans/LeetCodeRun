package LeetcodeChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(0, (prev, i) -> prev + i * i);
        }

        return n == 1;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19));
    }
}
