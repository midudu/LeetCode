/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
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

        ListNode psudoHead = new ListNode(0);
        psudoHead.next = head;

        ListNode pointer = psudoHead;

        while (true) {

            if (pointer.next == null || pointer.next.next == null) {
                break;
            }

            ListNode nextNode = pointer.next;
            ListNode nextNextNode = pointer.next.next;
            ListNode nextNextNextNode = pointer.next.next.next;

            pointer.next = nextNextNode;
            nextNextNode.next = nextNode;
            nextNode.next = nextNextNextNode;

            pointer = pointer.next.next;
        }

        return psudoHead.next;
    }
}