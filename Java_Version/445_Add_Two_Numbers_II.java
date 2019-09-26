/*
  You are given two non-empty linked lists representing two non-negative
integers. The most significant digit comes first and each of their nodes
contain a single digit. Add the two numbers and return it as a linked list.

  You may assume the two numbers do not contain any leading zero, except the
number 0 itself.

Follow up:
  What if you cannot modify the input lists? In other words, reversing the
lists is not allowed.

Example:

        Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 8 -> 0 -> 7
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

        // (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode head1 = new ListNode(0);

        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(3);

        ListNode result = new Solution().addTwoNumbers(head1, head2);
        System.out.println();
    }

    private class MyNode {

        ListNode node;
        boolean carryBit;

        MyNode(ListNode node, boolean carryBit) {
            this.node = node;
            this.carryBit = carryBit;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int length1 = getLength(l1);
        int length2 = getLength(l2);

        MyNode result = addTwoNumbersHelper(l1, length1, l2, length2);
        if (result.carryBit) {
            ListNode head = new ListNode(1);
            head.next = result.node;
            return head;
        } else {
            return result.node;
        }
    }

    private int getLength(ListNode head) {

        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }

        return result;
    }

    private MyNode addTwoNumbersHelper(
            ListNode head1, int length1, ListNode head2, int length2) {

        if (length1 == length2 && length1 == 1) {
            int result = head1.val + head2.val;
            boolean carryBit = false;
            if (result > 9) {
                result -= 10;
                carryBit = true;
            }
            return new MyNode(new ListNode(result), carryBit);
        }

        if (length1 != length2) {
            MyNode lastResult;
            if (length1 > length2) {
                lastResult = addTwoNumbersHelper(
                        head1.next, length1 - 1, head2, length2);
            } else {
                lastResult = addTwoNumbersHelper(
                        head1, length1, head2.next, length2 - 1);
            }
            int currentVal = (length1 > length2 ? head1.val : head2.val);
            currentVal += (lastResult.carryBit ? 1 : 0);
            boolean carryBit = false;
            if (currentVal > 9) {
                currentVal -= 10;
                carryBit = true;
            }
            ListNode currentNode = new ListNode(currentVal);
            currentNode.next = lastResult.node;
            return new MyNode(currentNode, carryBit);
        }

        MyNode lastResult = addTwoNumbersHelper(
                head1.next, length1 - 1, head2.next, length2 - 1);
        int currentVal = head1.val + head2.val + (lastResult.carryBit ? 1 : 0);
        boolean carryBit = false;
        if (currentVal > 9) {
            currentVal -= 10;
            carryBit = true;
        }
        ListNode currentNode = new ListNode(currentVal);
        currentNode.next = lastResult.node;
        return new MyNode(currentNode, carryBit);
    }
}
