/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*You are given a string representing an attendance record for a student. The record only contains the following three characters:
        'A' : Absent.
        'L' : Late.
        'P' : Present.
        A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

        You need to return whether the student could be rewarded according to his attendance record.

        Example 1:
        Input: "PPALLP"
        Output: True
        Example 2:
        Input: "PPALLL"
        Output: False*/


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
    public boolean checkRecord(String s) {

        boolean result = true;
        int sLength = s.length();

        int ACount = 0, LCount = 0;

        for (int i = 0; i < sLength; i++) {

            if (s.charAt(i) == 'A') {
                LCount = 0;
                ACount++;
                if (ACount >= 2) {
                    return false;
                }
            } else if (s.charAt(i)== 'L') {
                LCount++;
                if (LCount >= 3) {
                    return false;
                }
            } else {
                LCount = 0;
            }
        }

        return result;
    }
}