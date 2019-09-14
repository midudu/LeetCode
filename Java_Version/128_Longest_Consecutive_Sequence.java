/*
  Given an unsorted array of integers, find the length of the longest
consecutive elements sequence.
  Your algorithm should run in O(n) complexity.

Example:

        Input: [100, 4, 200, 1, 3, 2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
        Therefore its length is 4.
*/

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 0, 1};
        System.out.println(new Solution().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {

        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        Arrays.sort(nums);

        int startIndex = 0, currentIndex = 1;
        int result = 0;

        while (startIndex < nums.length) {

            int duplicateCount = 0;
            while (currentIndex < nums.length &&
                    nums[currentIndex] - nums[currentIndex - 1] <= 1) {
                if (nums[currentIndex] == nums[currentIndex - 1]) {
                    duplicateCount++;
                }
                currentIndex++;
            }

            result = Math.max(result, currentIndex - startIndex - duplicateCount);
            startIndex = currentIndex;
            currentIndex = startIndex + 1;
        }

        return result;
    }
}
