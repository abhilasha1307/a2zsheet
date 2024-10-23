package Arrays.Easy;

/*
 * PROBLEM : https://leetcode.com/problems/missing-number/description/
 */

public class p9_find_missing_number {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int[] hashset = new int[nums.length+1];

        for(int i = 0; i<nums.length; i++){
            hashset[nums[i]]++;
        }

        int missingNumber = -1;

        for(int i = 0; i<hashset.length; i++){
            if(hashset[i] == 0){
                missingNumber = i;
                break;
            }
        }

        return missingNumber;
    }
    
}