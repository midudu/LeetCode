/*
  Given an unsorted array of integers, find the length of longest increasing
subsequence.

Example:

    Input: [10,9,2,5,3,7,101,18]
    Output: 4

    Explanation:
      The longest increasing subsequence is [2,3,7,101], therefore the length
    is 4.

Note:
  There may be more than one LIS combination, it is only necessary for you to
return the length. Your algorithm should run in O(n2) complexity.

Follow up:
  Could you improve it to O(n log n) time complexity?
*/

class Solution {

    public static void main(String[] args) {

        int[] data = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(new Solution().lengthOfLIS(data));
    }

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1;
        int[] minLastNumOfSequence = new int[nums.length + 1];
        minLastNumOfSequence[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > minLastNumOfSequence[result]) {
                result++;
                minLastNumOfSequence[result] = nums[i];
            } else if (nums[i] < minLastNumOfSequence[result]) {
                if (nums[i] <= minLastNumOfSequence[1]) {
                    minLastNumOfSequence[1] = nums[i];
                } else {
                    int lastLessIndex = getLastLessIndex(minLastNumOfSequence,
                            1, result, nums[i]);
                    minLastNumOfSequence[lastLessIndex + 1] = nums[i];
                }
            }
        }

        return result;
    }

    private int getLastLessIndex(int[] nums, int startIndex, int endIndex, int target) {

        if (startIndex == endIndex) {
            return startIndex;
        }

        int middleIndex = startIndex + (endIndex - startIndex + 1) / 2;
        if (nums[middleIndex] < target) {
            return getLastLessIndex(nums, middleIndex, endIndex, target);
        } else {
            return getLastLessIndex(nums, startIndex, middleIndex - 1, target);
        }
    }
}
