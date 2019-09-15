/*
  Given a singly linked list, group all odd nodes together followed by the even
nodes. Please note here we are talking about the node number and not the value
in the nodes.

  You should try to do it in place. The program should run in O(1) space
complexity and O(nodes) time complexity.

Example 1:

        Input: 1->2->3->4->5->NULL
        Output: 1->3->5->2->4->NULL

Example 2:

        Input: 2->1->3->5->6->4->7->NULL
        Output: 2->3->6->7->1->5->4->NULL

Note:
  1. The relative order inside both the even and odd groups should remain as it
  was in the input.
  2. The first node is considered odd, the second node even and so on ...
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

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode newHead = new Solution().oddEvenList(head);

        System.out.println();
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode pointerOdd = oddHead, pointerEven = evenHead;
        ListNode pointer = head;

        while (pointer != null) {

            pointerOdd.next = pointer;
            pointerOdd = pointerOdd.next;

            pointer = pointer.next;
            if (pointer != null) {
                pointerEven.next = pointer;
                pointerEven = pointerEven.next;

                pointer = pointer.next;
            }
        }

        pointerOdd.next = evenHead.next;
        pointerEven.next = null;

        return oddHead.next;
    }
}
