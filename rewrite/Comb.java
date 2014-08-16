public class Solution {
    public List<List<Integer>> combine(int n, int k) {  
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < k) return res;
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, comb, k, n, 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> comb, int k, int n, int start) {
        if (comb.size() == k) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        if (start > n-k+comb.size()+1) return;
        for (int i = start; i <= n; i++) {
            comb.add(i);
            helper(res, comb, k, n, i+1);
            comb.remove(comb.size()-1);
        }
    }
}