/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

        You are given a target value to search. If found in the array return its index, otherwise return -1.

        You may assume no duplicate exists in the array.

        Your algorithm's runtime complexity must be in the order of O(log n).

        Example 1:

        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4
        Example 2:

        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1*/


class Solution {

    public int search(int[] nums, int target) {

        // Step 1: Check input parameter
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return (nums[0] == target ? 0 : -1);
        }

        // Step 2: find lowest element's index
        int lowestIndex = findLowestElementIndex(nums);

        if (lowestIndex == 0) {
            return searchHelper(nums, 0, nums.length - 1, target);
        }

        // Step 3: find the target index
        if (target >= nums[0] && target <= nums[lowestIndex - 1]) {
            return searchHelper(nums, 0, lowestIndex - 1, target);
        } else if (target >= nums[lowestIndex] && target <= nums[nums.length - 1]) {
            return searchHelper(nums, lowestIndex, nums.length - 1, target);
        } else {
            return -1;
        }
    }

    private int findLowestElementIndex(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {

            if (startIndex == endIndex) {
                return startIndex;
            } else if (startIndex + 1 == endIndex) {
                return (nums[startIndex] < nums[endIndex] ? startIndex : endIndex);
            }

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[startIndex] < nums[middleIndex]) {
                startIndex = middleIndex;
            } else {
                endIndex = middleIndex;
            }
        }

        return -1;
    }

    private int searchHelper(int[] nums, int startIndex, int endIndex, int target) {

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
}