/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

Note:

  Your algorithm should use only constant extra space.

  You may not modify the values in the list's nodes, only nodes itself may be
changed.
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;

        ListNode pointer = pseudoHead;

        while (pointer.next != null
                && pointer.next.next != null) {

            ListNode firstNode = pointer.next;
            ListNode secondNode = pointer.next.next;
            ListNode nextPairNode = pointer.next.next.next;

            pointer.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = nextPairNode;

            pointer = firstNode;
        }

        return pseudoHead.next;
    }
}