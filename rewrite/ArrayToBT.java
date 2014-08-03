public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
    	return buildTree(num, 0, num.length-1);
    }
    
    private TreeNode buildTree(int[] num, int start, int end) {
    	// base case
    	if (start > end)
    		return null;
    	int mid = (start + end) / 2;
    	TreeNode cur = new TreeNode(num[mid]);
    	TreeNode left = buildTree(num, start, mid-1);
    	TreeNode right = buildTree(num, mid+1, end);
    	cur.left = left;
    	cur.right = right;
    	return cur;
    }
}