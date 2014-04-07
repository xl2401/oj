import java.util.HashSet;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * Title: Word Ladder
 * Description: 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * Solution:
 * BFS to a graph, remember to delete entry in set to prevent to return to previous level or the same level
 * the way to find an edge is to iterate over every possible substitution (a-z) on every position of the current str
 */
public class WordLadder {
    // BFS
    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> lenQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        lenQueue.add(1);

        while (!wordQueue.isEmpty()){
            String curStr = wordQueue.poll();
            int curLen = lenQueue.poll();

            // add children
            for (int i = 0; i < curStr.length(); i++){
                char[] charArray = curStr.toCharArray();
                for (char c = 'a'; c <= 'z'; c++){
                    charArray[i] = c;
                    String newStr = new String(charArray);
                    if (newStr.equals(end)) return curLen+1;
                    if (dict.contains(newStr) || newStr.equals(end)){
                        wordQueue.add(newStr);
                        lenQueue.add(curLen+1);
                    }
                    // ! important
                    dict.remove(newStr);
                }
                dict.remove(curStr);
            }
        }
        return 0;
    }

    public static void main(String[] args){
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hit", "cog", new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
    }
}
