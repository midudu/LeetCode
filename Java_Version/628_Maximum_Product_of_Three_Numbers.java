/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

        Example 1:
        Input: [1,2,3]
        Output: 6
        Example 2:
        Input: [1,2,3,4]
        Output: 24
        Note:
        The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
        Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        new Solution().findUnsortedSubarray(ints);

        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
	
	int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
	int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
	
    public int maximumProduct(int[] nums) {

        int numsLength = nums.length;
		
		for (int i = 0; i < numsLength; i++) {
			processMin(nums[i]);
			processMax(nums[i]);
		}
		
		return Math.max(firstMin * secondMin * firstMax, firstMax * secondMax * thirdMax);
    }
	
	private void processMin(int num) {
		if ( num < firstMin ) {
			secondMin = firstMin;
			firstMin = num;
		} else if ( num < secondMin ) {
			secondMin = num;
		}
	}
	
	private void processMax(int num) {
		if ( num > firstMax ) {
			thirdMax = secondMax;
			secondMax = firstMax;
			firstMax = num;
		} else if ( num > secondMax ) {
			thirdMax = secondMax;
			secondMax = num;
		} else if ( num > thirdMax ) {
			thirdMax = num;
		}
	}
}