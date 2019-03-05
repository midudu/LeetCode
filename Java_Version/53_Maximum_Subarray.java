/*Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

*/

class Solution {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int tempSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int currentSum = tempSum + nums[i];

            if (currentSum < 0) {
                tempSum = 0;
            } else {
                tempSum = currentSum;
            }

            if (currentSum > result) {
                result = currentSum;
            }
        }

        return result;
    }
}
