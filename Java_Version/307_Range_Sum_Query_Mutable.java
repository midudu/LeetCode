/*
  Given an integer array nums, find the sum of the elements between indices i
and j (i ≤ j), inclusive.

  The update(i, val) function modifies nums by updating the element at index i
to val.

Example:

        Given nums = [1, 3, 5]

        sumRange(0, 2) -> 9
        update(1, 2)
        sumRange(0, 2) -> 8

Note:
  The array is only modifiable by the update function.
  You may assume the number of calls to update and sumRange function is
distributed evenly.
*/


// Method 1: SQRT Decomposition
// Space: O(sqrt(n))
// Time: O(sqrt(n))
class NumArray {

    private int[] nums;
    private int[] sumOfBlocks;
    private int singleBlockLength;

    public NumArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        this.nums = nums;

        singleBlockLength = (int) Math.ceil(Math.sqrt(nums.length));
        int blockNumber = (int) Math.ceil((double) nums.length / singleBlockLength);
        sumOfBlocks = new int[blockNumber];

        for (int i = 0; i < nums.length; i++) {
            sumOfBlocks[i / singleBlockLength] += nums[i];
        }
    }

    public void update(int i, int val) {

        int diff = val - nums[i];

        sumOfBlocks[i / singleBlockLength] += diff;

        nums[i] = val;
    }

    public int sumRange(int i, int j) {

        int startBlockIndex = i / singleBlockLength;
        int endBlockIndex = j / singleBlockLength;

        int result = 0;

        if (startBlockIndex == endBlockIndex) {
            for (int k = i; k <= j; k++) {
                result += nums[k];
            }
        } else {
            for (int k = i; k < (startBlockIndex + 1) * singleBlockLength; k++) {
                result += nums[k];
            }

            for (int k = startBlockIndex + 1; k < endBlockIndex; k++) {
                result += sumOfBlocks[k];
            }

            for (int k = endBlockIndex * singleBlockLength; k <= j; k++) {
                result += nums[k];
            }
        }

        return result;
    }
}
