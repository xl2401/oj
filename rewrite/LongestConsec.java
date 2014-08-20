public class Solution {
    public int longestConsecutive(int[] num) {	
    	int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++)
            set.add(num[i]);
        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                int cnt = 1;
                int cur = num[i];
                set.remove(cur);
                while (set.contains(--cur)) {
                    cnt++;
                    set.remove(cur);
                }
                cur = num[i];
                while (set.contains(++cur)) {
                    cnt++;
                    set.remove(cur);
                }
                if (cnt > max) max = cnt;
            }
        }
        return max;
    }
}