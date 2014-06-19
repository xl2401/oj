/*
 * 4.6
 * Inorder successor
 */
public class InorderSuccessor {
    public TreeNode successor(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) {
            // right not null
            // right child go left ...
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        } else {
            // no right subtree
            // go up, find upper right parent
            while (root.parent != null && root.parent.right == root) {
                root = root.parent;
            }
            return root.parent;
        }
    }
}
