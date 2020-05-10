package LeetcodeChallenge;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Deque<Node> deque = new LinkedList<>();
    Map<Integer, Node> map = new HashMap<>();
    int size = 0;
    int capacityTotal = 0;

    public LRUCache(int capacity) {
        capacityTotal = capacity;
    }

    public int get(int key) {
        int result = -1;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            result = node.value;
            deque.remove(node);
            deque.addFirst(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            Node lastNode = map.get(key);
            deque.remove(lastNode);
            lastNode.value = value;
            deque.addFirst(lastNode);
        } else if (capacityTotal > size) {
            deque.addFirst(node);
            map.put(node.key, node);
            size++;
        } else {
            Node lastNode = deque.pollLast();
            map.remove(lastNode.key);
            map.remove(key);
            map.put(key, lastNode);
            deque.addFirst(node);
            map.put(node.key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */ );
        // cache.get(2);
        cache.put(2, 1);
        // cache.get(1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1)); // returns 1
        // cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 * 
 * 
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 * ["LRUCache","get","put","get","put","put","get","get"]
 * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 */