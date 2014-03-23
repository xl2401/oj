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
 * quite stright-forward. We don't need to record all the nodes,
 * just compare on the fly, maintain n1, n2, prev, this will cost O(1) space.
 */
public class RecoverBSTImprove {
    private TreeNode n1 = null;
    private TreeNode n2 = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        n1 = null;
        n2 = null;
        prev = null;
        inorder(root);
        swap();
    }

    private void swap(){
        if (n1 == null || n2 == null) return;
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        if (prev == null){// first element
            prev = root;
        }
        else{
            if (prev.val > root.val){// not right...
                // a little bit tricky here
                if (n1 == null) n1 = prev;
                n2 = root;
            }
            prev = root;
        }
        inorder(root.right);
    }
}
