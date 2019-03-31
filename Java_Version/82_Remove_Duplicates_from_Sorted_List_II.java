/*
  Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

Example 1:

        Input: 1->2->3->3->4->4->5
        Output: 1->2->5

Example 2:

        Input: 1->1->1->2->3
        Output: 2->3
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

        ListNode psudoHead = new ListNode(0);
        ListNode sew = psudoHead;

        int lastValue = head.val - 1;

        ListNode pointer = head;
        while (pointer != null) {

            if (pointer.val != lastValue) {

                if (pointer.next == null || pointer.next.val != pointer.val) {

                    sew.next = pointer;
                    sew = sew.next;
                }
            }

            lastValue = pointer.val;
            pointer = pointer.next;
        }

        sew.next = null;

        return psudoHead.next;
    }
}