package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        while (root != null || !treeNodes.isEmpty()) {
            if (root != null) {
                treeNodes.push(root);
                root = root.left;
            } else {
                root = treeNodes.pop();
                result.add(root.val); // only different from preorder
                root = root.right;
            }
        }

        return result;
    }

    public List<Integer> preorderTraversal2 (TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        
        while (!treeNodes.isEmpty() || root != null) {
            if (root != null) {
                list.add(root.val); // only difference from inorder
                treeNodes.push(root);
                root = root.left;
            } else {
                root = treeNodes.pop();
                root = root.right;
            }
        }
        
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            TreeNode n = treeNodes.pop();
            result.add(n.val);

            if (n.right != null) {
                treeNodes.push(n.right);
            }
            if (n.left != null) {
                treeNodes.push(n.left);
            }
        }

        return result;
    }
}
