/* Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases. */


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = new Solution().isSymmetric(root);

        System.out.println(result);
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
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode slowPointer = head;
        while (slowPointer != null && slowPointer.val == val) {
            slowPointer = slowPointer.next;
        }
        if (slowPointer == null || slowPointer.next == null) {
            return slowPointer;
        }

        ListNode newHead = slowPointer;
        ListNode fastPointer = slowPointer.next;

        while (fastPointer != null) {

            if (fastPointer.val != val) {
                slowPointer = fastPointer;
                fastPointer = fastPointer.next;
            } else {
                while (fastPointer != null && fastPointer.val == val) {
                    fastPointer = fastPointer.next;
                }
                slowPointer.next = fastPointer;
                if (fastPointer == null) {
                    return newHead;
                } else {
                    slowPointer = fastPointer;
                    fastPointer = fastPointer.next;
                }
            }

        }

        return newHead;
    }
}