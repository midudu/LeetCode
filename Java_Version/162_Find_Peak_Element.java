/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1],
find a peak element and return its index.

The array may contain multiple peaks,
in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

        Example 1:

        Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.

        Example 2:

        Input: nums = [1,2,1,3,5,6,4]
        Output: 1 or 5
        Explanation: Your function can return either index number 1 where the peak element is 2,
        or index number 5 where the peak element is 6.

        Note:

        Your solution should be in logarithmic complexity.*/


class Solution {


    /* Notice that when going in the direction of the greater element
    there are two possibilities:
    1. The array continues to increase in that direction until the end.
       Meaning the first(or last) element in array will be a peak.
    2. It drops back down in value at some point.
       Meaning that at that inflection point there is a peak.

    Because there must be at least a peak, so we can just find one sure solution:
    1. If the middle point is on the increasing slope, there must be one answer
    lies in [middle+1, end];
    2. If the middle point is on the decreasing slope, there must be one answer
    lies in [start, middle];
    */
    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int startIndex = 0, endIndex = nums.length - 1;

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex + 1] > nums[middleIndex]) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex;
            }
        }

        return startIndex;
    }
}