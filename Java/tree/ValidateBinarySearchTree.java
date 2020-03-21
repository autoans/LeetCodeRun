package tree;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 * @author Katherine
 *
 */

/// Binary Search Tree inorder traversal prints out the tree nodes value in asc order.
/// Therefore, this question we can use in-order traversal and check if it's asc order.
public class ValidateBinarySearchTree {

    public boolean InorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!treeNodes.isEmpty() || root != null) {
            if (root == null) {
                root = treeNodes.pop();
                if (pre >= root.val) return false;
                pre = root.val;
                root = root.right;
            } else {
                treeNodes.push(root);
                root = root.left;
            }
        }
        
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        return InorderTraversal(root);
    }
}
