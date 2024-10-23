package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * PROBLEM : https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
 */

public class p8_union_sorted_arrays {

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arr2[] = {2,3,4,4,5,11,12};

        System.out.println(union(arr1, arr2, arr1.length, arr2.length));
        System.out.println(unionAlternate(arr1, arr2, arr1.length, arr2.length));
    }

    /*
     * SOLUTION : 
     * traverse through the array with pointers and put the elements from both arrays into a new array in sorted manner
     * if one or both of the arrays still has elements left in the end, append all the remaining elements in new array
     * 
     * TC : ~ O(N) 
     * SC : O(1) - final result array is not aux space
     */

    static List<Integer> union(int[] arr1, int[] arr2, int n, int m){
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(!list.contains(arr1[i]))
                    list.add(arr1[i]);
                i++;
            }
            else{
                if(!list.contains(arr2[j]))
                    list.add(arr2[j]);
                j++;
            }
        }

        while(i < n){
            if(!list.contains(arr1[i]))
                    list.add(arr1[i]);
                i++;
        }

        while(j < m){
            if(!list.contains(arr2[j]))
                    list.add(arr2[j]);
                j++;
        }

        return list;
    }

    /*
     * SOLUTION : 
     * make a treeset (set contains unique elements only and treeset has them in sorted manner) and traverse through both the arrays and put elements in the set
     * traverse the set and put the elements in result array
     * 
     * TC : ~ O(N)
     * SC : O(n+m) - if elements in both array are unique in the array and among the 2 arrays
     */

    static List<Integer> unionAlternate(int[] arr1, int[] arr2, int n, int m){
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>(); //tree set is sorted set
        
        for(int i = 0; i<n; i++){
            set.add(arr1[i]);
        }

        for(int i = 0; i<m; i++){
            set.add(arr2[i]);
        }

       for(int x : set){
            list.add(x);
       }
        return list;
    }
}