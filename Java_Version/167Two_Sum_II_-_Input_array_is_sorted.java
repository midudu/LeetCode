/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

        You may assume that each input would have exactly one solution and you may not use the same element twice.

        Input: numbers={2, 7, 11, 15}, target=9
        Output: index1=1, index2=2*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = new Solution().isSymmetric(root);

        System.out.println(result);
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
    public int[] twoSum(int[] numbers, int target) {

        int startPointer = 0, endPointer = numbers.length - 1;

        while (startPointer < endPointer) {
            int sum = numbers[startPointer] + numbers[endPointer];

            if (target == sum) {
                return new int[]{startPointer + 1, endPointer + 1};
            } else if (target < sum) {
                endPointer--;
            } else {
                startPointer++;
            }
        }

        return null;
    }
}