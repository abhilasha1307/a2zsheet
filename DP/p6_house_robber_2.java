import java.util.ArrayList;

public class p6_house_robber_2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        int n = arr.length;

        System.out.println(rob(arr));
    }

    //similar to p5_max_sum_non_adj_element or house robber one, just use the following additional intuition
    /*
     * 
     * answer cannot contain both first and last element 
     * leaving the last element or first element of the array, and apply the logic to the other elements of array
     */

    private static int rob(int[] arr){
        int n = arr.length;

        if(n == 1){
            return arr[0];
        }
        ArrayList<Integer> withoutLastElement = new ArrayList<>();
        ArrayList<Integer> withoutFirstElement = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(i != 0){
                withoutFirstElement.add(arr[i]);
            }
            if(i != n-1){
                withoutLastElement.add(arr[i]);
            }
        }

        return Math.max(solveUtil(withoutFirstElement), solveUtil(withoutLastElement));
    }

    static int solveUtil(ArrayList<Integer> arr){
        int n = arr.size();

        int prev = arr.get(0);
        int prev2 = 0;

        for(int i = 1; i<n; i++){
            int pick = arr.get(i); 
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
