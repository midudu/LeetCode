/*
  A sequence of numbers is called a wiggle sequence if the differences between
successive numbers strictly alternate between positive and negative. The first
difference (if one exists) may be either positive or negative. A sequence with
fewer than two elements is trivially a wiggle sequence.

  For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
(6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
and [1,7,4,5,5] are not wiggle sequences, the first because its first two
differences are positive and the second because its last difference is zero.

  Given a sequence of integers, return the length of the longest subsequence
that is a wiggle sequence. A subsequence is obtained by deleting some number of
elements (eventually, also zero) from the original sequence, leaving the
remaining elements in their original order.

Example 1:

        Input: [1,7,4,9,2,5]
        Output: 6
        Explanation: The entire sequence is a wiggle sequence.

Example 2:

        Input: [1,17,5,10,13,15,10,5,16,8]
        Output: 7
        Explanation: There are several subsequences that achieve this length.
        One is [1,17,10,13,10,16,8].

Example 3:

        Input: [1,2,3,4,5,6,7,8,9]
        Output: 2

Follow up:
        Can you do it in O(n) time?
*/

class Solution {

    public static void main(String[] args) {

        int[] nums = {0, 0};

        int result = new Solution().wiggleMaxLength(nums);
    }

    public int wiggleMaxLength(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        int[] firstIncreasingResult = new int[nums.length];
        firstIncreasingResult[0] = nums[0];
        int pointer1 = 0;
        boolean ifIncrease1 = true;

        int[] firstDecreasingResult = new int[nums.length];
        firstDecreasingResult[0] = nums[0];
        int pointer2 = 0;
        boolean ifIncrease2 = false;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != firstIncreasingResult[pointer1]) {
                boolean ifSmaller = (nums[i] < firstIncreasingResult[pointer1]);
                boolean currentResult = (ifSmaller ^ ifIncrease1);

                if (currentResult) {
                    pointer1++;
                    firstIncreasingResult[pointer1] = nums[i];
                    ifIncrease1 = (!ifIncrease1);
                } else {
                    firstIncreasingResult[pointer1] = nums[i];
                }
            }

            if (nums[i] != firstDecreasingResult[pointer2]) {
                boolean ifSmaller = (nums[i] < firstDecreasingResult[pointer2]);
                boolean currentResult = (ifSmaller ^ ifIncrease2);

                if (currentResult) {
                    pointer2++;
                    firstDecreasingResult[pointer2] = nums[i];
                    ifIncrease2 = (!ifIncrease2);
                } else {
                    firstDecreasingResult[pointer2] = nums[i];
                }
            }
        }

        return 1 + Math.max(pointer1, pointer2);
    }
}
