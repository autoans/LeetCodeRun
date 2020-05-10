package List;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int total = 0;
        HashSet<Character> jewels = new HashSet<Character>();
        for (char j: J.toCharArray()) {
            jewels.add(j);
        }
        
        for (char s: S.toCharArray()) {
            if (jewels.contains(s)) total++;
        }
        
        return total;
    }
}
