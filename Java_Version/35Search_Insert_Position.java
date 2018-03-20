/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

        You may assume no duplicates in the array.

        Example 1:

        Input: [1,3,5,6], 5
        Output: 2
        Example 2:

        Input: [1,3,5,6], 2
        Output: 1
        Example 3:

        Input: [1,3,5,6], 7
        Output: 4
        Example 1:

        Input: [1,3,5,6], 0
        Output: 0*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        int[] input = {7, 1, 5, 3, 6, 4};

        Solution solution = new Solution();

        int result = solution.maxProfit(input);

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
    public int searchInsert(int[] nums, int target) {

        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        } else if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int startPointer = 0, endPointer = nums.length - 1;
        while (startPointer <= endPointer) {

            int mid = (startPointer + endPointer) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                startPointer = mid + 1;
            } else {
                endPointer = mid - 1;
            }
        }
        return startPointer;
    }
}