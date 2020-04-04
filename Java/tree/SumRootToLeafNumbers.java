package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.
 * @author Katherine
 *
 */
public class SumRootToLeafNumbers {
    List<Integer> allNumbers = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return allNumbers.stream().reduce(0, (prev, i) -> prev + i);
    }
    
    public void dfs(TreeNode node, int pre) {
        if (node.left == null && node.right == null) allNumbers.add(pre * 10+node.val);
        
        if (node.left != null) dfs(node.left, pre * 10 + node.val);
        if (node.right != null) dfs(node.right, pre * 10 + node.val);
    }
    
    public static void main(String[] args) {
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        
        SumRootToLeafNumbers sr = new SumRootToLeafNumbers();
        System.out.println(sr.sumNumbers(tn));
    }
}
