public class Solution {
    public int minDistance(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        int[][] dist = new int[M+1][N+1];
        for (int i = 0; i <= M; i++) dist[i][0] = i;
        for (int j = 0; j <= N; j++) dist[0][j] = j;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dist[i][j] = dist[i-1][j-1];
                else
                    dist[i][j] = min(dist[i-1][j],
                            dist[i][j-1],
                            dist[i-1][j-1]) + 1;
            }
        }
        return dist[M][N];
    }
    
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
