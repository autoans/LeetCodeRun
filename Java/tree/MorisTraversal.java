package tree;

/**
 * Moris traversal uses constant space complexity & O(N) time complexity
 *  https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 *  https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
 */
public class MorisTraversal {


    /**
     *  
        While current is not NULL
           1.  If the current does not have left child
               // print out current value
               Go to the right, i.e., current = current->right
           2.  Else
               Find the predecessor of current (in the left subtree of current, for in-order traversal)
               a. If predecessor's right child is null
                   predecessor.right = current;
                   current = current.left
               b. else
                   predecessor.right = null (revert tree to it's original form)
                   // print out current value
                   current = current.right;
     * @param current
     */
    public void InorderMorisTraversal(TreeNode current) {
        while (current != null) {
            if (current.left == null) { //1.
                System.out.println(current.val); //print out current
                current = current.right;
            } else {
                // find the predecessor
                // make current the right child of rightmost child of left subtree
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
                if (pre.right == null) { // 2.a
                    pre.right = current;
                    current = current.left;
                }
                else { // 2.b
                    pre.right = null; // return the tree back to it's original form
                    System.out.println(current.val); // print out
                    current = current.right;
                }
            }
        }
    }
}
