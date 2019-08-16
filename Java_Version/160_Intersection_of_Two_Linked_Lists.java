/*
  Write a program to find the node at which the intersection of two singly
linked lists begins.

  For example, the following two linked lists:


    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3

  begin to intersect at node c1.


Notes:
  1. If the two linked lists have no intersection at all, return null.
  2. The linked lists must retain their original structure after the function returns.
  3. You may assume there are no cycles anywhere in the entire linked structure.
  4. Your code should preferably run in O(n) time and use only O(1) memory.
*/

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		int lengthA = getLength(headA);
		int lengthB = getLength(headB);

		ListNode pointer1 = (lengthA > lengthB ? headA : headB);
		for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
			pointer1 = pointer1.next;
		}

		ListNode pointer2 = (lengthA > lengthB ? headB : headA);
		while (pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		return pointer1;
	}

	private int getLength(ListNode head) {

		int result = 0;
		while (head != null) {
			result++;
			head = head.next;
		}

		return result;
	}
}
