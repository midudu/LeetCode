/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

        Example 1:

        Input: [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.
        Example 2:

        Input: [-2,0,-1]
        Output: 0
        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

class Solution {

    public int maxProduct(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        /* {@code min} and {@code max} represent the minimum value and the maximum
        value when the current element in array is included */

        int min = arr[0];
        int max = arr[0];

        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            result = Math.max(Math.max(result, arr[i]),
                    Math.max(min * arr[i], max * arr[i]));

            int beforeMin = min;

            min = Math.min(arr[i], Math.min(arr[i] * min, arr[i] * max));

            max = Math.max(arr[i], Math.max(arr[i] * max, arr[i] * beforeMin));
        }

        return result;
    }
}