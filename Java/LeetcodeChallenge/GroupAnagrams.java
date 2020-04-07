package LeetcodeChallenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 * @author Katherine
 *
 */

public class GroupAnagrams {
    /**
     * Not sure why this approach is much faster than groupAnagrams2
     * Runtime: 5 ms    Memory: 42.7 MB
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (String s: strs) {
            char[] tmpArray = s.toCharArray();
            Arrays.sort(tmpArray);
            String tmp = new String(tmpArray);
            
            if (map.containsKey(tmp)) {
                anagrams.get(map.get(tmp)).add(s);
            } else {
                ArrayList<String> newAnagram = new ArrayList<String>();
                newAnagram.add(s);
                anagrams.add(newAnagram);
                map.put(tmp, anagrams.size()-1);
            }
        }
        
        return anagrams;
    }
    
    /**
     * Runtime: 18 ms   Memory 43.7 MB
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String s: strs) {
            char[] tmpArray = s.toCharArray();
            int[] arr = new int[26];
            for (int i = 0 ; i < tmpArray.length; i++) {
                arr[tmpArray[i] - 'a']++;
            }
            
            String tmp = Arrays.toString(arr);
            
            ArrayList<String> tmpList = map.getOrDefault(tmp, new ArrayList<String>());
            tmpList.add(s);
            map.put(tmp, tmpList);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> anagrams = ga.groupAnagrams2(strs);
        
        for (int i = 0; i < anagrams.size(); i++) {
            for (int j = 0 ; j < anagrams.get(i).size(); j++) {
                System.out.print(anagrams.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
