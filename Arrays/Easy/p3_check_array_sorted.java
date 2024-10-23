package Arrays.Easy;

/*
 * 
 * PROBLEM : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
 */

/*
 * SOLUTION : 
 * if the array is sorted, no element will be greater than its next element to the right
 * even if the sorted array (k times, clockwise) is rotated, the last element will be smaller than the first element
 * 
 * TC : O(n)
 * SC : O(1)
 */

public class p3_check_array_sorted {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,8};
        // int[] nums = {1,2,3,4,5};
        // int[] array = {1};
        System.out.println(checkSorted(arr));
    }
 
    static boolean checkSorted(int[] arr){

        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                return false;
            }
        }

        return true;
    }

    public boolean check(int[] arr) {
        int count = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                count++;
            }
        }

        if(arr[arr.length-1] > arr[0]){
            count++;
        }

        if(count > 1){
            return false;
        }

        return true;
    }
}
