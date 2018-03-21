/*Reverse a singly linked list.*/


import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        ListNode result = new Solution().reverseList(root);

        //System.out.println(result);
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
    public ListNode reverseList(ListNode head) {

        //Recursive
        /*if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        ListNode resultNode = reverseList(node);
        node.next = head;
        head.next = null;

        return resultNode;*/

        //Non-recursive

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowNode = head, fastNode = head.next;
        while (fastNode != null) {

            ListNode tempNode = fastNode.next;
            fastNode.next = slowNode;
            slowNode = fastNode;
            fastNode = tempNode;
        }
        head.next = null;

        return slowNode;
    }
}