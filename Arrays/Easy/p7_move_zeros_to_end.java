package Arrays.Easy;

/*
 * PROBLEM : https://leetcode.com/problems/move-zeroes/description/
 */

/**
 * SOLUTION : 2 pointers, move the j pointer (which is initially = i+1) only when arr[j] is non zero, swap when arr[i] = 0 and arr[j] != 0
 * increment both when both are non zero
 * 
 * TC : O(N)
 * SC : O(1)
 */

public class p7_move_zeros_to_end {
    public static void main(String[] args) {
        int[] arr = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        moveZerosToEnd(arr);

        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    static void moveZerosToEnd(int[] arr){
        int i = 0;
        int j = i + 1;

        //O(n)
        //O(1)

        while(j < arr.length){
            if(arr[i] == 0 && arr[j] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }else if(arr[i] == 0 && arr[j] == 0){
                j++;
                continue;
            }
            i++;
            j++;
        }
    }
}
