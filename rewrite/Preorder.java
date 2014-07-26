import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorderHelper(res, root);
        return res;
    }

    public void preorderHelper(List<Integer> res, TreeNode root) {
        // base condition
        if (root == null) return;
        res.add(root.val);
        preorderHelper(res, root.left);
        preorderHelper(res, root.right);
    }

    public List<Integer> preorderTraversalIter(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        // extreme case, consider root is null
        // check null first
        if (root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.right != null)
                // push is different from add
                stack.push(curNode.right);
            if (curNode.left != null)
                stack.push(curNode.left);
        }
        return res;
    }
}
