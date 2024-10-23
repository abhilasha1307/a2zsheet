package Math;

public class p2_reverse_digits {
    public static void main(String[] args) {
        int n = 12345;
        reverseDigits(n);
    }

    // TC : O(log10(N) + 1) +1 for const operations
    // SC : O(1)
    public static void reverseDigits(int n){

        int revNum = 0;
        while(n > 0){
            int mod = n%10;
            revNum = revNum*10+mod;
            n /= 10;
        }

        System.out.println(revNum);
    }
}
