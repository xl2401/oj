import java.util.Arrays;

/*
 * Title: Longest Substring Without Repeating Characters
 * Description:
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Solution:
 * Here, use an array appearIdx to record the last idx that a character appears, this array is 256 large including all ASCII char
 * pay attention:
 * 1. judge if a char is a repetition: the idx should within the range!
 * 2. the start point should be lastAppear + 1, not ptr
 * last, do not forget update max outside the loop, because it is possible the last char is not a repetition
 */
public class LongestSubstr{
    public int lengthOfLongestSubstring(String s){
        int[] appearIdx = new int[256];
        Arrays.fill(appearIdx, -1);
        int ptr = 0;
        int start = 0;
        int max = 0;
        int N = s.length();
        while (ptr < N){
            char c = s.charAt(ptr);
            int lastAppear = appearIdx[c];
            if (lastAppear >= start && lastAppear < ptr){ // appear again!
                // update appearance
                appearIdx[c] = ptr;
                max = Math.max(max, ptr - start);
                start = lastAppear + 1;
            }
            else{// simply update appearance
                appearIdx[c] = ptr;
            }
            ptr++;
        }
        max = Math.max(max, N - start);
        return max;
    }

    public static void main(String[] args){
        LongestSubstr lss = new LongestSubstr();
        System.out.println(lss.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}
