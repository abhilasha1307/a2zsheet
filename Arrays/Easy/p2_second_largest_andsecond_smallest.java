package Arrays.Easy;

/*
 * PROBLEM : https://www.geeksforgeeks.org/problems/second-largest3735/1
 */

 /**
  * SOLUTION : 
  2 loops one to find secondlargest and another to find secondsmallest
  largest and secondLargest
  when arr[i] > largest, largest = arr[i] and secondlargest = largest
  also if arr[i] > secondlargest and arr[i] != largest then replace secondlargest with arr[i]

  same intuition for secondsmallest

  TC : 2*O(N) ~ O(N)
  SC : O(1)

  */

public class p2_second_largest_andsecond_smallest {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        secondLargestAndSmallest(arr);
    }

    static void secondLargestAndSmallest(int[] arr){
        if (arr.length < 2){
    		System.out.println("Second Largest: " + -1);
            System.out.println("Second Smallest "+ -1);
            return;
    	}
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        //O(n)

        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }

        //O(n)

        for(int i=0; i<arr.length; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }else if(arr[i] < secondSmallest && arr[i] != smallest){
                secondSmallest= arr[i];
            }
        }

        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Second Smallest "+ secondSmallest);
    }

    //2O(n) ~ O(n)
    //space = O(1)
}
