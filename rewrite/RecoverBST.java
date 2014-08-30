/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode l = null;
        TreeNode r = null;
        TreeNode prev = null;
        TreeNode ptr = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (ptr != null || !s.isEmpty()) {
            while (ptr != null) {
                s.push(ptr);
                ptr = ptr.left;
            }
            TreeNode cur = s.pop();
            // visit cur
            if (prev != null && prev.val > cur.val) {
                if (l == null) {
                    l = prev;
                } 
                if (l != null) {
                    r = cur;
                }
            }
            prev = cur;
            ptr = cur.right;
        }
        swap(l, r);
    }

    private void swap(TreeNode l, TreeNode r) {
        if (l != null && r != null) {
            int tmp = l.val;
            l.val = r.val;
            r.val = tmp;
        }
    }
}