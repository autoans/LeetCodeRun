package sort;

import java.util.Arrays;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 *
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        
        for(String dict: d) {
            if (wordExists(dict, s)) {
                if (dict.length() > result.length()) {
                    result = dict;
                }
                else if (result.length() == dict.length() && result.compareTo(dict) > 0) {
                    result = dict;
                }
            }
        }
        
        return result;
    }
    
    /**
     * Runtime | Memory
        10 ms  | 48.3 MB
     * @param dict
     * @param s
     * @return
     */
    public boolean wordExists(String dict, String s) {
        int start = -1;
        
        for (int i = 0 ; i < dict.length(); i++) {
            start = s.indexOf(dict.charAt(i), start+1);
            if (start < 0) return false;
        }
        
        return true;
    }
    
    /**
     * 33 ms    53.1 MB
     * @param dict
     * @param s
     * @return
     */
    public boolean wordExists1(String dict, String s) {
        char[] dictChars = dict.toCharArray();
        char[] sChars = s.toCharArray();
        
        int i = 0;
        int j = 0;
        
        while (i < dictChars.length && j < sChars.length) {
            if (dictChars[i] == sChars[j]) {
                i++;
            }
            j++;
        }
        
        if (i == dictChars.length) return true;
        
        return false;
    }
    
    public static void main(String[] args) {
        LongestWordinDictionarythroughDeleting lwd = new LongestWordinDictionarythroughDeleting();
        String[] array = {"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
        //String[] array = {"a","b","c"};
        List<String> d = Arrays.asList(array);
        System.out.println(lwd.findLongestWord("aewfafwafjlwajflwajflwafj", d));
    }
}
