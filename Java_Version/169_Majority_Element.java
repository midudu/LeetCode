/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element always exist in the array.*/

import java.util.Arrays;
import java.lang.Math;
import java.lang.System;
import java.util.HashMap;
import java.lang.Integer;

// Method 1: sort
/* class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length/2];
    }
} */

// Method 2: The Boyer-Moore algorithm
class Solution {

    public int majorityElement(int[] nums) {

        int majority = nums[0];
        int count = 0;
		
		for (int vote: nums) {
			
			if ( vote == majority ) {
				count++;
			} else if (count == 0) {
				majority = vote;
				count = 1;
			} else {
				count--;
			}
		}
		
		// Because "You may assume that the array is non-empty and the majority element always exist in the array"
		return majority;
    }
}