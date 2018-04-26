/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

        Example 1:
        Input: "aba"
        Output: True
        Example 2:
        Input: "abca"
        Output: True
        Explanation: You could delete the character 'c'.
        Note:
        The string will only contain lowercase characters a-z. The maximum length of the string is 50000.*/


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
    public boolean validPalindrome(String s) {

        return validPalindromeHelper(s, 0, s.length() - 1, 0);
    }

    private boolean validPalindromeHelper(String s,
                                          int startPointer, int endPointer, int count) {

        while (startPointer < endPointer) {
            if (s.charAt(startPointer) != s.charAt(endPointer)) {

                count++;
                if (count == 2) {
                    return false;
                }

                return validPalindromeHelper(s, startPointer, endPointer - 1, count)
                        || validPalindromeHelper(s, startPointer + 1, endPointer, count);

            } else {
                startPointer++;
                endPointer--;
            }
        }

        return true;
    }
}