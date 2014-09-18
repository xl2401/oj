import java.util.HashSet;
import java.util.Set;

/**
 * collect all nodes that are k levels higher than a leaf in a binary tree
 * note the path is straight
 */
public class Solution {
    public Set<TreeNode> kDistanceFromLeaves(TreeNode root, int k) {
        Set<TreeNode> res = new HashSet<TreeNode>();
        if (root == null) return res;
        int height = treeHeight(root);
        TreeNode[] path = new TreeNode[height];
        helper(res, path, root, 0, k);
        return res;
    }

    private void helper(Set<TreeNode> res, TreeNode[] path, TreeNode root, int depth, int k) {
        // base condition
        if (root == null) return;
        path[depth] = root;
        // leaf
        if (root.left == null && root.right == null && depth-k >= 0) {
            res.add(path[depth-k]);
        }
        helper(res, path, root.left, depth+1, k);
        helper(res, path, root.right, depth+1, k);
    }

    private int treeHeight(TreeNode root) {
        // base case
        if (root == null) return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
