import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, target, num, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int target, int[] num, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        int i = start;
        while (i < num.length) {
            int cand = num[i];
            cur.add(cand);
            helper(res, cur, target-cand, num, i+1);
            cur.remove(cur.size()-1);
            // skip the dup ones
            while (i < num.length && num[i] == cand)
                i++;
        }
    }
}