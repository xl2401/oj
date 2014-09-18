class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Find the first common ancestor of two nodes
 */
public class Solution {
    private TreeNode commonAnc;

    public TreeNode commonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        commonAnc = null;
        if (n1 == n2) return n1;
        helper(root, n1, n2);
        return commonAnc;
    }

    /**
     * post order traversal
     * @param root
     * @param n1
     * @param n2
     * @return
     * 0 - this tree does not contain n1 or n2
     * 1 - only contain n1
     * 2 - only contain n2
     * 3 - contain both n1 & n2
     */
    private int helper(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return 0;
        int leftRes = helper(root.left, n1, n2);
        if (leftRes == 3) return 3;
        int rightRes = helper(root.right, n1, n2);
        if (rightRes == 3) return 3;
        if (root == n1) {
            if (leftRes == 2 || rightRes == 2) {
                commonAnc = root;
                return 3;
            } else {
                return 1;
            }
        }
        if (root == n2) {
            if (leftRes == 1 || rightRes == 1) {
                commonAnc = root;
                return 3;
            } else {
                return 2;
            }
        }
        if ((leftRes == 1 && rightRes == 2) || (leftRes == 2 && rightRes == 1)) {
            commonAnc = root;
            return 3;
        }
        return leftRes + rightRes;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(new Solution().commonAncestor(a, d, c).val);
    }
}
