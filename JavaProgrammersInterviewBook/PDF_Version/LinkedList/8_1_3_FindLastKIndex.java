package LinkedList;

class FindLastKIndex{
	
	public Node findLastKIndex(Node head, int lastKIndex) {
		
		if (lastKIndex <= 0) {
			return null;
		}
		
		
		Node slow = null;
		Node fast = head;
		
		for (int i = 0; i < lastKIndex - 1; i++) {
			
			if ( fast != null ) {
				fast = fast.next;
			} else {
				return null;
			}
		}
		if ( fast == null ) {
			return null;
		}
		
		fast = fast.next;
		slow = head;
		while ( fast != null ) {
			
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		
		FindLastKIndex findLastKIndex = new FindLastKIndex();
		
		Node head = new Node(0);
		Node temp = head;
		for (int i = 1; i < 6; i++ ) {
			temp.next = new Node(i);
			temp = temp.next;
		}
		
		Node result1 = findLastKIndex.findLastKIndex(head, 0);
		Node result2 = findLastKIndex.findLastKIndex(head, -1);
		Node result3 = findLastKIndex.findLastKIndex(head, 1);
		Node result4 = findLastKIndex.findLastKIndex(head, 2);
		Node result5 = findLastKIndex.findLastKIndex(head, 5);
		Node result6 = findLastKIndex.findLastKIndex(head, 6);
		Node result7 = findLastKIndex.findLastKIndex(head, 7);
		Node result8 = findLastKIndex.findLastKIndex(head, 8);
		
		System.out.println("haha");
	}
}