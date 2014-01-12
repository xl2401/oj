/*
 * Title: Longest Common Prefix 
 * Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Solution:
 * Simple compare
 */
public class LCP {
    public String longestCommonPrefix(String[] strs) {
        int N = strs.length;
        if (N == 0)
            return "";
        int idx = -1;
        for (int i = 0; i < strs[0].length(); i++){// iterate over the first string
            char curChar = strs[0].charAt(i);
            boolean commonChar = true;
            for (int j = 1; j < N; j++){
                if (i >= strs[j].length()){
                    commonChar = false;
                    break;
                }
                if (strs[j].charAt(i) != curChar){
                    commonChar = false;
                    break;
                }
            }
            if (commonChar)
                idx++;
            else
                break;
        }
        return strs[0].substring(0, idx+1);
    }

    public static void main(String[] args){
        String[] strs = {"ca", "cb"};
        System.out.println(new LCP().longestCommonPrefix(strs));
    }
}
