package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 * @author Katherine
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursiveSortedArrayToBST(nums);
    }
    
    /**
     * The iterative implementation is a translation of the recursive one.
     * nodes keeps track of all the nodes (including left nodes and right nodes)
     * The correct val of each node is later updated with left and right indexes.
     * indexes keeps track of the border of left and right, like start and end in recursiveHelper
     * @param nums, sorted array
     * @return root
     */
    public TreeNode iterativeSortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> indexes = new LinkedList<>();
        
        // insert left index then right index
        indexes.push(0);
        indexes.push(len-1);
        
        TreeNode root = new TreeNode(0);
        // placeholder, the actual value will be updated later
        nodes.push(root);
        
        while(!nodes.isEmpty()) {
            TreeNode tmp = nodes.pop();
            
            int right = indexes.pop();
            int left = indexes.pop();
            
            int mid = (right - left) / 2 + left;
            tmp.val = nums[mid];
            
            if (left <= mid - 1) {
                tmp.left = new TreeNode(0);
                nodes.push(tmp.left);
                // insert left index then right
                indexes.push(left);
                indexes.push(mid-1);
            }
            
            if (mid + 1 <= right) {
                tmp.right = new TreeNode(0);
                nodes.push(tmp.right);
                
                indexes.push(mid+1);
                indexes.push(right);
            }
        }
        
        return root;
    }
    

    /**
     * The intuitive way is to convert an array to BST with recursion
     * The recursion model applies to several similar questions from array to tree
     * Since this question array is sorted, and it's changing to a bst
     * The mid of the array is always the tree root
     * @param nums, given sorted array
     * @return root of the tree
     */
    public TreeNode recursiveSortedArrayToBST(int[] nums) {
        // always always starts with corner cases!
        if (nums == null || nums.length == 0) return null;
        
        return recursiveHelper(nums, 0, nums.length);
    }
    
    public TreeNode recursiveHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        
        // leaving some redundant code as below as reminder :)
        //if (start == end) {
        //    TreeNode tmp = new TreeNode(nums[start]);
        //    return tmp;
        //}
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = recursiveHelper(nums, start, mid-1);
        root.right = recursiveHelper(nums, mid+1, end);
        
        return root;
    }
}
