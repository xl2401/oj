public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // null check
        if (root == null) return res;
        // node in the queue has not been visited, poll to visit and add left and right child
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // this is the trick to separate the previous layer and the current added layer
            int lastCnt = queue.size();
            List<Integer> curLayerRes = new ArrayList<Integer>();
            for (int i = 0; i < lastCnt; i++) {
                TreeNode node = queue.poll();
                curLayerRes.add(node.val);
                if (node.left != null) 
                	queue.add(node.left);
                if (node.right != null)
                	queue.add(node.right);
            }
            res.add(curLayerRes);
        }
        return res;
    }
}
