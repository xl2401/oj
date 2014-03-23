import java.util.ArrayList;

/*
 * Title: Recover Binary Search Tree
 * Description:
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * Solution:
 * This is O(n) solution...
 * Just use inorder traversal and final which two nodes are not in order and swap them
 */
public class RecoverBST {
    private ArrayList<TreeNode> orderList = null;

    public void recoverTree(TreeNode root) {
        orderList = new ArrayList<TreeNode>();
        inorder(root);
        TreeNode n1 = null;
        TreeNode n2 = null;
        for (int i = 0; i < orderList.size(); i++){
            TreeNode cur = orderList.get(i);
            if (i == 0 && cur.val > orderList.get(i+1).val){
                n1 = cur;
                continue;
            }
            TreeNode prev = orderList.get(i-1);
            if (prev.val > cur.val){
                if (cur == n1) n1 = cur;
                else n2 = cur;
            }
        }
        swap(n1, n2);
    }

    private void swap(TreeNode n1, TreeNode n2){
        if (n1 == null || n2 == null) return;
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        orderList.add(root);
        inorder(root.right);
    }
}
