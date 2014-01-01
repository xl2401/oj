public class BalancedBinaryTree {
    public int checkHeight(TreeNode root){
        // Base case
        if (root == null) return 0;
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        // not balanced
        if (Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (checkHeight(root) != -1) return true;
        else return false;
    }
}
