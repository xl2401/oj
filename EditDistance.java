public class EditDistance {
    private int min(int i, int j, int k){
        return Math.min(i, Math.min(j, k));
    } 

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] disMatrix = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            disMatrix[i][0] = i;
        }
        for (int j = 1; j <= n; j++){
            disMatrix[0][j] = j;
        }
        for (int i = 1; i <=m; i++){
            for (int j = 1; j <= n; j++){
                disMatrix[i][j] = min(disMatrix[i-1][j]+1,
                                      disMatrix[i][j-1]+1,
                                      disMatrix[i-1][j-1] 
                                      + (word1.charAt(i-1) == word2.charAt(j-1)? 0: 1));
            }
        }
        return disMatrix[m][n];
    }
}
