public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // null check
        if (root == null) return res;
        LinkedList<TreeNode> lastLayer = new LinkedList<TreeNode>();
        LinkedList<Integer> lastLayerVal = new LinkedList<Integer>();
        lastLayer.add(root);
        lastLayerVal.add(root.val);
        res.add(lastLayerVal);
        while (!lastLayer.isEmpty()) {
            LinkedList<TreeNode> curLayer = new LinkedList<TreeNode>();
            LinkedList<Integer> curLayerVal = new LinkedList<Integer>();
            for (TreeNode n: lastLayer) {
                if (n.left != null) {
                    curLayer.add(n.left);
                    curLayerVal.add(n.left.val);
                }
                if (n.right != null) {
                	curLayer.add(n.right);
                	curLayerVal.add(n.right.val);
                }
            }
            if (!curLayerVal.isEmpty())
                res.add(0, curLayerVal);
            lastLayer = curLayer;
        }
        return res;
    }
}