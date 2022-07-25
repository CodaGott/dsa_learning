package dsa.arrays;

import java.util.Arrays;

public class Assignment {
    /**
     * Given an integer array nums of length n, you want to create an array
     * ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
     * Specifically, ans is the concatenation of two nums arrays.
     *
     * Todo---> I understand that this array is expected to be joined together.
     * Todo ---> so if we have [1, 2, 3,4] given, we end up with [1, 2, 3, 4, 1, 2, 3, 4].
     *
     * */


    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
//        int[] arr = {2,3,1,1,4};
        joinArray(arr);

        int getThis = arr[arr.length - 1];

        boolean jump = canJump(arr);

        System.out.println(jump);
    }

    static void joinArray(int[] arr){

        int[] joinedArr = new int[arr.length * 2];
        int j = 0;
        System.out.println(joinedArr.length);

        for (int i = 0; i < joinedArr.length; i++) {
            joinedArr[i] = arr[j];
            j++;
            if (j == arr.length){
                j = 0;
            }
        }
        System.out.println(Arrays.toString(joinedArr));
    }

    public static boolean canJump(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {

            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }




}
