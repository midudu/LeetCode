/*
  Given an unsorted array nums, reorder it such that
nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:
  You may assume all input has valid answer.

Follow Up:
  Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);

        int[] numsCopy = new int[nums.length];
        int pointer1 = (nums.length - 1) / 2, pointer2 = nums.length - 1;

        for (int i = 0; i < numsCopy.length; i += 2) {
            numsCopy[i] = nums[pointer1];
            pointer1--;
        }
        for (int i = 1; i < numsCopy.length; i += 2) {
            numsCopy[i] = nums[pointer2];
            pointer2--;
        }

        System.arraycopy(numsCopy, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {

        int[][] nums = {{1, 5, 1, 1, 6, 4},
                {1, 3, 2, 2, 3, 1},
                {4, 5, 5, 6}};

        Solution solution = new Solution();

        for (int[] num : nums) {
            solution.wiggleSort(num);
        }

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }
}
