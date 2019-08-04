/*
  Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

  For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
[4,-1,2,1] has the largest sum = 6.
*/

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().maxSubArray(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int lastMaxSum = 0;

        for (int num : nums) {

            lastMaxSum += num;
            maxSum = Math.max(maxSum, lastMaxSum);

            if (lastMaxSum < 0) {
                lastMaxSum = 0;
            }
        }

        return maxSum;
    }
}
