/**
 * Title: Validate Binary Search Tree 
 * Desciption:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Solution:
 * This solution is not optimal!!
 * try to get the largest node of the left subtree and smallest node of right subtree
 * and compare with the root (sure, left subtree and right subtree also should be valid)
 * This method go over the tree again and again. Not good...
 * See ValidBSTImprove.java
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int leftLarge = getLargest(root.left);
        int rightSmall = getSmallest(root.right);
        return root.val > leftLarge && root.val < rightSmall 
            && isValidBST(root.left) && isValidBST(root.right);
    }

    public int getSmallest(TreeNode root){
        if (root == null) return Integer.MAX_VALUE;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }

    public int getLargest(TreeNode root){
        if (root == null) return Integer.MIN_VALUE;
        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
