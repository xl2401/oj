public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return res;
        List<String> cur = new ArrayList<String>();
        helper(res, cur, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> cur, String s, int start) {
        // base condition
        if (start == s.length()) res.add(new ArrayList<String>(cur));
        for (int i = start+1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalin(sub)) {
                cur.add(sub);
                helper(res, cur, s, i);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalin(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}