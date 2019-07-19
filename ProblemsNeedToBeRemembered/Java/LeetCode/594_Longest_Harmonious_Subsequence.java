/*
  We define a harmonious array is an array where the difference between its
maximum value and its minimum value is exactly 1.

  Now, given an integer array, you need to find the length of its longest
harmonious subsequence among all its possible subsequences.

Example 1:

        Input: [1,3,2,2,5,2,3,7]
        Output: 5
        Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Note:
  The length of the input array will not exceed 20,000.
*/

import java.util.Arrays;

class Solution {

    public int findLHS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int[] resultIncludingCurrentNum = new int[nums.length];
        int[] sameNumberCount = new int[nums.length];
        resultIncludingCurrentNum[0] = sameNumberCount[0] = 1;

        int result = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i-1]) {
                sameNumberCount[i] = sameNumberCount[i - 1] + 1;
                resultIncludingCurrentNum[i] = resultIncludingCurrentNum[i - 1] + 1;
            } else if (nums[i] == nums[i-1] + 1) {
                sameNumberCount[i] = 1;
                resultIncludingCurrentNum[i] = sameNumberCount[i - 1] + 1;
            } else {
                sameNumberCount[i] = 1;
                resultIncludingCurrentNum[i] = 1;
            }

            if(resultIncludingCurrentNum[i] > sameNumberCount[i]){
                result = Math.max(result, resultIncludingCurrentNum[i]);
            }
        }

        return result;
    }
}