/*
 * 4.3
 * Create a BST from a sorted array
 *
 * Solution:
 * binary recursive
 */
public class CreateBST {
    public TreeNode constructTree(int[] array) {
        return constructHelper(array, 0, array.length-1);
    }

    private TreeNode constructHelper(int[] array, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(array[m]);
        TreeNode left = constructHelper(array, l, m-1);
        TreeNode right = constructHelper(array, m+1, r);
        root.left = left;
        root.right = right;
        return root;
    }
}
