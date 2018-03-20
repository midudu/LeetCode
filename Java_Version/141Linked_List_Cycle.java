/*Given a linked list, determine if it has a cycle in it.

        Follow up:
        Can you solve it without using extra space?*/


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
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slowPointer = head, fastPointer = head;

        while (fastPointer!=null) {
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next;
            } else {
                return false;
            }

            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }

        return false;
    }
}