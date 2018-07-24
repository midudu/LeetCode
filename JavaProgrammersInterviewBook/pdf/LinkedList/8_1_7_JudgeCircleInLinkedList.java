package LinkedList;

class JudgeCircleInLinkedList {
	
	public boolean judgeCircleInLinkedList(Node head) {
		
		Node slow = head;
		Node fast = head;
		
		while ( fast != null && fast.next != null ) {
			if ( fast == slow ) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		Node temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
		
		System.out.println(new JudgeCircleInLinkedList().judgeCircleInLinkedList(head));
	}
}