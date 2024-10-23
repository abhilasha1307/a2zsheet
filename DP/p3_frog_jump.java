public class p3_frog_jump {
    public static void main(String[] args) {
        // int[] arr = {10,20,30,10};
        int[] arr = {30,10,60,10,60,50};
        int n = arr.length;

        System.out.println(frogJump(n-1, arr));

        int[] dp = new int[n+1];
        for(int i = 0; i<= n; i++){
            dp[i] = -1;
        }
        System.out.println(frogJump(n-1, arr, dp));
        System.out.println(frogJumpTab(n, arr));
        System.out.println(frogJumpTabSpaceOpt(n, arr));
    }

    //recursive solution
    static int frogJump(int n, int[] arr){
        if(n == 0){
            return 0;
        }

        int left = frogJump(n-1, arr) + Math.abs(arr[n] - arr[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = frogJump(n-2, arr) + Math.abs(arr[n] - arr[n-2]);
        }

        return Math.min(left, right);
    }

    //TC : O(n)
    //SC : O(n) + O(n)
    //memoization
    static int frogJump(int n, int[] arr, int[] dp){
        if(n == 0){
            return dp[n] = 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int left = frogJump(n-1, arr, dp) + Math.abs(arr[n] - arr[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = frogJump(n-2, arr, dp) + Math.abs(arr[n] - arr[n-2]);
        }

        return dp[n] = Math.min(left, right);
    }

    //Tabulation
    static int frogJumpTab(int n, int[] arr){
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i = 1; i<n;i++){
            int firstStep = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if(i>1){
                secondStep = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }

            dp[i] = Math.min(firstStep, secondStep);
        }

        return dp[n-1];
    }

    static int frogJumpTabSpaceOpt(int n, int[] arr){
        int prev2 = 0;
        int prev = 0;

        for(int i = 1; i<n;i++){
            int firstStep = prev + Math.abs(arr[i] - arr[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if(i>1){
                secondStep = prev2 + Math.abs(arr[i] - arr[i-2]);
            }

            int current = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}
