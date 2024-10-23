package Arrays.Easy;

/**
 * PROBLEM : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

/**
 * SOLUTION : 
 * two pointers
 * if both elements at i and j are same, then increnment j till this condition holds true
 * if both are different then replace element at i+1 with element at j and increment j
 * 
 * return i+1 (new length of arr with only unique elements)
 */

public class p4_remove_duplicates_sorted_array {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};
        removeDuplicates(arr);
    }

    static void removeDuplicates(int[] arr){
        int i = 0;
        int j = i+1;
       
        while(j<arr.length){
            if(arr[i] == arr[j]){
                j++;
            }else{
                arr[++i] = arr[j++];
            }
        }

        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(i+1);
    }
}
