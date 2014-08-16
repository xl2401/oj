public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curSumList = new ArrayList<Integer>();
        helper(res, curSumList, 0, sum, root);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curSumList, int curSum, int sum, TreeNode root) {
        if (root == null) return;
    	// make a copy
    	curSumList = new ArrayList<Integer>(curSumList);
        curSumList.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null) {
        	if (curSum == sum) res.add(curSumList);
        	return;
        }
        helper(res, curSumList, curSum, sum, root.left);
        helper(res, curSumList, curSum, sum, root.right);
    }
}