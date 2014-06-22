/*
 * 4.8
 * Check whether one tree is another tree's subtree
 */
public class Subtree {
    // if q is p's subtree
    public boolean isSubtree(TreeNode p, TreeNode q) {
        if (q == null) return true;
        if (p == null) return false;
        // only invoke matchTree when p and q match
        if (p.val == q.val && matchTree(p, q)) {
            return true;
        }
        return isSubtree(p.left, q) || 
               isSubtree(p.right, q);
    }

    // if p, q are the same tree
    private boolean matchTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) ||
            (p != null && q == null))
            return false;
        // p/q not null
        if (p.val != q.val) return false;
        else
            return matchTree(p.left, q.left) && 
                   matchTree(p.right, q.right);
    }
}
