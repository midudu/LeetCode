/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        You may not modify the values in the list's nodes, only nodes itself may be changed.

        Example 1:

        Given 1->2->3->4, reorder it to 1->4->2->3.
        Example 2:

        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.*/


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode middleNode = findMiddleNode(head);

        ListNode anotherHead = reverseList(middleNode);

        mergeTwoList(head, anotherHead);
    }

    private ListNode findMiddleNode(ListNode head) {

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {

        ListNode lastNode = null, currentNode = head;
        ListNode nextNode = null;

        while (currentNode != null) {

            nextNode = currentNode.next;
            currentNode.next = lastNode;

            lastNode = currentNode;
            currentNode = nextNode;
        }

        return lastNode;
    }

    private void mergeTwoList(ListNode firstHead, ListNode secondHead) {

        ListNode psudoHead = new ListNode(0);

        while (firstHead != null && secondHead != null) {

            ListNode nextNode1 = firstHead.next;
            ListNode nextNode2 = secondHead.next;

            psudoHead.next = firstHead;
            psudoHead = psudoHead.next;

            psudoHead.next = secondHead;
            psudoHead = psudoHead.next;

            firstHead = nextNode1;
            secondHead = nextNode2;
        }

        if (firstHead != null) {
            psudoHead.next = firstHead;
            psudoHead = psudoHead.next;
        } else if (secondHead != null) {
            psudoHead.next = secondHead;
            psudoHead = psudoHead.next;
        }

        psudoHead.next = null;

    }
}