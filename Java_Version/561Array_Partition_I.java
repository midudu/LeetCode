/*Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

        Example 1:
        Input: [1,4,3,2]

        Output: 4
        Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
        Note:
        n is a positive integer, which is in the range of [1, 10000].
        All the integers in the array will be in the range of [-10000, 10000].*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        String[] input = {"5", "2", "C", "D", "+"};

        Solution solution = new Solution();
        int receive = solution.calPoints(input);


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
    public int arrayPairSum(int[] nums) {

        int[] hashTable = new int[20001];

        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            hashTable[nums[i] + 10000]++;
        }

        int result = 0, count = 0;
        int parityFlag = 1;
        for (int i = 0; i < 20001; ) {

            if (hashTable[i] > 0) {

                hashTable[i] --;
                if (parityFlag == 1) {
                    result += (i - 10000);
                }
                parityFlag = 1- parityFlag;
            } else {
                i++;
            }
        }

        return result;
    }
}