/*
  Given an array of numbers nums, in which exactly two elements appear only
once and all the other elements appear exactly twice. Find the two elements
that appear only once.

Example:

        Input:  [1,2,1,3,2,5]
        Output: [3,5]

Note:
  1. The order of the result is not important. So in the above example, [5, 3]
  is also correct.
  2. Your algorithm should run in linear runtime complexity. Could you
  implement it using only constant space complexity?
*/

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1,2,1,3,2,5};

        System.out.println(Arrays.toString(new Solution().singleNumber(nums)));
    }

    public int[] singleNumber(int[] nums) {

        if (nums == null || nums.length < 2) {
            throw new RuntimeException("illegal input");
        }

        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        if (xorResult == 0) {
            throw new RuntimeException("illegal input");
        }

        int lowestBit = getLowestOneBit(xorResult);

        int[] result = new int[2];
        for (int num : nums) {
            if ((num & lowestBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    private int getLowestOneBit(int num) {

        return num & (-num);
    }
}
