import java.util.Arrays;

public class p10_min_path_sum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int m = grid.length;
        int n = grid[0].length;

        System.out.println(minPathSum(grid, m-1, n-1));

        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(minPathSumMemoized(grid, m-1, n-1, dp));

        System.out.println(minPathSumTabulation(grid, m, n));
        System.out.println(minPathSumTabulationSpaceOptmized(grid, m, n));

    }

    //TC : O(2^(m*n))
    //SC : O(m-1 + n-1) -> path length
    private static int minPathSum(int[][] grid, int m, int n) {
        if(m == 0 && n == 0){
            return grid[0][0];
        }

        if(m<0 || n<0){
            return (int) Math.pow(10, 9);
        }

        int up = grid[m][n] + minPathSum(grid, m-1, n);
        int left = grid[m][n] + minPathSum(grid, m, n-1);

        return Math.min(up, left);
    }

    //TC : O(m*n)
    //SC : O(m*n) + O(m-1 + n-1)
    private static int minPathSumMemoized(int[][] grid, int m, int n, int[][] dp) {
        if(m == 0 && n == 0){
            return grid[0][0];
        }

        if(m<0 || n<0){
            return (int) Math.pow(10, 9);
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int up = grid[m][n] + minPathSumMemoized(grid, m-1, n, dp);
        int left = grid[m][n] + minPathSumMemoized(grid, m, n-1, dp);

        return dp[m][n] = Math.min(up, left);
    }

    //TC : O(m*n);
    //SC : O(m*n);

    private static int minPathSumTabulation(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i>0){
                        up += dp[i-1][j];
                    }else{
                        up += (int)Math.pow(10, 9);
                    }

                    if(j > 0){
                        left += dp[i][j-1];
                    }else{
                        left += (int) Math.pow(10, 9);
                    }

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1];
    }

    //TC : O(m*n)
    //SC : O(N) + O(N) ~ O(N)
    private static int minPathSumTabulationSpaceOptmized(int[][] grid, int m, int n) {
        int[] prev = new int[n];

        for(int i = 0; i<m; i++){
            int[] curr = new int[n];
            for(int j = 0; j<n; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i>0){
                        up += prev[j];
                    }else{
                        up += (int)Math.pow(10, 9);
                    }

                    if(j > 0){
                        left += curr[j-1];
                    }else{
                        left += (int) Math.pow(10, 9);
                    }

                    curr[j] = Math.min(up, left);
                }
            }

            prev = curr;
        }

        return prev[n-1];
    }
}
