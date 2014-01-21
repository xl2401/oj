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
        boolean[] containTo = new boolean[N];
        HashMap<Integer, ArrayList<Integer>> idxMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < N; i++){
            boolean contain = false;
            ArrayList<Integer> idxList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++){
                boolean prev = true;
                if (j == 0)
                    prev = true;
                else
                    prev = containTo[j-1];
                if (prev && dict.contains(s.substring(j, i+1))){
                    contain = true;
                    idxList.add(j);
                }
            }
            containTo[i] = contain;
            idxMap.put(i, idxList);
        }
        ArrayList<String> result = new ArrayList<String>();
        buildList(idxMap, "", s, N-1, result);
        return result;
    }

    public void buildList(HashMap<Integer, ArrayList<Integer>> map, String m, String s, int i, ArrayList<String> result){
        for (Integer j: map.get(i)){
            String curStr = "";
            if (m.length() == 0){
                curStr = s.substring(j, i+1);
            }
            else
                curStr = s.substring(j, i+1) + " " + m;
            if (j == 0){
                result.add(curStr);
            }
            else{
                buildList(map, curStr, s, j-1, result);
            }
        }
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
