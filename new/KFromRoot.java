import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> kDistanceFromRoot(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        helper(res, root, k);
        return res;
    }

    private void helper(List<TreeNode> res, TreeNode root, int k) {
        // base condition
        if (k == 0) {
            res.add(root);
            return;
        }
        if (root == null) return;
        helper(res, root.left, k-1);
        helper(res, root.right, k-1);
    }
}
