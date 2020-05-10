package LeetcodeChallenge;

public class ValidSequenceInABinaryTree {
    // Function to insert nodes in level order 
    public TreeNode insertLevelOrder(int[] arr, TreeNode root, 
                                                int i) 
    { 
        // Base case for recursion 
        if (i < arr.length) { 
            TreeNode temp = new TreeNode(arr[i]); 
            root = temp; 
  
            // insert left child 
            root.left = insertLevelOrder(arr, root.left, 
                                             2 * i + 1); 
  
            // insert right child 
            root.right = insertLevelOrder(arr, root.right, 
                                               2 * i + 2); 
        } 
        return root; 
    } 
    
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    public boolean isValidSequence(TreeNode root, int[] arr, int idx) {
        if (root == null || idx > arr.length - 1)
            return false;

        if (arr[idx] != root.val)
            return false;

        // last one and also leaf
        if (idx == arr.length - 1 && root.left == null && root.right == null)
            return true;

        // last one but not leaf
        if ((idx == arr.length - 1) && (root.left != null || root.right != null)) {
            return false;
        }

        idx++;
        return isValidSequence(root.left, arr, idx) || isValidSequence(root.right, arr, idx);
    }

    public static void main(String[] args) {
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t8 = new TreeNode(8, t7, t2);
        ValidSequenceInABinaryTree ls = new ValidSequenceInABinaryTree();
        int[] treelevel = {0,1,0,0,1,0,-1,-1,1,0,0};
        TreeNode root = new TreeNode(5);
        root = ls.insertLevelOrder(treelevel, root, 0);
        
        int[] arr = {0,1, 1};
        System.out.println(ls.isValidSequence(root, arr));
        
    }
}
