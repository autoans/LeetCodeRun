package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * Input: 3 
 * Output: [ [1,null,3,2], [3,2,null,1], [3,1,null,null,2], [2,1,3],
 * [1,null,2,null,3] ] 
 * Explanation: The above output corresponds to the 5 unique
 * BST's shown below:
 * 
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 * 
 * @author Katherine
 *
 */
public class UniqueBinaryTreesII {
    public List<TreeNode> generateTrees(int n) {
        // generate an array, fill it up with possible numbers in nodes
        List<TreeNode> list = generateTreeHelper(1, n);
        return list.get(0) == null? new ArrayList<TreeNode>(): list;
    }

    public List<TreeNode> generateTreeHelper(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTreeHelper(start, i-1);
            List<TreeNode> rightTrees = generateTreeHelper(i+1, end);
            
            // assemble all the possibilities from left subtrees and right subtrees
            for (TreeNode leftSubTree: leftTrees) {
                for (TreeNode rightSubTree: rightTrees) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = leftSubTree;
                    tmp.right = rightSubTree;
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
