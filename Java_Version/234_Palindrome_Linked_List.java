/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a singly linked list, determine if it is a palindrome.

        Follow up:
        Could you do it in O(n) time and O(1) space?*/

import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        ListNode root = new ListNode(1);
        root.next = new ListNode(0);
        root.next.next = new ListNode(1);

        new Solution().isPalindrome(root);

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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slowPointer = head, fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        ListNode middleNode = slowPointer.next;
        ListNode anotherHead = reverseList(middleNode);

        while (true) {
            if (head.val != anotherHead.val) {
                return false;
            }

            if (head == middleNode || anotherHead == middleNode) {
                return true;
            }

            head = head.next;
            anotherHead = anotherHead.next;
        }
    }

    private ListNode reverseList(ListNode head) {

        ListNode lastNode = null;
        ListNode nextNode;

        while (head != null) {
            nextNode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = nextNode;
        }

        return lastNode;
    }
}