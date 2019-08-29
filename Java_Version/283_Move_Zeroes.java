/*
  Given an array nums, write a function to move all 0's to the end of it while
maintaining the relative order of the non-zero elements.

  For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
should be [1, 3, 12, 0, 0].

Note:
  1. You must do this in-place without making a copy of the array.
  2. Minimize the total number of operations.
*/

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        new Solution().moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int slow = 0, fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
