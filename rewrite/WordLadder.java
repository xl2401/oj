public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> lenQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        lenQueue.add(1);
        while (!wordQueue.isEmpty()) {
            // visit the words' children
            String cur = wordQueue.poll();
            int curLen = lenQueue.poll();
            for (int i = 0; i < cur.length(); i++) {
                char[] array = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    String newStr = new String(array);
                    if (newStr.equals(end)) return curLen+1;
                    if (dict.contains(newStr)) {
                        wordQueue.add(newStr);
                        lenQueue.add(curLen+1);
                        dict.remove(newStr);
                    }
                }
            }
            dict.remove(cur);
        }
        return 0;
    }
}