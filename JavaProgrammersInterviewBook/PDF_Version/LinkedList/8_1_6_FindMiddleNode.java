package LinkedList;

class FindMiddleNode {
	
	public Node findMiddleNode(Node head) {
		
		Node slow = head;
		Node fast = head;
		
		while ( fast != null && fast.next != null ) {
			
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		
		Node headOne = new Node(1);
        Node temp = headOne;
        for (int i = 2; i < 2; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
		
		System.out.println(new FindMiddleNode().findMiddleNode(null).val);
	}
}