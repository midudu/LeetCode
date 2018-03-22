/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

        Example 1

        Input: [3,0,1]
        Output: 2
        Example 2

        Input: [9,6,4,2,3,5,7,0,1]
        Output: 8

        Note:
        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        StringBuilder a = new StringBuilder("ha");
        StringBuilder b = a;
        a.append("haha");

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
    public int missingNumber(int[] nums) {

        int numsLength = nums.length;

        int result = 0;
        for (int i = 0; i < numsLength; i++) {
            result = result ^ i;
            result = result ^ nums[i];
        }

        return result ^ numsLength;
    }
}