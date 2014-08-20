public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (S == null) return res;
        Arrays.sort(S);
        List<Integer> sub = new ArrayList<Integer>();
        helper(res, sub, S, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> sub, int[] S, int start) {
        res.add(new ArrayList<Integer>(sub));
        if (start == S.length) return;
        for (int i = start; i < S.length; i++) {
            sub.add(S[i]);
            helper(res, sub, S, i+1);
            sub.remove(sub.size()-1);
        }
    }
}