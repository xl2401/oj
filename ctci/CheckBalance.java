/*
 * 4.1
 * Check if a binary tree is balanced
 */
public class CheckBalance {
    public boolean checkBalance(TreeNode root) {
        return getHeight(root) != -1;
    }

    // if subtree rooted at `root` is not balanced, return -1
    // otherwise return the height
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight-rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        a.left = b;
        b.left = c;
        System.out.println(new CheckBalance().checkBalance(a));
    }
}
