package Math;

public class p3_check_palindrome {
    public static void main(String[] args) {
        int n = 4554;
        System.out.println(palindrome(n));
    }

    static boolean palindrome(int n) {
        int revNum = 0;
        int dup = n;
        while (n > 0) {
            int ld = n % 10;
            revNum = (revNum * 10) + ld;
            n = n / 10;
        }
        if (dup == revNum) {
            return true;
        } else {
            return false;
        }
    }
}
