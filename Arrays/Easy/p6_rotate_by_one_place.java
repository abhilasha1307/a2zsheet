package Arrays.Easy;

public class p6_rotate_by_one_place {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateByOne(arr);
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void rotateByOne(int[] arr){
        int temp = arr[0];
        for(int i = 0; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }

        arr[arr.length-1] = temp;
    }
}
