package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    
    List<List<Integer>> paths = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(cur, root, sum);
        return paths;
    }
    
    public void dfs(ArrayList<Integer> currentRow, TreeNode currentNode, int currentSum) {
        if (currentNode == null) return;
        currentRow.add(currentNode.val);
        
        if (currentNode.left == null && currentNode.right == null && currentNode.val == currentSum) {
            paths.add(new ArrayList(currentRow));
        } else {
            dfs(currentRow, currentNode.left, currentSum - currentNode.val);
            dfs(currentRow, currentNode.right, currentSum - currentNode.val);
        }
        
        currentRow.remove(currentRow.size() - 1);
    }
    
    public static void main(String args[]) 
    { 
        /* Constructed binary tree is 
               1 
             /   \ 
            2      3 
          /  \ 
        4     5 
        */
        PathSumII mt = new PathSumII(); 
        TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
  
        mt.pathSum(root, 7); 
    } 
}
