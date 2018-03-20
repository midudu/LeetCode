/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

        If the last word does not exist, return 0.

        Note: A word is defined as a character sequence consists of non-space characters only.

        Example:

        Input: "Hello World"
        Output: 5*/


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
    public int lengthOfLastWord(String s) {

        int sLength = s.length();

        int i = sLength - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0) {
            return 0;
        }

        int endIndex = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return (endIndex - i);

    }
}