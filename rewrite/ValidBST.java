public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode ptr = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (!s.isEmpty() || ptr != null) {
            // to most left
            while (ptr != null) {
                s.push(ptr);
                ptr = ptr.left;
            }
            // visit
            TreeNode cur = s.pop();
            if (cur.val <= prev.val) return false;
            prev = cur;
            ptr = cur.right;
        }
        return true;
    }
}