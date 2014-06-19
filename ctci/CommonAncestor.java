class Result {
    // if the current subtree contains p or q
    public boolean contains;
    // common ancestor, if not ancestor found so far, it is null
    public TreeNode node;

    public Result(boolean contains, TreeNode node) {
        this.contains = contains;
        this.node = node;
    }
}

/*
 * 4.7
 * Find the lowest common ancestor of two nodes
 *
 * Solution:
 * Property of lowest common ancestor
 * 1. if root is not p || q, left subtree contains and right subtree contains
 * 2. if root is p || q, left subtree contains or right subtree contains
 */
public class CommonAncestor {
    public Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new Result(false, null);
        Result leftRes = commonAncestorHelper(root.left, p, q);
        Result rightRes = commonAncestorHelper(root.right, p, q);
        if (root == p || root == q) {
            if (leftRes.contains || rightRes.contains) return new Result(true, root);
            return new Result(true, null);
        } else {
            if (leftRes.contains && rightRes.contains) return new Result(true, root);
            // if one of the subtree contains, we just copy node field
            if (leftRes.contains) return leftRes;
            if (rightRes.contains) return rightRes;
            return new Result(false, null);
        }
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return commonAncestorHelper(root, p, q).node;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(new CommonAncestor().commonAncestor(a, d, b).val);
    }
}
