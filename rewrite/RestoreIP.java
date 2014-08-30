import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) return res;
        helper(res, s, "", 0, 0);
        return res;
    }

    private void helper(List<String> res, String s, String portion, int start, int portionCnt) {
        if (portionCnt == 4) {
            if (start == s.length()) res.add(portion);
            return;
        }
        int sum = 0;
        int i = start;
        while (i < s.length()) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum <= 255) {
                String newPortion = portion.length() == 0 ?
                        portion + sum : portion + "." + sum;
                helper(res, s, newPortion, i+1, portionCnt+1);
                i++;
            } else break;
            if (sum == 0) break;
        }
    }
}