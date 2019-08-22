/*
  Given a singly linked list, determine if it is a palindrome.

  Follow up:
        Could you do it in O(n) time and O(1) space?
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class NodeWrapper {

    ListNode node;
    boolean isOdd;

    NodeWrapper(ListNode node, boolean isOdd) {
        this.node = node;
        this.isOdd = isOdd;
    }
}

class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        NodeWrapper wrapper = new Solution().getMiddleNode(head);

        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        NodeWrapper middleNodeWrapper = getMiddleNode(head);
        ListNode newHead = reverseList(head, middleNodeWrapper.node);

        if (middleNodeWrapper.isOdd) {
            return isTwoListEqual(newHead, middleNodeWrapper.node.next);
        } else {
            return isTwoListEqual(newHead, middleNodeWrapper.node);
        }
    }

    private NodeWrapper getMiddleNode(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast == null ? new NodeWrapper(slow, false) :
                new NodeWrapper(slow, true);

    }

    private ListNode reverseList(ListNode head, ListNode tail) {

        ListNode lastNode = null, currentNode = head;

        while (currentNode.next != tail) {
            ListNode nextNode = currentNode.next;
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;
        }

        currentNode.next = lastNode;
        return currentNode;
    }

    private boolean isTwoListEqual(ListNode head1, ListNode head2) {

        while (head1 != null && head2 != null) {

            if (head1.val != head2.val) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == head2;
    }
}
