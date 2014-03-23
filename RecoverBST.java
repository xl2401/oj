import java.util.ArrayList;

/*
 * Title: Recover Binary Search Tree
 * Solution:
 * This use inorder traversal and takes O(n) space
 * refer to RecoverBSTImprove.java for O(1) solution
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
            if ((i > 0 && cur.val < orderList.get(i-1).val) 
            || (i < orderList.size()-1 && cur.val > orderList.get(i+1).val)){
                if (n1 == null) n1 = cur;
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
