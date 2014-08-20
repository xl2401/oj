import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res, candidates, target, cur, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> cur, int start) {
        // base condition
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int cand = candidates[i];
            cur.add(cand);
            helper(res, candidates, target-cand, cur, i);
            cur.remove(cur.size()-1);
        }
    }
}