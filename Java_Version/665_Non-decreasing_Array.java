/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

        We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

        Example 1:
        Input: [4,2,3]
        Output: True
        Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
        Example 2:
        Input: [4,2,1]
        Output: False
        Explanation: You can't get a non-decreasing array by modify at most one element.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[][] inpur = {{1}};
        new Solution().imageSmoother(inpur);

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
    public boolean checkPossibility(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return true;
        }

        int numsLength = nums.length;
        int count = 0;
        for (int i = 0; i < numsLength - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                if (i != 0 && nums[i - 1] > nums[i + 1]
                        && i != numsLength - 2 && nums[i] > nums[i + 2]) {
                    return false;
                }

                count++;
                if (count == 2) {
                    return false;
                }
            }
        }

        return true;
    }
}