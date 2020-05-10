package tree;

import java.util.List;

public class TraversalTest {
    public TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void main(String args[]) {
        /*
         * Constructed binary tree is 1 / \ 2 3 / \ 4 5
         */
        // MorisTraversal mt = new MorisTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);

        // mt.InorderMorisTraversal(root);

        BinaryTreePreOrderTraversal bt = new BinaryTreePreOrderTraversal();
        List<Integer> result = bt.preorderTraversalRecursive(root);

        for (int num : result) {
            System.out.print(num + " ");
        }

        System.out.println("- recursive");

        List<Integer> result2 = bt.preorderTraversal(root);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println("- non recursive");

        List<Integer> result3 = bt.morisPreorderTraversal(root);
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println("- non recursive - Moris");

    }
}
