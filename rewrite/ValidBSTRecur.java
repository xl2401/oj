public class Solution {
    private int lastVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= lastVal) return false;
        lastVal = root.val;
        if (!isValidBST(root.right)) return false;
        return true;
    }
}