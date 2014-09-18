class Result {
    TreeNode node;
    boolean isAnc;

    Result(TreeNode node, boolean isAnc) {
        this.node = node;
        this.isAnc = isAnc;
    }
}

public class Solution {
    // use isAnc to represent whether the current result is ancestor 
    // avoid the condition that the whole tree only contains one of n1 and n2
    public TreeNode commonAncester(TreeNode root, TreeNode n1, TreeNode n2) {
        Result res = helper(root, n1, n2);
        if (res.isAnc) return res.node;
        else return null;
    }

    // return p or q if subtree contains p or q (one of them)
    // return root if it is a common ancestor
    private Result helper(TreeNode root, TreeNode n1, TreeNode n2) {
        // base case
        if (root == null) return new Result(null, false);
        Result lRes = helper(root.left, n1, n2);
        if (lRes.isAnc) return lRes.node;
        Result rRes = helper(root.right, n1, n2);
        if (rRes.isAnc) return rRes.node;
        if (lRes.node != null && rRes.node != null) return new Result(root, true);
        else if (root == n1 || root == n2) {
            if (lRes.node != null || rRes.node != null) return new Result(root, true);
            else return new Result(root, false);
        } else {
            TreeNode node = lRes.node != null ? lRes.node : rRes.node;
            return new Result(node, false);
        }
    }
}
