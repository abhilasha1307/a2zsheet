import java.util.Arrays;

public class p9_grid_unique_paths_II {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        System.out.println(uniquePathsWithObstacles(obstacleGrid, m-1, n-1));

        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(uniquePathsWithObstaclesMemoized(obstacleGrid, m-1, n-1, dp));
        System.out.println(uniquePathsWithObstaclesTabulation(obstacleGrid, m, n));
        System.out.println(uniquePathsWithObstaclesTabulationSpaceOptimize(obstacleGrid, m, n));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n) {
        if(m>=0 && n >=0 && obstacleGrid[m][n] == 1){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }

        int up = uniquePathsWithObstacles(obstacleGrid, m-1, n);
        int left = uniquePathsWithObstacles(obstacleGrid, m, n-1);

        return up + left;
    }

    private static int uniquePathsWithObstaclesMemoized(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if(m>=0 && n >=0 && obstacleGrid[m][n] == 1){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int up = uniquePathsWithObstaclesMemoized(obstacleGrid, m-1, n, dp);
        int left = uniquePathsWithObstaclesMemoized(obstacleGrid, m, n-1, dp);

        return dp[m][n] = up + left;
    }

    private static int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid, int m, int n) {
        int[][] dp = new int[m][n];
       
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                    
                int up = 0;
                int left = 0;
                if(i>0) {
                    up = dp[i-1][j];
                }
                if(j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up+left;
                
            }
        }

        return dp[m-1][n-1];
    } 


    private static int uniquePathsWithObstaclesTabulationSpaceOptimize(int[][] obstacleGrid, int m, int n) {
        int[] prev = new int[n];
        
        for(int i = 0; i<m; i++){
            int[] temp = new int[n];
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    temp[j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;

                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                temp[j] = up + left;
            }
            prev = temp;
        }

        return prev[n-1];
    } 
}
