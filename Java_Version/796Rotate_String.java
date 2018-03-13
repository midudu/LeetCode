/*We are given two strings, A and B.

        A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

        Example 1:
        Input: A = 'abcde', B = 'cdeab'
        Output: true

        Example 2:
        Input: A = 'abcde', B = 'abced'
        Output: false
        Note:

        A and B will have length at most 100.*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};

        Solution solution = new Solution();
        int receive = solution.findComplement(5);


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
    public boolean rotateString(String A, String B) {

        return ( A.length() == B.length() && (A+A).contains(B) );
    }
}