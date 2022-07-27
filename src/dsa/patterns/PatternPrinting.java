package dsa.patterns;

public class PatternPrinting {
    public static void main(String[] args) {
        pattern30(4);
    }

    static void pattern1(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col.
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("End of program");
    }


    static void pattern2(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col.
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("End of program");
    }

    static void pattern3(int n){
        for (int row = n; row >= 1 ; row--) {
            for (int col = 1; col <= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern5(int n){

        for (int row = 1; row <= 2 * n; row++){
            int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 1; col <= totalColsInRow ; col++) {
                System.out.print("* ");
                }
                System.out.println();
            }
        }

    static void pattern28(int n){

        for (int row = 1; row <= 2 * n; row++){
            int totalColsInRow = row > n ? 2 * n - row : row;
            
            int numOfSpaces = n - totalColsInRow;
            for (int spaces = 0; spaces < numOfSpaces; spaces++) {
                System.out.print(" ");
            }
            
            for (int col = 1; col <= totalColsInRow ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n){
        for (int row = 1; row <= n ; row++) {
            for (int spaces = 0; spaces < n - row; spaces++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print( col + " ");
            }
            System.out.println();
        }
    }
}
