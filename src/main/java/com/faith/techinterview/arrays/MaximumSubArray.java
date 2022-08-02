package com.faith.techinterview.arrays;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {

        // -2,1,-3,4,-1,2,1,-5,4
        /*
        -2 1 = 1
        -2 1 -3 = -4
        -2,1,-3,4 = 0
        -2,1,-3,4,-1 = 1
        -2,1,-3,4,-1,2 = 3
        -2,1,-3,4,-1,2,1 = 4
        -2,1,-3,4,-1,2,1,-5 = -1
        -2,1,-3,4,-1,2,1,-5,4 = 3

        1 -3 = -2
        1,-3,4 = 2
        1,-3,4,-1
        1,-3,4,-1,2
        1,-3,4,-1,2,1
        1,-3,4,-1,2,1,-5
        1,-3,4,-1,2,1,-5,4
         */

        if (nums.length < 2) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int total = nums[i];
            for (int y = i + 1; y < nums.length; y++) {
                total += nums[y];
                max = Math.max(max, total);
            }
        }
        return max;
    }
}
