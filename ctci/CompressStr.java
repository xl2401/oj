/*
 * 1.5
 * Compress string using char and the repeated times
 * e.g. aabcccccaaa -> a2b1c5a3
 * if the new string is shorter than the original string
 * return the new string, otherwise return the original one
 *
 * Solution:
 * if the loop is not progressing one by one -> for example,
 * advance according to some particular rule, use old school while!
 * with a ptr!
 */
public class CompressStr {
    public String compressStr(String str) {
        StringBuilder sb = new StringBuilder();
        int ptr = 0;
        while (ptr < str.length()) {
            char c = str.charAt(ptr);
            int cnt = 0;
            while (ptr < str.length() && str.charAt(ptr) == c) {
                ptr++;
                cnt++;
            }
            sb.append(c);
            sb.append(cnt);
        }
        String newStr = sb.toString();
        return newStr.length() < str.length() ? newStr : str;
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(new CompressStr().compressStr(str));
    }
}
