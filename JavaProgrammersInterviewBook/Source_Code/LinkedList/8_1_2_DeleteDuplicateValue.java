package LinkedList;

import java.util.HashSet;


class DeleteDuplicateValue {
	
	public static void deleteDuplicateValue(Node head) {
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		Node fast = head;
		Node slow = null;
		
		while ( fast != null ) {
			
			if ( hashSet.contains(fast.val) ) {
				fast = fast.next;
				slow.next = fast;
				
			} else {
				hashSet.add(fast.val);
				slow = fast;
				fast = fast.next;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(4);
		/*head.next = new Node(4, null);
		head.next.next = new Node(4, null);
		head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);
        head.next.next.next.next.next = new Node(4, null);
*/
		deleteDuplicateValue(head);
		
		System.out.println("hah");
	}
}