public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        int[][] pathMatrix = new int[M][N];
        // init
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[i][0] == 0) {
                pathMatrix[i][0] = 1;
            } else break;
        }
        for (int j = 0; j < N; j++) {
            if (obstacleGrid[0][j] == 0) {
                pathMatrix[0][j] = 1;
            } else break;
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1) continue;
                else if (obstacleGrid[i-1][j] == 1)
                	pathMatrix[i][j] = pathMatrix[i][j-1];
                else if (obstacleGrid[i][j-1] == 1)
                	pathMatrix[i][j] = pathMatrix[i-1][j];
                else
                	pathMatrix[i][j] =  obstacleGrid[i][j] == 1 ? 0 : pathMatrix[i-1][j] + pathMatrix[i][j-1];
            }
        }
        return pathMatrix[M-1][N-1];
    }
}