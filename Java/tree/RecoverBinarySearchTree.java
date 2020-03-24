package tree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
    Recover the tree without changing its structure.
    
    Example 1:
    
    Input: [1,3,null,null,2]
    
       1
      /
     3
      \
       2
    
    Output: [3,1,null,null,2]
    
       3
      /
     1
      \
       2
    Example 2:
    
    Input: [3,1,4,null,null,2]
    
      3
     / \
    1   4
       /
      2
    
    Output: [2,1,4,null,null,3]
    
      2
     / \
    1   4
       /
      3
    Follow up:
    
    A solution using O(n) space is pretty straight forward.
    Could you devise a constant space solution?
 * @author Katherine
 *
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        // inorder moris traversal
        
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        
        while (root != null) {
            TreeNode node = root.left;
            // find the left subtree's right most
            if (node != null) {
                while (node.right != null && node.right != root) {
                    node = node.right;
                }
                
                if (node.right == null) {
                    node.right = root;
                    root = root.left;
                    continue;
                } else {
                    node.right = null; //change the tree format back
                }
            }
            
            if (pre.val > root.val) { //?
                if (first == null) first = pre;
                second = root;
            }
            
            pre = root;
            root = root.right;
        }
        
        int tmp = second.val;
        second.val = first.val;
        first.val = tmp;
    }
    
    public static void main(String args[]) 
    { 
        /* Constructed binary tree is 
               3 
             /   \ 
            1      4 
                 /
                2
        */
        RecoverBinarySearchTree mt = new RecoverBinarySearchTree(); 
        TreeNode root = new TreeNode(3); 
        root.left = new TreeNode(1); 
        root.right = new TreeNode(4); 
        root.right.left = new TreeNode(2); 
        
        /* Constructed binary tree is 
        1 
      /
     3
      \
        2
 */
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);
//  
        mt.recoverTree(root); 
    } 
}
