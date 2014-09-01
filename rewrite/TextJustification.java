public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) return res;
        int start = 0;
        int end = 0;
        int cnt = 0;
        while (end < words.length) {
            // look for end
            while (true) {
                if (cnt == 0) cnt += words[end].length();
                else cnt += words[end].length()+1;
                if (end == words.length-1) break;
                if (cnt + words[end+1].length() + 1 > L) break;
                end++;
            }
            addLine(res, words, start, end, L);
            end = end + 1;
            start = end;
            cnt = 0;
        }
        return res;
    }

    private void addLine(List<String> res, String[] words, int start, int end, int L) {
        boolean leftJust = false;
        if (end == words.length-1 || (end-start) == 0) leftJust = true;
        StringBuilder sb = new StringBuilder();
        int totalLen = 0;
        for (int i = start; i <= end; i++) {
            totalLen += words[i].length();
        }
        int extra = leftJust ? 0 : (L - totalLen) % (end - start);
        int space = leftJust ? 1 : (L - totalLen) / (end - start);
        for (int i = start; i <= end; i++) {
            if (i == start) {
                sb.append(words[i]);
            } else {
                // add space
                int curSpace = space;
                if (extra > 0) {
                    extra--;
                    curSpace++;
                }
                for (int j = 0; j < curSpace; j++) {
                    sb.append(' ');
                }
                sb.append(words[i]);
            }
        }
        if (leftJust) {
            int tailSpace = L - totalLen - (end - start);
            for (int i = 0; i < tailSpace; i++) {
                sb.append(' ');
            }
        }
        res.add(sb.toString());
    }
}