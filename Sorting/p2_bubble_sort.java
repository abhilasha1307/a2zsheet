public class p2_bubble_sort {
    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        bubbleSort(arr, arr.length);

        System.out.println();
        
        int arr2[] = {13, 46, 24, 52, 20, 9};
        bubbleSortOptimized(arr2, arr2.length);
    }

    // TC : O(N^2)
    // SC : O(1) 
    private static void bubbleSort(int[] arr, int n){
        for(int i=n-1; i>=0; i--){
            for(int j = 0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    // TC : O(N^2) - worst case and O(N) - best case
    // SC : O(1) 
    private static void bubbleSortOptimized(int[] arr, int n){
        for(int i=n-1; i>=0; i--){
            int didSwap = 0;
            for(int j = 0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = 1;
                }
            }

            //in best case (when the array is sorted, there would be no swaps in the first full iteration of the array and didSwap will be 0)
            if(didSwap == 0){
                break;
            }
        } 

        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
