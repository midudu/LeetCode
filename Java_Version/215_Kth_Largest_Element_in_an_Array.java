/*
Find the kth largest element in an unsorted array.

Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

        Note:
        You may assume k is always valid, 1 ≤ k ≤ array's length.*/

class Solution {

    public int findKthLargest(int[] nums, int k) {

        return findKthLargestHelper(nums, 0, nums.length - 1, k);
    }

    public int findKthLargestHelper(
            int[] nums, int startIndex, int endIndex, int k) {

        int standardElement = nums[startIndex];

        int lowIndex = startIndex, highIndex = endIndex;

        while (lowIndex < highIndex) {

            while (lowIndex < highIndex
                    && nums[highIndex] < standardElement) {
                highIndex--;
            }

            if (lowIndex < highIndex) {
                nums[lowIndex] = nums[highIndex];
                lowIndex++;
            }

            while (lowIndex < highIndex
                    && nums[lowIndex] > standardElement) {
                lowIndex++;
            }

            if (lowIndex < highIndex) {
                nums[highIndex] = nums[lowIndex];
            }
        }

        if (lowIndex == k - 1) {
            return standardElement;
        } else if (lowIndex < k - 1) {
            return findKthLargestHelper(nums, lowIndex + 1, endIndex, k);
        } else {
            return findKthLargestHelper(nums, startIndex, lowIndex - 1, k);
        }
    }
}