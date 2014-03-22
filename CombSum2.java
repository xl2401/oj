import java.util.ArrayList;
import java.util.Arrays;

/*
 * Title: Combination Sum
 * Description:
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 *
 * Solution:
 * avoid dup
 */
public class CombSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curComb = new ArrayList<Integer>();
        getComb(candidates, 0, target, curComb, res);
        return res;
    }

    public void getComb(int[] cand, int idx, int target, 
            ArrayList<Integer> curComb, ArrayList<ArrayList<Integer>> res){
        if (target == 0){
            res.add(curComb);
            return;
        }
        if (idx >= cand.length || target < 0) return;
        
        int cur = cand[idx];
        int nextIdx = idx;
        while (nextIdx < cand.length && cand[nextIdx] == cur) nextIdx++;
        int cnt = nextIdx - idx;
        for (int i = 0; i <= cnt; i++){
            ArrayList<Integer> nextComb = new ArrayList<Integer>(curComb);
            getComb(cand, nextIdx, target, nextComb, res);
            target -= cur;
            curComb.add(cur);
        }
   }

    public static void main(String[] args){
        CombSum2 cs = new CombSum2();
        int[] candidates = {1};
        int target = 1;
        ArrayList<ArrayList<Integer>> res = cs.combinationSum2(candidates, target);
        for (ArrayList<Integer> sol: res){
            for (Integer i: sol){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
