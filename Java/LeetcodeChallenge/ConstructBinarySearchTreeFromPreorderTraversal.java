package LeetcodeChallenge;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length);
    }
    
    public int firstRightChildIndex (int[] preorder, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end- start)/ 2;
            if (preorder[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
    
    // [start, end)
    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start >= end) return null;
        if (start == end-1) return new TreeNode(preorder[start]);
        TreeNode root = new TreeNode(preorder[start]);
        int mid = firstRightChildIndex (preorder, start+1, end, root.val);
        root.left = bstFromPreorder(preorder, start+1, mid);
        root.right = bstFromPreorder(preorder, mid, end);
        
        return root;
    }
    
    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal cb = new ConstructBinarySearchTreeFromPreorderTraversal();
        int[] preorder= {8,5,1,7,10,12};
        TreeNode root = cb.bstFromPreorder(preorder);
        System.out.println(root.val);
    }
}
