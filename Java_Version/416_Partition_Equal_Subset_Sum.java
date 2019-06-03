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

// Method 1: Packing-Solution
/*class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        boolean result = new Solution().canPartition(nums);

        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) != 0) {
            return false;
        }

        sum /= 2;
        boolean[][] canFirstNElementsMakeM = new boolean[sum + 1][nums.length + 1];

        for (int col = 0; col < canFirstNElementsMakeM[0].length; col++) {
            canFirstNElementsMakeM[0][col] = true;
        }

        for (int currentSum = 1; currentSum < canFirstNElementsMakeM.length;
             currentSum++) {

            for (int col = 1; col < canFirstNElementsMakeM[0].length; col++) {

                if (nums[col - 1] > currentSum) {
                    canFirstNElementsMakeM[currentSum][col]
                            = canFirstNElementsMakeM[currentSum][col - 1];
                } else {
                    canFirstNElementsMakeM[currentSum][col]
                            = canFirstNElementsMakeM[currentSum][col - 1]
                            | canFirstNElementsMakeM[currentSum - nums[col - 1]][col - 1];
                }

                if (currentSum == sum && canFirstNElementsMakeM[currentSum][col]) {
                    return true;
                }
            }
        }

        return false;
    }
}*/

// Method 2: DFS
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        return dfs(nums, 0, target);
    }

    private boolean dfs(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            if (dfs(nums, i + 1, target - nums[i])) {
                return true;
            }
        }
        return false;
    }
}