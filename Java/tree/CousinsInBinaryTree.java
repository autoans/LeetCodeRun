package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        // level order traversal, until find both x and y in one level or only one in a level
        Queue<TreeNode> level = new LinkedList<>();
        
        level.add(root);
        level.add(new TreeNode(101));
        boolean foundX = false;
        boolean foundY = false;
        boolean newParent = false;

        // insert 0 between different nodes' children
        // insert 101 between different level
        while(!level.isEmpty() ) {
            root = level.poll();
            if (root.val == 101 && foundX && foundY && newParent) return true;
            if (root.val == 101 && (foundX || foundY) && (!foundX || !foundY || !newParent)) return false;
            if (root.val == 101 && !level.isEmpty()) {
                level.add(new TreeNode(101));
                continue; // continue to the next level
            }
            
            if (root.val == x) foundX = true;
            else if (root.val == y) foundY = true;
            else if (root.val == 0) {
                if (!newParent && foundX && foundY) return false;
                if (foundX || foundY) newParent = true;
            }
            
            if (root.left != null) level.add(root.left);
            if (root.right != null) level.add(root.right);
            level.add(new TreeNode(0));
        }
        
        return false;
    }
    
    public static void main(String[] args) {
//        TraversalTest ls = new TraversalTest();
//        int[] treelevel = {0,1,0,0,1,0,-1,-1,1,0,0};
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        CousinsInBinaryTree n = new CousinsInBinaryTree();
        System.out.println(n.isCousins(root, 4, 5));
        
    }
}
