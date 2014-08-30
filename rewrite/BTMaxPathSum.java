public class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        // base 
        if (root == null) return 0;
        int leftMax = helper(root.left);
        leftMax = leftMax < 0 ? 0: leftMax;
        int rightMax = helper(root.right);
        rightMax = rightMax < 0 ? 0: rightMax;
        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}