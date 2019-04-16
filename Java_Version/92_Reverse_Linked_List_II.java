/*
  Reverse a linked list from position m to n. Do it in one-pass.

  Note: 1 ≤ m ≤ n ≤ length of list.

  Example:

        Input: 1->2->3->4->5->NULL, m = 2, n = 4
        Output: 1->4->3->2->5->NULL
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

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new Solution().reverseBetween(head, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m == n) {
            return head;
        }

        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;
        ListNode lastNodeBeforeReverse = pseudoHead;
        ListNode currentNode = pseudoHead;

        for (int i = 0; i < n; i++) {

            if (i == m - 1) {
                lastNodeBeforeReverse = currentNode;
            }

            currentNode = currentNode.next;
        }

        ListNode startNodeOfReverse = lastNodeBeforeReverse.next;
        ListNode firstNodeAfterReverse = currentNode.next;

        ListNode lastNode = lastNodeBeforeReverse;
        currentNode = lastNode.next;
        ListNode nextNode = null;

        for (int i = 0; i <= n - m; i++) {

            nextNode = currentNode.next;

            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;
        }

        lastNodeBeforeReverse.next = lastNode;
        startNodeOfReverse.next = currentNode;

        return pseudoHead.next;
    }
}