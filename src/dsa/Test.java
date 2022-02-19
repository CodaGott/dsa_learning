package dsa;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String [] array = {"a", "a", "b", "b", "c", "d", "d", "e"};
        findDuplicates(array);


        int[] arrays = {8, 5, 19, 10, 4, 9, 1};
        int sum = 19;

        for (int counter = 0; counter< arrays.length; counter++){
            for (int loop = 0; loop < counter; loop++){
                if (arrays[counter] + arrays[loop] == sum){
                    System.out.println(arrays[counter] + " + " + arrays[loop] + " = " + sum);
                }
            }
        }

    }

    public static String[] findDuplicates(String []arr){
        int j = 0;
        String [] unique = new String[arr.length];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1]){
                unique[j] = arr[i];
                j++;
            }
        }
        unique[j] = arr[arr.length - 1];
        System.out.println("Unique" + Arrays.toString(unique));
        return unique;
    }

}
