/**
 * p1_selection_sort
 */
public class p1_selection_sort {

    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        selectionSort(arr, arr.length);
    }

    //TC : O(N^2)
    //SC : O(1)

    private static void selectionSort(int[] arr, int n){
        for(int i = 0; i<n-1; i++){
            int min = i;

            for(int j = i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            //swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        for(int x : arr){
            System.out.print(x + " ");
        }

    }
}