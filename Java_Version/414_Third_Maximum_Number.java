/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

        Example 1:
        Input: [3, 2, 1]

        Output: 1

        Explanation: The third maximum is 1.
        Example 2:
        Input: [1, 2]

        Output: 2

        Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
        Example 3:
        Input: [2, 2, 3, 1]

        Output: 1

        Explanation: Note that the third maximum here means the third maximum distinct number.
        Both numbers with value 2 are both considered as second maximum.*/


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

        new Solution().sumOfLeftLeaves(treeNode);

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

    private Integer firstMax = null;
    private Integer secondMax = null;
    private Integer thirdMax = null;


    public int thirdMax(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        for (Integer num : nums) {
            thirdMaxHelper(num);
        }

        return (thirdMax == null) ? firstMax : thirdMax;

    }

    private void thirdMaxHelper(Integer num) {
        if (num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax)) {
            return;
        }


        if (firstMax == null || num > firstMax) {
            thirdMax = secondMax;
            secondMax = firstMax;
            firstMax = num;
        } else if (secondMax == null || num > secondMax) {
            thirdMax = secondMax;
            secondMax = num;
        } else if (thirdMax == null || num > thirdMax) {
            thirdMax = num;
        }

    }
}