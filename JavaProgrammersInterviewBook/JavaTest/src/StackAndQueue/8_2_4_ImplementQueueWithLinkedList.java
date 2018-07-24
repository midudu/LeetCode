package StackAndQueue;

class ImplementQueueWithLinkedList<E> {
	
	private class Node<E>{
	    E val;
	    Node<E> next;
	    Node(E val) {
	        this.val = val;
	        this.next = null;
        }
    }
	
	private Node<E> headNode;
	private Node<E> tailNode;
	
	public ImplementQueueWithLinkedList() {
		
		headNode = null;
		tailNode = null;
	}
	
	
	public void push(E val) {
		
		if ( headNode == null ) {
			headNode = new Node<E>(val);
			tailNode = headNode;
		} else {
			tailNode.next = new Node<E>(val);
			tailNode = tailNode.next;
		}
	}
	
	public E pop() {
		
		if ( headNode == null ) {
			return null;
		} else {
			
			E val = headNode.val;
			headNode = headNode.next;
			if ( headNode == null ) {
				tailNode = null;
			}
			
			return val;
		}
	}
	
	public E peek() {
		if ( headNode == null ) {
			return null;
		} else {
			return headNode.val;
		}
	}


	public static void main(String[] args) {

	    ImplementQueueWithLinkedList<Integer> queue
                = new ImplementQueueWithLinkedList<>();

	    for (int i = 0; i < 10; i++) {
	        queue.push(i);
        }

        System.out.println(queue.peek());

        for (int i = 0; i < 15; i++) {
            System.out.println(queue.pop());
        }
    }
}