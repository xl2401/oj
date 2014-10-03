given a string, find the longest substring that's a palindrome

abcdeedca -> cdeedc

s s.substring(i, j+1)
Palindrome(i, j) = s[i] == s[j] && Palindrome(i+1, j-1)

public String longestPalindrome(String s) {
        // check null
        if (s == null) return null;
        int N = s.length();
        // P[i][j] record if the substring s.substring(i, j+1) is a palindrome
        boolean[][] P = new boolean[N][N];
        int startIdx = -1;
        int endIdx = -1;
        int max = 0;
        for (int l = 1; l <= N; l++) {
                for (int i = 0; i <= N - l; i++) {
                        int j = i + l - 1;
                        P[i][j] = s.charAt(i) == s.charAt(j) &&
                            ((j - i) > 1 ? P[i+1][j-1] : true);
                        if (P[i][j]) {
                                if (l > max) {
                                        startIdx = i;
                                        endIdx = j
                                        max = l;
                                }
                        }
                }
        }
        if (startIdx == -1) return "";
        return s.substring(startIdx, endIdx+1);
}

test cases:
null
""
aba abac
abcbawabbbbbbbbba
abbbbbbbbbawabcba
wabcbaw
abc
cabac
abba
