/* 题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。 */

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        
		ListNode slow = pHead;
		ListNode fast = pHead;
		
		while ( true ) {
			
			if (fast == null || fast.next == null) {
				return null;
			}
			
			fast = fast.next.next;
			slow = slow.next;
			
			if ( fast == slow ) {
				break;
			}
		}
		
		slow = pHead;
		while ( fast != slow ) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
    }
}