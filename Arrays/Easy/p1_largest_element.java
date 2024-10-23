package Arrays.Easy;

public class p1_largest_element {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 7, 56, 90};
        System.out.println(largest(arr));
    }

    private static int largest(int[] arr) {
       int max = Integer.MIN_VALUE;
       
       for(int n : arr){
            max = Math.max(n, max);
       }

       return max;
    }  
}
