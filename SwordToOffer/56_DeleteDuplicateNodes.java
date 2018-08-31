/* 题目描述

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 

例如，链表1->2->3->3->4->4->5 处理后为 1->2->5 */

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
    public ListNode deleteDuplication(ListNode pHead) {
		
		if ( pHead == null ) {
			return pHead;
		}
		
		ListNode psudoHead = new ListNode(pHead.val - 1);
		ListNode sewPointer = psudoHead;
		
		int currentValue = psudoHead.val;
		ListNode traversePointer = pHead;
		
		while ( traversePointer != null ) {
			
			if ( traversePointer.next != null ) {
				if ( traversePointer.val != currentValue 
				&& traversePointer.val != traversePointer.next.val ) {
					sewPointer.next = traversePointer;
					sewPointer = sewPointer.next;
				}
			} else {
				if ( traversePointer.val != currentValue ) {
					sewPointer.next = traversePointer;
					sewPointer = sewPointer.next;
				}
			}
			
			currentValue = traversePointer.val;
			traversePointer = traversePointer.next;
		}
		
		sewPointer.next = null;
		
		return psudoHead.next;
    }
}