/*
  Given an unsorted array of integers, find the length of longest increasing
subsequence.

Example:

    Input: [10,9,2,5,3,7,101,18]
    Output: 4

Explanation:

    The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:

    There may be more than one LIS combination, it is only necessary for you to
return the length. Your algorithm should run in O(n2) complexity.

Follow up:
    Could you improve it to O(n log n) time complexity?
*/

class Solution {

    public static void main(String[] args) {

        int[] data = {10,9,2,5,3,7,101,18};

        int result = new Solution().lengthOfLIS(data);
    }

    private int findFirstLessOrEqualIndex(
            int[] nums, int endIndex, int theInsertedNum) {

        int startIndex = 0;

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[middleIndex] == theInsertedNum) {
                return middleIndex;
            } else if (nums[middleIndex] < theInsertedNum) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex;
            }
        }

        return startIndex;
    }

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] minLastNumOfCurrentLength = new int[nums.length + 1];
        minLastNumOfCurrentLength[1] = nums[0];
        int currentIndex = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > minLastNumOfCurrentLength[currentIndex]) {
                currentIndex++;
                minLastNumOfCurrentLength[currentIndex] = nums[i];
            } else if (nums[i] == minLastNumOfCurrentLength[currentIndex]) {
                continue;
            } else {
                int index = findFirstLessOrEqualIndex(
                        minLastNumOfCurrentLength, currentIndex, nums[i]);

                minLastNumOfCurrentLength[index] = nums[i];
            }
        }

        return currentIndex;
    }
}