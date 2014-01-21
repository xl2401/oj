import java.util.Set;
import java.util.HashSet;

/*
 * Title: Word Break
 * Description:
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * Solution:
 * DP record if it str valid till i
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int N = s.length();
        boolean[] containTo = new boolean[N];
        for (int i = 0; i < N; i++){
            boolean contain = false;
            for (int j = 0; j <= i; j++){
                boolean prev = true;
                if (j == 0)
                    prev = true;
                else
                    prev = containTo[j-1];
                if (prev && dict.contains(s.substring(j, i+1))){
                    contain = true;
                }
            }
            containTo[i] = contain;
        }
       return containTo[N-1];
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("leetcode", dict));
    }
}
