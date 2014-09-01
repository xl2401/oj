import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        // construct dict map
        HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
        for (String str: L) {
            if (cntMap.containsKey(str)) {
                cntMap.put(str, cntMap.get(str)+1);
            } else {
                cntMap.put(str, 1);
            }
        }
        int wordLen = L[0].length();
        int totalLen = wordLen * L.length;
        List<Integer> res = new ArrayList<Integer>();
        if (S.length() < totalLen) return res;
        for (int i = 0; i <= S.length()-totalLen; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>(cntMap);
            boolean contain = true;
            for (int j = 0; j < L.length; j++) {
                int start = i + j * wordLen;
                int end = start + wordLen;
                String curWord = S.substring(start, end);
                if (map.containsKey(curWord)) {
                    if (map.get(curWord) == 0) {
                        contain = false;
                        break;
                    }
                    else map.put(curWord, map.get(curWord)-1);
                } else {
                    contain = false;
                    break;
                }
            }
            if (contain) res.add(i);
        }
        return res;
    }
}