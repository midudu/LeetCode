/*
  You are a professional robber planning to rob houses along a street. Each
house has a certain amount of money stashed, the only constraint stopping you
from robbing each of them is that adjacent houses have security system
connected and it will automatically contact the police if two adjacent houses
were broken into on the same night.

  Given a list of non-negative integers representing the amount of money of
each house, determine the maximum amount of money you can rob tonight without
alerting the police.
*/

class Solution {

    // f(x) = max(f(x-1), f(x-2) + nums[x])
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int lastTwoResult = nums[0];
        int lastResult = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            int currentResult = Math.max(lastResult, lastTwoResult + nums[i]);
            lastTwoResult = lastResult;
            lastResult = currentResult;
        }

        return lastResult;
    }
}
