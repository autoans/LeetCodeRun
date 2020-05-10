package hash;

import java.util.HashMap;

/**
 * 387. First Unique Character in a String
 * @author penzh
 *
 */
public class FirstUniqueCharacterInaString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> chars = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            chars.put(c, chars.getOrDefault(c, 0)+1);
        }
        
        for (int i = 0 ; i < charArr.length; i++) {
            if (chars.getOrDefault(charArr[i], 0) == 1)
                return i;
        }
        
        return -1;
    }
}
