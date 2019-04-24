/*
  Given a singly linked list, determine if it is a palindrome.

  Follow up:
        Could you do it in O(n) time and O(1) space?*/


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
        //head.next.next.next.next = new ListNode(5);

        boolean result = new Solution().isPalindrome(head);

        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head.next;
        ListNode lastNode = null, nextNode = slow.next;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            nextNode = slow.next;
            slow.next = lastNode;

            lastNode = slow;
            slow = nextNode;
        }

        if (fast == null) {
            slow = slow.next;
            while (slow != null) {

                if (slow.val != lastNode.val) {
                    return false;
                }

                slow = slow.next;
                lastNode = lastNode.next;
            }

            return true;
        } else {

            if (slow.val != slow.next.val) {
                return false;
            }

            slow = slow.next.next;
            while (slow != null) {

                if (slow.val != lastNode.val) {
                    return false;
                }

                slow = slow.next;
                lastNode = lastNode.next;
            }

            return true;
        }
    }
}