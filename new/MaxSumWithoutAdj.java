/**
 * Get the max sum of a binary tree
 * The nodes that consists the sum should not be adjacent
 */
public class Solution {
    public int getMaxSumWithoutAdjNodes(TreeNode root) {
        int[] res = maxHelper(root);
        return Math.max(res[0], res[1]);
    }

    /*
     * This helper class return 2 results
     * the first one is the max sum of the current tree that use the root
     * the second one does not count root
     */
    private int[] maxHelper(TreeNode root) {
        int[] res = new int[2];
        // base condition
        if (root == null) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int[] leftRes = maxHelper(root.left);
        int[] rightRes = maxHelper(root.right);
        // with root max
        res[0] = root.val + leftRes[1] + rightRes[1];
        // without root max
        res[1] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        return res;
    }
}
