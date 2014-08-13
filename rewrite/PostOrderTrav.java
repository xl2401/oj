public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
    
    public List<Integer> postorderTraversalIter(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        LinkedList<TreeNode> s1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> s2 = new LinkedList<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
        }
        // pump in res
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }
}
