/*
  Given a set of distinct positive integers, find the largest subset such that
every pair (Si, Sj) of elements in this subset satisfies:

  Si % Sj = 0 or Sj % Si = 0.

  If there are multiple solutions, return any subset is fine.

Example 1:

        Input: [1,2,3]
        Output: [1,2] (of course, [1,3] will also be ok)

Example 2:

        Input: [1,2,4,8]
        Output: [1,2,4,8]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length, maxLength = 0, maxLengthIndex = 0;

        int[] dp = new int[n];
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            pre[i] = -1;

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0) {

                    // dp[i] = max(dp[i], dp[j] + 1)
                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxLengthIndex = i;
            }
        }

        while (maxLengthIndex >= 0) {

            result.add(nums[maxLengthIndex]);
            maxLengthIndex = pre[maxLengthIndex];
        }

        return result;
    }
}