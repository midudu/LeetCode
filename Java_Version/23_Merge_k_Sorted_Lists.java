/*
  Merge k sorted linked lists and return it as one sorted list.
  Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists,
                                       int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return lists[startIndex];
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        ListNode listA = mergeKListsHelper(lists, startIndex, middleIndex);
        ListNode listB = mergeKListsHelper(lists, middleIndex + 1, endIndex);

        return mergeTwoLists(listA, listB);
    }

    private ListNode mergeTwoLists(ListNode headA, ListNode headB) {

        ListNode pseudoHead = new ListNode(0);
        ListNode pointer = pseudoHead;

        while (headA != null && headB != null) {

            if (headA.val < headB.val) {
                pointer.next = headA;
                headA = headA.next;
            } else {
                pointer.next = headB;
                headB = headB.next;
            }

            pointer = pointer.next;
        }

        pointer.next = (headA == null ? headB : headA);

        return pseudoHead.next;
    }
}