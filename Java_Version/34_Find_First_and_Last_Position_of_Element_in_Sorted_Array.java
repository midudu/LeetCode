/*
Given an array of integers nums sorted in ascending order,
find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]*/

class Solution {

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int targetIndex = findTargetIndex(nums, target);
        if (targetIndex == -1) {
            return new int[]{-1, -1};
        }

        int firstNonTargetIndex = findFirstNonTargetIndex(
                nums, targetIndex, target);
        int lastNonTargetIndex = findLastNonTargetIndex(
                nums, targetIndex, target);

        return new int[]{
                firstNonTargetIndex + 1, lastNonTargetIndex - 1};
    }

    private int findTargetIndex(int[] nums, int target) {

        int startIndex = 0, endIndex = nums.length - 1;

        while (startIndex <= endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    private int findFirstNonTargetIndex(
            int[] nums, int maximumIndex, int target) {

        int startIndex = 0, endIndex = maximumIndex - 1;

        while (startIndex < endIndex - 1) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex] == target) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex;
            }
        }

        if (endIndex >= 0 && nums[endIndex] != target) {
            return endIndex;
        } else if (nums[startIndex] != target) {
            return startIndex;
        }

        return -1;
    }

    private int findLastNonTargetIndex(
            int[] nums, int minimumIndex, int target) {

        int startIndex = minimumIndex + 1, endIndex = nums.length - 1;

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex] == target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex;
            }
        }

        if (startIndex < nums.length && nums[startIndex] != target) {
            return startIndex;
        } else {
            return nums.length;
        }
    }
}