package tree;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
          
 * @author Katherine
 *
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * 0 ms 100%
     * 38.4 MB 20%
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        // find the right most child
        if (root.left != null) {
            TreeNode leftSubtreeRightMostChild = root.left;
            while(leftSubtreeRightMostChild.right != null)
                leftSubtreeRightMostChild = leftSubtreeRightMostChild.right;
            
            leftSubtreeRightMostChild.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    
    /**
     * 1 ms 26.24%
     * 39.5 MB 14.54%
     * @param root
     */
    public void flattenIterativePreorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        
        while (!nodes.isEmpty()) {
            TreeNode t = nodes.pop();
         // find the right most child
            if (t.left != null) {
                TreeNode leftSubtreeRightMostChild = t.left;
                while(leftSubtreeRightMostChild.right != null)
                    leftSubtreeRightMostChild = leftSubtreeRightMostChild.right;
                
                leftSubtreeRightMostChild.right = t.right;
                t.right = t.left;
                t.left = null;
            }
            
            if (t.right!=null)
                nodes.push(t.right);
            
            // below in normal preorder traversal has no need here
            // since all the left children have been set to null
//            if (t.left!=null)
//                nodes.push(t.left);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        FlattenBinaryTreeToLinkedList fb = new FlattenBinaryTreeToLinkedList();
        fb.flattenIterativePreorder(root);
    }
}
