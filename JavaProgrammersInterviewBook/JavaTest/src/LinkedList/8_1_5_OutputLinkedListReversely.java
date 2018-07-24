package LinkedList;

class OutputLinkedListReversely {
	
	public void outputLinkedListReversely(Node head) {
		
		if ( head == null ) {
			return;
		}
		
		outputLinkedListReversely(head.next);
		System.out.println(head.val);
	}
	
	public static void main(String[] args) {
		
		Node headOne = new Node(1);
        Node temp = headOne;
        for (int i = 2; i < 9; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
		
		new OutputLinkedListReversely().outputLinkedListReversely(headOne);
	}
}