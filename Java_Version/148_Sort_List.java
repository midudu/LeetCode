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

    public static void main(String[] args) {

        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode newHead = new Solution().sortList(head);

        System.out.println();
    }

    public ListNode sortList(ListNode head) {

        return mergeSortList(head);
    }

    private ListNode mergeSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode anotherHead = middleNode.next;
        middleNode.next = null;

        ListNode newHead1 = mergeSortList(head);
        ListNode newHead2 = mergeSortList(anotherHead);

        ListNode pseudoHead = new ListNode(0);
        ListNode pointer = pseudoHead;

        while (newHead1 != null && newHead2 != null) {

            if (newHead1.val < newHead2.val) {
                pointer.next = newHead1;
                newHead1 = newHead1.next;
            } else {
                pointer.next = newHead2;
                newHead2 = newHead2.next;
            }

            pointer = pointer.next;
        }

        pointer.next = (newHead1 == null ? newHead2 : newHead1);

        return pseudoHead.next;
    }

    private ListNode findMiddleNode(ListNode head) {

        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;
        ListNode fast = pseudoHead, slow = pseudoHead;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
