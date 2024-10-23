public class p2_climb_stairs {
    //like fibonacci problem
    public static void main(String[] args) {
        int n = 2;
        int[] dp = new int[n+1];
        for(int i = 1; i<=n; i++){
            dp[i] = -1;
        }
        System.out.println(climbStairs(n, dp));
        System.out.println(climbStairsTab(n));
    }

    //Memoization
    //TC : O(n)
    //SC : O(n)

    static int climbStairs(int n, int[] dp){
        if(n <= 2){
            return dp[n] = n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
    }

    static int climbStairsTab(int n){
        int prev = 2;
        int prev2 = 1;

        for(int i = 3; i<= n; i++){
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }

        return prev;
    }

    //if constraints are high use matrix exponentiation

}
