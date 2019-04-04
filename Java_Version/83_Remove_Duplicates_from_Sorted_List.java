/*Given a sorted linked list, delete all duplicates such that each element
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

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head.next;

        while (fast != null) {

            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }

        slow.next = null;

        return head;
    }
}