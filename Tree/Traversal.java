package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        
        while (root != null || !s.isEmpty())
        {
            if (root != null)
            {
                s.push(root);
                root = root.left;
            }
            else
            {
                root = s.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        
        return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        s.push(root);
        
        while (!s.isEmpty())
        {
            TreeNode n = s.pop();
            result.add(n.val);
            
            if (n.right != null)
            {
                s.push(n.right);
            }
            if (n.left != null)
            {
                s.push(n.left);
            }
        }
        
        return result;
    }
}
