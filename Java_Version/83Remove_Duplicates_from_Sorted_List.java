/*Given a sorted linked list, delete all duplicates such that each element appear only once.

        For example,
        Given 1->1->2, return 1->2.
        Given 1->1->2->3->3, return 1->2->3.*/


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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return head;
        }

        ListNode slow = head, fast = head.next;

        while (fast != null) {

            if (fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }

        slow.next = null;

        return head;
    }
}