package LinkedList;

class DeleteNodeWithoutHead {
	
	public boolean deleteNodeWithoutHead(Node toBeDeletedNode) {
		
		if (toBeDeletedNode.next != null ) {
			
			toBeDeletedNode.val = toBeDeletedNode.next.val;
			toBeDeletedNode.next = toBeDeletedNode.next.next;
			
			return true;
			
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		Node temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
		
		boolean result1 = new DeleteNodeWithoutHead().deleteNodeWithoutHead(head);
		boolean result2 = new DeleteNodeWithoutHead().deleteNodeWithoutHead(head.next);
		boolean result3 = new DeleteNodeWithoutHead().deleteNodeWithoutHead(temp);
		
		System.out.println("haha");
	}
}