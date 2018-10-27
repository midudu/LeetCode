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

        return searchRangeHelper(nums, target, 0, nums.length - 1);
    }

    private int[] searchRangeHelper(int[] nums, int target,
                                    int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return new int[]{-1, -1};
        }

        if (startIndex == endIndex) {

            if (nums[startIndex] == target) {
                return new int[]{startIndex, endIndex};
            } else {
                return new int[]{-1, -1};
            }
        }

        if (startIndex + 1 == endIndex) {
            int[] result = new int[2];
            if (nums[startIndex] == target) {
                result[0] = startIndex;
                result[1] = (nums[endIndex] == target ? endIndex : startIndex);
                return result;
            } else {
                result[0] = result[1] = (nums[endIndex] == target ? endIndex : -1);
                return result;
            }
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (nums[middleIndex] == target) {
            int[] result1 = searchRangeHelper(nums, target, startIndex, middleIndex);
            int[] result2 = searchRangeHelper(nums, target, middleIndex, endIndex);
            return new int[]{result1[0], result2[1]};

        } else if (nums[middleIndex] < target) {
            return searchRangeHelper(nums, target, middleIndex + 1, endIndex);
        } else {
            return searchRangeHelper(nums, target, startIndex, middleIndex - 1);
        }
    }
}