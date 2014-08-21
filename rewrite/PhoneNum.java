import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private HashMap<Character, String> digitMap;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            res.add("");
            return res;
        }
        // init hashmap
        digitMap = new HashMap<Character, String>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
        helper(res, "", digits, 0);
        return res;
    }

    private void helper(List<String> res, String cur, String digits, int start) {
        // base condition
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        String digitStr = digitMap.get(digits.charAt(start));
        for (int i = 0; i < digitStr.length(); i++) {
            cur = cur + digitStr.charAt(i);
            helper(res, cur, digits, start+1);
            cur = cur.substring(0, cur.length()-1);
        }
    }
}