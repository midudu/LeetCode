/*
  Given a non-empty array containing only positive integers, find if the array
can be partitioned into two subsets such that the sum of elements in both
subsets is equal.

Note:

  Each of the array element will not exceed 100.
  The array size will not exceed 200.

Example 1:

        Input: [1, 5, 11, 5]

        Output: true

        Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

        Input: [1, 2, 3, 5]

        Output: false

        Explanation: The array cannot be partitioned into equal sum subsets.
*/

import java.util.Arrays;


class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        System.out.println(new Solution().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = getSum(nums);
        if ((sum & 1) != 0) {
            return false;
        }

        Arrays.sort(nums);

        // return canPartitionHelperDFS(nums, 0, sum / 2);
        return canPartitionHelperPackingProblem(nums, sum / 2);
    }

    private int getSum(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result += num;
        }

        return result;
    }

    // dfs method
    private boolean canPartitionHelperDFS(int[] nums, int startIndex, int target) {

        if (target == 0) {
            return true;
        }
        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }

            if (canPartitionHelperDFS(nums, i + 1,
                    target - nums[i])) {
                return true;
            }
        }

        return false;
    }

    // 0-1 packing method
    private boolean canPartitionHelperPackingProblem(int[] nums, int target) {

        boolean[] result = new boolean[target + 1];
        result[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                result[j] |= result[j - nums[i - 1]];
            }
        }

        return result[target];
    }
}