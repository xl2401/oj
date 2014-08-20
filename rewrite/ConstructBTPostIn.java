public class Solution {
    private HashMap<Integer, Integer> idxMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int N = inorder.length;
        // build inorder map
        idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, N-1, 0, N-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd) return null;
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int offset = idxMap.get(rootVal) - iStart;
        TreeNode left = buildTree(inorder, postorder, iStart, iStart+offset-1, pStart, pStart+offset-1);
        TreeNode right = buildTree(inorder, postorder, iStart+offset+1, iEnd, pStart+offset, pEnd-1);
        root.left = left;
        root.right = right;
        return root;
    }
}