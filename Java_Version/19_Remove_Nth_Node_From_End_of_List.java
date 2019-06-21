/*
  Given a linked list, remove the nth node from the end of list and return its
head.

  For example,

  Given linked list: 1->2->3->4->5, and n = 2.

  After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
        Given n will always be valid.

        Try to do this in one pass.
*/

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fastNode = head;

        for (int i = 0; i < n + 1; i++) {

            if (fastNode == null) {
                return head.next;
            } else {
                fastNode = fastNode.next;
            }
        }

        ListNode slowNode = head;
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;
        return head;
    }
}