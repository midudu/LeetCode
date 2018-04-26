/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

        Example 1:
        Input: [1,12,-5,-6,50,3], k = 4
        Output: 12.75
        Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
        Note:
        1 <= k <= n <= 30,000.
        Elements of the given array will be in the range [-10,000, 10,000].*/


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
    public double findMaxAverage(int[] nums, int k) {

        double tempResult = 0.0;
        for (int i = 0; i < k; i++) {
            tempResult += nums[i];
        }

        double maxResult = tempResult;

        int startPointer = 0, endPointer = k;
        int numsLength = nums.length;

        while (endPointer < numsLength) {
            tempResult = tempResult + nums[endPointer] - nums[startPointer];
            if (tempResult > maxResult) {
                maxResult = tempResult;
            }
            startPointer++;
            endPointer++;
        }

        return maxResult / k;
    }
}