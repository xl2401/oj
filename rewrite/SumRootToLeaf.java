public class Solution {
    public int sumNumbers(TreeNode root) {    
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int lastSum) {
        if (root == null) return 0;
        int curSum = lastSum * 10 + root.val;
        if (root.left == null && root.right == null) { // leaf
        	return curSum;
        }
        return helper(root.left, curSum) + helper(root.right, curSum);
    }
}