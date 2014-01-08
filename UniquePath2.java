/**
 * Title: Unique Paths 2
 * Desciption:
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Solution:
 * Not able to use Combination in this situation,
 * DP solution still works
 */
public class UniquePath2 {
    /**
     * DP EDITION
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        // reformat grid, first line and first col->1
        // obstacle -> -1
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
            }
        }
        obstacleGrid[0][0] = 1;
        // update the first column and first line
        for (int i = 1; i < m; i++){
            int up = obstacleGrid[i-1][0];
            if (obstacleGrid[i][0] != -1){
                obstacleGrid[i][0] = up;
            }
        }
        for (int j = 1; j < n; j++){
            int left = obstacleGrid[0][j-1];
            if (obstacleGrid[0][j] != -1) obstacleGrid[0][j] = left;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == -1) continue;
                else{
                    int left = obstacleGrid[i][j-1];
                    int up = obstacleGrid[i-1][j];
                    if (left == -1) left = 0;
                    if (up == -1) up = 0;
                    obstacleGrid[i][j] = up + left;
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args){
        int[][] A = {{0}};
        System.out.println(new UniquePath2().uniquePathsWithObstacles(A));
    }
}
