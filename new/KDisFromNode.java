import java.util.ArrayList;
import java.util.List;

/**
 * return a list of nodes which have distance k from a given node in binary tree
 *
 * Solution:
 * 2 conditions:
 * 1. nodes that are in the subtree of the given node
 * 2. nodes elsewhere
 *
 * for the second condition, we should get the distance from the given node to its ancestors and search other side subtree
 */
public class Solution {
    public List<TreeNode> kDistanceNode(TreeNode root, TreeNode node, int k) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        helper(res, root, node, k);
        return res;
    }

    // @return the distance from the current root to the target node
    private int helper(List<TreeNode> res, TreeNode root, TreeNode node, int k) {
        if (root == null) return -1;
        if (root == node) {
            kDistanceFromRoot(res, root, k);
            return 0;
        }
        int leftDis = helper(res, root.left, node, k);
        if (leftDis != -1) {
            int distance = leftDis + 1;
            if (distance == k) res.add(root);
            kDistanceFromRoot(res, root.right, k - distance - 1);
            return distance;
        }
        int rightDis = helper(res, root.right, node, k);
        if (rightDis != -1) {
            int distance = rightDis + 1;
            if (distance == k) res.add(root);
            kDistanceFromRoot(res, root.left, k - distance - 1);
            return distance;
        }
        // node not in this subtree return -1
        return -1;
    }

    // add nodes into res that are k levels down from root
    private void kDistanceFromRoot(List<TreeNode> res, TreeNode root, int k) {
        if (root == null) return;
        if (k == 0) {
            res.add(root);
            return;
        }
        kDistanceFromRoot(res, root.left, k-1);
        kDistanceFromRoot(res, root.right, k-1);
    }
}
