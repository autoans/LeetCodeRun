package LeetcodeChallenge;

import java.util.HashSet;

public class CountingElements {
    public int countElements(int[] arr) {
        int totalCount = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0 ; i < arr.length; i++) {
            set.add(arr[i]);
        }
        
        for (int i = 0 ; i < arr.length; i++) {
            if (set.contains(arr[i]+1)) totalCount++;
        }

        return totalCount;
    }
    
    public static void main(String[] args) {
        CountingElements ce = new CountingElements();
        int[] arr = {1,3,2,3,5,0};
        System.out.println(ce.countElements(arr));
    }
}
