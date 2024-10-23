public class p5_max_sum_non_adj_elements {
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int n = arr.length;

        System.out.println(maxSumNonAdjElements(n-1, arr));

        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = -1;
        }
        System.out.println(maxSumNonAdjElementsMemoized(n-1, arr, dp));
        System.out.println(maxSumNonAdjElementsTab(n-1, arr));
        System.out.println(maxSumNonAdjElementsTabSpaceOp(n-1, arr));
    }


    //recursive solution 
    //pick an element or dont pick an element (as adjacent elements cannot be picked)
    static int maxSumNonAdjElements(int lastIndx, int[] arr){
        if(lastIndx == 0){
            return arr[lastIndx];
        }
        if(lastIndx < 0){
            return 0;
        }

        int pick = arr[lastIndx] + maxSumNonAdjElements(lastIndx-2, arr);
        int nonPick = maxSumNonAdjElements(lastIndx-1, arr);

        return Math.max(pick, nonPick);
    }

    //TC : O(n)
    // SC : O(n) + O(n)
    static int maxSumNonAdjElementsMemoized(int lastIndx, int[] arr, int[] dp){
        if(lastIndx == 0){
            return dp[lastIndx] = arr[lastIndx];
        }
        if(lastIndx < 0){
            return 0;
        }

        if(dp[lastIndx] != -1){
            return dp[lastIndx];
        }

        int pick = arr[lastIndx] + maxSumNonAdjElementsMemoized(lastIndx-2, arr, dp);
        int nonPick = maxSumNonAdjElementsMemoized(lastIndx-1, arr, dp);

        return dp[lastIndx] = Math.max(pick, nonPick);
    }

    //TC : O(n)
    //SC : O(n)
    static int maxSumNonAdjElementsTab(int lastIndx, int[] arr){
        int[] dp = new int[lastIndx+1];
        dp[0] = arr[0];

        for(int i = 1; i<=lastIndx; i++){
            int pick = arr[i];
            //if element at 'i' is picked then the adjacent element (at i-1) cannot be picked, so picking element at (i-2)
            if(i>1){
                pick += dp[i-2];
            }
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[lastIndx];
    }

    //TC : O(n)
    //SC : O(1)
    static int maxSumNonAdjElementsTabSpaceOp(int lastIndx, int[] arr){
        int prev = arr[0]; //0th element for i-1 when i is 1
        int prev2 = 0; //negative index

        for(int i = 1; i<=lastIndx; i++){
            int pick = arr[i];
            //if element at 'i' is picked then the adjacent element (at i-1) cannot be picked, so picking element at (i-2)
            if(i>1){
                pick += prev2;
            }
            int nonPick = prev;
            int current = Math.max(pick, nonPick);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
