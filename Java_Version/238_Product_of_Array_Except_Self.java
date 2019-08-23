/*
  Given an array nums of n integers where n > 1,  return an array output such
that output[i] is equal to the product of all the elements of nums except
nums[i].

Example:

        Input:  [1,2,3,4]
        Output: [24,12,8,6]

Note: Please solve it without division and in O(n).

Follow up:
  Could you solve it with constant space complexity? (The output array does not
count as extra space for the purpose of space complexity analysis.)
*/

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] leftResult = new int[nums.length];
        leftResult[0] = 1;
        for (int i = 1; i < leftResult.length; i++) {
            leftResult[i] = leftResult[i - 1] * nums[i - 1];
        }

        int[] rightResult = new int[nums.length];
        rightResult[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightResult[i] = rightResult[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < leftResult.length; i++) {
            leftResult[i] *= rightResult[i];
        }

        return leftResult;
    }
}
