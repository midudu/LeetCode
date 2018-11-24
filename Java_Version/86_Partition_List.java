/*
Given a linked list and a value x,
partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

        Example:

        Input: head = 1->4->3->2->5->2, x = 3
        Output: 1->2->2->4->3->5*/



class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode lessThanXPseudoHead = new ListNode(0);
        ListNode greaterOrEqualXPseudoHead = new ListNode(0);

        ListNode sewPointerOfLessThanX = lessThanXPseudoHead;
        ListNode sewPointerOfGreaterOrEqualX = greaterOrEqualXPseudoHead;

        ListNode pointer = head;

        while (pointer != null) {

            if (pointer.val < x) {
                sewPointerOfLessThanX.next = pointer;
                sewPointerOfLessThanX = sewPointerOfLessThanX.next;
            } else {
                sewPointerOfGreaterOrEqualX.next = pointer;
                sewPointerOfGreaterOrEqualX = sewPointerOfGreaterOrEqualX.next;
            }

            pointer = pointer.next;
        }

        sewPointerOfGreaterOrEqualX.next = null;
        sewPointerOfLessThanX.next = greaterOrEqualXPseudoHead.next;

        return lessThanXPseudoHead.next;
    }
}