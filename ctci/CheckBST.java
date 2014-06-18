/*
 * 4.5
 * Check if a binary tree is a BST
 * 
 * Solution:
 * 2 solutions:
 * 1. in-order traversal
 * 2. pass range (min, max) check
 */
public class CheckBST {
    private int lastVisited;

    public CheckBST() {
        lastVisited = Integer.MIN_VALUE;
    }

    // check with in-order traversal
    // in-order traversal of BST is in non-decreasing order
    public boolean checkBST(TreeNode root) {
        if (root == null) return true;
        // check left subtree
        if (!checkBST(root.left)) return false;
        // check current
        if (root.val < lastVisited) return false;
        lastVisited = root.val;
        // check right subtree
        if (!checkBST(root.right)) return false;
        return true;
    }

    // pass min max as a range to a recursive call to check recursively
    public boolean checkBST2(TreeNode root) {
        return checkBST2Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST2Helper(TreeNode root, int min, int max) {
        // base condition
        if (root == null) return true;
        // check current node
        if (min <= root.val && root.val < max) {
            // check left & right subtree
            return checkBST2Helper(root.left, min, root.val) &&
                   checkBST2Helper(root.right, root.val, max);
        }
        else return false;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(2);
        a.left = b;
        a.right = c;
        System.out.println(new CheckBST().checkBST2(a));
    }
}
