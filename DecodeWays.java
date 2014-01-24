/*
 * Title: Decode Ways
 * Description:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 * Solution:
 * Use DP, use a array to represent the count at the length of s
 * pay special attention to the scope of mapping.
 * 0 is not a valid key
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int N = s.length();
        if (N == 0)
            return 0;
        char firC = s.charAt(0);
        if (!(firC >= '1' && firC <= '9'))
            return 0;
        int[] countDp = new int[N];
        countDp[0] = 1;
        for (int i = 1; i < N; i++){
            char curC = s.charAt(i);
            char prevC = s.charAt(i-1);
            int sum = curC - '0' + (prevC - '0') * 10;
            int prevCount = countDp[i-1];
            int ppCount = 0;
            if (i == 1)
                ppCount = 1;
            else
                ppCount = countDp[i-2];
            if (curC >= '1' && curC <= '9')
                countDp[i] += prevCount;
            if (sum >= 10 && sum <= 26)
                countDp[i] += ppCount;
            if (countDp[i] == 0)
                return 0;
        }
        return countDp[N-1];
    }

    public static void main(String[] args){
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("0"));
    }
}
