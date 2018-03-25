/*Given a word, you need to judge whether the usage of capitals in it is right or not.

        We define the usage of capitals in a word to be right when one of the following cases holds:

        All letters in this word are capitals, like "USA".
        All letters in this word are not capitals, like "leetcode".
        Only the first letter in this word is capital if it has more than one letter, like "Google".
        Otherwise, we define that this word doesn't use capitals in a right way.
        Example 1:
        Input: "USA"
        Output: True
        Example 2:
        Input: "FlaG"
        Output: False
        Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.*/


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
    public boolean detectCapitalUse(String word) {

        if (word == null || word.length() < 2) {
            return true;
        }

        boolean needCapitalFlag = false;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {

            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                needCapitalFlag = true;
            }

        } else {
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                return false;
            }
        }

        int wordLength = word.length();

        if (needCapitalFlag) {

            for (int i = 2; i < wordLength; i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    return false;
                }
            }

        } else {

            for (int i = 2; i < wordLength; i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
        }

        return true;
    }
}