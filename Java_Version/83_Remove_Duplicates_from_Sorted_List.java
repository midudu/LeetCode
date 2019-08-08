/*
  Given a sorted linked list, delete all duplicates such that each element
appear only once.

For example,

        Given 1->1->2, return 1->2.
        Given 1->1->2->3->3, return 1->2->3.
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode newHead = new Solution().deleteDuplicates(head);

        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pseudoHead = new ListNode(head.val - 1);
        ListNode pointer1 = pseudoHead, pointer2 = head;

        while (pointer2 != null) {

            if (pointer1.val != pointer2.val) {
                pointer1.next = pointer2;
                pointer1 = pointer1.next;
            }

            pointer2 = pointer2.next;
        }

        pointer1.next = null;
        return pseudoHead.next;
    }
}