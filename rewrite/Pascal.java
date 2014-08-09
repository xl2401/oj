public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = res.get(i-1);
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= last.size(); j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(last.get(j)+last.get(j-1));
                }
            }
            res.add(cur);
        }
        return res;
    }
}