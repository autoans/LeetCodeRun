package LeetcodeChallenge;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstUnique {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public FirstUnique(int[] nums) {
        for (int num: nums) {
            cache.put(num, cache.getOrDefault(num, 0)+1);
        }
    }

    public int showFirstUnique() {
        Optional<Integer> first = cache.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst();
        return first.isPresent()? first.get(): -1;
    }

    public void add(int value) {
        cache.put(value, cache.getOrDefault(value, 0)+1);
    }
    
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7};
        FirstUnique firstUnique = new FirstUnique(nums);
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        
        System.out.println(firstUnique.showFirstUnique()); // return 17
    }
}
