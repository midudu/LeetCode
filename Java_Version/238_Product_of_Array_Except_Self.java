/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

        Example:

        Input:  [1,2,3,4]
        Output: [24,12,8,6]

        Note: Please solve it without division and in O(n).

        Follow up:
        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        result[0] = 1;

        for (int i = 1; i < result.length; i++) {

            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = result.length - 1; i >= 0; i--) {

            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}