package tree;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulateNextRightPointers {
    /**
     * This implementation is from the idea of below answer
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37979/O(1).-Concise.-Fast.-What's-so-hard
     * Neat & elegant approach :)
     * @param root
     * @return
     */
    public Node connect(Node root) {
        // processing to the next level
        for (Node head = root; head != null;) {
            // connect each node in a row
            Node nextLevelPrefix = new Node();
            Node nextLevelTail = nextLevelPrefix;
            while (head != null) {
                if (head.left != null) {
                    nextLevelTail.next = head.left;
                    nextLevelTail = nextLevelTail.next;
                }
                
                if (head.right != null) {
                    nextLevelTail.next = head.right;
                    nextLevelTail = nextLevelTail.next;
                }
                
                head = head.next;
            }
            
            head = nextLevelPrefix.next;
        }
        
        return root;
    }
}
