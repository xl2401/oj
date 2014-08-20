public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Stack<TreeNode> curLayer = new Stack<TreeNode>();
        curLayer.add(root);
        boolean ltr = true;
        while (!curLayer.isEmpty()) {
            List<Integer> curRes = new ArrayList<Integer>();
            Stack<TreeNode> nextLayer = new Stack<TreeNode>();
            while (!curLayer.isEmpty()) {
                TreeNode cur = curLayer.pop();
                curRes.add(cur.val);
                if (ltr) {
                    if (cur.left != null)
                        nextLayer.add(cur.left);
                    if (cur.right != null)
                        nextLayer.add(cur.right);
                } else {
                    if (cur.right != null)
                        nextLayer.add(cur.right);
                    if (cur.left != null)
                        nextLayer.add(cur.left);
                }
            }
            res.add(curRes);
            curLayer = nextLayer;
            ltr = !ltr;
        }
        return res;
    }
}