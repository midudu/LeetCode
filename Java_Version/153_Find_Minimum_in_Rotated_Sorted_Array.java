/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

        Find the minimum element.

        You may assume no duplicate exists in the array.

        Example 1:

        Input: [3,4,5,1,2]
        Output: 1

        Example 2:

        Input: [4,5,6,7,0,1,2]
        Output: 0*/

class Solution {

    public int findMin(int[] nums) {

        // Step 0: Check input parameters
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // Step 1: Find the index whose corresponding element is smaller than
        // the last element
        int pivotIndex = findPivotIndex(nums);

        // Step 2: Generate output result
        if (pivotIndex == -1) {
            return nums[0];
        } else {
            return Math.min(nums[pivotIndex], nums[0]);
        }
    }

    private int findPivotIndex(int[] nums) {

        int startIndex = 0, endIndex = nums.length - 1;
        if (nums[endIndex] > nums[startIndex]) {
            return -1;
        }

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (middleIndex != 0 && nums[middleIndex] < nums[middleIndex - 1]) {
                return middleIndex;
            } else {

                // Here must compare nums[middleIndex] and nums[endIndex] because nums[middleIndex] > nums[startIndex]
				// cannot determine which branch the middleIndex is on
                if (nums[middleIndex] > nums[endIndex]) {
                    startIndex = middleIndex + 1;
                } else {
                    endIndex = middleIndex;
                }
            }
        }

        if (startIndex != 0 && nums[startIndex] < nums[startIndex - 1]) {
            return startIndex;
        } else {
            return -1;
        }
    }
}