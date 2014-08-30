public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        HashMap<String, String> hist = new HashMap<String, String>();
        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortStr = new String(charArray);
            if (hist.containsKey(sortStr)) {
                String former = hist.get(sortStr);
                if (former != null) {
                    res.add(former);
                    hist.put(sortStr, null);
                }
                res.add(s);
            } else {
                hist.put(sortStr, s);
            }
        }
        return res;
    }
}