public class p7_ninjas_training {
    public static void main(String[] args) {
        int[][] arr = {{1,2,5}, {3,1,1}, {3,3,3}};
        int n = 3;

        System.out.println(maximumPoints(arr, n));
    }

    private static int maximumPoints(int arr[][], int N) {

        int[][] dp = new int[N][4];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<4; j++){
                dp[i][j] = -1;
            }
        } 

        // return solveUtil(N-1, 3, arr);

        // return solveUtilMemoized(N-1, 3, arr, dp);
        // return solveUtilTabulation(N, arr);

        return solveUtilTabulationSpaceOpt(N, arr);
    }  

    
    private static int solveUtil(int day, int last, int[][] arr){
        if(day == 0){
            int maximumPoints = 0;
            for(int i = 0; i<3; i++){
                if(i != last){
                    maximumPoints = Math.max(maximumPoints, arr[0][i]);
                }
            }
            return maximumPoints;
        }

        int maximumPoints = 0;

        for(int i = 0; i<3; i++){
            if(i != last){
                int points = arr[day][i] + solveUtil(day-1, i, arr);
                maximumPoints = Math.max(maximumPoints, points);
            }
        }
        return maximumPoints;
    }

    //TC : O(N*4) * 3
    //TC : O(N*4) + O(N) 
    private static int solveUtilMemoized(int day, int last, int[][] arr, int[][] dp){
        if(day == 0){
            int maximumPoints = 0;
            for(int i = 0; i<3; i++){
                if(i != last){
                    maximumPoints = Math.max(maximumPoints, arr[0][i]);
                }
            }
            return maximumPoints;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int maximumPoints = 0;

        for(int i = 0; i<3; i++){
            if(i != last){
                int points = arr[day][i] + solveUtilMemoized(day-1, i, arr, dp);
                maximumPoints = Math.max(maximumPoints, points);
            }
        }
        return dp[day][last] = maximumPoints;
    }


    //TC : O(n*4*3)
    //SC : O(n*4)

    private static int solveUtilTabulation(int N, int[][] arr){
        int[][] dp = new int[N][4];

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));


        for(int day = 1; day<N; day++){
            for(int last = 0; last<4; last++){
                dp[day][last] = 0;
                for(int task = 0; task<3; task++){
                    if(task != last){
                        int points = arr[day][task] + dp[day-1][task]; 
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }

        return dp[N-1][3];
    }

    //TC : O(n*4*3)
    //SC : O(4)
    private static int solveUtilTabulationSpaceOpt(int N, int[][] arr){
        int[]prev = new int[4];

        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));


        for(int day = 1; day<N; day++){
            int[] temp = new int[4];
            for(int last = 0; last<4; last++){
                temp[last] = 0;
                for(int task = 0; task<3; task++){
                    if(task != last){
                        temp[last] = Math.max(temp[last], arr[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }
}
