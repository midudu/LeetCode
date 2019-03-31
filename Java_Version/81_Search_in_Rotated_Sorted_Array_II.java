/*
  Suppose an array sorted in ascending order is rotated at some pivot unknown
to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

  You are given a target value to search. If found in the array return true,
otherwise return false.

Example 1:

        Input: nums = [2,5,6,0,0,1,2], target = 0
        Output: true

Example 2:

        Input: nums = [2,5,6,0,0,1,2], target = 3
        Output: false

Follow up:

  This is a follow up problem to Search in Rotated Sorted Array, where nums may
contain duplicates. Would this affect the run-time complexity? How and why?

  For the worst case, this problem can only be solved in O(n) not in O(logn)
*/


class Solution {

    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        return searchHelper(nums, 0, nums.length - 1, target);
    }

    private boolean searchHelper(
            int[] nums, int startIndex, int endIndex, int target) {

        if (startIndex == endIndex) {
            return nums[startIndex] == target;
        }

        if (nums[startIndex] < nums[endIndex]
                && (nums[startIndex] > target || nums[endIndex] < target)) {
            return false;
        } else {
            return searchHelper(nums, startIndex,
                    startIndex + (endIndex - startIndex) / 2, target)
                    || searchHelper(nums,
                    startIndex + (endIndex - startIndex) / 2 + 1,
                    endIndex, target);
        }
    }
}
