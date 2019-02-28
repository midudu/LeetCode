/*
  Merge k sorted linked lists and return it as one sorted list.
  Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
		
		if ( lists == null || lists.length == 0 ) {
			return null;
		}
		
		return mergeKListsHelper(lists, 0, lists.length - 1);
    }
	
	private ListNode mergeKListsHelper(ListNode[] lists, 
	    int startIndex, int endIndex) {
			
		if ( startIndex == endIndex ) {
			return lists[startIndex];
		}
		
		int middleIndex = startIndex + ( endIndex - startIndex ) / 2;
		
		ListNode firstNode = mergeKListsHelper(lists, startIndex, middleIndex);
		ListNode secondNode = mergeKListsHelper(lists, middleIndex + 1, endIndex);
		
		return mergeTwoNodes(firstNode, secondNode);
	}
	
	private ListNode mergeTwoNodes(ListNode firstNode, ListNode secondNode) {
		
		ListNode pseudoHead = new ListNode(0);
		ListNode currentNode = pseudoHead;
		
		while ( firstNode != null && secondNode != null ) {
			
			if ( firstNode.val <= secondNode.val ) {
				currentNode.next = firstNode;
				firstNode = firstNode.next;
			} else {
				currentNode.next = secondNode;
				secondNode = secondNode.next;
			}
			
			currentNode = currentNode.next;
		}
		
		currentNode.next = ( firstNode != null ? firstNode : secondNode );
		
		return pseudoHead.next;
	}
}