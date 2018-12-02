/*
Reverse a linked list from position m to n. Do it in one-pass.

        Note: 1 ≤ m ≤ n ≤ length of list.

        Example:

        Input: 1->2->3->4->5->NULL, m = 2, n = 4
        Output: 1->4->3->2->5->NULL*/


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m == n) {
            return head;
        }

        ListNode startPointer = null;
        if (m != 1) {
            startPointer = head;
            for (int i = 0; i < m - 2; i++) {
                startPointer = startPointer.next;
            }
        }

        ListNode firstNodeOfChain = null;
        ListNode lastNodeOfChain = (startPointer == null ? head : startPointer.next);

        ListNode lastNode = lastNodeOfChain;
        ListNode currentNode = lastNode.next;

        int count = 0;
        while (count < n - m) {

            count++;

            ListNode nextNode = currentNode.next;

            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;

            if (count == n - m) {
                firstNodeOfChain = lastNode;
            }
        }

        lastNodeOfChain.next = currentNode;

        if (startPointer != null) {
            startPointer.next = firstNodeOfChain;
            return head;
        } else {
            return firstNodeOfChain;
        }
    }
}