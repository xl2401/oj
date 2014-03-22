import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

/*
 * Title: Combination Sum
 * Description:
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 *
 * Solution:
 * use recursion: getComb to get the result from the idx in cand
 * curComb represent the current combination, remember to copy curComb before enter next recursion
 */
public class CombSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> cand = rmDup(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curComb = new ArrayList<Integer>();
        getComb(cand, 0, target, curComb, res);
        return res;
    }

    public void getComb(ArrayList<Integer> cand, int idx, int target, 
            ArrayList<Integer> curComb, ArrayList<ArrayList<Integer>> res){
        if (idx >= cand.size()) return;
        int cur = cand.get(idx);
        while (target > 0){
            ArrayList<Integer> nextComb = new ArrayList<Integer>(curComb);
            getComb(cand, idx+1, target, nextComb, res);
            target -= cur;
            curComb.add(cur);
            if (target == 0){
                res.add(curComb);
            }
        }
    }

    ArrayList<Integer> rmDup(int[] candidates){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < candidates.length; i++){
            set.add(candidates[i]);
        }
        ArrayList<Integer> res = new ArrayList<Integer>(set);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args){
        CombSum cs = new CombSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        ArrayList<ArrayList<Integer>> res = cs.combinationSum(candidates, target);
        for (ArrayList<Integer> sol: res){
            for (Integer i: sol){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
