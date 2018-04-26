/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

        You need to find the shortest such subarray and output its length.

        Example 1:
        Input: [2, 6, 4, 8, 10, 9, 15]
        Output: 5
        Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
        Note:
        Then length of the input array is in range [1, 10,000].
        The input array may contain duplicates, so ascending order here means <=.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {



        int[] ints = {2,6,4,8,10,9,15};
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
    public int findUnsortedSubarray(int[] nums) {

        int numsLength = nums.length;
        int startPointer = 0;
        while (startPointer < numsLength - 1
                && nums[startPointer] <= nums[startPointer + 1]) {
            startPointer++;
        }
        if (startPointer == numsLength - 1) {
            return 0;
        }

        int endPointer = numsLength - 1;
        while (endPointer > startPointer
                && nums[endPointer] >= nums[endPointer - 1]) {
            endPointer--;
        }

        int maxValue = nums[startPointer], minValue = nums[endPointer];
        for (int index = startPointer; index <= endPointer; index++) {
            if (nums[index] > maxValue) {
                maxValue = nums[index];
            }
            if (nums[index] < minValue) {
                minValue = nums[index];
            }
        }

        while (startPointer >= 0 && nums[startPointer] > minValue) {
            startPointer--;
        }
        while (endPointer < numsLength && nums[endPointer] < maxValue) {
            endPointer++;
        }

        return endPointer - startPointer - 1;
    }
}