package LeetcodeChallenge;

public class MaxPathSum {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return ans;
    }
    
    public int pathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
    
    public static void main(String[] args) {
//        TreeNode t9 = new TreeNode(9);
//        TreeNode t15 = new TreeNode(15);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t20 = new TreeNode(20, t15, t7);
//        TreeNode root = new TreeNode(-10, t9, t20);
//        
        
        //TreeNode root = new TreeNode(-3);
        
        TreeNode t1 = new TreeNode(-1);
        TreeNode t2 = new TreeNode(-2);
        TreeNode root = new TreeNode(2, t1, t2);
        //root.left = t1;
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t8 = new TreeNode(8, t7, t2);
//        TreeNode root = new TreeNode(5, t4, t8);
        
        MaxPathSum mp = new MaxPathSum();
        //System.out.println(mp.ans);
        System.out.println(mp.maxPathSum(root));
    }
}
