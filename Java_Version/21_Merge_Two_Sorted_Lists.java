/*
  Merge two sorted linked lists and return it as a new list. The new list should
be made by splicing together the nodes of the first two lists.

Example:

  Input: 1->2->4, 1->3->4
  Output: 1->1->2->3->4->4
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pseudoHead = new ListNode(0);
        ListNode tempNode = pseudoHead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }

            tempNode = tempNode.next;
        }

        if (l1 != null) {
            tempNode.next = l1;
        } else if (l2 != null) {
            tempNode.next = l2;
        }

        return pseudoHead.next;
    }
}