package dsa.arrays;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 8, 9, 12}
        };

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        // Todo:::>>> Note When iterating over 2D array, the outer loop
        //  iterates through every row, inner loop does every column in that row.

//        System.out.println(Arrays.toString(new int[]{arr[1][1]}));
    }
}
