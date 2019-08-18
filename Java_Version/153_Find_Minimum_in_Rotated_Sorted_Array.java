/*
  Suppose an array sorted in ascending order is rotated at some pivot unknown
to you beforehand.

  (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

  Find the minimum element.

  You may assume no duplicate exists in the array.

Example 1:

        Input: [3,4,5,1,2]
        Output: 1

Example 2:

        Input: [4,5,6,7,0,1,2]
        Output: 0
*/

class Solution {

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(new Solution().findMin(nums));
    }

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("illegal input");
        }

        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        return findMinHelper(nums, 0, nums.length - 1);
    }

    private int findMinHelper(int[] nums, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return nums[startIndex];
        }

        if (startIndex == endIndex - 1) {
            return Math.min(nums[startIndex], nums[endIndex]);
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (nums[middleIndex] < nums[middleIndex - 1]) {
            return nums[middleIndex];
        }

        if (nums[middleIndex] < nums[endIndex]) {
            return findMinHelper(nums, startIndex, middleIndex);
        } else {
            return findMinHelper(nums, middleIndex + 1, endIndex);
        }
    }
}
