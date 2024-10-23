public class p4_frog_jump_k {
    public static void main(String[] args) {
        int height[] = { 10, 40,50,20,60 };
        int n = height.length;
        int k = 3;
        
        System.out.println(frogJump(n-1, height, k));

        int[] dp = new int[n+1];
        for(int i = 0; i<= n; i++){
            dp[i] = -1;
        }
        System.out.println(frogJump(n-1, height, dp, k));
        System.out.println(frogJumpTab(n, height, k));
        // System.out.println(frogJumpTabSpaceOpt(n, arr));
    }

    //Recursive solution
    static int frogJump(int n, int[] arr, int k){
        if(n == 0){
            return 0;
        }

        int minEnergy = Integer.MAX_VALUE;

        for(int i = 1; i<=k; i++){
            if(n - i >= 0){
                int jump = frogJump(n-i, arr, k) + Math.abs(arr[n] - arr[n-i]);
                minEnergy = Math.min(minEnergy, jump);  
            }
        }

        return minEnergy;
    }

    //TC : O(n*k)
    //SC : O(n) + O(n)

    static int frogJump(int n, int[] arr, int[] dp, int k){
        if(n == 0){
            return dp[n] = 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int minEnergy = Integer.MAX_VALUE;

        for(int i = 1; i<=k; i++){
            if(n-i>=0){
                int jumpEnergy = frogJump(n-i, arr, dp, k) + Math.abs(arr[n] - arr[n-i]);
                minEnergy = Math.min(minEnergy, jumpEnergy);
            }
            
        }
        return dp[n] = minEnergy;
    }
   
    //TC : O(n*k)
    //SC : O(n) + O(n)
    static int frogJumpTab(int n, int[] arr, int k){
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i = 1; i<n;i++){
            int minEnergy = Integer.MAX_VALUE;  
            for(int j = 1; j<=k; j++){
                if(i-j>=0){
                    int jumpEnergy = frogJump(i-j, arr, dp, k) + Math.abs(arr[i] - arr[i-j]);
                    minEnergy = Math.min(minEnergy, jumpEnergy);
                }
                
            }
            dp[i] = minEnergy;
        }

        return dp[n-1];
    }

    // static int frogJumpTabSpaceOpt(int n, int[] arr){
    //     int prev2 = 0;
    //     int prev = 0;

    //     for(int i = 1; i<n;i++){
    //         int firstStep = prev + Math.abs(arr[i] - arr[i-1]);
    //         int secondStep = Integer.MAX_VALUE;
    //         if(i>1){
    //             secondStep = prev2 + Math.abs(arr[i] - arr[i-2]);
    //         }

    //         int current = Math.min(firstStep, secondStep);
    //         prev2 = prev;
    //         prev = current;
    //     }

    //     return prev;
    // }
}
