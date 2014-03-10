import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * Title: Word Break II
 * Description:
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * Solution:
 * Same as work break, add index when iterating.
 * the construct process is a little tedious, the combination process usually use recursion,
 * the following is the better version of buildList
 * http://blog.csdn.net/violet_program/article/details/12499125
 */
public class WordBreak2 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int N = s.length();
        boolean[] validTil = new boolean[N];
        ArrayList<ArrayList<Integer>> idxLists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++){
            // calculate if valid to i
            boolean valid = false;
            ArrayList<Integer> idxList = new ArrayList<Integer>(); 
            for (int j = 0; j <= i; j++){
                boolean prevValid = j == 0 ? true : validTil[j-1];
                // when there's one valid
                if (prevValid && dict.contains(s.substring(j, i+1))){
                    valid = true;
                    idxList.add(j);
                }
            }
            validTil[i] = valid;
            idxLists.add(idxList);
        }
        return getPath(s, idxLists, N);
    }

    /*
     * invariant: return return the work break strings of s.substring(0,n)
     */
    public ArrayList<String> getPath(String s, ArrayList<ArrayList<Integer>> idxLists, int n){
        ArrayList<String> res = new ArrayList<String>();
        for (Integer idx: idxLists.get(n-1)){
            if (idx == 0){
                res.add(s.substring(0, n));
            }
            else{
                ArrayList<String> prevRes = getPath(s, idxLists, idx);
                for (String str: prevRes){
                    res.add(str + " " + s.substring(idx, n));
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        WordBreak2 wb = new WordBreak2();
        ArrayList<String> sList = wb.wordBreak("catsanddog", dict);
        for (String str: sList){
            System.out.println(str);
        }
    }
}
