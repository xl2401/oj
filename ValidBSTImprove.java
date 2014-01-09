/*
 * Title: Validate Binary Search Tree 
 * Description:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Solution:
 * Note Valid BST has a attribute:
 * during inorder traversal, the previous visited node value shoul be smaller
 * than the current node value!
 * Node if detect not valid structure return false immediately to avoid not necessary traverse
 */
class ValidBSTImprove{
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root){
        if (root == null) return true;
        boolean leftValid = isValidBST(root.left);
        if (!leftValid) return false;
        // inorder traversal
        boolean curValid = true;
        if (prev != null) curValid = prev.val < root.val;
        if (!curValid) return false;
        prev = root;
        boolean rightValid = isValidBST(root.right);
        if (!rightValid) return false;
        return true;
    }
}
