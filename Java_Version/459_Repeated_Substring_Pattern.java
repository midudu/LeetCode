/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
        Example 1:
        Input: "abab"

        Output: True

        Explanation: It's the substring "ab" twice.
        Example 2:
        Input: "aba"

        Output: False
        Example 3:
        Input: "abcabcabcabc"

        Output: True

        Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        String input = "ab";

        boolean answer = new Solution().repeatedSubstringPattern(input);

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
    public boolean repeatedSubstringPattern(String s) {

        int sLength = s.length();

        int[] prefixLength = new int[sLength];
        int currentPrefix = 0;

        for (int i = 1; i < sLength; i++) {

            while (currentPrefix > 0 && s.charAt(i) != s.charAt(currentPrefix)) {
                currentPrefix = prefixLength[currentPrefix - 1];
            }
            if (s.charAt(i) == s.charAt(currentPrefix)) {
                currentPrefix++;
            }

            prefixLength[i] = currentPrefix;
        }

        return prefixLength[sLength - 1] > 0
                && (sLength % (sLength - prefixLength[sLength - 1]) == 0);
    }
}