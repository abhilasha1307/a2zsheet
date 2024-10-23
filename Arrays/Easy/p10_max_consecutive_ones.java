package Arrays.Easy;

/**
 * PROBLEM : https://leetcode.com/problems/max-consecutive-ones/description/
 */

public class p10_max_consecutive_ones {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    private static int findMaxConsecutiveOnes(int[] nums){
        int maxLen = 0;
        int len = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                len++;
            }else{
                len = 0;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
