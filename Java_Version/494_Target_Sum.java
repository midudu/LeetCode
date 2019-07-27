/*
  You are given a list of non-negative integers, a1, a2, ..., an, and a target
S. Now you have 2 symbols + and -. For each integer, you should choose one from
+ and - as its new symbol.

  Find out how many ways to assign symbols to make sum of integers equal to
target S.

Example 1:

        Input: nums is [1, 1, 1, 1, 1], S is 3.
        Output: 5

        Explanation:

        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3

        There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:
  1. The length of the given array is positive and will not exceed 20.
  2. The sum of elements in the given array will not exceed 1000.
  3. Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};

        System.out.println(new Solution().findTargetSumWays(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("illegal input");
        }

        int sum = getSum(nums);
        if (S < -sum || S > sum || ((S + sum) & 1) != 0) {
            return 0;
        }

        int newTarget = (S + sum) / 2;

        int[] result = new int[newTarget + 1];
        result[0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = newTarget; j >= nums[i - 1]; j--) {
                result[j] += result[j - nums[i - 1]];
            }
        }

        return result[newTarget];
    }

    private int getSum(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result += num;
        }

        return result;
    }
}
