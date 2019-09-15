/*
  Given an integer array nums, find the sum of the elements between indices i
and j (i ≤ j), inclusive.

Example:

        Given nums = [-2, 0, 3, -5, 2, -1]

        sumRange(0, 2) -> 1
        sumRange(2, 5) -> -1

        sumRange(0, 5) -> -3

Note:
  1. You may assume that the array does not change.
  2. There are many calls to sumRange function.
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

class NumArray {

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    private int[] sum = null;

    public NumArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        this.sum = new int[nums.length];
        this.sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            this.sum[i] = this.sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {

        if (this.sum == null) {
            return 0;
        }
        if (i > j || i < 0 || j >= this.sum.length) {
            throw new RuntimeException("illegal input");
        }

        return (i == 0 ? this.sum[j] : this.sum[j] - this.sum[i - 1]);
    }
}
