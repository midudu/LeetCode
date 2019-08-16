/*
  Given an array of size n, find the majority element. The majority element is
the element that appears more than ⌊ n/2 ⌋ times.

  You may assume that the array is non-empty and the majority element always
exist in the array.
*/

class Solution {

	public int majorityElement(int[] nums) {

		if (nums == null || nums.length == 0) {
			throw new RuntimeException("illegal input");
		}

		int majority = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] == majority) {
				count++;
				continue;
			}

			if (count == 0) {
				majority = nums[i];
				count = 1;
			} else {
				count--;
			}
		}

		return majority;
	}
}
