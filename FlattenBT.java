import java.util.LinkedList;

/**
 * Title: Flatten Binary Tree to Linked List
 * Description:
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Solution:
 * Preorder traversal
 */
public class FlattenBT {
    private TreeNode prev = null;

    /*
     * Recur version
     */
    public void flatten2(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        prev = dummy;
        flatternRecur(root);
    }

    public void flatternRecur(TreeNode root){
        if (root == null) return;
        prev.right = root;
        prev.left = null;
        prev = root;
        TreeNode rootRight = root.right;
        flatternRecur(root.left);
        flatternRecur(rootRight);
    }

    /*
     * Iterative version
     */
    public void flatten3(TreeNode root){
        if (root == null) return;
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        prev = dummy;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            prev.right = cur;
            prev.left = null;
            prev = cur;

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
   
    public void flatten(TreeNode root){
        while (root != null) {
            if (root.left != null) {
                TreeNode ptr = root.left;
                while (ptr.right != null) ptr = ptr.right;
                ptr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;
        new FlattenBT().flatten(a);
        while (a != null){
            System.out.println(a.val);
            a = a.right;
        }
    }
}
