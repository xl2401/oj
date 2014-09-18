class Result {
    // the distance from A to root
    int distA = -1;
    // the distance from B to root
    int distB = -1;
    // the distance from LCA (lowest common ancestor) to root
    int distLCA = -1;
}

/**
 * calculate the distance of two nodes in a binary tree
 * similar to lowest common ancestor
 */
public class Solution {
    public int distanceOfTwo(TreeNode root, TreeNode a, TreeNode b) {
        Result res = helper(root, a, b);
        // a or b does not exists in the tree
        if (res.distLCA == -1) return Integer.MAX_VALUE;
        else return res.distA + res.distB - 2 * res.distLCA;
    }

    private Result helper(TreeNode root, TreeNode a, TreeNode b) {
        // base case
        if (root == null) return new Result();
        Result leftRes = helper(root.left, a, b);
        Result rightRes = helper(root.right, a, b);
        Result curRes = new Result();
        if (root == a) {
            if (leftRes.distB != -1 || rightRes.distB != -1) {
                curRes.distLCA = 0;
            }
            curRes.distA = 0;
        }
        if (root == b) {
            if (leftRes.distA != -1 || rightRes.distA != -1) {
                curRes.distLCA = 0;
            }
            curRes.distB = 0;
        }
        if ((leftRes.distA != -1 && rightRes.distB != -1)
                ||  (leftRes.distB != -1 && rightRes.distA != -1)) curRes.distLCA = 0;
        if (leftRes.distA != -1) curRes.distA = leftRes.distA + 1;
        if (leftRes.distB != -1) curRes.distB = leftRes.distB + 1;
        if (leftRes.distLCA != -1) curRes.distLCA = leftRes.distLCA + 1;
        if (rightRes.distA != -1) curRes.distA = rightRes.distA + 1;
        if (rightRes.distB != -1) curRes.distB = rightRes.distB + 1;
        if (rightRes.distLCA != -1) curRes.distLCA = rightRes.distLCA + 1;
        return curRes;
    }
}
