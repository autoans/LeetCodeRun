package tree;

/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * @author Katherine
 *
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftMaxSum = Math.max(0, dfs(node.left));
        int rightMaxSum = Math.max(0, dfs(node.right));
        
        int maxSide = Math.max(leftMaxSum, rightMaxSum);
        max = Math.max(leftMaxSum + rightMaxSum + node.val, Math.max(maxSide+node.val, max));
        return maxSide+node.val;
    }
    
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum bp = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(bp.maxPathSum(root));
    }
}
