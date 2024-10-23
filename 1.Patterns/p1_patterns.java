/**
  PROBLEM LINK : https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/
 */

public class p1_patterns {

    public static void main(String[] args) {
        // patternOne();
        // patternTwo();
        // patternThree();
        // patternFour();
        // patternFive();
        // patternSix();
        // patternSeven();
        patternEight();
    }

    private static void patternOne(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void patternTwo(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void patternThree(){
        for(int i = 1; i<=5; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void patternFour(){
        for(int i = 1; i<=5; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void patternFive(){
        for(int i = 1; i<=5; i++){
            for(int j = 1; j<=5+1-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void patternSix(){
        for(int i = 1; i<=5; i++){
            for(int j = 1; j<=5+1-i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void patternSeven(){
        int n = 6;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=2*n-1; j++){
                if(j>=n+1-i && j<= n-1+i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void patternEight(){
        int n = 5;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=2*n-1; j++){
                if(j>=i && j<= 2*n - i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}