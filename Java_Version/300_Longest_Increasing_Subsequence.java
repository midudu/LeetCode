/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

    Input: [10,9,2,5,3,7,101,18]
    Output: 4

Explanation:

    The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up:
    Could you improve it to O(n log n) time complexity?
*/

class Solution {

    public static void main(String[] args) {

        int[] data = {1, 3, 6, 7, 9, 4, 10, 5, 6};

        int result = new Solution().lengthOfLIS(data);
    }

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        result[0] = 1;

        int max = 1;

        for (int i = 1; i < nums.length; i++) {

            int currentResult = 1;

            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] > nums[j]) {
                    currentResult = Math.max(
                            currentResult, result[j] + 1);
                }
            }

            result[i] = currentResult;

            max = Math.max(max, currentResult);
        }

        return max;
    }
}