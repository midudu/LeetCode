/*
Sort a linked list using insertion sort.


        A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
        With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


        Algorithm of Insertion Sort:

        Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
        At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
        It repeats until no input elements remain.

        Example 1:

        Input: 4->2->1->3
        Output: 1->2->3->4
        Example 2:

        Input: -1->5->3->4->0
        Output: -1->0->3->4->5*/

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode insertionSortList(ListNode head) {

        if (head == null ) {
            return null;
        }

        ListNode currentNode = head.next;
        ListNode nextNode = null;
        ListNode newHead = head;

        head.next = null;

        while (currentNode != null) {

            nextNode = currentNode.next;

            newHead = insertionSortListHelper(newHead, currentNode);

            currentNode = nextNode;
        }

        return newHead;
    }

    private ListNode insertionSortListHelper(
            ListNode head, ListNode insertingNode) {

        if (insertingNode.val < head.val) {
            insertingNode.next = head;
            return insertingNode;
        }

        ListNode lastNode = head;
        ListNode currentNode = head.next;

        while (currentNode != null) {

            if (currentNode.val > insertingNode.val) {
                lastNode.next = insertingNode;
                insertingNode.next = currentNode;
                return head;
            }

            lastNode = currentNode;
            currentNode = currentNode.next;
        }


        lastNode.next = insertingNode;
        insertingNode.next = null;
        return head;
    }
}