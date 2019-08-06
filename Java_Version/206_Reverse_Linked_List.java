/*
  Reverse a singly linked list.

Example:

        Input: 1->2->3->4->5->NULL
        Output: 5->4->3->2->1->NULL

Follow up:
  A linked list can be reversed either iteratively or recursively. Could you
implement both?
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

        ListNode newHead = new Solution().reverseList(head);

        System.out.println();
    }

    public ListNode reverseList(ListNode head) {

        return reverseListNonRecursively(head);
        // return reverseListRecursively(head);
    }

    private ListNode reverseListNonRecursively(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastNode = null, currentNode = head;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = lastNode;

            lastNode = currentNode;
            currentNode = nextNode;
        }

        return lastNode;
    }

    private ListNode reverseListRecursively(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = null;
        ListNode newHead = reverseListRecursively(nextNode);
        nextNode.next = head;
        return newHead;
    }
}