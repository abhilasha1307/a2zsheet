package Math;

/**
 * p1_count_digits
 */
public class p1_count_digits {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(count(n));
        System.out.println(countDigits(n));
    }

    // TC : O(log10(N) + 1) +1 for increment in count
    // SC : O(1)
    public static int count(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }

    //The logarithmic base 10 of a positive integers gives the number of digits in n. 
    //We add 1 to the result to ensure that the count is correct even for numbers that are powers of 10.
    //We cast the result to an integer to ensure that any fractional part is discarded giving the exact count of digits.
    public static int countDigits(int n){
        return (int) (Math.log10(n) + 1);
    }

    //TC : O(1)
    //SC : O(1)
}