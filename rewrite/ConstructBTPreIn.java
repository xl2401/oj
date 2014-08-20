public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) return null;
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int rootOffset = searchRootOffset(inorder, iStart, iEnd, rootVal);
        TreeNode left = buildTree(preorder, inorder, pStart+1, pStart+rootOffset, iStart, iStart+rootOffset-1);
        TreeNode right = buildTree(preorder, inorder, pStart+rootOffset+1, pEnd, iStart+rootOffset+1, iEnd);
        root.left = left;
        root.right = right;
        return root;
    }

    private int searchRootOffset(int[] inorder, int start, int end, int target) {
        int cnt = 0;
        int i = start;
        while (i <= end && inorder[i] != target) i++;
        if (i > end) return -1;
        else return i - start;
    }
}