/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a binary array, find the maximum number of consecutive 1s in this array.

        Example 1:
        Input: [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s.
        The maximum number of consecutive 1s is 3.
        Note:

        The input array will only contain 0 and 1.
        The length of input array is a positive integer and will not exceed 10,000*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        new Solution().countSegments("   f");

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
    public int findMaxConsecutiveOnes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int consecutiveCount = 0;

        for (int num : nums) {

            if (num == 1) {
                consecutiveCount++;
            } else {
                result = Math.max(consecutiveCount, result);
                consecutiveCount = 0;
            }
        }

        return Math.max(result, consecutiveCount);
    }
}