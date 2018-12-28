/*

Sort a linked list in O(n log n) time using constant space complexity.

        Example 1:

        Input: 4->2->1->3
        Output: 1->2->3->4
        Example 2:

        Input: -1->5->3->4->0
        Output: -1->0->3->4->5
*/

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode sortList(ListNode head) {

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = findMiddleNode(head);

        if (middleNode == null) {
            return mergeSort(head);

        } else {

            ListNode anotherHead = middleNode.next;
            middleNode.next = null;

            ListNode head1 = mergeSort(head);
            ListNode head2 = mergeSort(anotherHead);

            return mergeTwoLists(head1, head2);
        }
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode dummyNode = new ListNode(0);
        ListNode tempNode = dummyNode;

        while (head1 != null && head2 != null) {

            if (head1.val <= head2.val) {

                tempNode.next = head1;
                head1 = head1.next;

            } else {

                tempNode.next = head2;
                head2 = head2.next;
            }

            tempNode = tempNode.next;
        }

        tempNode.next = (head1 != null ? head1 : head2);

        return dummyNode.next;
    }

    private ListNode findMiddleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}