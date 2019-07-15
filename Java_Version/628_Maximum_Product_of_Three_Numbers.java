/*
  Given an integer array, find three numbers whose product is maximum and
output the maximum product.

Example 1:

        Input: [1,2,3]
        Output: 6

Example 2:

        Input: [1,2,3,4]
        Output: 24

Note:
  The length of the given array will be in range [3,104] and all elements are
in the range [-1000, 1000].

  Multiplication of any three numbers in the input won't exceed the range of
32-bit signed integer.
*/

class Solution {

	private int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE,
			thirdMax = Integer.MIN_VALUE;

	public int maximumProduct(int[] nums) {

		if (nums == null || nums.length < 3) {
			throw new RuntimeException("illegal input");
		}

		for (int i = 0; i < nums.length; i++) {
			processMin(nums[i]);
			processMax(nums[i]);
		}

		return Math.max(min * secondMin * max, max * secondMax * thirdMax);
	}

	private void processMin(int num) {

		if ( num < min) {
			secondMin = min;
			min = num;
		} else if ( num < secondMin ) {
			secondMin = num;
		}
	}

	private void processMax(int num) {

		if ( num > max) {
			thirdMax = secondMax;
			secondMax = max;
			max = num;
		} else if ( num > secondMax ) {
			thirdMax = secondMax;
			secondMax = num;
		} else if ( num > thirdMax ) {
			thirdMax = num;
		}
	}
}