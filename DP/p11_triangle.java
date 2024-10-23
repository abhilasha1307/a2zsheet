import java.util.List;
import java.util.Arrays;

public class p11_triangle {
    public static void main(String[] args) {
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int[][] test = {{1},{2, 3},{3, 6, 7},{8, 9, 6, 10}};

        int n = test.length;

        System.out.println(minimumTotal(test, 0, 0, n));
        
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(minimumTotalMemoize(triangle, 0, 0, n, dp));
    }

    //start recurrence from 0,0
    //base case - last row

    //TC : 2^(1+2+ ... + n-1)
    //sc : O(N)
    private static int minimumTotal(int[][] triangle, int i, int j, int n) {
        if(i == n-1){
            return triangle[i][j];
        } 

        int d = triangle[i][j] + minimumTotal(triangle, i+1, j, n);
        int diagonal = triangle[i][j] + minimumTotal(triangle, i+1, j+1, n);

        return Math.min(d, diagonal);
    }

    //TC : O(n*n)
    //sc : O(n) + O(n*n)
    private static int minimumTotalMemoize(int[][] triangle, int i, int j, int n, int[][] dp) {
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == n-1){
            return triangle[i][j];
        } 

        int d = triangle[i][j] + minimumTotalMemoize(triangle, i+1, j, n, dp);
        int diagonal = triangle[i][j] + minimumTotalMemoize(triangle, i+1, j+1, n, dp);

        return dp[i][j] = Math.min(d, diagonal);
    }

}
