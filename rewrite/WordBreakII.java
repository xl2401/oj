public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        int N = s.length();
        List<List<Integer>> idxsList = new ArrayList<List<Integer>>();
        List<Integer> initIdx = new ArrayList<Integer>();
        initIdx.add(-1);
        idxsList.add(initIdx);
        for (int i = 1; i <= N; i++) {
            List<Integer> idxs = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (!idxsList.isEmpty() && dict.contains(s.substring(j, i))) {
                    idxs.add(j);
                }
            }
            idxsList.add(idxs);
        }
        List<String> res = new ArrayList<String>();
        generateRes(res, s, "", N, idxsList);
        return res;
    }

    private void generateRes(List<String> res, String s, String cur, int end, List<List<Integer>> idxsList) {
        if (end == 0) {
            res.add(cur);
            return;
        }
        List<Integer> idxs = idxsList.get(end);
        for (Integer idx: idxs) {
            String newStr = s.substring(idx, end) + " " + cur;
            generateRes(res, s, newStr.trim(), idx, idxsList);
        }
    }
}