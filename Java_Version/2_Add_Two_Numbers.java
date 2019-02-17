/*You are given two non-empty linked lists representing two non-negative
integers. The digits are stored in reverse order and each of their nodes
contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the
number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Explanation: 342 + 465 = 807.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pseudoHead = new ListNode(0);
        ListNode pointer = pseudoHead;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int l1Val = (l1 == null ? 0 : l1.val);
            int l2Val = (l2 == null ? 0 : l2.val);

            int currentSum = l1Val + l2Val + carry;

            if (currentSum > 9) {
                carry = 1;
                currentSum %= 10;
            } else {
                carry = 0;
            }

            pointer.next = new ListNode(currentSum);

            pointer = pointer.next;

            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        if (carry != 0) {
            pointer.next = new ListNode(carry);
        }

        return pseudoHead.next;
    }
}
