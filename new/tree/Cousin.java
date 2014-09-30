/* 
 * Check if two nodes are cousins in a Binary Tree
 * http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 *
 * Solution:
 * break the problem down into two different small tasks
 * 1. is sibling? recursively
 * 2. the level of a given node? top down
 */
public class Solution {
    public boolean isCousin(TreeNode root, TreeNode a, TreeNode b) {
        return level(root, a, 1) == level(root, b, 1)
                && !isSibling(root, a, b);
    }

    private boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {
        // base case
        if (root == null) return false;
        return (root.left == a && root.right == b)
                || (root.left == b && root.right == a)
                || isSibling(root.left, a, b)
                || isSibling(root.right, a, b);
    }

    // top-down get level of a given node
    private int level(TreeNode root, TreeNode node, int lvl) {
        // base case
        if (root == null) return 0;
        if (root == node) return lvl;
        int l = level(root.left, node, lvl + 1);
        // found left subtree
        if (l != 0) return l;
        return level(root.right, node, lvl + 1);
    }
}
