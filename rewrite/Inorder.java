import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderHelper(res, root);
        return res;
    }

    public void inorderHelper(List<Integer> res, TreeNode root) {
        // base case
        if (root == null)
            return;
        // left root right
        inorderHelper(res, root.left);
        res.add(root.val);
        inorderHelper(res, root.right);
    }

    /*
     * Basic thoughts:
     * use a pointer to go through the tree
     * use a stack to keep the track of the route all down to the left
     * reset cur pointer to right of the last node
     */
    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // cur is null, most left
            TreeNode last = stack.pop();
            res.add(last.val);
            if (last.right != null) {
                cur = last.right;
            }
        }
        return res;
    }
}
