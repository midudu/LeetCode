/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
        Example:
        Input: s = "abcdefg", k = 2
        Output: "bacdfeg"
        Restrictions:
        The string consists of lower English letters only.
        Length of the given string and k will in the range [1, 10000]*/


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

        int[] ints = {3, 1, 4, 1, 5};
        new Solution().findPairs(ints, 2);

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
    public String reverseStr(String s, int k) {

        if (s == null || s.length() == 0) {
            return s;
        }

        char[] sChar = s.toCharArray();
        boolean flag = true;
        int length = sChar.length;

        for (int i = 0; i < length; ) {
            if (flag) {
                flag = false;

                reverseStrHelper(sChar, i, i + k -1);
            } else {
                flag = true;
            }

            i += k;
        }

        return new String(sChar);
    }

    private void reverseStrHelper(char[] sChar, int firstPointer, int lastPointer) {

        if (lastPointer >= sChar.length) {
            lastPointer = sChar.length - 1;
        }

        while (firstPointer < lastPointer){
            char temp = sChar[firstPointer];
            sChar[firstPointer] = sChar[lastPointer];
            sChar[lastPointer] = temp;

            firstPointer++;
            lastPointer--;
        }
    }
}