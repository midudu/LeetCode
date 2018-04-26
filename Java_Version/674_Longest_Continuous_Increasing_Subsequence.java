/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

        Example 1:
        Input: [1,3,5,4,7]
        Output: 3
        Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
        Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
        Example 2:
        Input: [2,2,2,2,2]
        Output: 1
        Explanation: The longest continuous increasing subsequence is [2], its length is 1.*/


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
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int numsLength = nums.length;
        int result = 1;
        int temp = 1;

        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                temp++;
            } else {
                result = Math.max(temp, result);
                temp = 1;
            }
        }

        return Math.max(temp, result);
    }
}