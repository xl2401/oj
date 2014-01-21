import java.util.ArrayList;

/*
 * Title: Palindrome Partitioning
 * Description:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *       ["aa","b"],
 *       ["a","a","b"]
 *   ]
 *
 * Solution:
 * very similar to word break II
 * DP
 */
public class PalindromePartition {
    public ArrayList<ArrayList<String>> partition(String s) {
        int N = s.length();
        ArrayList<ArrayList<Integer>> jump = new ArrayList<ArrayList<Integer>>();
        for (int j = 0; j < N; j++){
            ArrayList<Integer> jumpList = new ArrayList<Integer>(); 
            for (int i = 0; i <= j; i++){
                if (isPalindrom(s, i, j))
                    jumpList.add(i);
            }
            jump.add(jumpList);
        }
        ArrayList<ArrayList<String>> result = buildPartition(jump, s, s.length()-1);
        return result;
    }

    private ArrayList<ArrayList<String>> buildPartition(ArrayList<ArrayList<Integer>> jump, String s, int j){
        ArrayList<ArrayList<String>> newPartition = new ArrayList<ArrayList<String>>();
        if (j == -1){
            ArrayList<String> emptyList = new ArrayList<String>();
            newPartition.add(emptyList);
            return newPartition;
        }
        ArrayList<Integer> jumpIdx = jump.get(j);
        for (Integer idx: jumpIdx){
            ArrayList<ArrayList<String>> prevPartition = buildPartition(jump, s, idx-1);
            String curStr = s.substring(idx, j+1);
            for (ArrayList<String> par: prevPartition){
                ArrayList<String> curPar = cloneArrayList(par);
                curPar.add(curStr);
                newPartition.add(curPar);
            }
        }
        return newPartition;
    }

    public boolean isPalindrom(String a, int i, int j){
        int n = (j-i+1) / 2;
        for (int off = 0; off < n; off++){
            int first = i + off;
            int last = j - off;
            if (a.charAt(first) != a.charAt(last)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> cloneArrayList(ArrayList<String> l){
        ArrayList<String> newL = new ArrayList<String>();
        for (String str: l){
            newL.add(str);
        }
        return newL;
    }

    public static void main(String[] args){
        PalindromePartition pp = new PalindromePartition();
        ArrayList<ArrayList<String>> result = pp.partition("abcba");
        for (ArrayList<String> l: result){
            for (String s: l){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
