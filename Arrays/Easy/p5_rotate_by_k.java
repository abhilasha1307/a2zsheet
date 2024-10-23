package Arrays.Easy;

/**
 * PROBLEM : https://leetcode.com/problems/rotate-array/description/
 */

/*
 * SOLUTION/INTUITION : Think in terms of reversing the array
 * 
 * TC : O(n)
 * SC : O(1)
 */

public class p5_rotate_by_k {
    public static void main(String[] args) {
        int[] arr = {3,7,8,9,10,11};
        int k = 3;
        rotateByK(arr, k);

        for(int x : arr){
            System.out.print( x + " ");
        }
    }

    static void rotateByK(int[] arr, int k){
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length - 1);
    }

    static void reverseArray(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
