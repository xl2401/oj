import java.util.ArrayList;
import java.util.HashMap;

/*
 * Title: Substring with Concatenation of All Words
 * Description:
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * Solution:
 * just check every substring with len: wLen * N
 * use hashmap to count
 */
public class SubstrConcat {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int wLen = L[0].length();
        int N = L.length;
        int dictLen = N * wLen;
        int ptr = 0;
        while (ptr + dictLen <= S.length()){
            if (checkContain(S, ptr, L)){
                res.add(ptr);
            }
            ptr++;
        }
        return res;
    }

    private boolean checkContain(String S, int idx, String[] L){
        int wLen = L[0].length();
        int N = L.length;
        if (S.length() - idx < wLen*N) return false;
        HashMap<String, Integer> dict = getDict(L);
        for (int i = 0; i < N; i++){
            String substr = S.substring(idx+wLen*i, idx+wLen*(i+1));
            if (!dict.containsKey(substr)) return false;
            else{
                dict.put(substr, dict.get(substr)-1);
                if (dict.get(substr) < 0) return false;
            }
        }
        return true;
    }

    private HashMap<String, Integer> getDict(String[] L){
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for (String str: L){
            if (dict.containsKey(str)){
                dict.put(str, dict.get(str)+1);
            }
            else{
                dict.put(str, 1);
            }
        }
        return dict;
    }

    public static void main(String[] args){
        String S = "barfoothefoobarman";
        String[] L = {"foo", "bar"};
        ArrayList<Integer> res = new SubstrConcat().findSubstring(S, L); 
        for (Integer i: res){
            System.out.println(i);
        }
    }
}
