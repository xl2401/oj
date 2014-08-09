public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateHelper(res, 0, 0, n, "");
        return res;
    }
    
    private void generateHelper(List<String> res, int leftCnt, int rightCnt, int n, String curStr) {
    	// final case
    	if (leftCnt == n && rightCnt == n) {
    		res.add(curStr);
    		return;
    	}
    	if (leftCnt < n) generateHelper(res, leftCnt+1, rightCnt, n, curStr+"(");
    	if (rightCnt < n && leftCnt > rightCnt) generateHelper(res, leftCnt, rightCnt+1, n, curStr+")");
    }
}