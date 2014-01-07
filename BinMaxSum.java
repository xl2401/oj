/**
 * Title: Binary Tree Maximum Path Sum
 * Description:
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * Note: May go from child to parent.
 *
 * Solution:
 * Similar to max subarray problem
 */
public class BinMaxSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        this.max = Integer.MIN_VALUE;
        maxSumTillRoot(root);
        return max;
    }

    /**
     * Calculate max sum of path from the descents of root till root
     * update this.max value according to max(maxpath, arch)
     * Note: don't forget to consider arch
     */
    public int maxSumTillRoot(TreeNode root){
        if (root == null) return 0;
        int left = maxSumTillRoot(root.left);
        int right =  maxSumTillRoot(root.right);
        int maxPath = Math.max(root.val, Math.max(left, right) + root.val);
        int arch = root.val + left + right; 
        int maxSum = Math.max(maxPath, arch);
        if (maxSum > max) max = maxSum;
        return maxPath;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println(new BinMaxSum().maxPathSum(a));
    }
}
