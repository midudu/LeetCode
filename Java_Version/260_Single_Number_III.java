/*
Share

Given an array of numbers nums,
in which exactly two elements appear only once
and all the other elements appear exactly twice.
Find the two elements that appear only once.

        Example:

        Input:  [1,2,1,3,2,5]
        Output: [3,5]
        Note:

        The order of the result is not important. So in the above example, [5, 3] is also correct.
        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/

class Solution {

    public int[] singleNumber(int[] nums) {

        int[] result = {0, 0};

        // Step 1: Get the result of a ^ b
        int xorResultOfTwoNumbers = 0;

        for (int num : nums) {

            xorResultOfTwoNumbers ^= num;
        }

        // Step 2: Since a != b, there must be at least one bit in
        // {@code xorResultOfTwoNumbers} is 1.

        // Also, m & -m can get the lowest bit which is 1.
        xorResultOfTwoNumbers &= (-xorResultOfTwoNumbers);

        // Step 3: Now {@code xorResultOfTwoNumbers} is a number with only one bit
        // 1 and other bits 0. Then the numbers in {@code nums} can be divided into
        // two groups: numbers in the first group have the exact bit 1 and another
        // have the exact bit 0. And a, b must lies in two different groups and
        // that is exactly the result we want
        for (int num : nums) {

            if ((num & xorResultOfTwoNumbers) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}