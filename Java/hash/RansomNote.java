package hash;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineLetters = new HashMap<>();
        for (char m: magazine.toCharArray()) {
            magazineLetters.put(m, magazineLetters.getOrDefault(m, 0)+1);
        }
        for (char c: ransomNote.toCharArray()) {
            if (magazineLetters.get(c) == null) return false;
            magazineLetters.put(c, magazineLetters.get(c)-1);
        }
        
        return true;
    }
}
