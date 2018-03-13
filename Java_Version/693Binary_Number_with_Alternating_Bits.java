/*Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

        Example 1:
        Input: 5
        Output: True
        Explanation:
        The binary representation of 5 is: 101
        Example 2:
        Input: 7
        Output: False
        Explanation:
        The binary representation of 7 is: 111.
        Example 3:
        Input: 11
        Output: False
        Explanation:
        The binary representation of 11 is: 1011.
        Example 4:
        Input: 10
        Output: True
        Explanation:
        The binary representation of 10 is: 1010.*/

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
    public boolean hasAlternatingBits(int n) {

        int mark = Integer.highestOneBit(n);
        int lastBit = 0;
        int temp;

        while (mark != 0) {
            temp = n & mark;
            if (temp != 0) {
                if (lastBit != 0){
                    return false;
                }
                lastBit = 1;
            } else {
                if (lastBit == 0){
                    return false;
                }
                lastBit = 0;
            }
            mark = mark >> 1;
        }

        return true;
    }
}