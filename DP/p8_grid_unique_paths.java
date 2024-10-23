import java.util.Arrays;

/**
 * p8_grid_unique_paths
 */
public class p8_grid_unique_paths {

    public static void main(String[] args) {
        int m = 3, n = 7;

        System.out.println(uniquePaths(m-1, n-1));

        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        System.out.println(uniquePathsMemo(m-1, n-1, dp));
        System.out.println(uniquePathsTabulation(m, n));
        System.out.println(uniquePathsTabulationSpaceOptimize(m, n));
    }

    //TC : O(2^(m*n))
    //SC : O(path length); path length is the stack space
    //path length = (m-1)+(n-1)
    private static int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }

        int up = uniquePaths(m-1, n);
        int left = uniquePaths(m, n-1);

        return up + left;
    }

    //TC : O(N*M)
    //SC : O(m-1 + n-1) + O(n*m) 
    private static int uniquePathsMemo(int m, int n, int[][] dp) {
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        return dp[m][n] = uniquePathsMemo(m-1, n, dp) + uniquePathsMemo(m, n-1, dp); 
    }   

    //TC : O(n*m)
    //SC : O(n*m)
    private static int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
       
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 && j == 0){
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


    //if there is a previous row and previous column, then we can space optimize
    //store the previous row values only
    private static int uniquePathsTabulationSpaceOptimize(int m, int n) {
        int[] prev = new int[n];
        
        for(int i = 0; i<m; i++){
            int[] temp = new int[n];
            for(int j = 0; j<n; j++){
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