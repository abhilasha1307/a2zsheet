package DPStriverPlaylist;
/**
 * pq_fib_with_dp
 */
public class p1_fib_with_dp {

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        for(int i = 0; i<= n; i++){
            dp[i] = -1;
        }
        System.out.println(fibWithDp(dp, n));
        System.out.println(fibTab(n));
        System.out.println(fibTabAlterante(n));
    }

    //Memoization 
    //TC : O(n)
    //sc : O(n) + O(n) //recursion stack space + dp array
    static int fibWithDp(int[] dp, int n){
        if(n <= 1){
            return dp[n] = n; 
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = fibWithDp(dp, n-1) + fibWithDp(dp, n-2);
    }

    //TC : O(N)
    //SC : O(N)
    static int fibTab(int n){
        int[] dp = new int[n+1];

        for(int i = 0; i<= n; i++){
            dp[i] = -1;
        }

        for(int i = 0; i<=n; i++){
            if(i <= 1){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    //no need to create a dp array here
    //TC : O(n)
    //SC : O(1)
    static int fibTabAlterante(int n){
        int prev = 1;
        int prev2 = 0;

        for(int i = 2; i<=n; i++){
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}