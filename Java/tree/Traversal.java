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
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
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
