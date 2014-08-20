public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null) return res;
        List<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(res, sub, num, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> sub, int[] num, int start) {
        res.add(new ArrayList<Integer>(sub));
        if (start == num.length) return;
        int i = start;
        while (i < num.length) {
        	int cur = num[i];
        	sub.add(cur);
            helper(res, sub, num, i+1);
        	sub.remove(sub.size()-1);
        	// skip the same elem
            while (i < num.length && num[i] == cur) i++;
        }
    }
}